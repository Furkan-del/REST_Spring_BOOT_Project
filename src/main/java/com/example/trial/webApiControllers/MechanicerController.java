package com.example.trial.webApiControllers;

import com.example.trial.busines.concretes.MechanicerServiceImpl;
import com.example.trial.requests.CreateMechanicerRequest;
import com.example.trial.response.GetAllMechanicerResponse;
import com.example.trial.response.GetByIdMechanicerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("apiMec")
public class MechanicerController {
    private final MechanicerServiceImpl mechanicerService;

    @PostMapping("/create")
    public void add (@Valid @RequestBody CreateMechanicerRequest createMechanicerRequest){
        mechanicerService.add(createMechanicerRequest);
    }
    @GetMapping("/getAllMechanics")
    List<GetAllMechanicerResponse> getAll(){
       return mechanicerService.getAll();
    }

    @GetMapping("/getAllMechanicer/{id}")
    GetByIdMechanicerResponse getById(@PathVariable(name = "id") Long id){
       return mechanicerService.getById(id);
    }


}
