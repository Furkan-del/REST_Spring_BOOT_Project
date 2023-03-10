package com.example.trial.webApiControllers;

import com.example.trial.busines.concretes.ModelServiceImpl;
import com.example.trial.requests.CreateModelRequest;
import com.example.trial.response.GetAllModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/models")
public class ModelController {
    private final ModelServiceImpl modelService;


    @GetMapping("/getAll")
    public List<GetAllModelResponse> getAllModelResponses() {
        return modelService.getAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void addModel(@RequestBody CreateModelRequest createModelRequest) {
        modelService.add(createModelRequest);
    }

    @GetMapping("/get/{id}")
    public GetAllModelResponse getAllModelResponsess(@PathVariable Long id) {
        return modelService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete( @PathVariable Long id){
        modelService.delete(id);
    }
}
