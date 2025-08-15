
package com.example.air.service;

import com.example.air.domain.Aircraft;
import com.example.air.error.NotFoundException;
import com.example.air.repo.AircraftRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AircraftService {
    private final AircraftRepository repo;
    public AircraftService(AircraftRepository repo){ this.repo = repo; }

    public Aircraft create(Aircraft a){ return repo.save(a); }
    public List<Aircraft> list(){ return repo.findAll(); }
    public Aircraft get(Long id){ return repo.findById(id).orElseThrow(() -> new NotFoundException("Aircraft " + id + " not found")); }
    public Aircraft update(Long id, String model, String manufacturer, Integer capacity){
        Aircraft a = get(id);
        if(model!=null && !model.isBlank()) a.setModel(model);
        if(manufacturer!=null && !manufacturer.isBlank()) a.setManufacturer(manufacturer);
        if(capacity!=null) a.setCapacity(capacity);
        return repo.save(a);
    }
    public void delete(Long id){
        if(!repo.existsById(id)) throw new NotFoundException("Aircraft " + id + " not found");
        repo.deleteById(id);
    }
}
