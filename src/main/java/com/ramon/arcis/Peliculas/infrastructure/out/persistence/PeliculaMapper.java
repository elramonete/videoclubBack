package com.ramon.arcis.Peliculas.infrastructure.out.persistence;

import com.ramon.arcis.Peliculas.application.port.in.PeliculaInDto;
import com.ramon.arcis.Peliculas.domain.model.Pelicula;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeliculaMapper extends GenericMapper<PeliculaInDto, Pelicula>{
    @Override
    Pelicula toEntity(PeliculaInDto peliculaInDto);

    @Override
    PeliculaInDto toDto(Pelicula pelicula);


}

