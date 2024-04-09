package com.example.fleet.repositories;

import com.example.fleet.models.TaxiModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxiRepository extends CrudRepository<TaxiModel, Integer> {
}
