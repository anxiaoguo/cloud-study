package com.axg.study.tencent.cloud.signature.common;

import cn.hutool.core.util.StrUtil;
import lombok.Data;

@Data
public class ClientProfile {

    /** Signature process version 1, with HmacSHA1. */
    public static final String SIGN_SHA1 = "HmacSHA1";

    /** Signature process version 1, with HmacSHA256. */
    public static final String SIGN_SHA256 = "HmacSHA256";

    /** Signature process version 3. */
    public static final String SIGN_TC3_256 = "TC3-HMAC-SHA256";

    private String signMethod;

    private HttpProfile httpProfile;

    private boolean unsignedPayload;

    private String language;

    private boolean debug;


    public ClientProfile() {
    }

    public ClientProfile(String signMethod, HttpProfile httpProfile) {
        if(StrUtil.isEmpty(signMethod)) signMethod = SIGN_TC3_256;
        this.signMethod = signMethod;
        this.httpProfile = httpProfile;
        this.unsignedPayload = false;
        this.language = null;
        this.setDebug(false);
    }

}
