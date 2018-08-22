package com.ambow.first.controller;


import com.ambow.first.entity.Book;
import com.ambow.first.entity.Borrow;
import com.ambow.first.entity.Lost;
import com.ambow.first.entity.User;
import com.ambow.first.service.BookService;
import com.ambow.first.service.BorrowService;
import com.ambow.first.service.LostService;
import com.ambow.first.service.UserService;
import com.ambow.first.util.Page;
import com.ambow.first.vo.BorrowBookUserVo;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.IntrospectionException;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private LostService lostService;


    /**
     * 展示借阅列表
     *
     * @param model
     * @param
     * @return
     */
    @RequestMapping(value = "/toList")
    public String toList(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer size) {
        Page<BorrowBookUserVo> borrowBookUserVoPage = borrowService.selectBorrowUserBook(page, size);
        Integer ye = borrowBookUserVoPage.getTotal() / borrowBookUserVoPage.getSize();
        if (borrowBookUserVoPage.getTotal() % borrowBookUserVoPage.getSize() != 0) {
            ye = ye + 1;

        }
        model.addAttribute("ye", ye);
        model.addAttribute("list", borrowBookUserVoPage);
        model.addAttribute("chuanzhi", "cat");
        for (int i = 0; i < borrowBookUserVoPage.getRows().size(); i++) {
            if (new Date().getTime() > borrowBookUserVoPage.getRows().get(i).getBorrowSrtimeStamp()) {
                if (lostService.getByBorrowId(borrowBookUserVoPage.getRows().get(i).getBorrowId()) == null) {

                    Lost lost = new Lost();
                    lost.setBorrowId(borrowBookUserVoPage.getRows().get(i).getBorrowId());
                    lost.setUserId(borrowBookUserVoPage.getRows().get(i).getUserId());
                    lostService.insert(lost);
                }
                if(borrowBookUserVoPage.getRows().get(i).getBorrowStatus()==2) {
                    borrowBookUserVoPage.getRows().get(i).setBorrowStatus(3);
                    Borrow b = new Borrow();
                    b.setId(borrowBookUserVoPage.getRows().get(i).getBorrowId());
                    b.setStatus(3);
                    borrowService.updateByPrimaryKeySelective(b);
                }
            }
        }


        return "/borrow/list";
    }

    /**
     * 借阅列表的模糊查询
     */
    @RequestMapping(value = "toLikeList")
    public String selectLikeBorrow(String mohu, Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer size) {
        System.out.println(mohu);
        System.out.println(page);
        Page<BorrowBookUserVo> borrowBookUserVoPage = borrowService.selectBorrowLike(page, size, mohu);
        Integer ye = borrowBookUserVoPage.getTotal() / borrowBookUserVoPage.getSize();
        if (borrowBookUserVoPage.getTotal() % borrowBookUserVoPage.getSize() != 0) {
            ye = ye + 1;

        }
        model.addAttribute("ye", ye);
        model.addAttribute("list", borrowBookUserVoPage);
        model.addAttribute("mohu", mohu);
        model.addAttribute("chuanzhi", "dog");


        return "/borrow/list";
    }

    /**
     * 前往增加借阅信息的页面
     */
    @RequestMapping(value = "/toNew/{bookId}")
    public String toNewBorrow(@PathVariable("bookId") String bookId, Model model) {
        model.addAttribute("bookId", bookId);
        return "/borrow/new";
    }

    /**
     * 添加借阅信息
     */
    @RequestMapping(value = "/newBorrow/{bookId}")
    public String insertSelective(@RequestParam("phone") String phone, @PathVariable("bookId") String bookId) {
        User user = userService.getUserByPhone(phone);
        int i = lostService.selectCountUser(phone);
        if (i < 3) {
            Borrow borrow = new Borrow();

            borrow.setBookId(bookId);
            borrow.setUserId(user.getId());

            user.setBorrowNum(user.getBorrowNum() + 1);
            userService.updateByPrimaryKey(user);

            Book book = bookService.selectByPrimaryKey(bookId);
            book.setNum(book.getNum() + 1);
            book.setId(bookId);
            book.setStatus(2);
            borrow.setStatus(book.getStatus());
            bookService.updateByPrimaryKeySelective(book);


            borrowService.insertSelective(borrow);
            return "redirect:/borrow/toList";
        } else {
            return "redirect:/borrow/toList";
        }

    }

    /**
     * 管理员进行还书
     */
    @ResponseBody
    @RequestMapping(value = "/updateBorrow")
    public String updateBorrow(String bookId) {
        Book book = bookService.selectByPrimaryKey(bookId);
        long date = new Date().getTime();//获取当前还书的时间戳
        Borrow borrow = borrowService.getByBookId(bookId);
        long date1 = borrow.getsRTimeStamp();//获取应当还书的时间戳*/

        if (date > date1) {
            borrow.setBookId(bookId);
            borrow.setStatus(4);
            borrowService.updateByBookId(borrow);

            book.setId(bookId);
            book.setStatus(1);
            bookService.updateByPrimaryKeySelective(book);

           /* Lost lost = new Lost();
            lost.setUserId(borrow.getUserId());
            lost.setBorrowId(borrow.getId());
            lostService.insert(lost);*/
            return "false";
        } else {
            borrow.setBookId(bookId);
            borrow.setStatus(5);
            borrowService.updateByBookId(borrow);

            book.setId(bookId);
            book.setStatus(1);
            bookService.updateByPrimaryKeySelective(book);
            return "OK";
        }

    }
    @RequestMapping("/export")
    @ResponseBody
    public String export(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IntrospectionException, IllegalAccessException, ParseException, InvocationTargetException, UnsupportedEncodingException {
        System.out.println(response+" "+request);
        response.reset(); //清除buffer缓存
        // 指定下载的文件名，浏览器都会使用本地编码，即GBK，浏览器收到这个文件名后，用ISO-8859-1来解码，然后用GBK来显示
        // 所以我们用GBK解码，ISO-8859-1来编码，在浏览器那边会反过来执行。
        response.setHeader("Content-Disposition", "attachment;filename=Borrow_"+new Date().getTime()+".xlsx");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        XSSFWorkbook workbook = null;
        //导出Excel对象
        workbook = borrowService.exportExcelInfo();
        OutputStream output;
        try {
            output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            bufferedOutPut.flush();
            workbook.write(bufferedOutPut);
            bufferedOutPut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/borrow/toList";
    }

}
