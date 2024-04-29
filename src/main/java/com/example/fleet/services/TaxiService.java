package com.example.fleet.services;

import com.example.fleet.models.LocationModel;
import com.example.fleet.models.TaxiModel;
import com.example.fleet.repositories.LocationRepository;
import com.example.fleet.repositories.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TaxiService {
    @Autowired
    private TaxiRepository taxiRepository;

    @Autowired
    private LocationRepository locationRepository;

    public Page<TaxiModel> getTaxis(Pageable pageable) {
        return taxiRepository.findAll(pageable);
    }

    public TaxiModel saveTaxi(TaxiModel taxi) {
        return taxiRepository.save(taxi);
    }

    public TaxiModel getById(Integer id) {
        return taxiRepository.findById(id).orElse(null);
    }

    public Page<TaxiModel> getByPlate(String plate, Pageable pageable) {
        return taxiRepository.findByPlate(plate, pageable);
    }

    public boolean deleteTaxi(Integer id) {
        if (taxiRepository.existsById(id)) {
            taxiRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Page<LocationModel> getTaxiLocations(Long taxiId, LocalDate date, Pageable pageable) {
        if (date != null) {
            LocalDate startDate = date.atStartOfDay().toLocalDate();
            LocalDate endDate = startDate.plusDays(1);
            return locationRepository.findByTaxiIdAndDateTimeAfterAndDateTimeBefore(taxiId, startDate, endDate, pageable);
        } else {

            return locationRepository.findAllByTaxiId(taxiId, pageable);
        }
    }

}
