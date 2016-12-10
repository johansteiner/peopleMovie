/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hegarc.ig.odi.peoplemovie.bean;

import ch.hearc.ig.odi.peoplemovie.business.Person;
import ch.hearc.ig.odi.peoplemovie.exception.NullParameterException;
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

    private Long idPerson;
    private String firstname;
    private String lastname;
    private Person currentPerson;
    
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

    public Person getCurrentPerson() {
        return currentPerson;
    }

    public void setCurrentPerson(Person currentPerson) {
        this.currentPerson = currentPerson;
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
     * ajoute une nouvelle personne en fonction des informations
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
    
}
