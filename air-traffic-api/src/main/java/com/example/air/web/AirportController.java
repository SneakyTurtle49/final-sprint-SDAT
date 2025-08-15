
package com.example.air.web;

import com.example.air.domain.Airport;
import com.example.air.service.AirportService;
import com.example.air.web.dto.AirportDtos.*;
import com.example.air.web.mapper.Mappers;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/airports") @CrossOrigin
public class AirportController {
  private final AirportService service;
  public AirportController(AirportService service){ this.service = service; }

  @PostMapping public AirportResponse create(@RequestBody @Valid AirportCreateRequest req){
    Airport a = new Airport(); a.setCode(req.code); a.setName(req.name);
    return Mappers.toDto(service.create(req.cityId, a));
  }
  @GetMapping public List<AirportResponse> list(){ return service.list().stream().map(Mappers::toDto).toList(); }
  @GetMapping("/{id}") public AirportResponse get(@PathVariable Long id){ return Mappers.toDto(service.get(id)); }
  @PatchMapping("/{id}") public AirportResponse update(@PathVariable Long id, @RequestBody AirportUpdateRequest req){
    return Mappers.toDto(service.update(id, req.code, req.name, req.cityId));
  }
  @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
}
