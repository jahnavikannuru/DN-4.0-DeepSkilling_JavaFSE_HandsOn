package com.cognizant.orm_learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.orm_learn.repository.CountryRepository;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }
    @Override
    public void run(String... args) {
        System.out.println("Countries containing 'ou':");
        countryRepository.findByNameContaining("ou")
            .forEach(c -> System.out.println(c.getCode() + " - " + c.getName()));
        System.out.println("\nCountries containing 'ou' sorted:");
        countryRepository.findByNameContainingSorted("ou")
            .forEach(c -> System.out.println(c.getCode() + " - " + c.getName()));
        System.out.println("\nCountries starting with 'Z':");
        countryRepository.findByNameStartingWith("Z")
            .forEach(c -> System.out.println(c.getCode() + " - " + c.getName()));
    }
}
