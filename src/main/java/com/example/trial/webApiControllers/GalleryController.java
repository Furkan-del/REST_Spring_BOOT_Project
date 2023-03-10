package com.example.trial.webApiControllers;

import com.example.trial.busines.concretes.GalleryServiceImpl;
import com.example.trial.requests.CreateGalleryRequest;
import com.example.trial.requests.UpdateGalleryRequest;
import com.example.trial.response.GetAllGalleryResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/apigal")
public class GalleryController {
    private final GalleryServiceImpl galleryService;

    @PostMapping("/creategal")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateGalleryRequest createGalleryRequest) {
        galleryService.add(createGalleryRequest);
    }

    @GetMapping("/getAllgal")
    public List<GetAllGalleryResponse> getAll() {
        return galleryService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        galleryService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateGalleryRequest updateGalleryRequest) {
        galleryService.update(updateGalleryRequest);
    }

}
