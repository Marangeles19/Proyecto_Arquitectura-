package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProgramaFidelización {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProgramaFidelización;

    @Column (name = "clientesFrecuentes" , nullable = false)
    private String clientesFrecuentes;

    @ManyToOne
    @JoinColumn (name = "Id_Cliente" , nullable = false , foreignKey = @ForeignKey(name = "FK_PROGRAMAFIDELIZACIO_CLIENTE"))
    private Cliente cliente;

}
