package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity

public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @NotEmpty(message = "Asegúrate de proporcionar la información requerida")
    @Column(name = "nombre_cliente" , nullable = false)
    private String nombre_cliente;

    @NotEmpty(message = "Asegúrate de proporcionar la información requerida")
    @Column(name = "apellido_cliente" , nullable = false)
    private String apellido_cliente;

    @NotEmpty(message = "Asegúrate de proporcionar la información requerida")
    @Size(min = 10 , max = 10, message = "El tamaño del numero es 10")
    @Column(name ="cedula_cliente" , unique = true , length = 10 , nullable = false)
    private String cedula_cliente;

    @NotEmpty(message = "Asegúrate de proporcionar la información requerida")
    @Size(min = 10 , max = 10, message = "El tamaño del numero es 10")
    @Column(name ="telf_cliente" , unique = true , length = 10 , nullable = false)
    private String telf_cliente;

    @NotEmpty(message = "Asegúrate de proporcionar la información requerida")
    @Email(message = "La dirección de correo electrónico proporcionada no es válida")
    @Column(unique = true , nullable = false)
    private String email;

    @Column(name = "Points",nullable = false)
    private int Points;

    private String state;


}
