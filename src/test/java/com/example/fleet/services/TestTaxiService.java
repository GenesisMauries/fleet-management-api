package com.example.fleet.services;

import com.example.fleet.models.TaxiModel;
import com.example.fleet.repositories.TaxiRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class TestTaxiService {

    @Mock
    private TaxiRepository taxiRepository;

    @InjectMocks
    private TaxiService taxiService;

    @Test

    public void testGetTaxis() {
        // Mock de datos
        TaxiModel taxi1 = new TaxiModel();
        taxi1.setId(1);
        taxi1.setPlate("ABC123");

        TaxiModel taxi2 = new TaxiModel();
        taxi2.setId(2);
        taxi2.setPlate("XYZ789");

        // Mock del método findAll del repositorio
        Page<TaxiModel> expectedPage = new PageImpl<>(List.of(taxi1, taxi2));
        when(taxiRepository.findAll(Pageable.unpaged())).thenReturn(expectedPage);

        // Llamada al método del servicio getTaxis
        Page<TaxiModel> resultPage = taxiService.getTaxis(Pageable.unpaged());

        assertEquals(expectedPage, resultPage);
    }

    @Test
    public void testGetById_ExistingId() {
        // Mock de datos
        int existingId = 1;
        TaxiModel taxi = new TaxiModel();
        taxi.setId(existingId);
        taxi.setPlate("ABC123");

        // Mock del método findById del repositorio
        when(taxiRepository.findById(existingId)).thenReturn(Optional.of(taxi));

        // Llamada al método del servicio getById
        TaxiModel resultTaxi = taxiService.getById(existingId);

        assertEquals(taxi, resultTaxi);
    }

    @Test
    public void testGetById_NonExistingId() {
        // Mock de datos
        int nonExistingId = 999;

        // Mock del método findById del repositorio
        when(taxiRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        // Llamada al método del servicio
        TaxiModel resultTaxi = taxiService.getById(nonExistingId);

        assertNull(resultTaxi);
    }

    @Test
    public void testGetByPlate() {
        // Mock de datos
        String plate = "ABC123";
        TaxiModel taxi1 = new TaxiModel();
        taxi1.setId(1);
        taxi1.setPlate(plate);

        TaxiModel taxi2 = new TaxiModel();
        taxi2.setId(2);
        taxi2.setPlate(plate);

        // Mock del método findByPlate del repositorio
        Page<TaxiModel> expectedPage = new PageImpl<>(List.of(taxi1, taxi2));
        when(taxiRepository.findByPlate(plate, Pageable.unpaged())).thenReturn(expectedPage);

        // Llamada al método del servicio
        Page<TaxiModel> resultPage = taxiService.getByPlate(plate, Pageable.unpaged());

        assertEquals(expectedPage, resultPage);
    }

    @Test
    public void testGetByPlate_NoPlateProvided() {
        // Mock del método findByPlate del repositorio
        Page<TaxiModel> emptyPage = new PageImpl<>(Collections.emptyList());
        when(taxiRepository.findByPlate("", Pageable.unpaged())).thenReturn(emptyPage);

        // Llamada al método del servicio sin proporcionar una placa
        Page<TaxiModel> resultPage = taxiService.getByPlate("", Pageable.unpaged());

        assertEquals(emptyPage, resultPage);
    }
}
