package com.example.fleet.services;

import com.example.fleet.models.TaxiModel;
import com.example.fleet.repositories.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TaxiService {
    @Autowired
    TaxiRepository taxiRepository;

    public ArrayList<TaxiModel> getTaxis(){
        return (ArrayList<TaxiModel>) taxiRepository.findAll();
    }
    public TaxiModel saveTaxi(TaxiModel taxi){
        return taxiRepository.save(taxi);
    }
    // Debe regresar uno solo cambio el array???
    public ArrayList<TaxiModel> getByPlate(String plate){
        return taxiRepository.findByPlate(plate);
    }

    public Optional<TaxiModel> getById(Integer id){
        return taxiRepository.findById(id);
    }

    public boolean deleteTaxi(Integer id) {
        try{
            taxiRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
