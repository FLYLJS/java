package com.sjl.controller;

import com.sjl.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author Administrator
 */
@Controller
public class BookController {
    /**
     *
     */
//    @Qualifier("bookService")
    @Autowired
    private BookService bookServiceExt;


    public void testAutowired(){
        bookServiceExt.saveBook("java编程思想");
    }
}
