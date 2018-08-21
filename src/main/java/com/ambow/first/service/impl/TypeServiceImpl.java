package com.ambow.first.service.impl;

import com.ambow.first.dao.TypeMapper;
import com.ambow.first.entity.Type;
import com.ambow.first.service.TypeService;

import com.ambow.first.util.ExcelBean;
import com.ambow.first.util.ExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.*;

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

    @Override
    public XSSFWorkbook exportExcelInfo(){
        //根据条件查询数据，把数据装载到一个list中
        List<Type> list = typeMapper.queryAll();
        List<ExcelBean> excel=new ArrayList<>();
        Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();
        XSSFWorkbook xssfWorkbook=null;
        //设置标题栏
        excel.add(new ExcelBean("序号","id",0));
        excel.add(new ExcelBean("分类名称","name",0));
        excel.add(new ExcelBean("位置","place",0));
        excel.add(new ExcelBean("图书数量","bookNum",0));

        map.put(0, excel);
        String sheetName = "sheet1";
        //调用ExcelUtil的方法
        try {
            xssfWorkbook = ExcelUtil.createExcelFile(Type.class, list, map, sheetName);
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

    /**
     * 图书数量+1
     *
     * @param id
     */
    @Override
    public void addBookNum(String id) {
        typeMapper.addBookNum(id);
    }

    /**
     * 图书数量-1
     *
     * @param id
     */
    @Override
    public void subBookNum(String id) {
        Type type=typeMapper.selectByPrimaryKey(id);
        if (type.getBookNum()>0){
            typeMapper.subBookNum(id);
        }
    }

}
