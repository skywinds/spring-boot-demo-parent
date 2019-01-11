package com.sas.sbdth.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 版本集合类
 */
@Data
public class VersionSetInfo extends UserAppIds{

    /** 版本集合ID */
    @JSONField(name = "id")
    private Long vsetId;

    /** 版本集合名称 */
    @JSONField(name = "text")
    private String name;

    /** 版本集合关联业务 */
    @JSONField(serialize=false)
    private String appId;

    /** 版本集合下属版本 */
    @JSONField(serialize=false)
    private List<VersionSetDetailInfo>  versionSetDetailInfoList;

    /** 用于展示 */
    @JSONField(serialize=false)
    private Long[] versIdsArray;

    public void setVersIdsArray(String selectedVersIds) {
        if (StringUtils.isNotBlank(selectedVersIds)) {
            List<Long> temp = new ArrayList<>();
            for (String str : StringUtils.split(selectedVersIds, ",")) {
                temp.add(Long.valueOf(str));
            }
            versIdsArray = temp.toArray(new Long[]{});
        }
    }
}
