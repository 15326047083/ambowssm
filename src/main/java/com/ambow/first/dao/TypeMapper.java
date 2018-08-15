package com.ambow.first.dao;

import com.ambow.first.entity.Type;

public interface TypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
}