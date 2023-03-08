package com.example.trial.webApiControllers;

import com.example.trial.busines.CarServiceImpl;
import com.example.trial.requests.CreateCarRequest;
import com.example.trial.response.GetAllCarsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiCar")
@AllArgsConstructor
public class CarController {

    private final CarServiceImpl carService;

    @PostMapping("/createCar")
    public void add(@RequestBody CreateCarRequest createCarRequest){
        carService.add(createCarRequest);
    }
    @GetMapping("/getAllCar")
    public List<GetAllCarsResponse> getAllCarsResponses(){
        return carService.getAll();
    }

    @DeleteMapping("/deleteCar/{id}")
    public void delete(@PathVariable  Long id){
        carService.delete(id);
    }
}
