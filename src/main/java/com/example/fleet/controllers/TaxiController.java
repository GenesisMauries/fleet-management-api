package com.example.fleet.controllers;

import com.example.fleet.models.TaxiModel;
import com.example.fleet.services.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping( path = "/id/{id}")
    public TaxiModel getById(@PathVariable("id") Integer id) {
        return this.taxiService.getById(id);
    }

    @GetMapping("/plate/{plate}")
    public ResponseEntity<TaxiModel> getTaxiByPlate(
            @PathVariable("plate") String plate,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<TaxiModel> page = taxiService.getByPlate(plate, pageable);
        if (!page.isEmpty()) {
            // Si se encontró al menos un taxi con la placa proporcionada, devolver el primero
            return ResponseEntity.ok(page.getContent().get(0));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
