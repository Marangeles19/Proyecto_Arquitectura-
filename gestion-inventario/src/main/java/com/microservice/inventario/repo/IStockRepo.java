package com.microservice.inventario.repo;

import com.microservice.inventario.model.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockRepo extends IGenericRepo<Producto, Integer> {
}
