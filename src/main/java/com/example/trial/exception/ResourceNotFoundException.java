package com.example.trial.exception;

public class ResourceNotFoundException extends RuntimeException{
    private String msg;
  public  ResourceNotFoundException( String msg){

        this.msg=msg;

    }
}
