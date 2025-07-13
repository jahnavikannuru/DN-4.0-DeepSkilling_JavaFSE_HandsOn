package com.cognizant.rest_country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryService {
    @Autowired
    private List<Country> countryList;
    public Country getCountry(String code) throws Exception {
        return countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new Exception("Country not found: " + code));
    }
}

