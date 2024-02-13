package com.microservice.ventafisica.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlmacenDTO {
    private Integer idAlmacen;
    private String nombre;
    private String ubicacion;
}
