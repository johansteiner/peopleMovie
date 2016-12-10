/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hegarc.ig.odi.peoplemovie.bean;

import ch.hearc.ig.odi.peoplemovie.business.Movie;
import ch.hearc.ig.odi.peoplemovie.exception.NullParameterException;
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
    private String name;
    private String producer;
    private Movie currentMovie;
    
    public ManageMovie() {
        if(currentMovie == null) {
            currentMovie = new Movie();
        }
    }

    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Movie getCurrentMovie() {
        return currentMovie;
    }

    public void setCurrentMovie(Movie currentMovie) {
        this.currentMovie = currentMovie;
    }
    
    /**
     * crée un nouvel objet de type Movie en reprenant
     *  un film existant par son ID s'il n'est pas null
     */
    public void initMovie() {
        if(idMovie == null) {
            currentMovie = new Movie();
        } else {
            currentMovie = service.getMovieWithId(idMovie);
        }
    }
    
    /**
     * ajoute un nouveau film en fonction des
     * informations (nom, producteur) entrées par l'utilisateur
     * @return chaine de caractère pour redirection sur la page index.xhtml
     * @throws NullParameterException 
     */
    public String addNewMovie() throws NullParameterException {
        service.saveMovie(currentMovie);
        return "/index.xhtml?faces-redirect=true";
    }
    
    /**
     * modification sur un film présent dans la liste de films en 
     * fonction des informations (nom, producteur) modifiées par l'utilisateur
     * @return chaine de caractère pour redirection sur la page index.xhtml
     */
    public String editMovie() {
        
        return "/index.xhtml?faces-redirect=true";
    }
    
}
