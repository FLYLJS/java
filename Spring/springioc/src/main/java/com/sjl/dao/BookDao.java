package com.sjl.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

    public void save(String bookName){
        System.out.println(bookName+" 正在印刷");
    }
}
