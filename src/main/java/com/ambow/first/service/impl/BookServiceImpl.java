package com.ambow.first.service.impl;

import com.ambow.first.dao.BookMapper;
import com.ambow.first.entity.Book;
import com.ambow.first.entity.Type;
import com.ambow.first.service.BookService;

import com.ambow.first.util.ExcelBean;
import com.ambow.first.util.ExcelUtil;
import com.ambow.first.util.Page;
import com.ambow.first.vo.BookTypeVo;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
     * @param book1
     * @return
     */
    @Override
    public int insert(Book book1) {


        return bookMapper.insert(book1);
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
     * 单查
     *
     * @param id
     * @return
     */
    @Override
    public BookTypeVo selectTypeByKey(String id) {
        return bookMapper.selectTypeByKey(id);
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
        System.out.println(record.toString());
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
     * 基于分类下的模糊查询
     *
     * @param blur
     * @return
     */
    @Override
    public Page<BookTypeVo> getBookTypeVoByTypeIAndLike(String typeId, String blur, Integer page, Integer size) {
    //    blur = "%" + blur + "%";
        Page<BookTypeVo> pages = new Page<>();
        pages.setTotal(bookMapper.getBookTypeVoByTypeIAndLikeNum(typeId, blur));
        System.out.println(blur);
        System.out.println(typeId);
        pages.setPage(page);
        pages.setSize(size);
        List<BookTypeVo> bookTypeVoList = bookMapper.getBookTypeVoByTypeIAndLike(typeId, blur, (page - 1) * size, pages.getSize());
        System.out.println(bookTypeVoList.toString());
        pages.setRows(bookTypeVoList);
        return pages;
    }

    /**
     * 排行
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<BookTypeVo> getBookTypeVoByTypeIdSort(Integer page, Integer size) {
        Page<BookTypeVo> pages = new Page<>();
        pages.setTotal(bookMapper.getBookTypeVoByTypeIdSortNum());
        System.out.println(bookMapper.getBookTypeVoByTypeIdSortNum());
        pages.setPage(page);
        pages.setSize(size);
        List<BookTypeVo> bookTypeVoList = bookMapper.getBookTypeVoByTypeIdSort((page - 1) * size, pages.getSize());
        pages.setRows(bookTypeVoList);
        return pages;

    }
    @Override
    public XSSFWorkbook exportExcelInfo(){
        //根据条件查询数据，把数据装载到一个list中
        List<BookTypeVo> list = bookMapper.queryAll();
        List<ExcelBean> excel=new ArrayList<>();
        Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();
        XSSFWorkbook xssfWorkbook=null;
        //设置标题栏
        excel.add(new ExcelBean("类型ID","typeId",0));
        excel.add(new ExcelBean("类型名称","typeName",0));
        excel.add(new ExcelBean("位置","typePlace",0));
        excel.add(new ExcelBean("图书数量","bookNum",0));
        excel.add(new ExcelBean("图书编号","bookId",0));
        excel.add(new ExcelBean("图书名称","bookName",0));
        excel.add(new ExcelBean("图书作者","bookAuthorName",0));
        excel.add(new ExcelBean("图书出版社","bookPress",0));
        excel.add(new ExcelBean("图书出版日期","bookPublishDate",0));
        excel.add(new ExcelBean("图书简介","bookInfo",0));
        excel.add(new ExcelBean("图书状态","bookStatus",0));
        excel.add(new ExcelBean("被借次数","bookBorrowNum",0));
        excel.add(new ExcelBean("图书备注","bookRemark",0));
        map.put(0, excel);
        String sheetName = "sheet1";
        //调用ExcelUtil的方法
        try {
            xssfWorkbook = ExcelUtil.createExcelFile(BookTypeVo.class, list, map, sheetName);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return xssfWorkbook;
    }
}
