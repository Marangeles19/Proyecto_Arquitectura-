package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @Column ( name = "noPedido" , nullable = false)
    private String noPedido;

    @Column (name = "productoPedido" , nullable = false)
    private String productoPedido;

    @Column (name = "estado" , nullable = false)
    private String estado;

    @Column (name = "fechaPedido" , nullable = false)
    private Date fechaPago;

    @ManyToOne
    @JoinColumn (name = "id_Cliente" , nullable = false , foreignKey = @ForeignKey(name = "FK_PEDIDO_CLIENTE"))
    private Cliente cliente;


}
