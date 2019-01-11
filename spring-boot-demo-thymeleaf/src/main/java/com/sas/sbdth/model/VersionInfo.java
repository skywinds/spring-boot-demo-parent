package com.sas.sbdth.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Author: JinZhiJie .
 * <p>
 * Created on 2017-07-27.
 * <p>
 * Description:版本信息实体类
 */
@Data
class VersionInfo extends UserAppIds{
    /** 版本信息ID */
    @JSONField(name = "id")
    private Long versId;

    /** 应用ID */
    @JSONField(serialize=false)
    private String appId;

    /** 应用版本号 */
    @JSONField(serialize=false)
    private Long versCode;

    /** 版本名称 */
    @JSONField(name = "text")
    private String name;

    /** 版本描述 */
    @JSONField(serialize=false)
    private String desc;

}
