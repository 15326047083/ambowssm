package com.ambow.first.service;

import com.ambow.first.entity.Book;
import com.ambow.first.util.Page;
import com.ambow.first.vo.BookTypeVo;

import java.util.List;

public interface BookService {

    List<Book>  selectAlllBook();//图书全查

    int insert(Book record);//添加图书

    int insertSelective(Book record);//可选择增加图书

    Book selectByPrimaryKey(String id);//根据主键查询

    int updateByPrimaryKey(Book record);//修改图书

    int updateByPrimaryKeySelective(Book record);//可选择修改

    int deleteByPrimaryKey(String id);//根据关键值删除

    Page<BookTypeVo> getBookTypeVoList(Integer page, Integer size);//查询全部图书类型

    List<BookTypeVo> getBookTypeVoByTypeId(String typeId);//根据类型ID查询

    Integer getBookTypeVoByTypeIdNum(String typeId);//根据类型ID查询总数量

    List<Book> selectByLike(String blur);//总模糊查询

    List<Book> getBookTypeVoByTypeIAndLike(String typeId,String blur);//分类下模糊查询

}


