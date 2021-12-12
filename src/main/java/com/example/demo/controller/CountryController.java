package com.example.demo.controller;

import com.example.demo.dto.CountryDTO;
import com.example.demo.model.Country;
import com.example.demo.service.CountryService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/country")
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/hello")
    public String sayHello() {
        return """
                Hello, my friend!
                How are you?
                """;
    }

    @GetMapping()
    public Iterable<Country> getCountries() {
        return countryService.getDemoEntity();
    }

    @PostMapping
    public void addCountry(@RequestBody CountryDTO countryDTO) {
        countryService.addCountry(countryDTO);
    }

}

