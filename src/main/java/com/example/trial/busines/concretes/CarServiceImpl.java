package com.example.trial.busines.concretes;

import com.example.trial.busines.abstracts.CarService;
import com.example.trial.busines.rules.CarBusinessRules;
import com.example.trial.common.ModelMapperServiceImpl;
import com.example.trial.dataAccess.CarRepository;
import com.example.trial.model.Car;
import com.example.trial.requests.CreateCarRequest;
import com.example.trial.response.GetAllCarsResponse;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarBusinessRules carBusinessRules;
    private final ModelMapperServiceImpl modelMapperService;

    @Override
    public List<GetAllCarsResponse> getAll() {

        List<Car> cars = carRepository.findAll();
        List<GetAllCarsResponse> getAllCarsResponses = cars.stream().map(car -> modelMapperService.forResponse().map(car, GetAllCarsResponse.class)).collect(Collectors.toList());
        return getAllCarsResponses;
    }

    @Override
    public GetAllCarsResponse getCarResponseById(Long id) {

        Car car = carRepository.findById(id).orElseThrow();
        return modelMapperService.forResponse().map(car, GetAllCarsResponse.class);
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public void add(CreateCarRequest createCarRequest) {

        carBusinessRules.plateInvalid(createCarRequest.getPlate());
        carBusinessRules.dailyPriceInvalid(createCarRequest.getDailyPrice()); //not working
        carBusinessRules.dailyPriceIsGreaterThan(createCarRequest.getDailyPrice());
        Car car=modelMapperService.forRequest().map(createCarRequest,Car.class);
        carRepository.save(car);
    }
}
