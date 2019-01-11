package com.sas.sbdth.commons;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class UserAccessDataInfo {

    /**
     * 分页信息
     */
    private PageInfo pageInfo;

    /**
     * 用户管理的应用IDs,若管理全部的应用，则为空
     */
    private List<String> userAppIds;

    /**
     * 用户名
     */
    private String userName;

    /**
     * UUID
     *
     * @return
     */
    private String uuid;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<String> getUserAppIds() {
        return userAppIds;
    }

    public void setUserAppIds(List<String> userAppIds) {
        this.userAppIds = userAppIds;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
