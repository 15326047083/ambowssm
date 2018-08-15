package com.ambow.first.dao;

import com.ambow.first.entity.Borrow;

public interface BorrowMapper {
    int deleteByPrimaryKey(String id);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    Borrow selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);
}