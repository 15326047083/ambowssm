package com.ambow.leiyuan.test;

import com.aliyuncs.exceptions.ClientException;
import com.ambow.first.dao.TypeMapper;
import com.ambow.first.service.UserService;
import com.ambow.first.util.HttpUtils;
import com.ambow.first.util.Send;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;


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

    @org.junit.Test
    public void testAi() {

        String host = "https://jisuznwd.market.alicloudapi.com";
        String path = "/iqa/query";
        String method = "GET";
        String appcode = "d7b2e7a36744403793b1951d3507c588";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("question", "杭州天气");
        String reply = null;
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway
             * /demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
