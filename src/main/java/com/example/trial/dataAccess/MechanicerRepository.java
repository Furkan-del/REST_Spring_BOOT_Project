package com.example.trial.dataAccess;

import com.example.trial.model.Mechanicer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicerRepository extends JpaRepository<Mechanicer,Long> {
}
