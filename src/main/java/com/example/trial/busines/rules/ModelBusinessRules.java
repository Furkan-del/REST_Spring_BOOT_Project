package com.example.trial.busines.rules;

import com.example.trial.dataAccess.ModelRepository;
import com.example.trial.exception.IdGreaterException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;


@Service
@Data
@AllArgsConstructor
public class ModelBusinessRules {

    private  final ModelRepository modelRepository;

    public void checkExistsIdBefore(Long id){
        if(modelRepository.existsByIdBefore(id)){
            throw new IdGreaterException("Id is exists already...");
        }
    }
    public void checkExistsByModelByBrand_Id(Long id){
        if(modelRepository.existsModelByBrand_Id(id)){
            throw new RuntimeException();
        }
    }
}
