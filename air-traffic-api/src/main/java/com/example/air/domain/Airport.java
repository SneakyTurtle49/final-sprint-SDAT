
package com.example.air.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity @Table(name="airport")
public class Airport {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank private String code;
    @NotBlank private String name;
    @ManyToOne(optional=false, fetch=FetchType.LAZY) @JoinColumn(name="city_id")
    private City city;
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getCode(){return code;} public void setCode(String code){this.code=code;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public City getCity(){return city;} public void setCity(City city){this.city=city;}
}
