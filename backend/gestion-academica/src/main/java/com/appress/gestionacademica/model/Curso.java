package com.appress.gestionacademica.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "abreviatura", nullable = false, length = 10)
    private String abreviatura;

    @Column(name = "nombre", nullable = false, length = 70)
    private String nombre;

    @Column(name = "estado", nullable = false)
    private boolean estado = true;
}
