package com.example.trial.dataAccess;

import com.example.trial.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model,Long> {


    public boolean existsByIdBefore(Long id);
    public boolean existsModelByBrand_Id(Long id);


}
