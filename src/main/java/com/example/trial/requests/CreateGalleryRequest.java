package com.example.trial.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateGalleryRequest {
    private String name;
    private Integer totalAmount;
    private Integer distance;
}
