
package com.example.air.service;

import com.example.air.domain.Passenger;
import com.example.air.error.NotFoundException;
import com.example.air.repo.PassengerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PassengerService {
    private final PassengerRepository repo;
    public PassengerService(PassengerRepository repo){ this.repo = repo; }

    public Passenger register(Passenger p){ return repo.save(p); }
    public List<Passenger> list(){ return repo.findAll(); }
    public Passenger get(Long id){ return repo.findById(id).orElseThrow(() -> new NotFoundException("Passenger " + id + " not found")); }
    public Passenger update(Long id, String firstName, String lastName, String email){
        Passenger p = get(id);
        if(firstName!=null && !firstName.isBlank()) p.setFirstName(firstName);
        if(lastName!=null && !lastName.isBlank()) p.setLastName(lastName);
        if(email!=null && !email.isBlank()) p.setEmail(email);
        return repo.save(p);
    }
    public void delete(Long id){
        if(!repo.existsById(id)) throw new NotFoundException("Passenger " + id + " not found");
        repo.deleteById(id);
    }
}
