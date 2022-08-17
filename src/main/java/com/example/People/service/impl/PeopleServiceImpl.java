package com.example.People.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.example.People.controller.PeopleDTO;
import com.example.People.service.PeopleService;
import com.google.gson.Gson;

@Service
public class PeopleServiceImpl implements PeopleService{

    @Override //consumo de una api
    public PeopleDTO consultarPeople(Integer id) throws IOException {
        URL url = new URL("https://swapi.dev/api/people/"+String.valueOf(id)+"?format=json");
        //URL url = new URL("https://swapi.dev/api/people/"+String.valueOf(id));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            Gson g = new Gson();
            System.out.println(response.toString()); //para ver que llega de la api, tuvimos que agregarle format=json
            PeopleDTO swapiApi = g.fromJson(response.toString(), PeopleDTO.class); // declaro la variable pokeapi de tipo objeto PokeApi
            return swapiApi; 
        }
    return null;
    
}

}  