package com.example.trial.busines.rules;

import com.example.trial.dataAccess.MechanicerRepository;
import com.example.trial.exception.UnLogicException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MechanicerBusinessRules {
    private final MechanicerRepository mechanicerRepository;
     public void isValidName(String name){
         if(name.length()<7){
             throw  new UnLogicException("Length  of Name must be more than 7");
         }
     }

}
