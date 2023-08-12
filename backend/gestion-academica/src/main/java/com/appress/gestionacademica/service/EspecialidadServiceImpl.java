package com.appress.gestionacademica.service;

import com.appress.gestionacademica.Repository.EspecialidadRepository;
import com.appress.gestionacademica.model.Especialidad;
import com.appress.gestionacademica.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{

    @Autowired
    EspecialidadRepository especialidadRepository;
    @Override
    public ArrayList<Especialidad> getAllEspecialidad() {
        return (ArrayList<Especialidad>) especialidadRepository.findAll();
    }

    @Override
    public Optional<Especialidad> getEspecialidadById(long id) {
        return especialidadRepository.findById(id);
    }

    @Override
    public Especialidad saveEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public boolean deleteEspecialidadById(long id) {
        try{
            Optional<Especialidad> optionalEspecialidad = especialidadRepository.findById(id);
            if(optionalEspecialidad.isPresent()){
                Especialidad especialidad = optionalEspecialidad.get();
                especialidad.setActivo(false);
                especialidadRepository.save(especialidad);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
