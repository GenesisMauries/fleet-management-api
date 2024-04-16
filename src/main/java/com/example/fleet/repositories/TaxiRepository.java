package com.example.fleet.repositories;

import com.example.fleet.models.TaxiModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxiRepository extends JpaRepository<TaxiModel, Integer> {
    Page<TaxiModel> findByPlate(String plate, Pageable pageable);
}
