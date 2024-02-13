package com.microservice.ventafisica.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {
    private Integer idStock;
    private int cantidad;
    private AlmacenDTO almacen;
    private ProductoDTO producto;
}




















