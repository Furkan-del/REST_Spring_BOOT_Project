package com.example.trial.dataAccess;

import com.example.trial.model.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryRepository extends  JpaRepository<Gallery,Long>{

  boolean existsByName(String name);

}
