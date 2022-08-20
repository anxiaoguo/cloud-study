package com.axg.study.tencent.cloud.signature.common;

import lombok.Data;

@Data
public class HttpProfile {


    public static final String REQ_POST = "POST";
    public static final String REQ_HTTPS = "https://";
    public static final int TM_MINUTE = 60;
    public static final String REQ_GET = "GET";

    private String reqMethod;

    private String endpoint;

    private String rootDomain;

    private String protocol;

    private int readTimeout;

    private int writeTimeout;

    private int connTimeout;

    private String proxyHost;

    public HttpProfile() {
        this.reqMethod = HttpProfile.REQ_POST;
        this.endpoint = null;
        this.rootDomain = "tencentcloudapi.com";
        this.protocol = HttpProfile.REQ_HTTPS;
        this.readTimeout = 0;
        this.writeTimeout = 0;
        this.connTimeout = HttpProfile.TM_MINUTE;
    }

}
