package com.appress.gestionacademica.controller;

import com.appress.gestionacademica.model.Especialidad;
import com.appress.gestionacademica.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RequestMapping("api/especialidades")
@RestController
public class EspecialidadController {
    @Autowired
    EspecialidadService especialidadService;

    @GetMapping
    public ArrayList<Especialidad> getAllEspecialidad(){
        return especialidadService.getAllEspecialidad();
    }

    @GetMapping("/{id}")
    public Optional<Especialidad> getEspecialidadById(@PathVariable("id") long id){
        return especialidadService.getEspecialidadById(id);
    }

    @PostMapping
    public Especialidad saveEspecialidad(@RequestBody Especialidad especialidad){
        return especialidadService.saveEspecialidad(especialidad);
    }

    @DeleteMapping("/{id}")
    public String deleteEspecialidadById(@PathVariable("id") long id){
        if(especialidadService.deleteEspecialidadById(id))
            return "Se ha eliminado la especialidad";
        else
            return "NO se ha eliminado la especialidad";
    }
}
