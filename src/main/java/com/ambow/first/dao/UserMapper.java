package com.ambow.first.dao;

import com.ambow.first.entity.User;

import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(String id); // 根据主键删除

    int insert(User record); // 新增读者

    int insertSelective(User record); // 可选择新增读者

    User selectByPrimaryKey(String id); // 根据主键查询读者信息

    int updateByPrimaryKeySelective(User record); // 可选择根据主键修改

    int updateByPrimaryKey(User record); // 根据主键修改

    List<User> selectAllByBorrowNum(); // 查询所有读者根据借阅次数升序排列放到List集合

    List<User> selectAll(); // 查询所有读者

    User getUserByPhone(String phone); // 根据电话号码查询读者
}