/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hegarc.ig.odi.peoplemovie.bean;

import ch.hearc.ig.odi.peoplemovie.business.Movie;
import ch.hearc.ig.odi.peoplemovie.service.Services;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author johan.steiner
 */
@Named(value = "manageMovie")
@RequestScoped
public class ManageMovie {

    @Inject Services service;
    
    private Long idMovie;
    private Movie currentMovie;
    
    public ManageMovie() {
    }

    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }

    public Movie getCurrentMovie() {
        return currentMovie;
    }

    public void setCurrentMovie(Movie currentMovie) {
        this.currentMovie = currentMovie;
    }
    
    public void initMovie() {
        currentMovie = service.getMovieWithId(idMovie);
    }
    
    public String addNewMovie() {
        
        return "/index.xhtml";
    }
    
}
