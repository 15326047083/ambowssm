package com.ambow.first.service.impl;

import com.ambow.first.dao.DonateMapper;
import com.ambow.first.entity.Donate;
import com.ambow.first.service.DonateService;
import com.ambow.first.vo.DonateCountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DonateServiceImpl implements DonateService {
    @Autowired
    private DonateMapper donateMapper;
    /**
     * 全部列表
     * 查找
     * @return
     */
    @Override
    public List<DonateCountVo> queryAllByDate(Date start, Date end) {
        //获取时间段属性
        List<DonateCountVo> list=new ArrayList<DonateCountVo>();
        list= donateMapper.queryAllByDate(start,end);
        return list;
    }

    /**
     * 添加一条借书记录
     *
     * @param donate
     */
    @Override
    public void insert(Donate donate) {
        donate.setId(UUID.randomUUID().toString());
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        donate.setDonateTime(date);
     //   System.out.println(date);
     //   System.out.println(simpleDateFormat.format(date));
        donateMapper.insert(donate);
    }
}
