
package com.example.air.web;

import com.example.air.domain.City;
import com.example.air.service.CityService;
import com.example.air.web.dto.CityDtos.*;
import com.example.air.web.mapper.Mappers;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/cities") @CrossOrigin
public class CityController {
  private final CityService service;
  public CityController(CityService service){ this.service = service; }

  @PostMapping public CityResponse create(@RequestBody @Valid CityCreateRequest req){
    City c = new City(); c.setName(req.name); c.setCountry(req.country);
    return Mappers.toDto(service.create(c));
  }
  @GetMapping public List<CityResponse> search(@RequestParam(value="q", required=false) String q){
    return service.search(q).stream().map(Mappers::toDto).toList();
  }
  @GetMapping("/{id}") public CityResponse get(@PathVariable Long id){ return Mappers.toDto(service.get(id)); }
  @PatchMapping("/{id}") public CityResponse update(@PathVariable Long id, @RequestBody CityUpdateRequest req){
    return Mappers.toDto(service.update(id, req.name, req.country));
  }
  @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
}
