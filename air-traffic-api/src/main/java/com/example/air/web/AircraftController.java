
package com.example.air.web;

import com.example.air.domain.Aircraft;
import com.example.air.service.AircraftService;
import com.example.air.web.dto.AircraftDtos.*;
import com.example.air.web.mapper.Mappers;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/aircraft") @CrossOrigin
public class AircraftController {
  private final AircraftService service;
  public AircraftController(AircraftService service){ this.service = service; }

  @PostMapping public AircraftResponse create(@RequestBody @Valid AircraftCreateRequest req){
    Aircraft a = new Aircraft(); a.setModel(req.model); a.setManufacturer(req.manufacturer); a.setCapacity(req.capacity);
    return Mappers.toDto(service.create(a));
  }
  @GetMapping public List<AircraftResponse> list(){ return service.list().stream().map(Mappers::toDto).toList(); }
  @GetMapping("/{id}") public AircraftResponse get(@PathVariable Long id){ return Mappers.toDto(service.get(id)); }
  @PatchMapping("/{id}") public AircraftResponse update(@PathVariable Long id, @RequestBody AircraftUpdateRequest req){
    return Mappers.toDto(service.update(id, req.model, req.manufacturer, req.capacity));
  }
  @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
}
