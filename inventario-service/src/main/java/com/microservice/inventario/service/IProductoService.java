package com.microservice.inventario.service;

import com.microservice.inventario.http.response.DetallByProductResponse;
import com.microservice.inventario.model.Producto;

public interface IProductoService extends ICRUDService<Producto,Integer> {
    Producto findProductoNombre(String nombreProducto);
    DetallByProductResponse findDetallByIdProduct(Integer id);
}
