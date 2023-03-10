package com.example.trial.busines.abstracts;

import com.example.trial.model.Mechanicer;
import com.example.trial.requests.CreateMechanicerRequest;
import com.example.trial.response.GetAllMechanicerResponse;
import com.example.trial.response.GetByIdMechanicerResponse;

import java.util.List;

public interface MechanicerService {
    List<GetAllMechanicerResponse> getAll();
    GetByIdMechanicerResponse getById(Long id);
    void delete(Mechanicer mechanicer);
    void add(CreateMechanicerRequest createMechanicerRequest);
}
