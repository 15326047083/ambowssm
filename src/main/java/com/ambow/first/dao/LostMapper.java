package com.ambow.first.dao;

import com.ambow.first.entity.Lost;
import com.ambow.first.vo.LostUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LostMapper {
    int deleteByPrimaryKey(String id);

    int insert(Lost record);

    int insertSelective(Lost record);

    Lost selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Lost record);

    int updateByPrimaryKey(Lost record);

    Integer selectCountUser(String phone);

    Lost getByBorrowId(String borrowId);
    //统计失信表的总条目
    Integer selectLostCount();
    //分页查询失信表
    List<LostUserVo> selectAllPage(@Param("page") Integer page, @Param("size") Integer size);
}