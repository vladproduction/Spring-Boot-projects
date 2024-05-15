package com.app.vp.springsecurityjwtmysqljdbc.controller;

import com.app.vp.springsecurityjwtmysqljdbc.model.Book;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/data")
public class DataController {

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book createBook(@RequestBody Book book){
        System.out.println(book);
        return book;
    }
}
