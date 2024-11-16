package com.ramon.arcis.Peliculas.application.port.in;

import java.io.Serializable;

public record PeliculaInOutDto(Long id, String titulo, String autor, String genero) implements Serializable { }

