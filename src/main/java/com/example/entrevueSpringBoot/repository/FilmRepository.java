package com.example.entrevueSpringBoot.repository;

import com.example.entrevueSpringBoot.model.Film;

import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Long> {
    Film findById(long id);
}
