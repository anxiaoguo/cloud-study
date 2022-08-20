package com.axg.study.tencent.cloud.signature.model;

import lombok.Data;

@Data
public class UploadFile {

    /**
     * Base64编码后的文件内容
     */
    private String FileBody;
    /**
     * 文件名
     */
    private String FileName;


}
