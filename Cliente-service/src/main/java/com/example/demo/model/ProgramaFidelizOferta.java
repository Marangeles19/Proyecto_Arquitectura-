package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProgramaFidelizOferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idfidelizacionOferta;

    @Column (name = "fechaInicio" , nullable = false)
    private Date fechaInicio;

    @Column(name = "fechaFin", nullable = false)
    private Date fechaFin;

    @ManyToOne
    @JoinColumn (name = "id_progrmaFidelizacion" , nullable = false , foreignKey = @ForeignKey(name = "FK_PROGRAMAFIDELIZOFERTA_PROGRAMAFIDELIZACION"))
    private ProgramaFidelización programaFidelización;

    @ManyToOne
    @JoinColumn (name = "id_oferta" , nullable = false , foreignKey = @ForeignKey(name = "FK_PROGRAMAFIDELIZOFERTA_OFERTA"))
    private Oferta oferta;


}

