package com.ramon.arcis.Peliculas.infrastructure.in.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/seguridad")
@RestController
public class PruebaSeguridad {

    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/index")
    public String getPeli(){
        return "Hello world ES SEGURO";
    }
}
