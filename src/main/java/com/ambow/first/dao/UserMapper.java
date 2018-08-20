package com.ambow.first.dao;

import com.ambow.first.entity.User;
import com.ambow.first.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    int deleteByPrimaryKey(String id); // 根据主键删除

    int insert(User record); // 新增读者

    int insertSelective(User record); // 可选择新增读者

    User selectByPrimaryKey(String id); // 根据主键查询读者信息

    int updateByPrimaryKeySelective(User record); // 可选择根据主键修改

    int updateByPrimaryKey(User record); // 根据主键修改

    List<User> selectAllByBorrowNum(); // 查询所有读者根据借阅次数升序排列放到List集合

    List<User> selectAllByBorrowNumLimit(int pageIndex); // 查询所有读者根据借阅次数升序排列放到List集合带分页

    List<User> selectAll(); //查询所有读者

    List<User> selectAllLimit(int pageIndex); // 查询所有读者带分页

    List<User> likeSelect(@Param("selectKey") String selectKey, @Param("pageIndex") int pageIndex); //模糊查询

    int getPageNumber();  // 获取表中的数据总数

    int getPageNumberLike(String selectKey); // 获得模糊查询后的总记录数

    User getUserByPhone(String phone); // 根据电话号码查询读者
}