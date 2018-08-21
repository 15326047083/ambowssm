package com.ambow.first.dao;

import com.ambow.first.entity.Borrow;
import com.ambow.first.vo.BorrowBookUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BorrowMapper {
    //根据主键删除
    int deleteByPrimaryKey(String id);
    //添加借书记录
    int insert(Borrow record);
    //可选择性增加
    int insertSelective(Borrow record);
    //根据主键查询
    Borrow selectByPrimaryKey(String id);
    //可选择性修改
    int updateByPrimaryKeySelective(Borrow record);
    //根据主键修改
    int updateByPrimaryKey(Borrow record);
    //查询全部 book表 user 表 borrow 表
    List<BorrowBookUserVo> selectBorrowUserBook(@Param("page") Integer page, @Param("size") Integer size);
    //模糊查询借阅列表带分页
    List<BorrowBookUserVo> selectBorrowLike(@Param("page") Integer page, @Param("size") Integer size,@Param("mohu") String mohu);
    //根据图书ID修改状态
    int updateByBookId(Borrow borrow);
    //分页查询总数量
    Integer selectAllCount();
    //模糊查询分页总数量
    Integer selectAllCountLike(@Param("mohu") String mohu);
    //根据bookId查询时间戳
    Borrow getByBookId(String bookId);

}