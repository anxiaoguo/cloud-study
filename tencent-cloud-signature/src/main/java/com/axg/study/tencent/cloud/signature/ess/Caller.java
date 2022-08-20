package com.axg.study.tencent.cloud.signature.ess;

import lombok.Data;

@Data
public class Caller {

    /**
     * 电子签提供的应用号
     */
    private String ApplicationId;
    /**
     * 经办人用户ID
     */
    private String operatorId;

}
