package com.example.trial.busines.concretes;
import com.example.trial.busines.abstracts.BrandService;
import com.example.trial.busines.rules.BrandBusinessRules;
import com.example.trial.common.ModelMapperServiceImpl;
import com.example.trial.dataAccess.BrandRepository;
import com.example.trial.model.Brand;
import com.example.trial.requests.CreateBrandRequest;
import com.example.trial.requests.UpdateBrandRequest;
import com.example.trial.response.GetAllBrandsResponse;
import com.example.trial.response.GetByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandBusinessRules brandBusinessRules;
    private final BrandRepository brandRepository;
    private final ModelMapperServiceImpl modelMapperService;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> getAllBrandsResponseList = brands.stream().map(brand -> modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
        return getAllBrandsResponseList;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        // 1 den fazla kural olabilir projelerde bu kod mis gibi çalışır
        Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public GetByIdResponse getById(Long id) {

        Brand brand = brandRepository.findById(id).orElseThrow();
        return modelMapperService.forResponse().map(brand, GetByIdResponse.class);

    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        brandRepository.save(brand);
    }


    @Override
    public void delete(Long id) {
        brandRepository.deleteById(id);
    }


}
