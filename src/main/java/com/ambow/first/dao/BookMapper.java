package com.ambow.first.dao;

import com.ambow.first.entity.Book;

public interface BookMapper {
    int deleteByPrimaryKey(String id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}