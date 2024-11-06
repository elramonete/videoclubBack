package com.ramon.arcis.Peliculas.infrastructure.out.persistence;

import com.ramon.arcis.Peliculas.domain.model.Pelicula;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeliculaSaveMapper extends GenericMapper<Pelicula,PeliculaEntity>{
    @Override
    PeliculaEntity toEntity(Pelicula pelicula);

    @Override
    Pelicula toDto(PeliculaEntity peliculaEntity);
    Iterable<Pelicula> toDtoIterable(Iterable<PeliculaEntity> peliculasEntities);
}

