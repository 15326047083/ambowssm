package com.ambow.first.controller;

import com.ambow.first.dao.DonateMapper;
import com.ambow.first.service.DonateService;
import com.ambow.first.vo.DonateCountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/dataAnalysis")
public class DataAnalysisController {

    @Autowired
    private DonateService donateService;
    @RequestMapping("/toDataAnalysis")
    public String toDataAnalysis(Model model){
        List<DonateCountVo> list=new ArrayList<DonateCountVo>();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = simpleDateFormat.parse("2017-08-01");
            Date date2=simpleDateFormat.parse("2018-09-10");
            list=donateService.queryAllByDate(date1,date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int[] count=new int[list.size()];
        Date[] date =new Date[list.size()];
        int i=0;
        for (DonateCountVo v:list){
            count[i]=v.getCount();
            date[i]=v.getDonateTime();
        //    System.out.println(count[i]);
          //  System.out.println(date[i]);
        }
        model.addAttribute("count",count);
        model.addAttribute("date",date);


        return "/dataAnalysis";
    }

}
