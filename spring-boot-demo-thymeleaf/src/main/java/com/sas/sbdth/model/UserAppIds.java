package com.sas.sbdth.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * 该类用来存储用户所能管理的产品；
 */
@Data
class UserAppIds {
    @JSONField(serialize = false)
    private List<String> userAppIds;
}
