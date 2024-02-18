package com.microservice.inventario.service.impl;

import com.microservice.inventario.client.DetallCompClient;
import com.microservice.inventario.dto.DetallDTO;
import com.microservice.inventario.http.response.DetallByProductResponse;
import com.microservice.inventario.model.Producto;
import com.microservice.inventario.repo.IGenericRepo;
import com.microservice.inventario.repo.IProductoRepo;
import com.microservice.inventario.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl extends CRUDImpl<Producto,Integer> implements IProductoService {
    @Autowired
    private IProductoRepo repo;

    private DetallCompClient detallClient;

    @Override
    protected IGenericRepo<Producto, Integer> getGenericRepo() {
        return repo;
    }

    @Override
    public Producto findProductoNombre(String nombre) {
        return repo.findByProductoNombre(nombre);
    }

    @Override
    public DetallByProductResponse findDetallByIdProduct(Integer id) {
        //Consultar el producto

        Producto product = repo.findById(id).orElse(new Producto());

        //Obtener el detalle

        List<DetallDTO> detallDTOList = detallClient.findAllProducts(id);

        return DetallByProductResponse.builder()
                .nombre(product.getNombre())
                .descripcion(product.getDescripcion())
                .precio(product.getPrecio())
                .categoria(product.getCategoria())
                .DetallDTOlist(detallDTOList)
                .build();
    }
}
