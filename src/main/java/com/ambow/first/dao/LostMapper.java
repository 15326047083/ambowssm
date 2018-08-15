package com.ambow.first.dao;

import com.ambow.first.entity.Lost;

public interface LostMapper {
    int deleteByPrimaryKey(String id);

    int insert(Lost record);

    int insertSelective(Lost record);

    Lost selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Lost record);

    int updateByPrimaryKey(Lost record);
}