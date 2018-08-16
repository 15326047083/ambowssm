package com.ambow.leiyuan.test;

import com.ambow.first.entity.Book;
import com.ambow.first.service.BookService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-mybatis.xml","/spring-service.xml"})
public class BookTest {
    @Autowired
    private BookService bookService;

    @org.junit.Test
    public void testInsert() {

        int i = 2;
        while (i > 0) {
            i--;
            Book book = new Book();

            book.setBookName("c++");
            book.setAuthorName("刘");
            book.setInfo("159");
            book.setNum(2);
            book.setPress("清华");
            book.setTypeId("2");
            book.setStatus(1);
            book.setPublishDate("2017-06-03");

            book.setRemark("ddd");
            bookService.insert(book);
        }


    }

    @org.junit.Test
    public void selectById() {

        System.out.println(bookService.selectByPrimaryKey("3").toString());

    }
    @org.junit.Test
    public void updateSelective() {

        Book book=new Book();
        book.setId("2");
        book.setAuthorName("李");
        System.out.println(bookService.updateByPrimaryKeySelective(book));

    }

    @org.junit.Test
    public void deleteByid() {
    bookService.deleteByPrimaryKey("3");
    }

    @org.junit.Test
    public void getBookTypeVoList() {
        System.out.println(bookService.getBookTypeVoList().toString());
    }

    @org.junit.Test
    public void getBookTypeVoByTypeId() {
        System.out.println(bookService.getBookTypeVoByTypeId("2").toString());
    }
    @org.junit.Test
    public void getBookTypeVoByTypeIdNum() {
        System.out.println(bookService.getBookTypeVoByTypeIdNum("2"));
    }

    @org.junit.Test
    public void selectByLike() {
        System.out.println(bookService.selectByLike("人").toString());
    }

    @org.junit.Test
    public void getBookTypeVoByTypeIAndLike() {
        System.out.println(bookService.getBookTypeVoByTypeIAndLike("2","b").toString());
    }


}