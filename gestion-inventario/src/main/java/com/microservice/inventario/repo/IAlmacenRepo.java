package com.microservice.inventario.repo;

import com.microservice.inventario.model.Almacen;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlmacenRepo extends IGenericRepo<Almacen, Integer> {
}
