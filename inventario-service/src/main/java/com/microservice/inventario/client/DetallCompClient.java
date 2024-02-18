package com.microservice.inventario.client;

import com.microservice.inventario.dto.DetallDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "proveedor-service", url = "localhost:8081/api/Detallecomp")
public interface DetallCompClient {

    @GetMapping("/search-ny-product/{id}")
    List<DetallDTO> findAllProducts(@PathVariable Integer id);

}
