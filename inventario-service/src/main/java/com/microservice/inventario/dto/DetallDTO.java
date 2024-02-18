package com.microservice.inventario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetallDTO {

    private int cantidadComprada;
    private double precioUnitario;
    private String correoCliente;
    private String status;

}
