package com.example.trial.busines;


import com.example.trial.exception.ResourceNotFoundException;
import com.example.trial.requests.CreateBrandRequest;
import com.example.trial.requests.UpdateBrandRequest;
import com.example.trial.response.GetAllBrandsResponse;
import com.example.trial.response.GetByIdResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    void add(CreateBrandRequest createBrandRequest);

    GetByIdResponse getById(Long id) throws ResourceNotFoundException;

    public void update (UpdateBrandRequest updateBrandRequest);
    void delete(Long id);

}
