package com.example.fleet.controllers;

import com.example.fleet.models.TaxiModel;
import com.example.fleet.services.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/taxi")
public class TaxiController {
    @Autowired
    TaxiService taxiService;

    @GetMapping()
    public ArrayList<TaxiModel> getTaxis(){
        return taxiService.getTaxis();
    }

    @PostMapping
    public TaxiModel saveTaxi(@RequestBody TaxiModel taxi){
        return this.taxiService.saveTaxi(taxi);

    }
    @GetMapping( path = "/{id}")
    public Optional<TaxiModel> getById(@PathVariable("id") Integer id) {
        return this.taxiService.getById(id);
    }

    @GetMapping("/query")
    public ArrayList<TaxiModel> getByPlate(@RequestParam("plate") String plate){
        return this.taxiService.getByPlate(plate);
    }

    @DeleteMapping( path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        boolean ok = this.taxiService.deleteTaxi(id);
        if (ok){
            return "Se eliminó el taxi con id " + id;
        }else{
            return "No pudo eliminar el taxi con id" + id;
        }
    }


}
