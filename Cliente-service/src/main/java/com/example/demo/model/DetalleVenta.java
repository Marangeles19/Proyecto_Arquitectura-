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
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    @Column (name = "fechaVenta" , nullable = false)
    private Date fechaVenta;

    @Column (name = "totalVenta" , nullable = false)
    private int totalVenta;

    @Column (name = "descuentoVenta" , nullable = false)
    private int descuentoVenta;

    @Column (name = "ivaVenta" , nullable = false)
    private int ivaVenta;

    @Column (name = "correoCliente" , nullable = false)
    private String correoCliente;

    @ManyToOne
    @JoinColumn(name = "id_FactVenta", nullable = false, foreignKey = @ForeignKey(name = "FK_"))
    private Pedido pedido;

}
