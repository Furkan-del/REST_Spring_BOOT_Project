package com.example.trial;

import com.example.trial.common.ModelMapperServiceImpl;
import com.example.trial.exception.*;
import com.example.trial.utils.ProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@SpringBootApplication
public class TrialApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrialApplication.class, args);
    }



}
