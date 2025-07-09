package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    public BookRepository bookRepository;
    public void book(){
        System.out.println("This is a book service");
        bookRepository.bookRepo();
    }
}
