package com.ambow.leiyuan.test;

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
        User user = new User("sad8ad98a7d9asas98d7a", 0, "雷源", "雷源", "雷源", "雷源", "雷源", "雷源", 152100733, "雷源", "雷源", "雷源", "雷源");
        userService.save(user);
        System.out.println("我是可以用的");
    }
}
