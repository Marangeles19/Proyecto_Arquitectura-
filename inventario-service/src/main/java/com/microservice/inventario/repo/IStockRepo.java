package com.microservice.inventario.repo;

import com.microservice.inventario.model.Producto;
import com.microservice.inventario.model.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockRepo extends IGenericRepo<Stock, Integer> {
    @Query("SELECT s FROM Stock s WHERE s.producto = :producto")
    Stock findByProducto(Producto producto);
}
