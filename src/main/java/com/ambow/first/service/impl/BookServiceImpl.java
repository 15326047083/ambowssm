package com.ambow.first.service.impl;

import com.ambow.first.dao.BookMapper;
import com.ambow.first.entity.Book;
import com.ambow.first.service.BookService;

import com.ambow.first.util.Page;
import com.ambow.first.vo.BookTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    /**
     * 全查图书
     */


    @Override
    public List<Book> selectAlllBook() {
        return bookMapper.selectAlllBook();
    }

    /**
     * 添加图书
     *
     * @param record
     * @return
     */
    @Override
    public int insert(Book record) {

        record.setNum(0);
        return bookMapper.insert(record);
    }

    /**
     * 可选择增加
     *
     * @param record
     * @return
     */
    @Override
    public int insertSelective(Book record) {
        return bookMapper.insertSelective(record);
    }

    /**
     * 根据ID查询图书
     *
     * @param id
     * @return
     */

    @Override
    public Book selectByPrimaryKey(String id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改图书
     *
     * @param record
     * @return
     */

    @Override
    public int updateByPrimaryKey(Book record) {
        return bookMapper.updateByPrimaryKey(record);
    }

    /**
     * 可选择修改
     *
     * @param record
     * @return
     */

    @Override
    public int updateByPrimaryKeySelective(Book record) {
        return bookMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(String id) {
        return bookMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据类型Id查询信息
     *
     * @param
     * @return
     */
    @Override

    public Page<BookTypeVo> getBookTypeVoList(Integer page, Integer size) {

        Page<BookTypeVo> pages = new Page<>();
        pages.setTotal(bookMapper.getBookTypeVoListNum());
        pages.setPage(page);
        pages.setSize(size);
        List<BookTypeVo> bookTypeVoList = bookMapper.getBookTypeVoList((page - 1) * size, pages.getSize());
        pages.setRows(bookTypeVoList);



        return pages;
    }

    /**
     * 根据类型ID
     * 查询图书及类型
     *
     * @param typeId
     * @return
     */
    @Override
    public List<BookTypeVo> getBookTypeVoByTypeId(String typeId) {
        return bookMapper.getBookTypeVoByTypeId(typeId);
    }

    /**
     * 分页
     * 根据类型ID
     * 查询图书及类型总数量
     *
     * @param typeId
     * @return
     */

    @Override
    public Integer getBookTypeVoByTypeIdNum(String typeId) {
        return bookMapper.getBookTypeVoByTypeIdNum(typeId);
    }

    /**
     * 总模糊查询
     *
     * @param blur
     * @return
     */
    @Override
    public List<Book> selectByLike(String blur) {

        blur = "%" + blur + "%";
        System.out.println(blur);
        return bookMapper.selectByLike(blur);
    }

    /**
     * 基于分类下的模糊查询
     *
     * @param blur
     * @return
     */
    @Override
    public List<Book> getBookTypeVoByTypeIAndLike(String typeId, String blur) {
        blur = "%" + blur + "%";

        return bookMapper.getBookTypeVoByTypeIAndLike(typeId, blur);
    }
}
