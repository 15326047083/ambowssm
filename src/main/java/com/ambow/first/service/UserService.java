package com.ambow.first.service;

import com.ambow.first.entity.User;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;


public interface UserService {

    boolean insert(User user); // 新增读者

    User selectByPrimaryKey(String id); // 查询读者信息

    void updateByPrimaryKey(User user); // 根据主键修改

    boolean updateByPrimaryKeySelective(User user); // 修改读者信息

    List<User> selectAllByBorrowNum(); // 查询所有读者并按借阅次数排列

    List<User> selectAllByBorrowNumLimit(int pageIndex); // 查询所有读者并按借阅次数排列带分页

    List<User> selectAll(); // 查询所有读者

    List<User> selectAllLimit(int pageIndex); // 查询所有读者带分页

    List<User> likeSelect( String selectKey,int pageIndex); //模糊查询

    int getPageNumber(); // 获取表中的数据总数

    int getPageNumberLike(String selectKey); // 获得模糊查询后的总记录数

    boolean deleteUser(String id); // 根据读者ID删除信息

    User getUserByPhone(String phone); // 根据电话查询读者

    XSSFWorkbook exportExcelInfo(); // 导出表

}
