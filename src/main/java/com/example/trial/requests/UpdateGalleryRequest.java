package com.example.trial.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UpdateGalleryRequest {
    private Long id;
    private String name;
    private Integer distance;
    private Integer totalAmount;
}
