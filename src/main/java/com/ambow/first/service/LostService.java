package com.ambow.first.service;

import com.ambow.first.entity.Lost;
import com.ambow.first.util.Page;
import com.ambow.first.vo.LostUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LostService {
    //增加失信记录
    int insertSelective(Lost record);
    int insert(Lost record);
    //统计失信次数
    Integer selectCountUser(String phone);

    Lost getByBorrowId(String borrowId);

    //分页查询失信表
    Page<LostUserVo> selectAllPage(@Param("page") Integer page, @Param("size") Integer size);
}
