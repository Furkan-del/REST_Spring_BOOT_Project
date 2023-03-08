package com.example.trial.requests;

import com.example.trial.model.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {


    @NotNull
    private Long modelId;
    @Size(min=3,max=20)
    private String plate;
    private Integer dailyPrice;

}
