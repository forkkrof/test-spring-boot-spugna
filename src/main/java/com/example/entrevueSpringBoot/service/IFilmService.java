package com.example.entrevueSpringBoot.service;

import java.util.Optional;

import com.example.entrevueSpringBoot.model.Film;

public interface IFilmService {

    public Optional<Film> ajouterFilm(Film film);

    public Optional<Film> obtenirFilmParId(Long id);
}
