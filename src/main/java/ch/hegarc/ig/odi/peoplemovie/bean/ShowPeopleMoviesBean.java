/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hegarc.ig.odi.peoplemovie.bean;

import ch.hearc.ig.odi.peoplemovie.business.Movie;
import ch.hearc.ig.odi.peoplemovie.business.Person;
import ch.hearc.ig.odi.peoplemovie.service.Services;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author johan.steiner
 */
@Named(value = "showPeopleMoviesBean")
@RequestScoped
public class ShowPeopleMoviesBean {
    
    @Inject Services service;
    private List<Person> people;
    private List<Movie> movies;
    
    /**
     * Creates a new instance of ShowPeopleMoviesBean
     */
    public ShowPeopleMoviesBean() {
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
    /**
     * rempli les listes people et movies
     * avec les personnes et films déjà existants
     */
    public void initEntities() {
        this.people = service.getPeopleList();
        this.movies = service.getMoviesList();
    }
        
}
