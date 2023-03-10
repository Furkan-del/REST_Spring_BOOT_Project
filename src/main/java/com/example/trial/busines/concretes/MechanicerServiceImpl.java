package com.example.trial.busines.concretes;

import com.example.trial.busines.abstracts.MechanicerService;
import com.example.trial.busines.rules.MechanicerBusinessRules;
import com.example.trial.common.ModelMapperServiceImpl;
import com.example.trial.dataAccess.MechanicerRepository;
import com.example.trial.model.Mechanicer;
import com.example.trial.requests.CreateMechanicerRequest;
import com.example.trial.response.GetAllMechanicerResponse;
import com.example.trial.response.GetByIdMechanicerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@AllArgsConstructor
public class MechanicerServiceImpl implements MechanicerService {


    private  final  MechanicerRepository mechanicerRepository;
    private final MechanicerBusinessRules mechanicerBusinessRules;
    private  final  ModelMapperServiceImpl modelMapperService;

    @Override
    public List<GetAllMechanicerResponse> getAll() {
        List<Mechanicer> mechanicers = mechanicerRepository.findAll();
        return mechanicers.stream().map(mechanicer -> modelMapperService.forResponse().map(mechanicer, GetAllMechanicerResponse.class)).toList();

    }

    @Override
    public GetByIdMechanicerResponse getById( Long id) {
        Mechanicer mechanicer = mechanicerRepository.findById(id).orElseThrow();
        return modelMapperService.forResponse().map(mechanicer, GetByIdMechanicerResponse.class);
    }

    @Override
    public void delete(Mechanicer mechanicer) {
        mechanicerRepository.delete(mechanicer);
    }

    @Override
    public void add(CreateMechanicerRequest createMechanicerRequest) {

        mechanicerBusinessRules.isValidName(createMechanicerRequest.getName());
        Mechanicer mechanicer = modelMapperService.forRequest().map(createMechanicerRequest, Mechanicer.class);
        mechanicerRepository.save(mechanicer);

    }


}
