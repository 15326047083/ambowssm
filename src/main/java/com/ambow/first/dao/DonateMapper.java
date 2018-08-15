package com.ambow.first.dao;

import com.ambow.first.entity.Donate;

public interface DonateMapper {
    int deleteByPrimaryKey(String id);

    int insert(Donate record);

    int insertSelective(Donate record);

    Donate selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Donate record);

    int updateByPrimaryKey(Donate record);
}