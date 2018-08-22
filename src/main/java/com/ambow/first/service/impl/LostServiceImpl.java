package com.ambow.first.service.impl;

import com.ambow.first.dao.LostMapper;
import com.ambow.first.entity.Lost;
import com.ambow.first.service.LostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Lost getByBorrowId(String borrowId) {
        return lostMapper.getByBorrowId(borrowId);
    }


}
/**
 * 统计失信次数
 * @return
 */

