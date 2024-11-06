package com.ramon.arcis.Peliculas.application.service;

import com.ramon.arcis.Peliculas.application.port.in.PeliculaInDto;
import com.ramon.arcis.Peliculas.application.port.in.PeliculaInOutDto;
import com.ramon.arcis.Peliculas.application.port.in.PeliculaServiceImp;
import com.ramon.arcis.Peliculas.application.port.out.SavePeliculaPort;

import org.springframework.stereotype.Service;

@Service
public class PeliculaService implements PeliculaServiceImp {

    private final SavePeliculaPort savePeliculaPort;




    public PeliculaService(SavePeliculaPort savePeliculaPort) {
        this.savePeliculaPort = savePeliculaPort;

    }

    @Override
    public PeliculaInOutDto guardarPelicula(PeliculaInDto peliculaInDto) {
       return this.savePeliculaPort.addPelicula(peliculaInDto);
        }

    @Override
    public PeliculaInOutDto updatePelicula(PeliculaInDto peliculaInDto) {
        return this.savePeliculaPort.updatePelicula(peliculaInDto);
    }

    @Override
    public Iterable<PeliculaInOutDto> getAllPeliculas() {
        return this.savePeliculaPort.getAllPeliculas();
    }

    @Override
    public PeliculaInOutDto getPeliculaById(Long id) {
        return this.savePeliculaPort.getPeliculaById(id);
    }

    @Override
    public void deletePelicula(Long id) {
        this.savePeliculaPort.deletePeliculaById(id);
    }




}

