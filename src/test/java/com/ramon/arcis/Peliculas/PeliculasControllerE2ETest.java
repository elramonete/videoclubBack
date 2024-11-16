package com.ramon.arcis.Peliculas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class PeliculasControllerE2ETest {
    @Autowired
    private final MockMvc mockMvc;

    @Autowired
    public PeliculasControllerE2ETest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

   // @Test
    void testGuardarPeliculaE2E() throws Exception {
        // Arrange
        String jsonContent = "{\"id\": 1, \"titulo\": \"Inception\", \"genero\": \"Sci-Fi\"}";

        // Act & Assert
        mockMvc.perform(post("/api/pelicula")
                        .contentType("application/json")
                        .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Inception"))
                .andExpect(jsonPath("$.genero").value("Sci-Fi"));
    }

   // @Test
    void testGetPeliculasE2E() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/api/pelicula"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    //@Test
    void testEliminarPeliculaE2E() throws Exception {
        // Act & Assert
        mockMvc.perform(delete("/api/pelicula/1"))
                .andExpect(status().isOk());
    }
}
