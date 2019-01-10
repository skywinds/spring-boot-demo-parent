package com.sas.sbdcc.controller;

import com.sas.sbdcc.model.UserInfo;
import com.sas.sbdcc.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {

    @Autowired
    IUserInfoService userInfoService;

    @GetMapping(value = "/user/{id}")
    public UserInfo getUserInfo(@PathVariable("id") Integer id) {
        return userInfoService.getUserInfo(id);
    }

    @GetMapping(value = "/users")
    public List<UserInfo> getAllUsersInfo() {
        return userInfoService.getAllUsersInfo();
    }

    @PostMapping("/user")
    public UserInfo addUserInfo(UserInfo info) {
        return userInfoService.addUserInfo(info);
    }

}
