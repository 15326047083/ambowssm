package com.ambow.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/jump")
public class JumpController {

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "/index";
    }

    @RequestMapping("/todataAnalysis")
    public String todataAnalysis() {
        return "/dataAnalysis";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "/user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("psw")
            String psw, Model model) {
        if ("admin".equals(username) && "admin".equals(psw)) {
            Map<String, String> admin = new HashMap<String, String>();
            admin.put("username", "admin");
            admin.put("psw", "admin");
            request.getSession().setAttribute("admin", admin);
            return "redirect:/jump/toIndex";
        } else {
            model.addAttribute("error", 1);
            return "/user/login";
        }
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/jump/toIndex";
    }
}
