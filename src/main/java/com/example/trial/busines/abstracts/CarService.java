package com.example.trial.busines.abstracts;

import com.example.trial.requests.CreateCarRequest;
import com.example.trial.response.GetAllCarsResponse;

import java.util.List;

public interface CarService {
    List<GetAllCarsResponse> getAll();

    GetAllCarsResponse getCarResponseById(Long id);

    void delete(Long id);

    void add(CreateCarRequest createCarRequest);

}
