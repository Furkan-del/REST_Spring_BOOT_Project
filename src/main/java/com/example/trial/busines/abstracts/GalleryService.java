package com.example.trial.busines.abstracts;
import com.example.trial.model.Gallery;
import com.example.trial.requests.CreateGalleryRequest;
import com.example.trial.requests.UpdateGalleryRequest;
import com.example.trial.response.GetAllGalleryResponse;

import java.util.List;

public interface GalleryService {

   public List<GetAllGalleryResponse> getAll();

   GetAllGalleryResponse getGalleryResponseById(Long id);
   void add(CreateGalleryRequest createGalleryRequest);

   void delete(Long id);

   void update(UpdateGalleryRequest updateGalleryRequest);

}
