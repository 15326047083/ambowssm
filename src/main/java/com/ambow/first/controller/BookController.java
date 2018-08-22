package com.ambow.first.controller;

import com.ambow.first.entity.Book;
import com.ambow.first.entity.Donate;
import com.ambow.first.entity.Type;
import com.ambow.first.service.BookService;
import com.ambow.first.service.DonateService;
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
    @Autowired
    private DonateService donateService;

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
    public String insert(Book book, int num, String userName, String userPhone) {

        System.out.println(userName);
        System.out.println(userPhone);
        int i = num;
        while (i > 0) {
            i--;
            Book book1 = new Book();
            book1.setTypeId(book.getTypeId());
            book1.setBookName(book.getBookName());
            book1.setAuthorName(book.getAuthorName());
            book1.setPress(book.getPress());
            book1.setPublishDate(book.getPublishDate());
            book1.setInfo(book.getInfo());
            book1.setStatus(book.getStatus());
            book1.setNum(0);
            book1.setRemark(book.getRemark());



            if (userName!= "" &&userPhone!="") {
                Donate donate = new Donate();

                donate.setBookId(book1.getId());
                donate.setUserName(userName);
                donate.setUserPhone(userPhone);
                donate.setDonateTime(new Date());
                System.out.println(donate.getDonateTime());

                donateService.insert(donate);
            }
            bookService.insert(book1);
            typeService.addBookNum(book1.getTypeId());

        }
        return "redirect:/book/listVo";
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

        if (ye == 0) {
            ye = 1;
        }

        List<Type> types = typeService.queryAll();
        mode.addAttribute("types", types);
        mode.addAttribute("show", "duo");
        mode.addAttribute("root", "vo");
        mode.addAttribute("ye", ye);
        mode.addAttribute("list", bookTypeVoList);
        return "/book/list";

    }

    /**
     * 查询捐赠信息
     */
    @RequestMapping(value = "/getDonate")
    public String getDonate(Model mode,@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer size) {



       Page<Donate> list=donateService.selectAll(page,size);

        Integer ye = list.getTotal() / list.getSize();

        if (list.getTotal() % list.getSize() != 0) {

            ye = ye + 1;
        }
        if (ye == 0) {
            ye = 1;
        }
        mode.addAttribute("list", list);
        mode.addAttribute("ye", ye);
         mode.addAttribute("root","donate");

        return "/book/listDonate";
    }


    /**
     * 单查
     */

    @RequestMapping(value = "/get")
    public String get(String bookId, Model mode) {

        BookTypeVo bookTypeVo = bookService.selectTypeByKey(bookId);

        bookTypeVo.setBookPublishDate(bookTypeVo.getBookPublishDate().substring(0, 10));
        mode.addAttribute("bookTypeVo", bookTypeVo);

        return "/book/show";
    }

    /**
     * 分类下的模糊
     */

    @RequestMapping(value = "/listVoBlurTypeId")
    public String listVoBlurTypeId(Model mode, String blur, String typeId, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer size) {


        Page<BookTypeVo> bookTypeVoList = bookService.getBookTypeVoByTypeIAndLike(typeId, blur, page, size);

        Integer ye = bookTypeVoList.getTotal() / bookTypeVoList.getSize();

        if (bookTypeVoList.getTotal() % bookTypeVoList.getSize() != 0) {

            ye = ye + 1;
        }
        if (ye == 0) {
            ye = 1;
        }

        List<Type> types = typeService.queryAll();
        mode.addAttribute("types", types);
        mode.addAttribute("root", "typeBlur");
        mode.addAttribute("show", "duo");
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
    public String toUpdate(String bookId, Model mode) {

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
        if (ye == 0) {
            ye = 1;
        }
        List<Type> types = typeService.queryAll();
        mode.addAttribute("types", types);
        mode.addAttribute("show", "duo");
        mode.addAttribute("root", "sort");
        mode.addAttribute("ye", ye);
        mode.addAttribute("list", bookTypeVoList);

        return "/book/list";
    }

    /**
     * 删除
     */

    @RequestMapping(value = "/delete")
    public String delete(String bookId, String typeId) {


        System.out.println(bookService.deleteByPrimaryKey(bookId));
        typeService.subBookNum(typeId);

        return "redirect:/book/listVo";
    }

}