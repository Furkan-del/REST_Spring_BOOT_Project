package com.example.trial.common;

import com.example.trial.requests.CreateBrandRequest;
import com.example.trial.response.GetAllBrandsResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperServiceImpl implements ModelMapperService {
    private final ModelMapper modelMapper;
    @Override
    public ModelMapper forResponse() {

        modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;

    }
    @Override
    public ModelMapper forRequest() {
        modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }
}
