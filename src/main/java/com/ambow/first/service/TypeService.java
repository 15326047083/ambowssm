package com.ambow.first.service;

import com.ambow.first.entity.Type;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public interface TypeService {
    /**
     * 查看全部类型
     * @return
     */
    List<Type> queryAll();

    /**
     * 新增分类
     * @param type
     */
    void newType(Type type);

    /**
     * 根据ID查找全部信息
     * @param id
     * @return
     */
    Type selectByPrimaryKey(String id);

    /**
     * 修改信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Type record);

    XSSFWorkbook exportExcelInfo();
}
