package com.sas.sbdcc.service;

import com.sas.sbdcc.model.UserInfo;

import java.util.List;

public interface IUserInfoService {
    UserInfo getUserInfo(Integer id);

    List<UserInfo> getAllUsersInfo();

    UserInfo addUserInfo(UserInfo info);
}
