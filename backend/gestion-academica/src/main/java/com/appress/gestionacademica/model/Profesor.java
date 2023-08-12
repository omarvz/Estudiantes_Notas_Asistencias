package com.appress.gestionacademica.model;

import com.appress.gestionacademica.model.enums.TipoProfesor;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "profesor")
@PrimaryKeyJoinColumn(name = "id")
public class Profesor extends Persona {

    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoProfesor tipo;

    @Column(name = "estado", nullable = false)
    private boolean estado = true;

    @Column(name = "area_especializacion", nullable = false, length = 100)
    private String areaEspecializacion;


}