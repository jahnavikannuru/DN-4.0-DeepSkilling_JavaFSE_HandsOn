package com.library.repository;


import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void bookRepo(){
        System.out.println("This is book repository");
    }
}
