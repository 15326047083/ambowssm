package com.ambow.first.service;

import com.ambow.first.entity.Book;
import com.ambow.first.util.Page;
import com.ambow.first.vo.BookTypeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {

    List<Book> selectAlllBook();//图书全查

    int deleteByPrimaryKey(String id);//根据关键值删除

    int insert(Book book1);//添加图书

    int insertSelective(Book record);//可选择增加图书

    Book selectByPrimaryKey(String id);//根据ID查询图书

    BookTypeVo selectTypeByKey(String id);//单查

    int updateByPrimaryKeySelective(Book record);//可选择修改

    int updateByPrimaryKey(Book record);//修改图书

    Page<BookTypeVo> getBookTypeVoList(Integer page, Integer size);//查询全部图书类型


    Page<BookTypeVo> getBookTypeVoByTypeIAndLike(String typeId, String blur, Integer page, Integer size);//分类下模糊查询


    Page<BookTypeVo> getBookTypeVoByTypeIdSort(Integer page, Integer size);//排行




}


