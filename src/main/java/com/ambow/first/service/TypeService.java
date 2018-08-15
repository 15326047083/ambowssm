package com.ambow.first.service;

import com.ambow.first.entity.Type;

import java.util.List;

public interface TypeService {
    /**
     * 查看全部类型
     * @return
     */
    List<Type> queryAll();
}
