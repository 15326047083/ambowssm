package com.ambow.first.service.impl;

import com.ambow.first.dao.UserMapper;
import com.ambow.first.entity.User;
import com.ambow.first.service.UserService;
import com.ambow.first.util.ExcelBean;
import com.ambow.first.util.ExcelUtil;
import com.ambow.first.util.PageUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 新增读者
     *
     * @param record
     * @return
     */
    @Override
    public void insert(User record) {
        userMapper.insert(record);
    }

    /**
     * 查询读者信息
     *
     * @param id
     * @return
     */
    @Override
    public User selectByPrimaryKey(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据主键修改读者
     *
     * @param user
     */
    @Override
    public void updateByPrimaryKey(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    /**
     * 修改读者信息
     *
     * @param user
     */
    @Override
    public void updateByPrimaryKeySelective(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 查询所有读者根据借阅次数排列
     *
     * @return
     */
    @Override
    public List<User> selectAllByBorrowNum() {
        return userMapper.selectAllByBorrowNum();
    }

    /**
     * 查询所有读者根据借阅次数排列带分页
     *
     * @return
     */
    @Override
    public List<User> selectAllByBorrowNumLimit(int pageIndex) {
        return userMapper.selectAllByBorrowNumLimit(pageIndex);
    }

    /**
     * 查询所有读者
     *
     * @return
     */
    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    /**
     * 查询所有读者带分页
     *
     * @return
     */
    @Override
    public List<User> selectAllLimit(int pageIndex) {
        return userMapper.selectAllLimit(pageIndex);
    }

    /**
     * 模糊查询加分页
     * @param selectKey
     * @param pageIndex
     * @return
     */
    @Override
    public List<User> likeSelect(String selectKey, int pageIndex) {
        return userMapper.likeSelect(selectKey, pageIndex);
    }

    /**
     * 获取表中的数据总数
     *
     * @return
     */
    @Override
    public int getPageNumber() {
        return userMapper.getPageNumber();
    }

    /**
     * 获得模糊查询后的总记录数
     *
     * @param selectKey
     * @return
     */
    @Override
    public int getPageNumberLike(String selectKey) {
        return userMapper.getPageNumberLike(selectKey);
    }

    /**
     * 根据读者ID删除信息
     *
     * @param id
     */
    @Override
    public void deleteUser(String id) {
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据电话查询读者
     *
     * @param phone
     * @return
     */
    @Override
    public User getUserByPhone(String phone) {
        return userMapper.getUserByPhone(phone);
    }

    /**
     * 导出表
     *
     * @return
     */

    @Override
    public XSSFWorkbook exportExcelInfo() {
        //根据条件查询数据，把数据装载到一个list中
        List<User> list = userMapper.selectAllByBorrowNum();
        List<ExcelBean> excel = new ArrayList<>();
        Map<Integer, List<ExcelBean>> map = new LinkedHashMap<>();
        XSSFWorkbook xssfWorkbook = null;
        //设置标题栏
        excel.add(new ExcelBean("读者ID", "id", 0));
        excel.add(new ExcelBean("读者姓名", "name", 0));
        excel.add(new ExcelBean("性别", "sex", 0));
        excel.add(new ExcelBean("年龄", "age", 0));
        excel.add(new ExcelBean("电话", "phone", 0));
        excel.add(new ExcelBean("注册时间", "newDate", 0));
        excel.add(new ExcelBean("注销时间", "outDate", 0));
        excel.add(new ExcelBean("地址", "place", 0));
        excel.add(new ExcelBean("借阅次数", "borrowNum", 0));
        excel.add(new ExcelBean("密码", "password", 0));

        map.put(0, excel);
        String sheetName = "sheet1";
        //调用ExcelUtil的方法
        try {
            xssfWorkbook = ExcelUtil.createExcelFile(User.class, list, map, sheetName);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return xssfWorkbook;
    }

}
