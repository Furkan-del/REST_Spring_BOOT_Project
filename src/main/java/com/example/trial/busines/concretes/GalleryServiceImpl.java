package com.example.trial.busines.concretes;

import com.example.trial.busines.abstracts.GalleryService;
import com.example.trial.busines.rules.GalleryBusinessRules;
import com.example.trial.common.ModelMapperServiceImpl;
import com.example.trial.dataAccess.GalleryRepository;
import com.example.trial.exception.ResourceNotFoundException;
import com.example.trial.model.Gallery;

import com.example.trial.requests.CreateGalleryRequest;
import com.example.trial.requests.UpdateGalleryRequest;
import com.example.trial.response.GetAllGalleryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GalleryServiceImpl implements GalleryService {
    private final GalleryRepository galleryRepository;
    private final GalleryBusinessRules galleryBusinessRules;

    private final ModelMapperServiceImpl modelMapperService;

    @Override
    public List<GetAllGalleryResponse> getAll() {
        List<Gallery> galleries = galleryRepository.findAll();
        return galleries.stream().map(gallery -> modelMapperService.forResponse().map(gallery, GetAllGalleryResponse.class)).toList();
    }

    @Override
    public GetAllGalleryResponse getGalleryResponseById(Long id) {
        Gallery gallery = galleryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource didnt found"));
        return modelMapperService.forResponse().map(gallery, GetAllGalleryResponse.class);
    }

    @Override
    public void add(CreateGalleryRequest createGalleryRequest) {
        /*galleryBusinessRules.isNumberValid(createGalleryRequest.getTotalAmount());
        galleryBusinessRules.existsByName(createGalleryRequest.getName());
        */Gallery gallery = modelMapperService.forRequest().map(createGalleryRequest, Gallery.class);
        galleryRepository.save(gallery);
    }

    @Override
    public void delete(Long id) {
        galleryRepository.deleteById(id);
    }

    @Override
    public void update( UpdateGalleryRequest updateGalleryRequest) {
        galleryBusinessRules.isDistanceValid(updateGalleryRequest.getDistance());
        galleryBusinessRules.isNumberValid(updateGalleryRequest.getTotalAmount());
        Gallery gallery= modelMapperService.forRequest().map(updateGalleryRequest, Gallery.class);
        galleryRepository.save(gallery);
    }


}
