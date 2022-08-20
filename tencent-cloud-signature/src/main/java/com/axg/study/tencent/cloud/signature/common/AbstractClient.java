package com.axg.study.tencent.cloud.signature.common;

import com.axg.study.tencent.cloud.signature.execption.TencentCloudSDKException;
import com.axg.study.tencent.cloud.signature.model.AbstractModel;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Response;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.UUID;

@Slf4j
public abstract class AbstractClient {

    private Credential credential;

    private ClientProfile profile;

    private String endpoint;

    private String service;

    private String region;

    private String path;

    private String sdkVersion;

    private String apiVersion;


    private String getEndpoint() {
        // in case user has reset endpoint after init this client
        if (null != this.profile.getHttpProfile().getEndpoint()) {
            return this.profile.getHttpProfile().getEndpoint();
        } else {
            // protected abstract String getService();
            // use this.getService() from overrided subclass will be better
            return this.service + "." + this.profile.getHttpProfile().getRootDomain();
        }
    }

    public AbstractClient(String endpoint, String version, Credential credential, String region, ClientProfile profile) {
        this.credential = credential;
        this.profile = profile;
        this.endpoint = endpoint;
        this.service = endpoint.split("\\.")[0];
        this.region = region;
        this.path = "/";
        this.sdkVersion = "SDK_JAVA_3.1.498";
        this.apiVersion = version;
    }

    protected String internalRequest(AbstractModel request, String actionName)
            throws TencentCloudSDKException {
        Response okRsp = null;
        String endpoint = this.getEndpoint();
        String[] binaryParams = request.getBinaryParams();
        String sm = this.profile.getSignMethod();
        String reqMethod = this.profile.getHttpProfile().getReqMethod();

        // currently, customized params only can be supported via post json tc3-hmac-sha256
        HashMap<String, Object> customizedParams = request.any();
        if (customizedParams.size() > 0) {
            if (binaryParams.length > 0) {
                throw new TencentCloudSDKException(
                        "WrongUsage: Cannot post multipart with customized parameters.");
            }
            if (sm.equals(ClientProfile.SIGN_SHA1) || sm.equals(ClientProfile.SIGN_SHA256)) {
                throw new TencentCloudSDKException(
                        "WrongUsage: Cannot use HmacSHA1 or HmacSHA256 with customized parameters.");
            }
            if (reqMethod.equals(HttpProfile.REQ_GET)) {
                throw new TencentCloudSDKException(
                        "WrongUsage: Cannot use get method with customized parameters.");
            }
        }

        if (binaryParams.length > 0 || sm.equals(ClientProfile.SIGN_TC3_256)) {
            okRsp = doRequestWithTC3(endpoint, request, actionName);
        } else if (sm.equals(ClientProfile.SIGN_SHA1) || sm.equals(ClientProfile.SIGN_SHA256)) {
            okRsp = doRequest(endpoint, request, actionName);
        } else {
            throw new TencentCloudSDKException(
                    "Signature method " + sm + " is invalid or not supported yet.");
        }

        if (okRsp.code() != AbstractClient.HTTP_RSP_OK) {
            String msg = "response code is " + okRsp.code() + ", not 200";
            log.info(msg);
            throw new TencentCloudSDKException(msg, "", "ServerSideError");
        }
        String strResp = null;
        try {
            strResp = okRsp.body().string();
        } catch (IOException e) {
            String msg = "Cannot transfer response body to string, because Content-Length is too large, or Content-Length and stream length disagree.";
            log.info(msg);
            throw new TencentCloudSDKException(msg, "", endpoint.getClass().getName());
        }

        JsonResponseModel<JsonResponseErrModel> errResp = null;
        try {
            Type errType = new TypeToken<JsonResponseModel<JsonResponseErrModel>>() {
            }.getType();
            errResp = gson.fromJson(strResp, errType);
        } catch (JsonSyntaxException e) {
            String msg = "json is not a valid representation for an object of type";
            log.info(msg);
            throw new TencentCloudSDKException(msg, "", e.getClass().getName());
        }
        if (errResp.response.error != null) {
            throw new TencentCloudSDKException(
                    errResp.response.error.message,
                    errResp.response.requestId,
                    errResp.response.error.code);
        }

        return strResp;
    }


    private Response doRequestWithTC3(String endpoint, AbstractModel request, String action)
            throws TencentCloudSDKException {
        String httpRequestMethod = this.profile.getHttpProfile().getReqMethod();
        if (httpRequestMethod == null) {
            throw new TencentCloudSDKException(
                    "Request method should not be null, can only be GET or POST");
        }
        String contentType = "application/x-www-form-urlencoded";
        byte[] requestPayload = "".getBytes(StandardCharsets.UTF_8);
        HashMap<String, String> params = new HashMap<String, String>();
        request.toMap(params, "");
        String[] binaryParams = request.getBinaryParams();
        if (binaryParams.length > 0) {
            httpRequestMethod = HttpProfile.REQ_POST;
            String boundary = UUID.randomUUID().toString();
            // okhttp always set charset even we don't specify it,
            // to ensure signature be correct, we have to set it here as well.
            contentType = "multipart/form-data; charset=utf-8" + "; boundary=" + boundary;
            try {
                requestPayload = getMultipartPayload(request, boundary);
            } catch (Exception e) {
                throw new TencentCloudSDKException("Failed to generate multipart. because: " + e);
            }
        } else if (httpRequestMethod.equals(HttpProfile.REQ_POST)) {
            requestPayload = AbstractModel.toJsonString(request).getBytes(StandardCharsets.UTF_8);
            // okhttp always set charset even we don't specify it,
            // to ensure signature be correct, we have to set it here as well.
            contentType = "application/json; charset=utf-8";
        }
        String canonicalUri = "/";
        String canonicalQueryString = this.getCanonicalQueryString(params, httpRequestMethod);
        String canonicalHeaders = "content-type:" + contentType + "\nhost:" + endpoint + "\n";
        String signedHeaders = "content-type;host";

        String hashedRequestPayload = "";
        if (this.profile.isUnsignedPayload()) {
            hashedRequestPayload = Sign.sha256Hex("UNSIGNED-PAYLOAD".getBytes(StandardCharsets.UTF_8));
        } else {
            hashedRequestPayload = Sign.sha256Hex(requestPayload);
        }
        String canonicalRequest =
                httpRequestMethod
                        + "\n"
                        + canonicalUri
                        + "\n"
                        + canonicalQueryString
                        + "\n"
                        + canonicalHeaders
                        + "\n"
                        + signedHeaders
                        + "\n"
                        + hashedRequestPayload;

        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String date = sdf.format(new Date(Long.valueOf(timestamp + "000")));
        String service = endpoint.split("\\.")[0];
        String credentialScope = date + "/" + service + "/" + "tc3_request";
        String hashedCanonicalRequest =
                Sign.sha256Hex(canonicalRequest.getBytes(StandardCharsets.UTF_8));
        String stringToSign =
                "TC3-HMAC-SHA256\n" + timestamp + "\n" + credentialScope + "\n" + hashedCanonicalRequest;

        String secretId = this.credential.getSecretId();
        String secretKey = this.credential.getSecretKey();
        byte[] secretDate = Sign.hmac256(("TC3" + secretKey).getBytes(StandardCharsets.UTF_8), date);
        byte[] secretService = Sign.hmac256(secretDate, service);
        byte[] secretSigning = Sign.hmac256(secretService, "tc3_request");
        String signature =
                DatatypeConverter.printHexBinary(Sign.hmac256(secretSigning, stringToSign)).toLowerCase();
        String authorization =
                "TC3-HMAC-SHA256 "
                        + "Credential="
                        + secretId
                        + "/"
                        + credentialScope
                        + ", "
                        + "SignedHeaders="
                        + signedHeaders
                        + ", "
                        + "Signature="
                        + signature;

        HttpConnection conn =
                new HttpConnection(
                        this.profile.getHttpProfile().getConnTimeout(),
                        this.profile.getHttpProfile().getReadTimeout(),
                        this.profile.getHttpProfile().getWriteTimeout());
        conn.addInterceptors(log);
        this.trySetProxy(conn);
        String url = this.profile.getHttpProfile().getProtocol() + endpoint + this.path;
        Headers.Builder hb = new Headers.Builder();
        hb.add("Content-Type", contentType)
                .add("Host", endpoint)
                .add("Authorization", authorization)
                .add("X-TC-Action", action)
                .add("X-TC-Timestamp", timestamp)
                .add("X-TC-Version", this.apiVersion)
                .add("X-TC-RequestClient", SDK_VERSION);
        if (null != this.getRegion()) {
            hb.add("X-TC-Region", this.getRegion());
        }
        String token = this.credential.getToken();
        if (token != null && !token.isEmpty()) {
            hb.add("X-TC-Token", token);
        }
        if (this.profile.isUnsignedPayload()) {
            hb.add("X-TC-Content-SHA256", "UNSIGNED-PAYLOAD");
        }
        if (null != this.profile.getLanguage()) {
            hb.add("X-TC-Language", this.profile.getLanguage().getValue());
        }

        Headers headers = hb.build();
        if (httpRequestMethod.equals(HttpProfile.REQ_GET)) {
            return conn.getRequest(url + "?" + canonicalQueryString, headers);
        } else if (httpRequestMethod.equals(HttpProfile.REQ_POST)) {
            return conn.postRequest(url, requestPayload, headers);
        } else {
            throw new TencentCloudSDKException("Method only support GET, POST");
        }
    }


}
