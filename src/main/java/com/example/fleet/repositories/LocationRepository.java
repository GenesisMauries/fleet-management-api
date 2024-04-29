package com.example.fleet.repositories;

import com.example.fleet.models.LocationModel;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface LocationRepository extends JpaRepository<LocationModel, Long> {
    Page<LocationModel> findByTaxiIdAndDateTimeAfterAndDateTimeBefore(Long taxiId, LocalDate startDate, LocalDate endDate, Pageable pageable);

    Page<LocationModel> findAllByTaxiId(Long taxiId, Pageable pageable);
}
