package com.example.trial.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GetByIdMechanicerResponse {
    private Long id;
    private String name;
}
