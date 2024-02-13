package com.microservice.ventafisica.http.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoByInventarioResponse {
    private String nombreAlmacen;
    private String nombreCategoria;
    private String nombreProducto;
    private double precio;
    private int cantidad;

}
