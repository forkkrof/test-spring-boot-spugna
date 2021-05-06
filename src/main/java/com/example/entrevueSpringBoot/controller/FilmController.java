package com.example.entrevueSpringBoot.controller;

import java.util.Optional;

import com.example.entrevueSpringBoot.model.Film;
import com.example.entrevueSpringBoot.service.FilmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/film/{id}")
    ResponseEntity<Film> obtenirUnFilm(@PathVariable Long id) throws FilmNotFoundException {
        Film filmRecupere = filmService.obtenirFilmParId(id).orElseThrow(() -> new FilmNotFoundException(id));
        return new ResponseEntity<Film>(filmRecupere, HttpStatus.OK);
    }

    @PostMapping("/film")
    public ResponseEntity<Film> ajoutFilm(@RequestBody Film film) {
        Optional<Film> filmAjoute = this.filmService.ajouterFilm(film);
        if (filmAjoute.isPresent()) {
            // Le film a bien ete ajoute dans la BDD
            return new ResponseEntity<Film>(filmAjoute.get(), HttpStatus.CREATED);
        } else {
            // Le film n a pas pu etre enregistre dans la BDD
            return new ResponseEntity<Film>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}