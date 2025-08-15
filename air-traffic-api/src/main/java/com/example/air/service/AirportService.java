
package com.example.air.service;

import com.example.air.domain.Airport;
import com.example.air.domain.City;
import com.example.air.error.NotFoundException;
import com.example.air.repo.AirportRepository;
import com.example.air.repo.CityRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AirportService {
    private final AirportRepository airportRepo;
    private final CityRepository cityRepo;
    public AirportService(AirportRepository airportRepo, CityRepository cityRepo){
        this.airportRepo = airportRepo; this.cityRepo = cityRepo;
    }
    public Airport create(Long cityId, Airport a){
        City c = cityRepo.findById(cityId).orElseThrow(() -> new NotFoundException("City " + cityId + " not found"));
        a.setCity(c);
        return airportRepo.save(a);
    }
    public List<Airport> list(){ return airportRepo.findAll(); }
    public Airport get(Long id){ return airportRepo.findById(id).orElseThrow(() -> new NotFoundException("Airport " + id + " not found")); }
    public Airport update(Long id, String code, String name, Long cityId){
        Airport a = get(id);
        if(code!=null && !code.isBlank()) a.setCode(code);
        if(name!=null && !name.isBlank()) a.setName(name);
        if(cityId!=null){
            City c = cityRepo.findById(cityId).orElseThrow(() -> new NotFoundException("City " + cityId + " not found"));
            a.setCity(c);
        }
        return airportRepo.save(a);
    }
    public void delete(Long id){
        if(!airportRepo.existsById(id)) throw new NotFoundException("Airport " + id + " not found");
        airportRepo.deleteById(id);
    }
}
