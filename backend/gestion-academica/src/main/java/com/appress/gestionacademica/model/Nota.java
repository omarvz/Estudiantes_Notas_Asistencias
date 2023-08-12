package com.appress.gestionacademica.model;

import com.appress.gestionacademica.model.enums.TipoNota;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "nota")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fid_horario", referencedColumnName = "id")
    private Horario horario;

    @ManyToOne
    @JoinColumn(name = "fid_estudiante", referencedColumnName = "id")
    private Estudiante estudiante;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoNota tipo;

    @Column(name = "descripcion", length = 50)
    private String descripcion;

    @Column(name = "fecha_de_registro", nullable = false)
    private LocalDate fechaDeRegistro = LocalDate.now();
}
