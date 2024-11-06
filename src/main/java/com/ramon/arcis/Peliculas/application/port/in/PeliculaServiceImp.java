package com.ramon.arcis.Peliculas.application.port.in;

public interface PeliculaServiceImp {
    PeliculaInOutDto guardarPelicula(PeliculaInDto pelicula);

    Iterable<PeliculaInOutDto> getAllPeliculas();

    PeliculaInOutDto getPeliculaById(Long id);

    void deletePelicula(Long id);

    PeliculaInOutDto updatePelicula(PeliculaInDto peliculaInDto);
}
