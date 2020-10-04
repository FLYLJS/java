package com.sjl.service;

import com.sjl.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void saveBook(String name){
        bookDao.save(name);
    }
}
