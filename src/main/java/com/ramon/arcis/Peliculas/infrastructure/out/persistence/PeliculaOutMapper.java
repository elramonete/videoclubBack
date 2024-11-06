package com.ramon.arcis.Peliculas.infrastructure.out.persistence;

import com.ramon.arcis.Peliculas.application.port.in.PeliculaInOutDto;
import com.ramon.arcis.Peliculas.domain.model.Pelicula;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeliculaOutMapper extends GenericMapper<PeliculaInOutDto, Pelicula>{
    @Override
    Pelicula toEntity(PeliculaInOutDto peliculaInDto);

    @Override
    PeliculaInOutDto toDto(Pelicula pelicula);
    Iterable<PeliculaInOutDto> toDtoIterable(Iterable<Pelicula> peliculas);
}

