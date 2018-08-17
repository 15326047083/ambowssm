package com.ambow.first.service;

import com.ambow.first.entity.Donate;
import com.ambow.first.vo.DonateCountVo;

import java.util.Date;
import java.util.List;

public interface DonateService {

    /**按日期全部列表
     * 查找
     * @return
     */
    List<DonateCountVo> queryAllByDate(Date start, Date end);
    /**
     * 添加一条借书记录
     * @param donate
     */
    void insert(Donate donate);
}
