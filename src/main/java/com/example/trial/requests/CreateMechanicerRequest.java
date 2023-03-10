package com.example.trial.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateMechanicerRequest {

    private String name;
    private Integer price;
    private String carPlate;
}
