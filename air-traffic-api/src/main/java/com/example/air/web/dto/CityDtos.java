
package com.example.air.web.dto;
import jakarta.validation.constraints.NotBlank;
public class CityDtos {
  public static class CityResponse { public Long id; public String name; public String country; }
  public static class CityCreateRequest { @NotBlank public String name; @NotBlank public String country; }
  public static class CityUpdateRequest { public String name; public String country; }
}
