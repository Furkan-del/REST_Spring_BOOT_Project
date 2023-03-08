package com.example.trial.busines;
import com.example.trial.requests.CreateGalleryRequest;
import com.example.trial.response.GetAllGalleryResponse;

import java.util.List;

public interface GalleryService {

   public List<GetAllGalleryResponse> getAll();

   GetAllGalleryResponse getGalleryResponseById(Long id);
   void add(CreateGalleryRequest createGalleryRequest);

}
