package com.sas.sbdth.commons;

import java.util.List;

/**
 * 用户登录信息线程安全持有类
 *
 */
public class UserAccessDataHolder {

    private static ThreadLocal<UserAccessDataInfo> locale = ThreadLocal.withInitial(UserAccessDataInfo::new);

    public static PageInfo getPage() {
        return locale.get().getPageInfo();
    }

    public static void setPage(PageInfo pageInfo) {
        locale.get().setPageInfo(pageInfo);
    }

    public static void setUserAppIds(List<String> appIds) {
        locale.get().setUserAppIds(appIds);
    }

    public static List<String> getUserAppIds() {
        return locale.get().getUserAppIds();
    }

    public static void setUserName(String userName) {
        locale.get().setUserName(userName);
    }

    public static String getUserName() {
        return locale.get().getUserName();
    }

    public static void setUUID(String uuid) {
        locale.get().setUuid(uuid);
    }

    public static String getUUID() {
        return locale.get().getUuid();
    }

    /**
     * 使用完毕之后，进行清理，否则数据会越积越多；
     */
    public static void unbind() {
        locale.remove();
    }

    public static UserAccessDataInfo getPageHolder() {
        return locale.get();
    }

}
