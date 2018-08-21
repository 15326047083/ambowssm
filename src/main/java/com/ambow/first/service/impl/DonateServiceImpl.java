package com.ambow.first.service.impl;

import com.ambow.first.dao.DonateMapper;
import com.ambow.first.entity.Donate;
import com.ambow.first.service.DonateService;
import com.ambow.first.vo.DonateCountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class DonateServiceImpl implements DonateService {
    @Autowired
    private DonateMapper donateMapper;

    /**
     * 按日期查询借书列表
     *
     * @param start
     * @param end
     * @return
     */
    @Override
    public List<DonateCountVo> getBorrowByDate(Date start, Date end) {
        Calendar calendar=new GregorianCalendar();
        if (end!=null) {
            calendar.setTime(end);
            calendar.add(Calendar.DATE, 1);
            end = calendar.getTime();
        }
        return donateMapper.getBorrowByDate(start,end);
    }

    /**
     * 全部列表
     * 查找
     * @return
     */
    @Override
    public List<DonateCountVo> queryAllByDate(Date start, Date end) {
        //获取时间段属性
        List<DonateCountVo> list=new ArrayList<DonateCountVo>();
        //end 向后加一天
        Calendar calendar=new GregorianCalendar();
        if (end!=null) {
            calendar.setTime(end);
            calendar.add(Calendar.DATE, 1);
            end = calendar.getTime();
        }
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
        donateMapper.insert(donate);
    }

    /**
     * 将两个date数组合并去重为一个数组，求长度
     * @param date1 第一个数组
     * @param date2 第二个数组
     * @return
     */
    @Override
    public int  getAllDate(Date[] date1, Date[] date2) {

        Set set =new HashSet<Date>();
        for (int i=0;i<date1.length;i++){
            set.add(date1[i]);
        }
        for (int i=0;i<date2.length;i++){
            set.add(date2[i]);
        }
        Object[] result =  set.toArray();
        return result.length;
    }
}
