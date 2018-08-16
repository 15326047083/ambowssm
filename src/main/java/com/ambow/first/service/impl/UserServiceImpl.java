package com.ambow.first.service.impl;

import com.ambow.first.dao.UserMapper;
import com.ambow.first.entity.User;
import com.ambow.first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 新增读者
     * @param record
     * @return
     */
    @Override
    public void insert(User record) {
       userMapper.insert(record);
    }

    /**
     * 查询读者信息
     * @param id
     * @return
     */
    @Override
    public User selectByPrimaryKey(String id) {
        return userMapper.selectByPrimaryKey(id);
    }
    /**
     * 修改读者信息
     * @param user
     */
    @Override
    public void updateByPrimaryKeySelective(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
    /**
     * 查询所有读者根据借阅次数排列
     * @return
     */
    @Override
    public List<User> selectAllByBorrowNum() {
        return userMapper.selectAllByBorrowNum();
    }

    /**
     * 查询所有读者
     * @return
     */
    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    /**
     * 根据读者ID删除信息
     * @param id
     */
    @Override
    public void deleteUser(String id) {
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据电话查询读者
     * @param phone
     * @return
     */
    @Override
    public User getUserByPhone(String phone) {
        return userMapper.getUserByPhone(phone);
    }
}
