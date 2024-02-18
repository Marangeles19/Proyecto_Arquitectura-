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
public class FacturaVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFacVenta;

    @Column (name = "fechaFacVenta" , nullable = false)
    private Date fechaFacVenta;

    @Column (name ="totalFacVenta" , nullable = false)
    private int totalFacVenta;

    @Column (name = "subTotalFactura" , nullable = false)
    private int subTotalFactura;

    @Column (name = "noPedido" , nullable = false)
    private int noPedido;

}
