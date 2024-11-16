package com.ramon.arcis.Peliculas.domain.model;


import java.io.Serializable;

public record Pelicula(Long id, String titulo, String autor, String genero) implements Serializable { }


