package com.appress.gestionacademica.service;

import com.appress.gestionacademica.model.Persona;

import java.util.ArrayList;
import java.util.Optional;

public interface PersonaService {
    ArrayList<Persona> getAllPerson();
    Optional<Persona> getPersonById(long id);
    Persona savePerson(Persona persona);
    boolean deletePersonById(long id);
}
