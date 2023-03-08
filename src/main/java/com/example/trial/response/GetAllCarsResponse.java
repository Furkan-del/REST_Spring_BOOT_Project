package com.example.trial.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GetAllCarsResponse {
private String plate;
private double dailyPrice;
private Integer state;
}
