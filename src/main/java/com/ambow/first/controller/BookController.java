package com.ambow.first.controller;

import com.ambow.first.entity.Book;
import com.ambow.first.entity.Type;
import com.ambow.first.service.BookService;
import com.ambow.first.service.TypeService;
import com.ambow.first.util.Page;
import com.ambow.first.vo.BookTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "/insert")
    public String insert(Book book){
        bookService.insert(book);
        return  "redirect:/book/list";
    }

    /**
     * 查询全部Vo
     * @param mode
     * @return
     */


    @RequestMapping(value = "/list")
    public String list(Model mode){
        List<BookTypeVo> bookTypeVoList= bookService.getBookTypeVoByTypeId("2");
        mode.addAttribute("list",bookTypeVoList);
        return  "/book/list";
    }

    /**
     * 根据图书类型查询
     * @param mode
     * @return
     */

    @RequestMapping(value = "/listVo")
    public String listVo(Model mode,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "3") Integer size){


        Page<BookTypeVo> bookTypeVoList= bookService.getBookTypeVoList(page,size);

        Integer ye=bookTypeVoList.getTotal()/bookTypeVoList.getSize();

        if(bookTypeVoList.getTotal()% bookTypeVoList.getSize()!=0){

            ye=ye+1;
        }
        System.out.println(ye);
        mode.addAttribute("ye",ye);
        mode.addAttribute("list",bookTypeVoList);
        return  "/book/list";

    }

    /**
     * 查询类型到
     * 新增页面
     */

    @RequestMapping(value = "/toNew")
    public String toNew(Model model){

        List<Type> types=typeService.queryAll();
        model.addAttribute("types",types);
        return "/book/new";
    }
    /**
     * 修改前查询
     */
    @RequestMapping(value = "/toUpdate")
    public String toUpdate(){

        return "/book/new";
    }




}
