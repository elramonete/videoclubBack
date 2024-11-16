package com.ramon.arcis.Peliculas;

import com.ramon.arcis.Peliculas.application.port.in.PeliculaInDto;
import com.ramon.arcis.Peliculas.application.port.in.PeliculaInOutDto;
import com.ramon.arcis.Peliculas.application.service.PeliculaService;
import com.ramon.arcis.Peliculas.infrastructure.in.web.PeliculasController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PeliculasController.class)
public class PeliculasControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PeliculaService peliculaService;

    @InjectMocks
    private PeliculasController peliculasController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

   // @Test
    void testGuardarPelicula() throws Exception {
        // Arrange
        PeliculaInDto peliculaInDto = new PeliculaInDto(1L, "Inception", "Leo","Sci-Fi");
        PeliculaInOutDto peliculaInOutDto = new PeliculaInOutDto(1L, "Inception", "Leo", "Sci-Fi");

        when(peliculaService.guardarPelicula(peliculaInDto)).thenReturn(peliculaInOutDto);

        // Act & Assert
        mockMvc.perform(post("/api/pelicula")
                        .contentType("application/json")
                        .content("{\"id\": 1, \"titulo\": \"Inception\",  \"autor\": \"Leo\", \"genero\": \"Sci-Fi\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Inception"))
                .andExpect(jsonPath("$.genero").value("Sci-Fi"));
    }
}
