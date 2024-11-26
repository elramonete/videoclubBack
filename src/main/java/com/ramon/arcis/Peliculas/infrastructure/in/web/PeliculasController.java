package com.ramon.arcis.Peliculas.infrastructure.in.web;

import com.ramon.arcis.Peliculas.application.port.in.PeliculaInDto;
import com.ramon.arcis.Peliculas.application.port.in.PeliculaInOutDto;
import com.ramon.arcis.Peliculas.application.port.in.PeliculaServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/pelicula")
@RestController
public class PeliculasController {

    private final PeliculaServiceImp peliculaServiceImp;

    public PeliculasController(PeliculaServiceImp peliculaServiceImp) {
        this.peliculaServiceImp = peliculaServiceImp;
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @PostMapping
    public ResponseEntity<PeliculaInOutDto> guardarPelicula(@RequestBody PeliculaInDto peliculaInDto){
    PeliculaInOutDto save = this.peliculaServiceImp.guardarPelicula(peliculaInDto);
        return ResponseEntity.ok(save);

    }

    @CrossOrigin("http://127.0.0.1:5500")
    @PutMapping
    public ResponseEntity<PeliculaInOutDto> actualizarPelicula(@RequestBody PeliculaInDto peliculaInDto) {
        PeliculaInOutDto updatePelicula = this.peliculaServiceImp.updatePelicula(peliculaInDto);
        return ResponseEntity.ok(updatePelicula);
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping
    public ResponseEntity<Iterable<PeliculaInOutDto>> getAllPeliculas(){
        return new ResponseEntity<>(this.peliculaServiceImp.getAllPeliculas(), HttpStatus.OK);
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/{id}")
    public ResponseEntity<PeliculaInOutDto> getPelicula (@PathVariable Long id){

        return new ResponseEntity<>(this.peliculaServiceImp.getPeliculaById(id), HttpStatus.OK);
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @DeleteMapping("/{id}")
    public void deletePelicula (@PathVariable Long id){
        this.peliculaServiceImp.deletePelicula(id);
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/index")
    public String getPeli(){
        return "Hello world NO SEGURO";
    }

}
