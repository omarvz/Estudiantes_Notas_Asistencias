package com.appress.gestionacademica.model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;

@Data
@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido_paterno")
    private String apellido_paterno;

    @Column(name = "DNI", columnDefinition = "varchar(8)", nullable = false, unique = true)
    private String DNI;

    @Column(name = "fecha_de_nacimiento", nullable = false)
    private LocalDate fecha_de_nacimiento;

    @Column(name = "activo")
    private Boolean activo = true;

    @Column(name = "codigo", columnDefinition = "varchar(8)", nullable = false, unique = true)
    private String codigo;
}
