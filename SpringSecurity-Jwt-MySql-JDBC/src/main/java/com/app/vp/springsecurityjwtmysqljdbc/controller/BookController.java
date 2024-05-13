package com.app.vp.springsecurityjwtmysqljdbc.controller;

import com.app.vp.springsecurityjwtmysqljdbc.model.Book;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/book")
public class BookController {

    @PostMapping
    public void createBook(@RequestBody Book book){
        System.out.println(book);
    }

}
