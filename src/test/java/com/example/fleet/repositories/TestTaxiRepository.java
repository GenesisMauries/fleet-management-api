package com.example.fleet.repositories;

import com.example.fleet.models.TaxiModel;
import com.example.fleet.services.TaxiService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TestTaxiRepository {

    @Mock
    private TaxiRepository taxiRepository;

    @InjectMocks
    private TaxiService taxiService;

    @Test
    public void testFindByPlate() {
        // Mock data
        String plate = "ABC123";
        TaxiModel taxi = new TaxiModel();
        taxi.setId(1);
        taxi.setPlate(plate);

        // Mock de findByPlate
        Page<TaxiModel> expectedPage = new PageImpl<>(Collections.singletonList(taxi));
        when(taxiRepository.findByPlate(plate, Pageable.unpaged())).thenReturn(expectedPage);

        // Llamada al método del repositorio
        Page<TaxiModel> resultPage = taxiService.getByPlate(plate, Pageable.unpaged());

        assertEquals(expectedPage, resultPage);
    }
}

