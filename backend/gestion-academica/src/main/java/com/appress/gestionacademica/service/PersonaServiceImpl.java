package com.appress.gestionacademica.service;

import com.appress.gestionacademica.Repository.PersonaRepository;
import com.appress.gestionacademica.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaRepository personaRepository;
    @Override
    public ArrayList<Persona> getAllPerson() {
        return (ArrayList<Persona>) personaRepository.findAll();
    }

    @Override
    public Optional<Persona> getPersonById(long id) {
        return personaRepository.findById(id);
    }

    @Override
    public Persona savePerson(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public boolean deletePersonById(long id) {
        try{
            Optional<Persona> optionalPersona = personaRepository.findById(id);
            if(optionalPersona.isPresent()){
                Persona persona = optionalPersona.get();
                persona.setActivo(false);
                personaRepository.save(persona);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
