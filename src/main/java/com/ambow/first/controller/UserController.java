package com.ambow.first.controller;

import com.ambow.first.entity.User;
import com.ambow.first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 前往新增页面
     * @return
     */
    @RequestMapping(value = "toInsertUser.action")
    public String toInsertUser(){
        return "/user/insertUser";
    }

    /**
     * 新增读者
     * @param user
     */
    @RequestMapping(value="insertUser.action")
    public String insertUser(User user){
        user.setNewDate(new Date());
        user.setBorrowNum(0);
        user.setPassword("000000");
        userService.insert(user);
        return "redirect:selectAll.action";
    }

    /**
     * 前往修改：查询读者信息
     * @param id
     * @return
     */
    @RequestMapping(value="toUpdateUser.action")
    public String toUpdateUser(String id,Model model){
        User user = userService.selectByPrimaryKey(id);
        model.addAttribute("userList",user);
        return "/user/updateUser";
    }

    /**
     * 修改读者信息
     * @param user
     */
    @RequestMapping(value ="updateUser.action")
    public String updateUser(User user){
        userService.updateByPrimaryKeySelective(user);
        return "redirect:selectAll.action";
    }

    /**
     * 查询所有读者
     * @param model
     * @return
     */
    @RequestMapping(value = "selectAll.action")
    public String selectAll(Model model){
        List<User> userList = userService.selectAll();
        model.addAttribute("userList",userList);
        return "/user/list";
    }

    /**
     * 根据借阅次数查询所有读者
     * @param model
     * @return
     */
    @RequestMapping(value = "selectAllByBorrowNum")
    public String selectAllByBorrowNum(Model model){
        List<User> userList=userService.selectAllByBorrowNum();
        model.addAttribute("userList",userList);
        return "/user/list";
    }

    /**
     * 删除读者信息
     * @param id
     */
    @RequestMapping(value = "deleteUser.action")
    public String deleteUser(String id){
        userService.deleteUser(id);
        return "redirect:selectAll.action";
    }
}
