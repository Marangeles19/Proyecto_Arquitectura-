package com.microservice.inventario.http.response;

import com.microservice.inventario.dto.DetallDTO;
import com.microservice.inventario.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetallByProductResponse {

    private String nombre;
    private String descripcion;
    private double precio;
    private Categoria categoria;
    private List<DetallDTO> DetallDTOlist;

}
