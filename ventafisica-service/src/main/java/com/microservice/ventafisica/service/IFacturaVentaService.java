package com.microservice.ventafisica.service;

import com.microservice.ventafisica.http.response.ProductoByInventarioResponse;
import com.microservice.ventafisica.model.FacturaVenta;

public interface IFacturaVentaService extends ICRUDService<FacturaVenta,Integer> {

    ProductoByInventarioResponse PRODUCTO_BY_INVENTARIO_RESPONSE(String nombreProducto, String nombreAlmacen);
}