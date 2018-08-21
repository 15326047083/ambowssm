package com.ambow.leiyuan.test;

import com.ambow.first.dao.DonateMapper;
import com.ambow.first.entity.Donate;
import com.ambow.first.service.DonateService;
import com.ambow.first.service.TypeService;
import com.ambow.first.vo.DonateCountVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-mybatis.xml","/spring-service.xml"})
public class cyj {
    @Autowired
    private DonateService donateService;
    @Autowired
    private DonateMapper donateMapper;
    @Autowired
    private TypeService typeService;
    @Test
    public void insertDonate(){
        Donate donate=new Donate();
        donate.setBookId("3");
        donate.setUserName("张三");
        donate.setUserPhone("12345678978");
        donateService.insert(donate);
    }
    @Test
    public  void queryAll(){
        List<DonateCountVo> list=new ArrayList<DonateCountVo>();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date1= null;
        try {
         //   date1.setTime("2017-08-01");
            date1 = simpleDateFormat.parse("2017-08-01");
            Date date2=simpleDateFormat.parse("2018-09-10");
            list=donateService.queryAllByDate(date1,date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(list);
    }
    @Test
    public void updatebookNum(){
        typeService.addBookNum("1");
        typeService.subBookNum("3");
    }
}
