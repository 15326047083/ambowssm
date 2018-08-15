package com.ambow.leiyuan.test;

import com.ambow.first.entity.User;
import com.ambow.first.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-mybatis.xml","/spring-service.xml"})
public class Test {
    @Autowired
    private UserService userService;

    @org.junit.Test
    public void testIdea() {
        System.out.println("我是可以用的");
    }
}
