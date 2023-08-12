package com.appress.gestionacademica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiante")
@PrimaryKeyJoinColumn(name = "id")
public class Estudiante extends Persona {

    @Column(name = "estado", nullable = false)
    private boolean estado = true;

    @Column(name = "ciclo_estudio", nullable = false)
    private int cicloEstudio;
}
