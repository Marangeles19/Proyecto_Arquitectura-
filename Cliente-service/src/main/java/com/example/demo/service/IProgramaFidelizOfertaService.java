package com.example.demo.service;

import com.example.demo.model.Producto;

import java.util.List;

public interface IProgramaFidelizOfertaService {

    void agregarProducto(Producto producto);

    void deleteProducto(Producto producto);

    List<Producto> obtenerProductos();
}
