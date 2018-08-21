package com.ambow.first.service.impl;

import com.ambow.first.dao.BorrowMapper;
import com.ambow.first.entity.Borrow;
import com.ambow.first.service.BorrowService;

import com.ambow.first.util.Page;
import com.ambow.first.vo.BorrowBookUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowMapper borrowMapper;
    /**
     * 根据主键删除借阅记录
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(String id) {
        int i= borrowMapper.deleteByPrimaryKey(id);
        return i;
    }

    /**
     * 根据主键查询借阅记录
     * @param id
     * @return
     */

    @Override
    public Borrow selectByPrimaryKey(String id) {
        return borrowMapper.selectByPrimaryKey(id);
    }

    /**
     * g根据主键修改
     * @param record
     * @return
     */

    @Override
    public int updateByPrimaryKey(Borrow record) {
        return borrowMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据ID可选择性修改
     * @param record
     * @return
     */

    @Override
    public int updateByPrimaryKeySelective(Borrow record) {

        return borrowMapper.updateByPrimaryKeySelective(record);

    }




    /**
     * 分頁查询User book borrow 表的全部信息
     * @return
     */
    @Override
    public Page<BorrowBookUserVo> selectBorrowUserBook(Integer page, Integer size) {
        Page<BorrowBookUserVo> pages=new Page<>();
        pages.setTotal(borrowMapper.selectAllCount());
        pages.setPage(page);
        pages.setSize(size);
        List<BorrowBookUserVo> borrowBookUserVo=borrowMapper.selectBorrowUserBook((page-1)*size,pages.getSize());
        pages.setRows(borrowBookUserVo);
        return pages;
    }
    /**
     * 模糊查询借阅列表带分页
     * @return
     */
    @Override
    public Page<BorrowBookUserVo> selectBorrowLike(Integer page, Integer size, String mohu) {
        mohu="%"+mohu+"%";
        Page<BorrowBookUserVo> pages=new Page<>();
        pages.setTotal(borrowMapper.selectAllCountLike(mohu));
        System.out.println("zonggpng:"+borrowMapper.selectAllCountLike(mohu));
        pages.setPage(page);
        pages.setSize(size);
        List<BorrowBookUserVo> borrowBookUserVo=borrowMapper.selectBorrowLike((page-1)*size,pages.getSize(),mohu);
        pages.setRows(borrowBookUserVo);
        return pages;
    }

    /**
     * 可选择性增加
     * 增加借书信息
     * @param record
     * @return
     */
    @Override
    public int insertSelective(Borrow record) {
        //获取借书时间
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            record.setBorrowDate(dateFormat.parse(dateFormat.format(new Date())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 获取十天后的时间
        SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE,10);

        try {
            record.setsRDate(d.parse(d.format(c.getTime())));
            //把十天后的时间转化成时间戳的格式
            record.setsRTimeStamp(d.parse(d.format(c.getTime())).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return borrowMapper.insertSelective(record);
    }

    /**
     * 还书修改借阅列表的归还状态
     * @param borrow
     * @return
     */
    @Override
    public int updateByBookId(Borrow borrow) {
        return borrowMapper.updateByBookId(borrow);
    }

    @Override
    public Borrow getByBookId(String bookId) {
        return borrowMapper.getByBookId(bookId);
    }


}
