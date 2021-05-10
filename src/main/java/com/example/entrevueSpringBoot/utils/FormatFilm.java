package com.example.entrevueSpringBoot.utils;

import java.util.stream.Collectors;

import com.example.entrevueSpringBoot.model.Acteur;
import com.example.entrevueSpringBoot.model.Film;

/**
 * Classe Utilitaire pour mettre au "propre" les valeurs de type String dans la
 * BDD
 */
public class FormatFilm {
    /**
     * Fonction permettant d homogeneiser les valeurs chaines de caracteres dans la
     * base de donnees
     * 
     * @param film - Film a formatter
     * @return Film - Film dont ses valeurs sont debarassees des espaces, et du
     *         multicasses
     */
    public static Film trimAndLowerCase(Film film) {
        film.setTitre(film.getTitre().trim().toLowerCase());
        film.setDescription(film.getDescription().trim().toLowerCase());
        film.setActeurs(film.getActeurs().stream().map(acteur -> formatActeur(acteur)).collect(Collectors.toList()));
        return film;
    }

    /**
     * Fonction permettant d homogeneiser les valeurs chaines de caracteres d un
     * acteur dans la base de donnees
     * 
     * @param acteur - Acteur a formatter
     * @return Acteur - Acteur dont ses valeurs sont debarassees des espaces, et du
     *         multicasses
     */
    private static Acteur formatActeur(Acteur acteur) {
        acteur.setNom(acteur.getNom().trim().toLowerCase());
        acteur.setPrenom(acteur.getPrenom().trim().toLowerCase());
        return acteur;
    }
}
