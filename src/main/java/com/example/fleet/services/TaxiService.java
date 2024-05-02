package com.example.fleet.services;

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

    public TaxiModel getById(Integer id) {
        return taxiRepository.findById(id).orElse(null);
    }

    public Page<TaxiModel> getByPlate(String plate, Pageable pageable) {
        return taxiRepository.findByPlate(plate, pageable);
    }

}
