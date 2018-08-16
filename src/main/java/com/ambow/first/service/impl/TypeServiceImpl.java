package com.ambow.first.service.impl;

import com.ambow.first.dao.TypeMapper;
import com.ambow.first.entity.Type;
import com.ambow.first.service.TypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

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

    /**
     * 新增分类
     *
     * @param type
     */
    @Override
    public void newType(Type type) {
        type.setId(UUID.randomUUID().toString());
        type.setBookNum(0);
        typeMapper.insert(type);
    }

    /**
     * 根据ID查找全部信息
     *
     * @param id
     * @return
     */
    @Override
    public Type selectByPrimaryKey(String id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改信息
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(Type record) {
        typeMapper.updateByPrimaryKey(record);
        return 0;
    }
}
