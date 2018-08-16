package com.ambow.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jump")
public class JumpController {

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "/index";
    }

    @RequestMapping("/todataAnalysis")
    public String todataAnalysis(){
        return "/dataAnalysis";
    }
}
