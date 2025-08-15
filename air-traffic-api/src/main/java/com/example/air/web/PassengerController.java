
package com.example.air.web;

import com.example.air.domain.Passenger;
import com.example.air.service.PassengerService;
import com.example.air.web.dto.PassengerDtos.*;
import com.example.air.web.mapper.Mappers;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/passengers") @CrossOrigin
public class PassengerController {
  private final PassengerService service;
  public PassengerController(PassengerService service){ this.service = service; }

  @PostMapping public PassengerResponse register(@RequestBody @Valid PassengerCreateRequest req){
    Passenger p = new Passenger(); p.setFirstName(req.firstName); p.setLastName(req.lastName); p.setEmail(req.email);
    return Mappers.toDto(service.register(p));
  }
  @GetMapping public List<PassengerResponse> list(){ return service.list().stream().map(Mappers::toDto).toList(); }
  @GetMapping("/{id}") public PassengerResponse get(@PathVariable Long id){ return Mappers.toDto(service.get(id)); }
  @PatchMapping("/{id}") public PassengerResponse update(@PathVariable Long id, @RequestBody PassengerUpdateRequest req){
    return Mappers.toDto(service.update(id, req.firstName, req.lastName, req.email));
  }
  @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
}
