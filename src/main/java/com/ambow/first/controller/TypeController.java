package com.ambow.first.controller;

import com.ambow.first.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "/toList")
    public String  toList(Model model){
        model.addAttribute("list",typeService.queryAll());
        return "/type/list";
    }
}
