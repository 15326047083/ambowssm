package com.ambow.first.service.impl;

import com.ambow.first.dao.TypeMapper;
import com.ambow.first.entity.Type;
import com.ambow.first.service.TypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    /**
     * 查看全部类型
     *
     * @return
     */
    @Override
    public List<Type> queryAll() {
        return typeMapper.queryAll();
    }
}
