package com.example.fleet.controllers;

import com.example.fleet.controllers.TaxiController;
import com.example.fleet.models.TaxiModel;
import com.example.fleet.services.TaxiService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Anotación de JUnit 5 para habilitar Mockito
class TaxiControllerTest {

    @Mock // mock del servicio
    private TaxiService taxiService;

    @InjectMocks // inyeccion al mock creado
    private TaxiController taxiController;

    @Test
    void testGetTaxis() {

        int pageNumber = 0;
        int pageSize = 10;
        List<TaxiModel> taxiList = new ArrayList<>();
        TaxiModel taxi = new TaxiModel();
        taxi.setId(1110);
        taxi.setPlate("TEST-1234");
        taxiList.add(taxi);
        Page<TaxiModel> expectedPage = new PageImpl<>(taxiList);
        when(taxiService.getTaxis(any(PageRequest.class))).thenReturn(expectedPage);

        Page<TaxiModel> result = taxiController.getTaxis(pageNumber, pageSize);

        assertEquals(expectedPage, result);
        verify(taxiService, times(1)).getTaxis(PageRequest.of(pageNumber, pageSize));
    }
}



