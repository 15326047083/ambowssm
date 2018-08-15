package com.ambow.first.controller;

import com.ambow.first.entity.Book;
import com.ambow.first.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "insert.action")
    public String insert(Book book){

        book=new Book();

       bookService.insert(book);
        return  "";

    }


}
