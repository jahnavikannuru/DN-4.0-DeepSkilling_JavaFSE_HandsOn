package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    public BookRepository bookRepository;
    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
    public void book(){
        System.out.println("This is book service");
        bookRepository.book();
    }
}
