package com.axg.study.tencent.cloud.signature.ess;

import lombok.Data;

@Data
public class UploadFilesResponse {

    /**
     * 文件id数组
     */
    private String[] FileIds;
    /**
     * 上传成功文件数量
     */
    private Long TotalCount;
    /**
     * 唯一请求ID,每次请求都会返回。定位问题可以将该RequestId给腾讯电子签对接研发人员
     */
    private String RequestId;



}
