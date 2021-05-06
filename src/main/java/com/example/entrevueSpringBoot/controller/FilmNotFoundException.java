package com.example.entrevueSpringBoot.controller;

public class FilmNotFoundException extends RuntimeException {
    FilmNotFoundException(Long id) {
        super("N'a pas pu retrouver le film " + id);
    }
}