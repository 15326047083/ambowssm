package com.ambow.first.service;

import com.ambow.first.entity.User;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public interface UserService {

    void insert(User user); // 新增读者

    User selectByPrimaryKey(String id); // 查询读者信息

    void updateByPrimaryKey(User user); // 根据主键修改

    void updateByPrimaryKeySelective(User user); // 修改读者信息

    List<User> selectAllByBorrowNum(); // 查询所有读者并按借阅次数排列

    List<User> selectAll(); // 查询所有读者

    void deleteUser(String id); // 根据读者ID删除信息

    User getUserByPhone(String phone); // 根据电话查询读者

    XSSFWorkbook exportExcelInfo(); // 导出表

}
