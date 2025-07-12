package com.cognizant.springBoot_airlines;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootAirlinesApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootAirlinesApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START - main()");
        SpringApplication.run(SpringbootAirlinesApplication.class, args);
        displayCountry();
        LOGGER.info("END - main()");
    }

    public static void displayCountry() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country.toString());
    }
}

