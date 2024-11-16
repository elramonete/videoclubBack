package com.ramon.arcis.Peliculas;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.ramon.arcis.Peliculas.application.port.in.PeliculaInDto;
import com.ramon.arcis.Peliculas.application.port.in.PeliculaInOutDto;
import com.ramon.arcis.Peliculas.application.port.out.SavePeliculaPort;
import com.ramon.arcis.Peliculas.application.service.PeliculaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

class PeliculaServiceTest {

    @Mock
    private SavePeliculaPort savePeliculaPort;

    private PeliculaService peliculaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        peliculaService = new PeliculaService(savePeliculaPort);
    }

   // @Test
    void testGuardarPelicula() {
        // Arrange
        PeliculaInDto peliculaInDto = new PeliculaInDto(1L,"perico","Inception", "Sci-Fi");
        PeliculaInOutDto peliculaInOutDto = new PeliculaInOutDto(1L, "perico","Inception", "Sci-Fi");
        when(savePeliculaPort.addPelicula(peliculaInDto)).thenReturn(peliculaInOutDto);

        // Act
        PeliculaInOutDto result = peliculaService.guardarPelicula(peliculaInDto);

        // Assert
        assertNotNull(result);
        assertEquals("perico", result.titulo());
        verify(savePeliculaPort, times(1)).addPelicula(peliculaInDto);
    }

    @Test
    void testActualizarPelicula() {
        // Similar setup to testGuardarPelicula, mock update behavior
    }
}