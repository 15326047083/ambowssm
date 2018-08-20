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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private TypeService typeService;

    /**
     * 添加图书
     *
     * @param book
     * @return
     */
    @RequestMapping(value = "/insert")
    public String insert(Book book) {

        bookService.insert(book);
        return "redirect:/book/list";
    }

    /**
     * 根据类型Id查询
     *
     * @param mode
     * @return
     */


    @RequestMapping(value = "/list")
    public String list(Model mode) {
        Page<BookTypeVo> bookTypeVoList = bookService.getBookTypeVoByTypeId("2", 1, 2);
        mode.addAttribute("list", bookTypeVoList);
        return "/book/list";
    }

    /**
     * 图书类型查询
     *
     * @param mode
     * @return
     */

    @RequestMapping(value = "/listVo")
    public String listVo(Model mode, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer size) {


        Page<BookTypeVo> bookTypeVoList = bookService.getBookTypeVoList(page, size);

        Integer ye = bookTypeVoList.getTotal() / bookTypeVoList.getSize();

        if (bookTypeVoList.getTotal() % bookTypeVoList.getSize() != 0) {

            ye = ye + 1;
        }

        mode.addAttribute("ye", ye);
        mode.addAttribute("list", bookTypeVoList);
        return "/book/list";

    }

    /**
     * 图书类型下模糊查询
     */


    /**
     * 查询类型到
     * 新增页面
     */

    @RequestMapping(value = "/toNew")
    public String toNew(Model model) {

        List<Type> types = typeService.queryAll();
        model.addAttribute("types", types);
        return "/book/new";
    }

    /**
     * 修改前查询
     */
    @RequestMapping(value = "/toUpdate")
    public String toUpdate(String bookId, Model mode) {

        Book book = bookService.selectByPrimaryKey(bookId);

        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format1.parse(book.getPublishDate());
            System.out.println(date);
            mode.addAttribute("date", date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Type type = typeService.selectByPrimaryKey(bookId);
        System.out.println(type.getName());

        mode.addAttribute("type", type);


        mode.addAttribute("book", book);
        return "/book/update";
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    public String Update(Book book) {
        bookService.updateByPrimaryKeySelective(book);
        return "redirect:/book/list";
    }


}