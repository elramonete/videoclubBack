package com.ramon.arcis.Peliculas.infrastructure.out.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends CrudRepository<PeliculaEntity, Long> {
}
