/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.peoplemovie.converter;

import ch.hearc.ig.odi.peoplemovie.business.Movie;
import ch.hearc.ig.odi.peoplemovie.service.Services;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

/**
 *
 * @author johan.steiner
 */
@Named(value = "moviesLOVConverter")
@RequestScoped
public class MoviesLOVConverter implements Converter {

    @Inject Services service;
    /**
     * Creates a new instance of movieLOVConerter
     */
    public MoviesLOVConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        } else {
            Movie movie = null;
            for (Movie currentMovie : service.getMoviesList()) {
                if (currentMovie.getName().equals(value)) {
                    movie = currentMovie;
                }
            }
            
            return movie;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof Movie) {
            return ((Movie) value).getName();
        } else {
            return "";
        }
    }
    
}
