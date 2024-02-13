package com.microservice.ventafisica.service.impl;

import com.microservice.ventafisica.api.InventarioClient;
import com.microservice.ventafisica.dto.StockDTO;
import com.microservice.ventafisica.http.response.ProductoByInventarioResponse;
import com.microservice.ventafisica.model.DetalleVenta;
import com.microservice.ventafisica.model.FacturaVenta;
import com.microservice.ventafisica.repo.IFacturaVentaRepo;
import com.microservice.ventafisica.repo.IGenericRepo;
import com.microservice.ventafisica.service.IFacturaVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaVentaServiceImpl extends CRUDImpl<FacturaVenta, Integer> implements IFacturaVentaService {
    @Autowired
    private IFacturaVentaRepo repo;

    @Autowired
    private InventarioClient inventarioClient;
    @Override
    protected IGenericRepo<FacturaVenta, Integer> getGenericRepo() {
        return repo;
    }

    @Override
    public ProductoByInventarioResponse PRODUCTO_BY_INVENTARIO_RESPONSE(String nombreProducto, String nombreAlmacen) {
        StockDTO stockDTO = inventarioClient.findByProductoAlmacen(nombreProducto,nombreAlmacen);

        return ProductoByInventarioResponse.builder()
                .nombreAlmacen(stockDTO.getAlmacen().getNombre())
                .nombreCategoria(stockDTO.getProducto().getCategoria().getNombre())
                .nombreProducto(stockDTO.getProducto().getNombre())
                .precio(stockDTO.getProducto().getPrecio())
                .cantidad(stockDTO.getCantidad())
                .build();
    }
}
