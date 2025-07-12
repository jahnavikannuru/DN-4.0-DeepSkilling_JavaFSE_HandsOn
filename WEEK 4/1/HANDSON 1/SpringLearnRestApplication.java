package com.cognizant.spring_learn_rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnRestApplication {
	public static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnRestApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Start");
		SpringApplication.run(SpringLearnRestApplication.class, args);
		LOGGER.info("End");
	}

}
