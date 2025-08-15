
package com.example.air.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity @Table(name="aircraft")
public class Aircraft {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank private String model;
    @NotBlank private String manufacturer;
    @PositiveOrZero private int capacity;
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getModel(){return model;} public void setModel(String model){this.model=model;}
    public String getManufacturer(){return manufacturer;} public void setManufacturer(String manufacturer){this.manufacturer=manufacturer;}
    public int getCapacity(){return capacity;} public void setCapacity(int capacity){this.capacity=capacity;}
}
