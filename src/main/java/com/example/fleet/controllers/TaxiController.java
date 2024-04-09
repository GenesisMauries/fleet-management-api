package com.example.fleet.controllers;

import com.example.fleet.models.TaxiModel;
import com.example.fleet.services.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
}
