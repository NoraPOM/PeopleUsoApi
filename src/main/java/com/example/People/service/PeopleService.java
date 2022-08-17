package com.example.People.service;

import java.io.IOException;

import com.example.People.controller.PeopleDTO;

public interface PeopleService {

    public PeopleDTO consultarPeople(Integer id) throws IOException;
    
}