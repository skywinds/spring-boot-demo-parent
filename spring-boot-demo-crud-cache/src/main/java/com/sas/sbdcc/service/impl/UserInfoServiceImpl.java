package com.sas.sbdcc.service.impl;

import com.sas.sbdcc.dao.IUserInfoDao;
import com.sas.sbdcc.model.UserInfo;
import com.sas.sbdcc.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "userInfoCache")
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    IUserInfoDao userInfoDao;


    /**
     * <ul>
     * <li>{@code @Cacheable(key = "#id", condition = "#id>0", unless = "#id>1")}
     * <li>condition id>0的存缓存
     * <li>unless id>1的不存缓存
     * <li>最终，只有id=1的存缓存
     * <p>
     * <li>{@code @Cacheable(key = "#id", condition = "#id>0", unless = "#result == null")}
     * <li>result == null时不缓存
     *
     * <p>
     * <li>注意，如果加上condition，不符合condition的请求，将每次都走数据库请求；
     *
     * </ul>
     *
     * @param id
     * @return
     */
    @Override
    @Cacheable(key = "#id")
    public UserInfo getUserInfo(Integer id) {
        return userInfoDao.getUserInfo(id);
    }

    @Override
    @Cacheable
    public List<UserInfo> getAllUsersInfo() {
        return userInfoDao.getAllUsersInfo();
    }

    /**
     * {@code @CachePut注解的方法，是一定要执行的；}
     *
     * @param info
     * @return
     */
    @Override
    @CachePut(key = "#info.id")
    //这里一定要注意，更新缓存的key，要与上面的一致
    public UserInfo addUserInfo(UserInfo info) {
        userInfoDao.addUserInfo(info);
        System.out.println("【新插入的数据】：" + info.toString());
        return info;
    }

}
