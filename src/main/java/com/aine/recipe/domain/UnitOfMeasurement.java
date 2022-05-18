package com.aine.recipe.domain;

import javax.persistence.*;

@Entity
public class UnitOfMeasurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unitOfMeasurement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUom() {
        return unitOfMeasurement;
    }

    public void setUom(String uom) {
        this.unitOfMeasurement = uom;
    }
}
