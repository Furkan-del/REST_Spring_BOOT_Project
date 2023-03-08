package com.example.trial.dataAccess;
import com.example.trial.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
 boolean existsByName(String name);




 //exists true false dönmesini sağlar varmı
 //find ise brand ya da data modeli dönerss

}
