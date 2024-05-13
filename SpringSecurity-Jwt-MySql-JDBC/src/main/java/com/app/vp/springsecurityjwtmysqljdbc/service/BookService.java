package com.app.vp.springsecurityjwtmysqljdbc.service;

import com.app.vp.springsecurityjwtmysqljdbc.model.Book;
import com.app.vp.springsecurityjwtmysqljdbc.model.User;
import com.app.vp.springsecurityjwtmysqljdbc.repository.BookRepository;
import com.app.vp.springsecurityjwtmysqljdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public Book createBook(Book book, String author){
        User username = userRepository.findByUsername(author);
        book.setAuthor(username.getName());
        book.setTitle(book.getTitle());
        return bookRepository.save(book);
    }

}
