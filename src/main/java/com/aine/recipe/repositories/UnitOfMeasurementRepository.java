package com.aine.recipe.repositories;

import com.aine.recipe.domain.UnitOfMeasurement;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasurementRepository extends CrudRepository<UnitOfMeasurement, Long> {

    Optional<UnitOfMeasurement> findByUnitOfMeasurement(String unitOfMeasurement);
}
