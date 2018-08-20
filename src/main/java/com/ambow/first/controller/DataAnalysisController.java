package com.ambow.first.controller;

import com.ambow.first.dao.DonateMapper;
import com.ambow.first.service.DonateService;
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

    @RequestMapping("/toDataAnalysis")
    @ResponseBody
    public CountDateVo toDataAnalysis(Model model, @RequestParam("start") String start, @RequestParam("end") String end) {

        List<DonateCountVo> list = new ArrayList<DonateCountVo>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1;
            Date date2;
            if ("".equals(start)) {
                start = null;
                date1 = null;
            } else {
                date1 = simpleDateFormat.parse(start);
            }
            if ("".equals(end)) {
                end = null;
                date2 = null;
            } else {
                date2 = simpleDateFormat.parse(end);
            }
            list = donateService.queryAllByDate(date1, date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        int[] count = new int[list.size()];
        String[] date = new String[list.size()];
        int i = 0;
        for (DonateCountVo v : list) {
            count[i] = v.getCount();
            date[i] = simpleDateFormat.format(v.getDonateTime());
            System.out.println(date[i]);
            i++;

        }
        CountDateVo countDateVo = new CountDateVo();
        countDateVo.setCount(count);
        countDateVo.setDate(date);
        System.out.println(list);
        return countDateVo;
    }

}
