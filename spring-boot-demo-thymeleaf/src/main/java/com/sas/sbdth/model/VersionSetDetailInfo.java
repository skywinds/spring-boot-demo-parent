package com.sas.sbdth.model;

import lombok.Data;

@Data
class VersionSetDetailInfo {

    /** 版本集合详情ID */
    private Long vsdeId;
    /** 版本集合ID */
    private Long vsetId;
    /** 版本ID */
    private Long versId;
    /** 版本信息 */
    private VersionInfo versionInfo;


}
