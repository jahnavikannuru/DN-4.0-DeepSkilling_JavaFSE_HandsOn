package com.cognizant.orm_learn;



import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;
    public static void main(String[] args) {
    	 System.out.println("PRINT CHECK: before context load");
    	ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

//        testGetAllCountries();
        testGetCountryByCode();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
        testSearchCountryByPartialName();
        LOGGER.info("Inside main");
    }
//    private static void testGetAllCountries() {
//        LOGGER.info("Start");
//        List<Country> countries = countryService.getAllCountries();
//        LOGGER.debug("countries={}", countries);
//        LOGGER.info("End");
//    }
    private static void testGetCountryByCode() {
        LOGGER.info("Start - Get Country by Code");
        Optional<Country> country = countryService.getCountryByCode("IN");
        country.ifPresent(c -> LOGGER.debug("Found: {}", c));
        LOGGER.info("End");
    }

    private static void testAddCountry() {
        LOGGER.info("Start - Add Country");
        Country newCountry = new Country("ZZ", "Zootopia");
        countryService.addCountry(newCountry);
        LOGGER.debug("Added: {}", newCountry);
        LOGGER.info("End");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start - Update Country");
        Country updated = new Country("ZZ", "Zootropolis");
        countryService.updateCountry(updated);
        LOGGER.debug("Updated: {}", updated);
        LOGGER.info("End");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start - Delete Country");
        countryService.deleteCountry("ZZ");
        LOGGER.debug("Deleted country with code ZZ");
        LOGGER.info("End");
    }

    private static void testSearchCountryByPartialName() {
        LOGGER.info("Start - Search Country by Name");
        List<Country> results = countryService.findCountriesByPartialName("an");
        results.forEach(c -> LOGGER.debug("Match: {}", c));
        LOGGER.info("End");
    }
}

