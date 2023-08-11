package com.appress.gestionacademica.controller;

import com.appress.gestionacademica.model.Persona;
import com.appress.gestionacademica.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RequestMapping("api/personas")
@RestController
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @GetMapping
    public ArrayList<Persona> getAllPerson(){
        return personaService.getAllPerson();
    }

    @GetMapping("/{id}")
    public Optional<Persona> getPersonById(@PathVariable("id") long id){
        return personaService.getPersonById(id);
    }

    @PostMapping
    public Persona savePerson(@RequestBody Persona persona){
        return personaService.savePerson(persona);
    }

    @DeleteMapping("/{id}")
    public String deletePersonById(@PathVariable("id") long id){
        if(personaService.deletePersonById(id))
            return "Se ha eliminado la persona";
        else
            return "NO se ha eliminado la persona";
    }
}
