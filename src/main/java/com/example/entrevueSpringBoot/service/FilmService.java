package com.example.entrevueSpringBoot.service;

import java.util.Optional;

import com.example.entrevueSpringBoot.model.Acteur;
import com.example.entrevueSpringBoot.model.Film;
import com.example.entrevueSpringBoot.repository.FilmRepository;
import com.example.entrevueSpringBoot.utils.FormatFilm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService implements IFilmService {

    private static final Logger log = LoggerFactory.getLogger(FilmService.class);

    @Autowired
    private FilmRepository repo;

    @Override
    public Optional<Film> ajouterFilm(Film film) {
        log.info("Service: ajouter un film {}", film.toString());
        Film filmCree = this.repo.save(FormatFilm.trimAndLowerCase(film));
        return Optional.ofNullable(filmCree);
    }

    @Override
    public Optional<Film> obtenirFilmParId(Long id) {
        log.info("Service: obtenir un film par id {}", id);
        return this.repo.findById(id);
    }

}
