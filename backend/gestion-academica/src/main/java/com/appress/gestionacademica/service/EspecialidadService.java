package com.appress.gestionacademica.service;

import com.appress.gestionacademica.model.Especialidad;

import java.util.ArrayList;
import java.util.Optional;

public interface EspecialidadService {
    ArrayList<Especialidad> getAllEspecialidad();
    Optional<Especialidad> getEspecialidadById(long id);

    Especialidad saveEspecialidad(Especialidad especialidad);

    boolean deleteEspecialidadById(long id);
}
