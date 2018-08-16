package com.ambow.first.controller;

import com.ambow.first.entity.Type;
import com.ambow.first.service.TypeService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "/toList")
    public String toList(Model model) {
        model.addAttribute("list", typeService.queryAll());
        return "/type/list";
    }

    @RequestMapping(value = "/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") String id, Model model) {

        Type type = typeService.selectByPrimaryKey(id);
        model.addAttribute("type", type);
        return "/type/update";
    }

    @RequestMapping(value = "/toNew")
    public String toNew() {
        return "/type/new";
    }

    @RequestMapping(value = "new")
    public String newType(Type type) {
        typeService.newType(type);
        return "redirect:/type/toList";
    }

    @RequestMapping(value = "update")
    public String update(Type type) {
        typeService.updateByPrimaryKey(type);
        return "redirect:/type/toList";
    }

    /**
     * 导出为Excel
     *
     * @return
     */
    @RequestMapping("/export")
    @ResponseBody
    public String export(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IntrospectionException, IllegalAccessException, ParseException, InvocationTargetException, UnsupportedEncodingException {
        System.out.println(response+" "+request);
            response.reset(); //清除buffer缓存
            // 指定下载的文件名，浏览器都会使用本地编码，即GBK，浏览器收到这个文件名后，用ISO-8859-1来解码，然后用GBK来显示
            // 所以我们用GBK解码，ISO-8859-1来编码，在浏览器那边会反过来执行。
            response.setHeader("Content-Disposition", "attachment;filename=Type"+new Date().getTime()+".xlsx");
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            XSSFWorkbook workbook = null;
            //导出Excel对象
            workbook = typeService.exportExcelInfo();
            OutputStream output;
            try {
                output = response.getOutputStream();
                BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
                bufferedOutPut.flush();
                workbook.write(bufferedOutPut);
                bufferedOutPut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return "redirect:/type/toList";
    }


}
