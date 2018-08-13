package com.ambow.first.controller;

import com.ambow.first.entity.User;
import com.ambow.first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin(Model model) {
        User user = new User("as9d87as89d7as987as98dsa98d7as98d7", 0, "雷源", "雷源", "雷源", "雷源", "雷源", "雷源", 152100733, "雷源", "雷源", "雷源",
                "雷源");
        userService.save(user);
        model.addAttribute("user", "雷园");
        return "/login/login";
    }
}
