package com.example.trial.busines;

import com.example.trial.busines.rules.ModelBusinessRules;
import com.example.trial.common.ModelMapperServiceImpl;
import com.example.trial.dataAccess.ModelRepository;
import com.example.trial.model.Model;
import com.example.trial.requests.CreateModelRequest;
import com.example.trial.response.GetAllModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {
private final ModelRepository modelRepository;
private  final ModelMapperServiceImpl modelMapperService;
private final ModelBusinessRules modelBusinessRules;

    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> models= modelRepository.findAll();
         return models.stream().map(model -> modelMapperService.forResponse().map(model, GetAllModelResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetAllModelResponse getById(Long id) {
        modelBusinessRules.checkExistsByModelByBrand_Id(id);
        Model model=modelRepository.findById(id).orElseThrow();
        return modelMapperService.forResponse().map(model, GetAllModelResponse.class);
    }



    @Override
    public void add(@RequestBody CreateModelRequest createModelRequest) {
         modelBusinessRules.checkExistsIdBefore(createModelRequest.getBrandId());
        Model model=modelMapperService.forRequest().map(createModelRequest, Model.class);
        modelRepository.save(model);
    }

    @Override
    public void delete(Long id) {
        modelBusinessRules.checkExistsByModelByBrand_Id(id);
        Model model=modelRepository.findById(id).orElseThrow();
        modelRepository.delete(model);
    }
}
