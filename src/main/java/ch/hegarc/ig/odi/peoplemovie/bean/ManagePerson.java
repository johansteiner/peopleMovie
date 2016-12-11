/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hegarc.ig.odi.peoplemovie.bean;

import ch.hearc.ig.odi.peoplemovie.business.Movie;
import ch.hearc.ig.odi.peoplemovie.business.Person;
import ch.hearc.ig.odi.peoplemovie.exception.InvalidParameterException;
import ch.hearc.ig.odi.peoplemovie.exception.NullParameterException;
import ch.hearc.ig.odi.peoplemovie.exception.UniqueException;
import ch.hearc.ig.odi.peoplemovie.service.Services;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author johan.steiner
 */
@ManagedBean(name = "managePerson")
@ViewScoped
public class ManagePerson implements Serializable{
    
    @Inject Services service;

    private Long idPerson;
    private Person currentPerson;
    Movie movieAdd;
    
    public ManagePerson() {
        if(currentPerson==null) {
            currentPerson = new Person();
        }
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public Person getCurrentPerson() {
        return currentPerson;
    }

    public void setCurrentPerson(Person currentPerson) {
        this.currentPerson = currentPerson;
    }

    public Movie getMovieAdd() {
        return movieAdd;
    }

    public void setMovieAdd(Movie movieAdd) {
        this.movieAdd = movieAdd;
    }
        
    /**
     * crée un nouvel objet de type Person en reprenant
     * une personne existante par son ID s'il y en a
     */
    public void initPerson() {
        if(idPerson == null) {
            currentPerson = new Person();
        } else {
            currentPerson = service.getPersonWithId(idPerson);
        }
    }
    
    /**
     * ajout d'une nouvelle personne en fonction des informations
     * (nom, prénom) entrées par l'utilisateur
     * @return chaine de caractère pour redirection sur la page index.xhtml
     * @throws NullParameterException 
     */
    public String addNewPerson() throws NullParameterException {
        service.savePerson(currentPerson);
        return "/index.xhtml?faces-redirect=true";
    }
    
    /**
     * modification sur une personne présente dans la liste de personnes
     * en fonction des informations (nom, prénom) modifiées par l'utilisateur
     * @return chaine de caractère pour redirection sur la page index.xhtml 
     */
    public String editPerson() {
        
        service.getPersonWithId(currentPerson.getId()).setFirstname(currentPerson.getFirstname());    
        service.getPersonWithId(currentPerson.getId()).setLastname(currentPerson.getLastname());
        return "/index.xhtml?faces-redirect=true";
    }
    
    public void deleteMovie(Movie movie) throws NullParameterException, InvalidParameterException {
        service.removeMovieFromPerson(currentPerson, movie);
        //return "/person/person.xhtml?faces-redirect=true?id=" + currentPerson;
    }
    
    
    /**
     * Retourne la liste des films pas encore ajoutés à une persone
     * @return liste de films
     */
    public List<Movie> getMovieToAdd(){
        List<Movie> moviesToReturn = service.getMoviesList();
        
        for(Movie movie : currentPerson.getMovies()){
            moviesToReturn.remove(movie);
        }
        
        return moviesToReturn;
    }
    
    /**
     * Ajoute un film à une personne
     */
    public void addMovie() throws NullParameterException, UniqueException {
        service.addMovieToPerson(currentPerson, movieAdd);
    }
}
