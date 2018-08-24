package com.ambow.first.controller;

import com.ambow.first.dao.DonateMapper;
import com.ambow.first.entity.Donate;
import com.ambow.first.service.DonateService;
import com.ambow.first.util.Page;
import com.ambow.first.vo.BookDonateVo;
import com.ambow.first.vo.CountDateVo;
import com.ambow.first.vo.DonateCountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/dataAnalysis")
public class DataAnalysisController {

    @Autowired
    private DonateService donateService;

    /**
     * 向页面传入需要的vo
     * @param start  从jsp接收到的开始日期
     * @param end    从jsp接收到的结束日期
     * @return
     */
    @RequestMapping("/toDataAnalysis")
    @ResponseBody
    public CountDateVo toDataAnalysis(@RequestParam("start") String start, @RequestParam("end") String end) {

        List<DonateCountVo> list1 = new ArrayList<DonateCountVo>();
        List<DonateCountVo> list2 = new ArrayList<DonateCountVo>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date_1;
            Date date_2;
            if ("".equals(start)) {
                start = null;
                date_1 = null;
            } else {
                date_1 = simpleDateFormat.parse(start);
            }
            if ("".equals(end)) {
                end = null;
                date_2 = null;
            } else {
                date_2 = simpleDateFormat.parse(end);
            }
            list1 = donateService.queryAllByDate(date_1, date_2);
            list2=donateService.getBorrowByDate(date_1,date_2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int[] count1 = new int[list1.size()];
        Date[] date1 = new Date[list1.size()];
        int[] count2 = new int[list2.size()];
        Date[] date2 = new Date[list2.size()];
        int i = 0;
        for (DonateCountVo v : list1) {
            count1[i] = v.getCount();
            date1[i] =v.getDonateTime();
            i++;
        }
        i=0;
        for (DonateCountVo v : list2) {
            count2[i] = v.getCount();
            date2[i] = v.getDonateTime();
            i++;
        }
        //得到两个日期数组去重后的长度
        int length=donateService.getAllDate(date1,date2);

        int[] n1=new int[length];
        int[] n2=new int[length];
        String[] date=new String[length];
        //将无日期的对应借书、捐书的数量设置为0
        int p=0;
        int j=0;
        i=0;
        for (p=0;p<length;p++) {
            if (i==date1.length){
                break;
            }
            if (j==date2.length){
                break;
            }
            if (date1[i].before(date2[j])) {  //date1 在前
                date[p] = simpleDateFormat.format(date1[i]);
                n1[p] = count1[i];
                n2[p] = 0;
                i++;
            } else if (date1[i].after(date2[j])) {  // date2 在前
                date[p] = simpleDateFormat.format(date2[j]);
                n1[p] = 0;
                n2[p] = count2[j];
                j++;
            } else {                          //date1 = date2
                date[p] = simpleDateFormat.format(date1[i]);
                n1[p] = count1[i];
                n2[p] = count2[j];
                i++;
                j++;
            }
        }
            while (i<date1.length){
                date[p]=simpleDateFormat.format(date1[i]);
                n1[p]=count1[i];
                n2[p]=0;
                i++;
                p++;
            }
            while (j<date2.length){
                date[p]=simpleDateFormat.format(date2[j]);
                n1[p] = 0;
                n2[p] = count2[j];
                j++;
                p++;
            }
        CountDateVo countDateVo = new CountDateVo();
        countDateVo.setCount1(n1);
        countDateVo.setCount2(n2);
        countDateVo.setDate(date);

        return countDateVo;
    }


    /**
     * 查询捐赠信息
     */
    @RequestMapping(value = "/getDonate")
    public String getDonate(Model mode,@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer size) {

        String date=null;

        Page<BookDonateVo> list=donateService.selectAll(page,size);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<BookDonateVo> donateVoList=list.getRows();
        for (BookDonateVo bookDonate: donateVoList
             ) {
            date=sdf.format(bookDonate.getDonateTime());

        }
        Integer ye = list.getTotal() / list.getSize();

        if (list.getTotal() % list.getSize() != 0) {

            ye = ye + 1;
        }
        if (ye == 0) {
            ye = 1;
        }
        mode.addAttribute("list", list);
        mode.addAttribute("ye", ye);
        mode.addAttribute("root","donate");
        mode.addAttribute("date",date);
        return "/book/listDonate";
    }


}
