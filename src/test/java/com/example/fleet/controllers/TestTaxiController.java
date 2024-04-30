package com.example.fleet.controllers;

import com.example.fleet.models.TaxiModel;
import com.example.fleet.services.TaxiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.util.List;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(TaxiController.class)
public class TestTaxiController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaxiService taxiService;

    @Test
    public void testGetTaxis() throws Exception {
        // Mock data
        List<TaxiModel> taxiList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TaxiModel taxi = new TaxiModel();
            taxi.setId(111 + i);
            taxi.setPlate("TEST-123-" + i);
            taxiList.add(taxi);
        }
        Page<TaxiModel> page = new PageImpl<>(taxiList);
        // Mock del servicio
        // given() metodo de mockito que establece el comportamiento
        // any(PageRequest.class) es un matcher de Mockito que coincide con cualquier objeto PageRequest
        given(taxiService.getTaxis(any(PageRequest.class))).willReturn(page);

        // request
        mockMvc.perform(get("/taxi")
                        .param("pageNumber", "2")
                        .param("pageSize", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(5)));
    }
}

