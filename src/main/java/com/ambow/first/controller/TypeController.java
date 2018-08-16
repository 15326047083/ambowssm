package com.ambow.first.controller;

import com.ambow.first.entity.Type;
import com.ambow.first.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") String id,Model model){

        Type type=typeService.selectByPrimaryKey(id);
        model.addAttribute("type",type);
        return "/type/update";
    }

    @RequestMapping(value = "/toNew")
    public String toNew(){
        return "/type/new";
    }
    @RequestMapping(value = "new")
    public String newType(Type type){
        typeService.newType(type);
        return "redirect:/type/toList";
    }

    @RequestMapping(value = "update")
    public String update(Type type){
        typeService.updateByPrimaryKey(type);
        return "redirect:/type/toList";
    }

}
