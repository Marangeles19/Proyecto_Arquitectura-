
package com.microservice.inventario.service;

import com.microservice.inventario.model.Producto;
import com.microservice.inventario.model.Stock;

public interface IStockService extends ICRUDService<Stock,Integer> {
    Stock findByProducto(Producto producto);
}
