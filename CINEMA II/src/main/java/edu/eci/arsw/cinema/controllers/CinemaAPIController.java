/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.controllers;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.services.CinemaException;
import edu.eci.arsw.cinema.services.CinemaServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author cristian
 */

@RestController
@RequestMapping(value = "/cinemas")
public class CinemaAPIController {

    @Autowired
    @Qualifier("CinemaServices")
    CinemaServicesInterface cs;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllCinemas() {
        //obtener datos que se enviarán a través del API
        return new ResponseEntity<>(cs.getAllCinemas(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getCinemaByName(@PathVariable String name) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(cs.getCinemaByName(name), HttpStatus.ACCEPTED);
        } catch (CinemaException ex) {
            Logger.getLogger(CinemaServicesInterface.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{name}/{date}", method = RequestMethod.GET)
    public ResponseEntity<?> getFunctionsbyCinemaAndDate(@PathVariable String name, @PathVariable String date) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(cs.getFunctionsbyCinemaAndDate(name,date), HttpStatus.ACCEPTED);
        } catch (CinemaException ex) {
            Logger.getLogger(CinemaServicesInterface.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{name}/{date}/{mname}", method = RequestMethod.GET)
    public ResponseEntity<?> getFunctionsbyCinemaAndDateMname(@PathVariable String name, @PathVariable String date,@PathVariable String mname) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(cs.getFunctionsbyCinemaAndDateMname(name,date,mname), HttpStatus.ACCEPTED);
        } catch (CinemaException ex) {
            Logger.getLogger(CinemaServicesInterface.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
    }

    /*
    @RequestMapping(path =  "/cinemas/{name}", method = RequestMethod.POST)
    public ResponseEntity<?> addNewCinema(@PathVariable String name, @RequestBody CinemaFunction cinemaFunction){
        try {
            cs.addNewCinema(cinema);
        } catch (CinemaException ex) {
            Logger.getLogger(CinemaServicesInterface.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.FORBIDDEN);
        }
    }

     */

}
