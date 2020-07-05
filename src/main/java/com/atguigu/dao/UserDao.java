package com.atguigu.dao;

import com.atguigu.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
//    @Update()
//    @Delete()
//    @Insert()
//    @Select("select * from user")
    public List<User> findAll();
}
