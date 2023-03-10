package com.example.trial.busines.rules;

import com.example.trial.dataAccess.GalleryRepository;
import com.example.trial.exception.ResourceNotFoundException;
import com.example.trial.exception.UnLogicException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GalleryBusinessRules {
    private final GalleryRepository galleryRepository;

    public void isNumberValid(double totalAmount){
        if(totalAmount<=0){
             throw new UnLogicException("total number cannot less than 0 dumb");
        }

    }
    public void existsByName(String name){
        if(!galleryRepository.existsByName(name)){
            throw new ResourceNotFoundException("We dont have this Name sorry..");
        }

    }
    public void isDistanceValid(Integer distance){
        if(distance<=0){
            throw  new UnLogicException("Distance is invalid");
        }
    }

}
