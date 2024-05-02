package com.example.fleet.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LocationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private Long taxiId;
    private double latitude;
    private double longitude;
    private LocalDateTime dateTime;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTaxiId(Long taxiId){
        this.taxiId = taxiId;
    }

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    public void setLongitude(double longitude){
        this.longitude = longitude;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public Long getTaxiId(){
        return taxiId;
    }

    public double getLatitude(){
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

}
