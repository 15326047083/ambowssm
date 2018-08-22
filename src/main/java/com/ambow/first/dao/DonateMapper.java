package com.ambow.first.dao;

import com.ambow.first.entity.Donate;
import com.ambow.first.vo.BookDonateVo;
import com.ambow.first.vo.DonateCountVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DonateMapper {
    int deleteByPrimaryKey(String id);

    int insert(Donate record);

    int insertSelective(Donate record);

    Donate selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Donate record);

    int updateByPrimaryKey(Donate record);

    List<DonateCountVo> queryAllByDate(@Param("start") Date start, @Param("end") Date end) ;
    List<BookDonateVo> selectAll(@Param("page") Integer page, @Param("size") Integer size);
    Integer selectAllNum();
    List<DonateCountVo> getBorrowByDate(@Param("start") Date start, @Param("end") Date end) ;
}