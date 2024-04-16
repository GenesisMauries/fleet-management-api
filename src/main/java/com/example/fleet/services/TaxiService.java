package com.example.fleet.services;

import com.example.fleet.models.TaxiModel;
import com.example.fleet.repositories.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaxiService {
    @Autowired
    TaxiRepository taxiRepository;

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
}
