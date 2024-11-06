package com.ramon.arcis.Peliculas.domain.exceptions;

public class PeliculaNotSavedException extends RuntimeException {
    public PeliculaNotSavedException(String message) {
        super(message);
    }

    public PeliculaNotSavedException(String message, Throwable cause) {
        super(message, cause);
    }

}
