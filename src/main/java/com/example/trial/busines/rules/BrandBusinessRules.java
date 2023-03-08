package com.example.trial.busines.rules;
import  com.example.trial.dataAccess.BrandRepository;
import  com.example.trial.exception.BusinessException;
import  lombok.AllArgsConstructor;
import  org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    //marka ismi tekrar ediyor mu business logicini buraya yaz
    private final BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name) {
        if (brandRepository.existsByName(name)) {
             throw new BusinessException("Brand name already exists") ;
        }
    }
}