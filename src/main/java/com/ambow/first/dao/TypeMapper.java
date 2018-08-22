package com.ambow.first.dao;

import com.ambow.first.entity.Type;
import com.ambow.first.vo.BookTypeVo;

import java.util.List;

public interface TypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    List<BookTypeVo> getBookTypeVoList();

    /**
     * 导出excel
     * @return
     */
    List<Type> queryAll();

    /**
     * 图书数量+1
     * @param id
     */
    void addBookNum(String id);

    /**
     * 图书数量-1
     * @param id
     */
    void subBookNum(String id);

    /**
     * 全部书籍数量
     * @return
     */
    int allBookNum ();

    /**
     *判断是否有重名
     * @param name
     * @return
     */
    int getCountByName(String name);
}