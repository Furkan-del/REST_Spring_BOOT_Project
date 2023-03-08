package com.example.trial.response;

import com.example.trial.model.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelResponse {

    private Long id;
    private String name;
    private String brandName;

}
