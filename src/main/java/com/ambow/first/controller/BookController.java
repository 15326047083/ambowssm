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
     * 添加图书
     *
     * @param book
     * @return
     */
    @RequestMapping(value = "/insert")

    public String insert(Book book) {


        bookService.insert(book);
        return "redirect:/book/listVo";
    }

    /**
     * 根据类型Id查询
     *
     * @param mode
     * @return
     */




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
        if(ye==0){ye=1;}

        List<Type> types = typeService.queryAll();
        mode.addAttribute("types", types);
        mode.addAttribute("show", "duo");
        mode.addAttribute("root","vo");
        mode.addAttribute("ye", ye);
        mode.addAttribute("list", bookTypeVoList);
        return "/book/list";

    }



    /**
     * 单查
     */

    @RequestMapping(value = "/get")
    public String get(String bookId, Model mode) {

        BookTypeVo bookTypeVo = bookService.selectTypeByKey(bookId);


        mode.addAttribute("bookTypeVo", bookTypeVo);
        mode.addAttribute("show","dan");
        return "/book/list";
    }

    /**
     * 分类下的模糊
     */

    @RequestMapping(value = "/listVoBlurTypeId")
    public String listVoBlurTypeId(Model mode,String blur,String typeId,@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer size) {


        Page<BookTypeVo> bookTypeVoList = bookService.getBookTypeVoByTypeIAndLike(typeId, blur, page, size);

        Integer ye = bookTypeVoList.getTotal() / bookTypeVoList.getSize();

        if (bookTypeVoList.getTotal() % bookTypeVoList.getSize() != 0) {

            ye = ye + 1;
        }
        if(ye==0){ye=1;}

        List<Type> types = typeService.queryAll();
        mode.addAttribute("types", types);
        mode.addAttribute("root", "typeBlur");
        mode.addAttribute("show","duo");
        mode.addAttribute("typeId", typeId);
        mode.addAttribute("blur", blur);
        mode.addAttribute("ye", ye);
        mode.addAttribute("list", bookTypeVoList);
        return "/book/list";

    }


    /**
     * 修改前查询
     */
    @RequestMapping(value = "/toUpdate")
    public String toUpdate(String bookId, Model mode) throws ParseException {

        Book book = bookService.selectByPrimaryKey(bookId);


        String publishDate = book.getPublishDate();
        publishDate = publishDate.substring(0, 10);
        book.setPublishDate(publishDate);


        List<Type> types = typeService.queryAll();


        mode.addAttribute("types", types);
        mode.addAttribute("book", book);
        return "/book/update";
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    public String update(Book book) {

        System.out.println(book.toString());
        System.out.println(bookService.updateByPrimaryKeySelective(book));

        return "redirect:/book/listVo";
    }


    /**
     * 排行
     */
    @RequestMapping(value = "/sort")
    public String sort(Model mode, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer size) {


        Page<BookTypeVo> bookTypeVoList = bookService.getBookTypeVoByTypeIdSort(page, size);

        Integer ye = bookTypeVoList.getTotal() / bookTypeVoList.getSize();

        if (bookTypeVoList.getTotal() % bookTypeVoList.getSize() != 0) {

            ye = ye + 1;
        }
        if(ye==0){ye=1;}
        List<Type> types = typeService.queryAll();
        mode.addAttribute("types", types);
        mode.addAttribute("show", "duo");
        mode.addAttribute("root", "sort");
        mode.addAttribute("ye", ye);
        mode.addAttribute("list", bookTypeVoList);

        return "/book/list";
    }


}