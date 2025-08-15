
package com.example.air.web.dto;
import jakarta.validation.constraints.Email; import jakarta.validation.constraints.NotBlank;
public class PassengerDtos {
  public static class PassengerResponse { public Long id; public String firstName; public String lastName; public String email; }
  public static class PassengerCreateRequest { @NotBlank public String firstName; @NotBlank public String lastName; @Email public String email; }
  public static class PassengerUpdateRequest { public String firstName; public String lastName; @Email public String email; }
}
