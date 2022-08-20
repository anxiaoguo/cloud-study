package com.axg.study.tencent.cloud.signature.ess;

import com.axg.study.tencent.cloud.signature.model.UploadFile;
import lombok.Data;

@Data
public class UploadFilesRequest {

    /**
     * 调用方信息
     */
    private Caller Caller;
    /**
     * 文件对应业务类型：用于区分文件存储路径
     */
    private String BusinessType;
    /**
     * 上传文件内容数组，最多支持20个文件
     */
    private UploadFile[] FileInfos;
    /**
     * 上传文件链接数组，最多支持20个URL
     */
    private String[] FileUrls;
    /**
     * 是否将pdf灰色矩阵置白
     */
    private Boolean CoverRect;
    /**
     * 特殊文件类型熟悉要指定文件类型
     */
    private String FileType;
    /**
     * 用户自定义ID数组，与上传文件一一对应
     */
    private String[] CustomIds;


}
