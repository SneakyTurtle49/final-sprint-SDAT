
package com.example.air;

import com.example.air.domain.City;
import com.example.air.service.CityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = com.example.air.web.CityController.class)
class CityControllerTest {
  @Autowired MockMvc mvc;
  @Autowired ObjectMapper om;
  @MockBean CityService service;

  @Test void createCity() throws Exception {
    City c = new City(); c.setId(1L); c.setName("Halifax"); c.setCountry("Canada");
    Mockito.when(service.create(Mockito.any(City.class))).thenReturn(c);
    mvc.perform(post("/api/cities")
      .contentType(MediaType.APPLICATION_JSON)
      .content("{"name":"Halifax","country":"Canada"}"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id").value(1))
      .andExpect(jsonPath("$.name").value("Halifax"));
  }
}
