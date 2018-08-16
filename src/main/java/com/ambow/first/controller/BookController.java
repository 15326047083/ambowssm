package com.ambow.first.controller;

import com.ambow.first.entity.Book;
import com.ambow.first.service.BookService;
import com.ambow.first.vo.BookTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired

    private BookService bookService;

    @RequestMapping(value = "/insert")
    public String insert(Book book){

        book=new Book();

       bookService.insert(book);
        return  "/book/new";

    }

    @RequestMapping(value = "/list")
    public String list(Model mode){


       List<BookTypeVo> bookTypeVoList= bookService.getBookTypeVoList();
       mode.addAttribute("list",bookTypeVoList);
        return  "/book/list";

    }



}
