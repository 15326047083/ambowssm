package com.ambow.first.controller;

import com.ambow.first.entity.User;
import com.ambow.first.service.UserService;
import com.ambow.first.util.PageUtil;
import org.apache.ibatis.annotations.Param;
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
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 前往新增页面
     *
     * @return
     */
    @RequestMapping(value = "/toInsertUser")
    public String toInsertUser() {
        return "/user/insertUser";
    }

    /**
     * 判断手机号是否已被注册
     * @param phone
     * @return
     */
    @RequestMapping("/checkPhone/{phone}")
    @ResponseBody
    public int checkPhone(@PathVariable("phone")String phone){
        System.out.println(phone);
        if (userService.getUserByPhone(phone)==null){
            return 0; // 未注册
        }
        return 1; // 已经注册
    }

    /**
     * 新增读者
     *
     * @param user
     */
    @RequestMapping(value = "/insertUser")
    public String insertUser(User user) {
        user.setNewDate(new Date());
        user.setBorrowNum(0);
        user.setPassword("000000");
        userService.insert(user);
        return "redirect:selectAll";
    }

    /**
     * 前往修改：查询读者信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/toUpdateUser")
    public String toUpdateUser(String id, Model model) {
        User user = userService.selectByPrimaryKey(id);
        model.addAttribute("userList", user);
        return "/user/updateUser";
    }

    /**
     * 修改读者信息
     *
     * @param user
     */
    @RequestMapping(value = "/updateUser")
    public String updateUser(User user) {
        userService.updateByPrimaryKeySelective(user);
        return "redirect:selectAll";
    }

    /**
     * 查询所有读者带分页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectAll")
    public String selectAll(HttpServletRequest request, Model model) {
        int pageIndex = 1;//设置初始的当前页，页面显示的都是第一页
        int pageSize = 5;//设置每一页显示几条数据,用于计算总页数，此处设置的值必须与sql语句的limit最后的数值一样
        PageUtil<User> pageUtil = new PageUtil<User>();//初始化工具类
        if (request.getParameter("pageIndex") != null) {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        }//对页面上的分页标签传的值,进行获取,也是就点击'上一页或者下一页'传过来的pageindex
        pageUtil.setPageIndex(pageIndex);//保存至工具类
        int number = userService.getPageNumber();//调用service层方法计算出总数据量，就是多少条数据.
        pageUtil.setPageNumber(number);//保存至工具类
        pageUtil.setPageSize(pageSize);//保存至工具类
        if (pageUtil.getPageNumber() % pageUtil.getPageSize() != 0) {    //计算出总页数,并封装到工具类,
            pageUtil.setPageCount(pageUtil.getPageNumber() / pageUtil.getPageSize() + 1);
        } else {
            pageUtil.setPageCount(pageUtil.getPageNumber() / pageUtil.getPageSize());
        }
        int index = (pageIndex - 1) * pageSize;//计算出每一页从数据库中第几条数据开始取值，也就是limit后面的第一个数字
        List<User> userList = userService.selectAllLimit(index);//调用service层的方法，取得数据库中的值
        pageUtil.setList(userList);//保存到工具类中的集合
        model.addAttribute("userList", userList);
        model.addAttribute("pageUtil", pageUtil);//传递到页面，存入值栈中
        model.addAttribute("tiao", "1");
        return "/user/list";
    }

    /**
     * 根据借阅次数查询所有读者带分页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectAllByBorrowNum")
    public String selectAllByBorrowNum(HttpServletRequest request, Model model) {
        int pageIndex = 1;//设置初始的当前页，页面显示的都是第一页
        int pageSize = 5;//设置每一页显示几条数据,用于计算总页数，此处设置的值必须与sql语句的limit最后的数值一样
        PageUtil<User> pageUtil = new PageUtil<User>();//初始化工具类
        if (request.getParameter("pageIndex") != null) {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        }//对页面上的分页标签传的值,进行获取,也是就点击'上一页或者下一页'传过来的pageindex
        pageUtil.setPageIndex(pageIndex);//保存至工具类
        int number = userService.getPageNumber();//调用service层方法计算出总数据量，就是多少条数据.
        pageUtil.setPageNumber(number);//保存至工具类
        pageUtil.setPageSize(pageSize);//保存至工具类
        if (pageUtil.getPageNumber() % pageUtil.getPageSize() != 0) {    //计算出总页数,并封装到工具类,
            pageUtil.setPageCount(pageUtil.getPageNumber() / pageUtil.getPageSize() + 1);
        } else {
            pageUtil.setPageCount(pageUtil.getPageNumber() / pageUtil.getPageSize());
        }
        int index = (pageIndex - 1) * pageSize;//计算出每一页从数据库中第几条数据开始取值，也就是limit后面的第一个数字
        List<User> userList = userService.selectAllByBorrowNumLimit(index);//调用service层的方法，取得数据库中的值
        pageUtil.setList(userList);//保存到工具类中的集合
        model.addAttribute("userList", userList);
        model.addAttribute("pageUtil", pageUtil);//传递到页面，存入值栈中
        model.addAttribute("tiao", "2");
        return "/user/list";
    }

    /**
     * 模糊查询带分页
     *
     * @param selectKey
     */
    @RequestMapping(value = "/likeSelect")
    public String likeSelect(@Param(value = "selectKey") String selectKey, Model model, HttpServletRequest request) {
        int pageIndex = 1;//设置初始的当前页，页面显示的都是第一页
        int pageSize = 5;//设置每一页显示几条数据,用于计算总页数，此处设置的值必须与sql语句的limit最后的数值一样
        PageUtil<User> pageUtil = new PageUtil<User>();//初始化工具类
        if (request.getParameter("pageIndex") != null) {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        }//对页面上的分页标签传的值,进行获取,也是就点击'上一页或者下一页'传过来的pageindex
        pageUtil.setPageIndex(pageIndex);//保存至工具类
        int number = userService.getPageNumberLike(selectKey);//调用service层方法计算出总数据量，就是多少条数据.
        pageUtil.setPageNumber(number);//保存至工具类
        pageUtil.setPageSize(pageSize);//保存至工具类
        if (pageUtil.getPageNumber() % pageUtil.getPageSize() != 0) {    //计算出总页数,并封装到工具类,
            pageUtil.setPageCount(pageUtil.getPageNumber() / pageUtil.getPageSize() + 1);
        } else {
            pageUtil.setPageCount(pageUtil.getPageNumber() / pageUtil.getPageSize());
        }
        int index = (pageIndex - 1) * pageSize;//计算出每一页从数据库中第几条数据开始取值，也就是limit后面的第一个数字
        Map map = new HashMap();
        map.put("pageIndex", pageIndex);
        map.put("selectKey", selectKey);
        List<User> userList = userService.likeSelect(selectKey, index);//调用service层的方法，取得数据库中的值
        pageUtil.setList(userList);//保存到工具类中的集合
        model.addAttribute("selectKey", selectKey);
        model.addAttribute("userList", userList);
        model.addAttribute("pageUtil", pageUtil);//传递到页面，存入值栈中
        model.addAttribute("tiao", "3");
        return "/user/list";
    }

    /**
     * 删除读者信息
     *
     * @param id
     */
    @RequestMapping(value = "/deleteUser")
    public String deleteUser(String id) {
        userService.deleteUser(id);
        return "redirect:selectAll";
    }


    /**
     * 导出为Excel
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/export")
    public String export(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IntrospectionException, IllegalAccessException, ParseException, InvocationTargetException, UnsupportedEncodingException {
        System.out.println(response + " " + request);
        response.reset(); //清除buffer缓存
        // 指定下载的文件名，浏览器都会使用本地编码，即GBK，浏览器收到这个文件名后，用ISO-8859-1来解码，然后用GBK来显示
        // 所以我们用GBK解码，ISO-8859-1来编码，在浏览器那边会反过来执行。
        response.setHeader("Content-Disposition", "attachment;filename=User" + new Date().getTime() + ".xlsx");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        XSSFWorkbook workbook = null;
        //导出Excel
        workbook = userService.exportExcelInfo();
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
        return "redirect:/user/selectAll";
    }

}
