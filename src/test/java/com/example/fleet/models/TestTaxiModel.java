package com.example.fleet.models;
import com.example.fleet.models.TaxiModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTaxiModel {

        @Test
        void testSetAndGetId() {

            TaxiModel taxi = new TaxiModel();
            Integer expectedId = 123;

            taxi.setId(expectedId);
            Integer actualId = taxi.getId();

            assertEquals(expectedId, actualId);
        }

        @Test
        void testSetAndGetPlate() {

            TaxiModel taxi = new TaxiModel();
            String expectedPlate = "ABC-123";

            taxi.setPlate(expectedPlate);
            String actualPlate = taxi.getPlate();

            assertEquals(expectedPlate, actualPlate);
        }


}

