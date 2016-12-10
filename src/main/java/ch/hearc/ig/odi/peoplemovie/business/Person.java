/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.peoplemovie.business;

import ch.hearc.ig.odi.peoplemovie.exception.NullParameterException;
import ch.hearc.ig.odi.peoplemovie.exception.UniqueException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johan.steiner
 */
public class Person {
    
    private Long id;
    private String firstname;
    private String lastname;
    private List<Movie> movies;

    public Person() {
        this.movies = new ArrayList<Movie>();
    }

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.movies = new ArrayList<Movie>();
    }

    public Person(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.movies = new ArrayList<Movie>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
       
    /**
     * 
     * @param movie objet de type Movie qui sera ajoutée à la liste movies
     * @throws UniqueException
     * @throws NullParameterException 
     */
    public void addMovie(Movie movie) throws UniqueException, NullParameterException {
        
        // Si le film est nul ==> exception
        if(movie == null) {
            throw new NullParameterException("Le paramètre est nul");
        }
        else{
            // Si la liste contient au moins un film...
            if(movies.size() > 0){
                // ... pour chaque film de la liste...
                for(Movie mov : movies) { 
                    // ... on contrôle s'il y a un film
                    // avec le même ID que le film à ajouter
                    if(movie.getId() == mov.getId()) {
                        throw new UniqueException("Le film existe déjà dans la liste"); 
                    }
                }
            }
            movies.add(movie);
            movie.addPerson(this);
        } 
               
    }
    
    public void removeMovie(Movie movie) {
        movies.remove(movie);
    }
    
}
