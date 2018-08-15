package com.ambow.leiyuan.test;

import com.aliyuncs.exceptions.ClientException;
import com.ambow.first.dao.TypeMapper;
import com.ambow.first.service.UserService;
import com.ambow.first.util.Send;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-mybatis.xml", "/spring-service.xml"})
public class Test {
    @Autowired
    private TypeMapper typeMapper;

    @org.junit.Test
    public void testIdea() {
        System.out.println(typeMapper.getBookTypeVoList());
        System.out.println("我是可以用的");
    }
}
