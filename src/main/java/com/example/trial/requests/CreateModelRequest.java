package com.example.trial.requests;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateModelRequest {

    @NotNull
    @Size(min=3,max=20)
    private String name;
    @NotNull
    private Long brandId;
}
