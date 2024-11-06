package com.ramon.arcis.Peliculas.infrastructure.out.persistence;


import com.ramon.arcis.Peliculas.application.port.in.PeliculaInDto;
import com.ramon.arcis.Peliculas.application.port.in.PeliculaInOutDto;
import com.ramon.arcis.Peliculas.application.port.out.SavePeliculaPort;
import com.ramon.arcis.Peliculas.domain.exceptions.PeliculaNotSavedException;
import com.ramon.arcis.Peliculas.domain.model.Pelicula;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class PeliculaPersistenceAdapter implements SavePeliculaPort {
    private final PeliculaRepository peliculaRepository;
    private final PeliculaSaveMapper peliculaSaveMapper;
    private final PeliculaMapper peliculaMapper;

    private final PeliculaOutMapper peliculaOutMapper;

    public PeliculaPersistenceAdapter(PeliculaRepository peliculaRepository, PeliculaSaveMapper peliculaSaveMapper, PeliculaMapper peliculaMapper, PeliculaOutMapper peliculaOutMapper) {
        this.peliculaRepository = peliculaRepository;
        this.peliculaSaveMapper = peliculaSaveMapper;
        this.peliculaMapper = peliculaMapper;
        this.peliculaOutMapper = peliculaOutMapper;
    }


    @Override
    public PeliculaInOutDto addPelicula(PeliculaInDto peliculaInDto) {
        try{
        Pelicula pelicula = peliculaMapper.toEntity(peliculaInDto);
        PeliculaEntity peliculaEntity =  peliculaRepository.save(peliculaSaveMapper.toEntity(pelicula));

        Pelicula peliculaOut = peliculaSaveMapper.toDto(peliculaEntity);
        return peliculaOutMapper.toDto(peliculaOut);
        } catch (Exception e) {
            // En caso de error en la persistencia, lanzar una excepción personalizada
            throw new PeliculaNotSavedException("No se pudo guardar la película: " + peliculaInDto.titulo(), e);
        }

    }

    @Override
    public PeliculaInOutDto updatePelicula(PeliculaInDto peliculaInDto) {

        if (peliculaInDto.id() == null || !peliculaRepository.existsById(peliculaInDto.id())) {
            throw new PeliculaNotSavedException("No se pudo actualizar no existe la película: " + peliculaInDto.titulo() + ", con ese id: " + peliculaInDto.id());

        }
        try{
        Pelicula pelicula = peliculaMapper.toEntity(peliculaInDto);
        PeliculaEntity peliculaEntity =  peliculaRepository.save(peliculaSaveMapper.toEntity(pelicula));

        Pelicula peliculaOut = peliculaSaveMapper.toDto(peliculaEntity);
        return peliculaOutMapper.toDto(peliculaOut);
        } catch (Exception e) {
            // En caso de error en la persistencia, lanzar una excepción personalizada
            throw new PeliculaNotSavedException("No se pudo actualizar la película con id: " + peliculaInDto.id(), e);
        }
    }

    @Override
    public Iterable<PeliculaInOutDto> getAllPeliculas() {
        try {
            // Intentamos obtener todas las películas desde el repositorio
            Iterable<PeliculaEntity> peliculaEntities = this.peliculaRepository.findAll();

            // Si no se encontraron películas, lanzamos una excepción personalizada
            if (!peliculaEntities.iterator().hasNext()) {
                throw new PeliculaNotSavedException("Error al obtener las películas, no hay datos disponibles.");
            }

            // Si se encontraron, mapeamos las entidades a DTOs
            Iterable<Pelicula> peliculas = peliculaSaveMapper.toDtoIterable(peliculaEntities);
            return peliculaOutMapper.toDtoIterable(peliculas);

        } catch (Exception e) {
            // Si ocurre cualquier otra excepción, la envolvemos en PeliculaNotSavedException
            throw new PeliculaNotSavedException("Error al obtener las películas", e);
        }
    }

    @Override
    public PeliculaInOutDto getPeliculaById(Long id) {
        try {
            PeliculaEntity  peliculaEntity =  this.peliculaRepository.findById(id)
                    .orElseThrow(() -> new PeliculaNotSavedException("No se pudo obtener la película con id: " + id));
            Pelicula peliculaOut = peliculaSaveMapper.toDto(peliculaEntity);
            return peliculaOutMapper.toDto(peliculaOut);

        } catch (Exception e) {
            // Si ocurre algún otro error, lo puedes envolver en la excepción personalizada con la causa original.
            throw new PeliculaNotSavedException("Error al obtener la película con id: " + id, e);
        }

    }

    @Override
    public void deletePeliculaById(Long id) {
        try {
            // Verificamos si la película existe
            Optional<PeliculaEntity> peliculaOpt = this.peliculaRepository.findById(id);

            // Si no existe, lanzamos la excepción personalizada
            if (!peliculaOpt.isPresent()) {
                throw new PeliculaNotSavedException("Error: No se encuentra la película con id: " + id);
            }

            // Si la película existe, la eliminamos
            this.peliculaRepository.deleteById(id);

        } catch (Exception e) {
            // Si ocurre un error inesperado, lanzamos la excepción personalizada con la causa original
            throw new PeliculaNotSavedException("Error al intentar eliminar la película con id: " + id, e);
        }
    }




}
