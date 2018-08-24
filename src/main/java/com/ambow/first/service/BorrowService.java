package com.ambow.first.service;

import com.ambow.first.entity.Borrow;
import com.ambow.first.util.Page;
import com.ambow.first.vo.BorrowBookUserVo;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public interface BorrowService {
    //根据主键删除
    int deleteByPrimaryKey(String id);

    //根据主键查询
    Borrow selectByPrimaryKey(String id);

    //根据主键修改
    int updateByPrimaryKey(Borrow record);

    //可选择性修改
    int updateByPrimaryKeySelective(Borrow record);

    //查询全部
    Page<BorrowBookUserVo> selectBorrowUserBook(@Param("page") Integer page, @Param("size") Integer size);

    //模糊查询借阅列表
    Page<BorrowBookUserVo> selectBorrowLike(@Param("page") Integer page, @Param("size") Integer size, @Param("mohu")
            String mohu);

    //可选择性增加
    int insertSelective(Borrow record);

    int updateByBookId(Borrow borrow);

    Borrow getByBookId(String bookId);

    /**
     * 导出
     *
     * @return
     */
    XSSFWorkbook exportExcelInfo();

    // 查询全部借阅列表
    List<BorrowBookUserVo> queryAll();
}
