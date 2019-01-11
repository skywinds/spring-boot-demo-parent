package com.sas.sbdth.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

/**
 * <li>ToString方法会排除prduId字段
 * <p>{@code @ToString}(exclude = {"prduId"})
 *
 * <li>ToString方法会输出添加了@ToString.include注解的字段
 * <p>{@code @ToString}(onlyExplicitlyIncluded = true)
 * <p>{@code @ToString.Include}
 * <p>private Long prduId;
 *
 * <li>生成全属性参数的构造函数
 * <p>{@code @AllArgsConstructor}
 *
 * <li>生成无参构造函数
 * <p>{@code @NoArgsConstructor}
 *
 * <li>生成带参数的构造函数（注解了NonNull的字段）
 * <p>{@code @RequiredArgsConstructor}
 * <p>@NonNull
 * <p>private Long prduId;
 *
 * @see ToString
 * @see AllArgsConstructor
 * @see NoArgsConstructor
 * @see RequiredArgsConstructor
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductInfo extends UserAppIds {
    /** 产品信息ID */
    @JSONField(serialize = false)
    @NonNull
    private Long prduId;

    /** APP应用ID */
    @JSONField(name = "id")
    @NonNull
    private String appId;

    /** APP应用名称 */
    @JSONField(name = "text")
    private String name;

    /** 描述 */
    @JSONField(serialize = false)
    private String desc;

    /** APP应用简称 */
    @JSONField(serialize = false)
    private String shortName;

}
