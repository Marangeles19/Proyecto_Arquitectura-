package com.microservice.ventafisica.api;

import com.microservice.ventafisica.dto.StockDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="inventario-service")
@Component
public interface InventarioClient {
    @GetMapping("/api/stock/producto")
    StockDTO findByProductoAlmacen(@RequestParam("producto") String nombreProducto,
                                   @RequestParam("almacen") String nombreAlmacen);
}
