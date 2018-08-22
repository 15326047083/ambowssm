package com.ambow.first.service;

import com.ambow.first.entity.Lost;

public interface LostService {
    //增加失信记录
    int insertSelective(Lost record);
    int insert(Lost record);
    //统计失信次数
    Integer selectCountUser(String phone);

    Lost getByBorrowId(String borrowId);
}
