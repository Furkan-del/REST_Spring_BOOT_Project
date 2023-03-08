package com.example.trial.exception;

import com.example.trial.utils.ProblemDetails;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {UnLogicException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleUnlogicException(UnLogicException unLogicException){
        ProblemDetails problemDetails=new ProblemDetails();
        problemDetails.setMessage(unLogicException.getMessage());
        return problemDetails;
    }
    @ExceptionHandler(value = {NumberException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleNumberException(NumberException numberException){
        ProblemDetails problemDetails=new ProblemDetails();
        problemDetails.setMessage(numberException.getMessage());
        return problemDetails;
    }
    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleBusinessException(BusinessException businessException) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(businessException.getMessage());
        return  problemDetails;
    }
    // herfarkklı exception için exception handler aç uygulamanın takip etmesini sağlaawqw
    @ExceptionHandler
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    public ProblemDetails handleIdGreaterException(IdGreaterException idGreaterException){
        ProblemDetails problemDetails=new ProblemDetails();
        problemDetails.setMessage(idGreaterException.getMessage());
        return problemDetails;
    }
    @ExceptionHandler
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    public ProblemDetails handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        ProblemDetails problemDetails=new ProblemDetails();
        problemDetails.setMessage(resourceNotFoundException.getMessage());
        return problemDetails;
    }


}
