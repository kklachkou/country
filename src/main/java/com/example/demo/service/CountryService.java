package com.example.demo.service;

import com.example.demo.dto.CountryDTO;
import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public record CountryService(CountryRepository countryRepository) {

    public Iterable<Country> getDemoEntity() {
        return countryRepository.findAll();
    }

    public void addCountry(CountryDTO countryDTO) {
        var country = Country.builder()
                .name(countryDTO.getName())
                .build();
        countryRepository.save(country);
    }

}
