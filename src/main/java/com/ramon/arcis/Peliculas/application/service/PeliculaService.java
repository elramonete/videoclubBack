package com.ramon.arcis.Peliculas.application.service;

import com.ramon.arcis.Peliculas.application.port.in.PeliculaInDto;
import com.ramon.arcis.Peliculas.application.port.in.PeliculaInOutDto;
import com.ramon.arcis.Peliculas.application.port.in.PeliculaServiceImp;
import com.ramon.arcis.Peliculas.application.port.out.SavePeliculaPort;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PeliculaService implements PeliculaServiceImp {

    private final SavePeliculaPort savePeliculaPort;




    public PeliculaService(SavePeliculaPort savePeliculaPort) {
        this.savePeliculaPort = savePeliculaPort;

    }

    @Override
    @CacheEvict(value = "peliculas", key = "'all'")
    public PeliculaInOutDto guardarPelicula(PeliculaInDto peliculaInDto) {
       return this.savePeliculaPort.addPelicula(peliculaInDto);
        }

    @Override
    @CacheEvict(value = "peliculas", key = "'all'")
    public PeliculaInOutDto updatePelicula(PeliculaInDto peliculaInDto) {
        return this.savePeliculaPort.updatePelicula(peliculaInDto);
    }

    @Override
    @Cacheable(value = "peliculas", key = "'all'")
    public Iterable<PeliculaInOutDto> getAllPeliculas() {
        return this.savePeliculaPort.getAllPeliculas();
    }

    @Override
   // @Cacheable(value = "peliculas", key = "#id")
    public PeliculaInOutDto getPeliculaById(Long id) {
        return this.savePeliculaPort.getPeliculaById(id);
    }

    @Override
    @CacheEvict(value = "peliculas", key = "'all'")
    public void deletePelicula(Long id) {
        this.savePeliculaPort.deletePeliculaById(id);
    }




}

