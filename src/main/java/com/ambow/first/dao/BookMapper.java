package com.ambow.first.dao;

import com.ambow.first.entity.Book;
import com.ambow.first.vo.BookTypeVo;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface BookMapper {

    List<Book>  selectAlllBook();//图书全查

    int deleteByPrimaryKey(String id);//根据关键值删除

    int insert(Book record);//添加图书

    int insertSelective(Book record);//可选择增加图书

    Book selectByPrimaryKey(String id);//根据ID查询图书

    int updateByPrimaryKeySelective(Book record);//可选择修改

    int updateByPrimaryKey(Book record);//修改图书

    List<BookTypeVo> getBookTypeVoList(@Param("page") Integer page,@Param("size") Integer size);//查询全部图书类型

    Integer getBookTypeVoListNum();//全部图书类型数量

    List<BookTypeVo> getBookTypeVoByTypeId(String typeId);//根据类型ID查询

    Integer getBookTypeVoByTypeIdNum(String typeId);//根据类型ID查询总数量

    List<Book> selectByLike(String blur);//总模糊查询

    List<Book> getBookTypeVoByTypeIAndLike(@Param("typeId") String typeId, @Param("blur")String blur);//分类下模糊查询

}