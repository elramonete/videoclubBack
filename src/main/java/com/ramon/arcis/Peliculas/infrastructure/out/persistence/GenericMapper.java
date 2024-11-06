package com.ramon.arcis.Peliculas.infrastructure.out.persistence;

public interface GenericMapper<D, E> {
    D toDto(E entity);
    E toEntity(D dto);
}