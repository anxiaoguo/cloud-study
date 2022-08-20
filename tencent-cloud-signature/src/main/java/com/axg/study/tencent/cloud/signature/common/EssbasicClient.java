package com.axg.study.tencent.cloud.signature.common;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import com.axg.study.tencent.cloud.signature.ess.UploadFilesRequest;
import com.axg.study.tencent.cloud.signature.ess.UploadFilesResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.jackson.Jacksonized;

import java.lang.reflect.Type;

public class EssbasicClient extends AbstractClient{

    private static String endpoint = "essbasic.tencentcloudapi.com";
    private static String service = "essbasic";
    private static String version = "2020-12-22";

    public EssbasicClient(Credential credential, String region) {
        this(credential, region, new ClientProfile());
    }

    public EssbasicClient(Credential credential, String region, ClientProfile profile) {
        super(EssbasicClient.endpoint, EssbasicClient.version, credential, region, profile);
    }

    public UploadFilesResponse UploadFiles(UploadFilesRequest req){


    }


}
