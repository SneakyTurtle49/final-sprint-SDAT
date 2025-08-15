
package com.example.air.web.dto;
import jakarta.validation.constraints.Min; import jakarta.validation.constraints.NotBlank;
public class AircraftDtos {
  public static class AircraftResponse { public Long id; public String model; public String manufacturer; public int capacity; }
  public static class AircraftCreateRequest { @NotBlank public String model; @NotBlank public String manufacturer; @Min(0) public int capacity; }
  public static class AircraftUpdateRequest { public String model; public String manufacturer; public Integer capacity; }
}
