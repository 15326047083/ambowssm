package com.ambow.first.controller;

import com.ambow.first.entity.Lost;
import com.ambow.first.service.LostService;
import com.ambow.first.util.Page;
import com.ambow.first.vo.LostUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/lost")
public class LostController {
    @Autowired
    private LostService lostService;

    /**
     * 分页查询失信表
     *
     * @param model
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/toLost")
    public String selectAllPage(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam
            (defaultValue = "3") Integer size) {
        Page<LostUserVo> lostPage = lostService.selectAllPage(page, size);
        Integer ye = lostPage.getTotal() / lostPage.getSize();
        if (lostPage.getTotal() % lostPage.getSize() != 0) {
            ye = ye + 1;

        }
        if (ye == 0) {
            ye = 1;
        }
        model.addAttribute("ye", ye);
        model.addAttribute("list", lostPage);
        return "/lost/list";

    }
}
