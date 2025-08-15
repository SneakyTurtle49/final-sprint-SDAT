
package com.example.air.service;

import com.example.air.domain.City;
import com.example.air.error.NotFoundException;
import com.example.air.repo.CityRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CityService {
    private final CityRepository repo;
    public CityService(CityRepository repo){ this.repo = repo; }
    public City create(City c){ return repo.save(c); }
    public List<City> search(String q){ return (q==null||q.isBlank())? repo.findAll(): repo.findByNameContainingIgnoreCase(q); }
    public City get(Long id){ return repo.findById(id).orElseThrow(() -> new NotFoundException("City " + id + " not found")); }
    public City update(Long id, String name, String country){
        City c = get(id);
        if(name!=null && !name.isBlank()) c.setName(name);
        if(country!=null && !country.isBlank()) c.setCountry(country);
        return repo.save(c);
    }
    public void delete(Long id){
        if(!repo.existsById(id)) throw new NotFoundException("City " + id + " not found");
        repo.deleteById(id);
    }
}
