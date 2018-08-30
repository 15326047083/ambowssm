package com.ambow.first.controller;


import com.aliyuncs.exceptions.ClientException;
import com.ambow.first.entity.Book;
import com.ambow.first.entity.Borrow;
import com.ambow.first.entity.Lost;
import com.ambow.first.entity.User;
import com.ambow.first.service.BookService;
import com.ambow.first.service.BorrowService;
import com.ambow.first.service.LostService;
import com.ambow.first.service.UserService;
import com.ambow.first.util.Page;
import com.ambow.first.util.Send;
import com.ambow.first.vo.BorrowBookUserVo;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
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

    @RequestMapping("/sendMessage")
    @ResponseBody
    public String sendMessage() {
        int sum = 0;
        List<BorrowBookUserVo> borrowBookUserVoList = borrowService.queryAll();
        long dateTime = new Date().getTime();
        for (BorrowBookUserVo b : borrowBookUserVoList
                ) {
            if (b.getBorrowStatus() == 2) {
                if (b.getBorrowSrtimeStamp() - dateTime < 86400000 && b.getBorrowSrtimeStamp() - dateTime > 0) {
                    // TODO 借阅中短信提示：借阅时间不足一天
                    try {
                        Send.sendSms(b.getUserPhone(), b.getBookName(), b.getUserName());
                        sum++;
                    } catch (ClientException e) {
                        e.printStackTrace();
                    }
                }
            } else if (b.getBorrowStatus() == 3) {
                // TODO 借阅逾期：短信提示逾期多久，时间根据时间戳差值除以86400+1
                long date = (b.getBorrowSrtimeStamp() - dateTime) / 86400000;
                try {
                    Send.sendMessage(b.getUserPhone(), b.getBookName(), b.getUserName(), date + 1);
                    sum++;
                } catch (ClientException e) {
                    e.printStackTrace();
                }
            }
        }
        return "" + sum;
    }

    /**
     * 展示借阅列表
     *
     * @param model
     * @param
     * @return
     */
    @RequestMapping(value = "/toList")
    public String toList(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue =
            "9") Integer size, RedirectAttributes attr) {
        Page<BorrowBookUserVo> borrowBookUserVoPage = borrowService.selectBorrowUserBook(page, size);
        Integer ye = borrowBookUserVoPage.getTotal() / borrowBookUserVoPage.getSize();
        if (borrowBookUserVoPage.getTotal() % borrowBookUserVoPage.getSize() != 0) {
            ye = ye + 1;

        }
        if (ye == 0) {
            ye = 1;
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
                if (borrowBookUserVoPage.getRows().get(i).getBorrowStatus() == 2) {
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
    public String selectLikeBorrow(Integer status, String borrowSrdate,String borrowDate,String mohu, Model model, @RequestParam(defaultValue = "1") Integer page,
                                   @RequestParam(defaultValue = "9") Integer size) {
        Page<BorrowBookUserVo> borrowBookUserVoPage = borrowService.selectBorrowLike(page, size,status,mohu,borrowDate,borrowSrdate);
        Integer ye = borrowBookUserVoPage.getTotal() / borrowBookUserVoPage.getSize();
        if (borrowBookUserVoPage.getTotal() % borrowBookUserVoPage.getSize() != 0) {
            ye = ye + 1;

        }
        if (ye == 0) {
            ye = 1;
        }
        model.addAttribute("ye", ye);
        model.addAttribute("list", borrowBookUserVoPage);
        model.addAttribute("mohu", mohu);
        model.addAttribute("status",status);
        model.addAttribute("borrowDate",borrowDate);
        model.addAttribute("borrowSrdate",borrowSrdate);
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
    public String insertSelective(@RequestParam("phone") String phone, @PathVariable("bookId") String bookId,
                                  RedirectAttributes attr) {
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
            //   JOptionPane.showMessageDialog(null, "借书成功！");
            attr.addFlashAttribute("flag", "alert('借书成功')");
            return "redirect:/borrow/toList";

        } else {
            attr.addFlashAttribute("flag", "alert('借书失败，你已经失信')");
            return "redirect:/borrow/toList";
        }

    }

    /**
     * 管理员进行还书
     */
    @ResponseBody
    @RequestMapping(value = "/updateBorrow")
    public String updateBorrow(String borrowId) {

        long date = new Date().getTime();//获取当前还书的时间戳
        Borrow borrow = borrowService.selectByPrimaryKey(borrowId);
        Book book = bookService.selectByPrimaryKey(borrow.getBookId());
        long date1 = borrow.getsRTimeStamp();//获取应当还书的时间戳*/

        if (date > date1) {
            if (borrow.getStatus() == 2 || borrow.getStatus() == 3) {
                borrow.setId(borrowId);
                borrow.setStatus(4);
                borrowService.updateByPrimaryKeySelective(borrow);

                book.setId(borrow.getBookId());
                book.setStatus(1);
                bookService.updateByPrimaryKeySelective(book);
                return "false";
            } else {
                return "error";
            }

        } else {
            if (borrow.getStatus() == 2) {
                borrow.setId(borrowId);
                borrow.setStatus(5);
                borrowService.updateByPrimaryKeySelective(borrow);
                book.setId(borrow.getBookId());
                book.setStatus(1);
                bookService.updateByPrimaryKeySelective(book);
                return "OK";
            } else {
                return "error";
            }
        }


    }

    @RequestMapping("/export")
    @ResponseBody
    public String export(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException,
            IntrospectionException, IllegalAccessException, ParseException, InvocationTargetException,
            UnsupportedEncodingException {
        response.reset(); //清除buffer缓存
        // 指定下载的文件名，浏览器都会使用本地编码，即GBK，浏览器收到这个文件名后，用ISO-8859-1来解码，然后用GBK来显示
        // 所以我们用GBK解码，ISO-8859-1来编码，在浏览器那边会反过来执行。
        response.setHeader("Content-Disposition", "attachment;filename=Borrow_" + new Date().getTime() + ".xlsx");
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

    /**
     * 判断手机号是否正确
     *
     * @param phone
     * @return
     */
    @RequestMapping("/checkPhone/{phone}")
    @ResponseBody
    public int checkPhone(@PathVariable("phone") String phone) {
        if (userService.getUserByPhone(phone) != null) {
            return 0; // 正确
        }
        return 1; // 不正确
    }



}
