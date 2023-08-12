package com.appress.gestionacademica.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "especialidad")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "abreviatura", nullable = false, length = 10)
    private String abreviatura;

    @Column(name = "nombre", nullable = false, length = 70)
    private String nombre;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;
}
