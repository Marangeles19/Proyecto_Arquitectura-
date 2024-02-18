package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Oferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOferta;

    @Column (name = "productoOferta" , nullable = false)
    private List productoOferta;

    @Column (name = "fechaInicio" , nullable = false)
    private Date fechaInicio;

    @Column (name = "fechaFin" , nullable = false)
    private Date fechaFin;

}
