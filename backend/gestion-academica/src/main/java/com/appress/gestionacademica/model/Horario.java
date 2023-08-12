package com.appress.gestionacademica.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "horario")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fid_curso", referencedColumnName = "id")
    private Curso curso;

    @Column(name = "nombre", nullable = false, length = 70)
    private String nombre;

    @Column(name = "estado", nullable = false)
    private boolean estado = true;
}
