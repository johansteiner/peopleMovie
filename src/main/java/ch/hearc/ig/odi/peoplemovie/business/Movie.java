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
public class Movie {
    
    private Long id;
    private String name;
    private String producer;
    private List<Person> people;    

    public Movie() {
        this.people = new ArrayList<Person>();
    }

    public Movie(String name, String producer) {
        this.name = name;
        this.producer = producer;
        this.people = new ArrayList<Person>();
    }

    public Movie(Long id, String name, String producer) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.people = new ArrayList<Person>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
    
    /**
     * 
     * @param person objet de type Person qui sera ajoutée à la liste people
     * @throws UniqueException
     * @throws NullParameterException 
     */
    public void addPerson(Person person) throws UniqueException, NullParameterException {
        
        // Si le film est nul ==> exception
        if(person == null) {
            throw new NullParameterException("Le paramètre est nul");
        }
        else{
            // Si la liste contient au moins une personne...
            if(people.size() > 0){
                // ... pour chaque personne de la liste...
                for(Person pers : people) { 
                    // ... on contrôle s'il y a une personne
                    // avec le même ID que la personne à ajouter
                    if(person.getId() == pers.getId()) {
                        throw new UniqueException("La personne existe déjà dans la liste"); 
                    }
                }
            }
            people.add(person);  
        } 
               
    }
    
}
