/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hegarc.ig.odi.peoplemovie.bean;

import ch.hearc.ig.odi.peoplemovie.business.Person;
import ch.hearc.ig.odi.peoplemovie.service.Services;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author johan.steiner
 */
@Named(value = "managePerson")
@RequestScoped
public class ManagePerson {
    
    @Inject Services service;

    Long idPerson;
    Person currentPerson;
    
    public ManagePerson() {
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
    
    public void initPerson() {
        currentPerson = service.getPersonWithId(idPerson);
    }
    
}
