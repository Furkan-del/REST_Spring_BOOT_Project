package com.example.trial.busines;

import com.example.trial.requests.CreateModelRequest;
import com.example.trial.response.GetAllModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelResponse> getAll();
    GetAllModelResponse getById(Long id);
    void add(CreateModelRequest createModelRequest);
    void delete(Long id);

}
