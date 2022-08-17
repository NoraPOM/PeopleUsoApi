package com.example.People.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.People.service.PeopleService;


@RestController
@RequestMapping( "/people" )
public class PeopleController {
    private final PeopleService peopleservice;
    public PeopleController( @Autowired PeopleService peopleservice )
    {
        this.peopleservice = peopleservice;
    } 
    @GetMapping( "/{id}")
    public ResponseEntity<PeopleDTO> mostrarPeople(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(peopleservice.consultarPeople(id));
        } catch (IOException e) {
           e.printStackTrace();
        }
        return null;
        
    }
}



