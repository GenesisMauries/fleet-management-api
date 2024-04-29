package com.example.fleet.controllers;

import com.example.fleet.models.LocationModel;
import com.example.fleet.models.TaxiModel;
import com.example.fleet.services.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/taxi")
public class TaxiController {
    @Autowired
    TaxiService taxiService;

    @GetMapping()
    public Page<TaxiModel> getTaxis(
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        return taxiService.getTaxis(PageRequest.of(pageNumber, pageSize));
    }

    @PostMapping
    public TaxiModel saveTaxi(@RequestBody TaxiModel taxi){
        return this.taxiService.saveTaxi(taxi);
    }

    @GetMapping( path = "/{id}")
    public TaxiModel getById(@PathVariable("id") Integer id) {
        return this.taxiService.getById(id);
    }

    @GetMapping("/query")
    public Page<TaxiModel> getByPlate(@RequestParam("plate") String plate, Pageable pageable){
        return this.taxiService.getByPlate(plate, pageable);
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


    @GetMapping("/{id}/locations")
    public Page<LocationModel> getTaxiLocations(
            @PathVariable("id") Long taxiId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            Pageable pageable) {
        return taxiService.getTaxiLocations(taxiId, date, pageable);
    }
}
