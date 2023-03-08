package com.example.trial.webApiControllers;

import com.example.trial.busines.BrandServiceImpl;
import com.example.trial.requests.CreateBrandRequest;
import com.example.trial.requests.UpdateBrandRequest;
import com.example.trial.response.GetAllBrandsResponse;
import com.example.trial.response.GetByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class BrandController {
    private final BrandServiceImpl brandService;

    @GetMapping("/getAll")
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }
    @GetMapping("/get/{id}")
    public GetByIdResponse getById(@PathVariable Long id){
        return brandService.getById(id);
    }

    @PostMapping("/createBrand")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody CreateBrandRequest createBrandRequest) {
        brandService.add(createBrandRequest);
    }


    @PutMapping("/update")
    public void updateById(@RequestBody UpdateBrandRequest updateBrandRequest){
         brandService.update(updateBrandRequest);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        brandService.delete(id);
    }

}
