package com.ambow.leiyuan.test;

import com.ambow.first.entity.User;
import com.ambow.first.service.UserService;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-mybatis.xml", "/spring-service.xml"})
public class GuoWeiTest {

    @Autowired
    private UserService userService;

    /**
     * 新增读者信息测试
     */
    @org.junit.Test
    public void insertUser(){
        User user = new User();
        user.setName("4389");
        user.setSex("0");
        user.setAge(12);
        user.setPhone("6556");
        user.setNewDate(new Date());
        user.setPlace("7686");
        user.setBorrowNum(42);
        user.setPassword("89000000");
        userService.insert(user);
    }

    /**
     * 根据借阅数查询读者信息
     */
    @org.junit.Test
    public void selectAllByBorrowNum(){
        System.out.println(userService.selectAllByBorrowNum());
    }
    /**
     * 根据ID删除读者信息
     */
    public void deleteUser(){
        userService.deleteUser("6");
    }

    /**
     * 修改读者信息
     */
    @org.junit.Test
    public void updateUser(){
        User user = new User();
        user.setId("6");
        user.setPassword("admin");
        userService.updateByPrimaryKeySelective(user);
    }
    @org.junit.Test
    public void getUserByPhone(){
        System.out.println(userService.getUserByPhone("6556"));
    }
}
