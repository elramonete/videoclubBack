package com.ramon.arcis.Peliculas.application.port.out;

import com.ramon.arcis.Peliculas.application.port.in.PeliculaInDto;
import com.ramon.arcis.Peliculas.application.port.in.PeliculaInOutDto;

public interface SavePeliculaPort {
   PeliculaInOutDto addPelicula(PeliculaInDto peliculaInDto);

   Iterable<PeliculaInOutDto> getAllPeliculas();

   PeliculaInOutDto getPeliculaById(Long id);

   void deletePeliculaById(Long id);

   PeliculaInOutDto updatePelicula(PeliculaInDto peliculaInDto);
}
