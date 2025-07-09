package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void bookService(){
        System.out.println("This is a book service");
        bookRepository.bookRepository();
    }
}

