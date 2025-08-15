
package com.example.air.web.dto;
import jakarta.validation.constraints.NotBlank; import jakarta.validation.constraints.NotNull;
public class AirportDtos {
  public static class AirportResponse { public Long id; public String code; public String name; public Long cityId; public String cityName; }
  public static class AirportCreateRequest { @NotBlank public String code; @NotBlank public String name; @NotNull public Long cityId; }
  public static class AirportUpdateRequest { public String code; public String name; public Long cityId; }
}
