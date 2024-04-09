package com.example.fleet.models;

import jakarta.persistence.*;

@Entity
@Table(name = "taxis")
public class TaxiModel {
    @Id
    @Column(unique = true, nullable = false)
    private Integer id;
    private String plate;

    public void setId(Integer id ){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }
}
