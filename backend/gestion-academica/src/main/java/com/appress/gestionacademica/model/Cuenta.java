package com.appress.gestionacademica.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fid_persona", nullable = false)
    private Long fidPersona;

    @Column(name = "correo", nullable = false, unique = true, length = 40)
    private String correo;

    @Column(name = "password", nullable = false, length = 40)
    private String password;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;

    // Relación con Persona
    @ManyToOne
    @JoinColumn(name = "fid_persona", referencedColumnName = "id", insertable = false, updatable = false)
    private Persona persona;
}
