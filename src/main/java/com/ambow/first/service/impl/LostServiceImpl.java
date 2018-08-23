package com.ambow.first.service.impl;

import com.ambow.first.dao.LostMapper;
import com.ambow.first.entity.Lost;
import com.ambow.first.service.LostService;

import com.ambow.first.util.Page;
import com.ambow.first.vo.LostUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostServiceImpl implements LostService {
    @Autowired
    private LostMapper lostMapper;

    /**
     * 增加失信记录
     *
     * @param record
     * @return
     */
    @Override
    public int insertSelective(Lost record) {
        return lostMapper.insertSelective(record);
    }

    @Override
    public int insert(Lost record) {
        return lostMapper.insert(record);
    }

    /**
     * 统计失信次数
     * @param phone
     * @return
     */
    @Override
    public Integer selectCountUser(String phone) {
        return lostMapper.selectCountUser(phone);
    }

    /**
     * 根据borrowid查询失信表
     * @param borrowId
     * @return
     */
    @Override
    public Lost getByBorrowId(String borrowId) {
        return lostMapper.getByBorrowId(borrowId);
    }
    /**
     * 分页查询失信表
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<LostUserVo> selectAllPage(Integer page, Integer size) {
        Page<LostUserVo> pages=new Page<>();
        pages.setTotal(lostMapper.selectLostCount());
        pages.setPage(page);
        pages.setSize(size);
        List<LostUserVo> borrowBookUserVo=lostMapper.selectAllPage((page-1)*size,pages.getSize());
        pages.setRows(borrowBookUserVo);
        return pages;
    }





}
/**
 * 统计失信次数
 * @return
 */

