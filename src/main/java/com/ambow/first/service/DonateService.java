package com.ambow.first.service;

import com.ambow.first.entity.Donate;
import com.ambow.first.util.Page;
import com.ambow.first.vo.DonateCountVo;

import java.util.Date;
import java.util.List;

public interface DonateService {

    /**
     * 按日期查询借书列表
     * @param start
     * @param end
     * @return
     */
    List<DonateCountVo> getBorrowByDate(Date start, Date end);

    /**按日期全部列表
     * 查找
     * @return
     */
    List<DonateCountVo> queryAllByDate(Date start, Date end);
    /**
     * 添加一条借书记录
     * @param donate
     */
    void insert(Donate donate);

    /**
     * 将两个date数组合并去重为一个数组,求长度
     * @param date1 第一个数组
     * @param date2 第二个数组
     * @return
     */
    int getAllDate (Date[] date1 ,Date[] date2);

    /**
     * 查询全部捐赠信息
     * @return
     */
    Page<Donate> selectAll(Integer page, Integer size);


}
