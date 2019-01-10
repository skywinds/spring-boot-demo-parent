package com.sas.sbdcc.dao;

import com.sas.sbdcc.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IUserInfoDao {

    @Select("select * from tbl_user where user_id=#{id}")
    @Results(id = "userInfoResultMap", value = {
            @Result(column = "user_id", property = "id"),
            @Result(column = "user_name", property = "name"),
            @Result(column = "user_email", property = "email"),
    })
    UserInfo getUserInfo(Integer id);

    @Select("select * from tbl_user")
    @ResultMap(value = "userInfoResultMap")
    List<UserInfo> getAllUsersInfo();


    /*
     * statement="select max(empNo)+1 as myNo from emp":表示定义的子查询语句
     * before=true：表示在之前执行，booler类型的,所以为true
     * keyColumn="myNo":表示查询所返回的类名
     * resultType=int.class：表示返回值得类型
     * keyProperty="empNo" ：表示将该查询的属性设置到某个列中，此处设置到empNo中
     */
    //使用注解
    @SelectKey(statement = "select last_insert_id()", before = false, keyColumn = "user_id", resultType = int.class, keyProperty = "id")
    @Insert("INSERT INTO tbl_user (user_name, user_email) VALUES (#{name},#{email})")
    int addUserInfo(UserInfo info);
}
