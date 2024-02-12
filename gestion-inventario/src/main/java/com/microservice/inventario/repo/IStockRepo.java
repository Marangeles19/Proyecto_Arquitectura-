package com.microservice.inventario.repo;

import com.microservice.inventario.model.Stock;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockRepo extends IGenericRepo<Stock, Integer> {
}
