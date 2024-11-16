package com.ramon.arcis.Peliculas;

import com.ramon.arcis.Peliculas.application.port.in.PeliculaInDto;
import com.ramon.arcis.Peliculas.application.port.in.PeliculaInOutDto;
import com.ramon.arcis.Peliculas.application.port.out.SavePeliculaPort;
import com.ramon.arcis.Peliculas.application.service.PeliculaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringJUnitConfig
@EnableCaching
class PeliculaService2Test {

    @Mock
    private SavePeliculaPort savePeliculaPort;

    @Mock
    private CacheManager cacheManager;

    @InjectMocks
    private PeliculaService peliculaService;

    private Cache cache;

    @BeforeEach
    void setUp() {
        // Configuramos un cache en memoria para las pruebas
        cache = new ConcurrentMapCache("peliculas");
        when(cacheManager.getCache("peliculas")).thenReturn(cache);
    }

    //@Test
    void testCacheableMethod() {
        Long id = 1L;
        PeliculaInOutDto pelicula = new PeliculaInOutDto(id, "Pelicula 1", "Autor 1", "Genero 1");
        when(savePeliculaPort.getPeliculaById(id)).thenReturn(pelicula);

        // Llamada al metodo por primera vez (cache miss)
        PeliculaInOutDto result1 = peliculaService.getPeliculaById(id);
        assertNotNull(result1);  // Debería retornar una película

        // Comprobamos que el caché contiene la clave con el valor correcto
        assertNotNull(cache.get(id.toString()));
        assertEquals(pelicula, cache.get(id.toString()).get());

        // Llamada al metodo por segunda vez (cache hit)
        PeliculaInOutDto result2 = peliculaService.getPeliculaById(id);
        assertSame(result1, result2);  // Debería retornar el mismo objeto (cache hit)
    }
}