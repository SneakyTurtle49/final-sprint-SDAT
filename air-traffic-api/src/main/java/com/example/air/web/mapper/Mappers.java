
package com.example.air.web.mapper;

import com.example.air.domain.*;
import com.example.air.web.dto.CityDtos.*;
import com.example.air.web.dto.AirportDtos.*;
import com.example.air.web.dto.PassengerDtos.*;
import com.example.air.web.dto.AircraftDtos.*;

public class Mappers {
  public static CityResponse toDto(City c){ CityResponse d=new CityResponse(); d.id=c.getId(); d.name=c.getName(); d.country=c.getCountry(); return d; }
  public static AirportResponse toDto(Airport a){ AirportResponse d=new AirportResponse(); d.id=a.getId(); d.code=a.getCode(); d.name=a.getName(); if(a.getCity()!=null){ d.cityId=a.getCity().getId(); d.cityName=a.getCity().getName(); } return d; }
  public static PassengerResponse toDto(Passenger p){ PassengerResponse d=new PassengerResponse(); d.id=p.getId(); d.firstName=p.getFirstName(); d.lastName=p.getLastName(); d.email=p.getEmail(); return d; }
  public static AircraftResponse toDto(Aircraft a){ AircraftResponse d=new AircraftResponse(); d.id=a.getId(); d.model=a.getModel(); d.manufacturer=a.getManufacturer(); d.capacity=a.getCapacity(); return d; }
}
