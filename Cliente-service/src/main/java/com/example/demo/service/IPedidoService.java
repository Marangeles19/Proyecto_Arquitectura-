package com.example.demo.service;

import com.example.demo.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface IPedidoService {
    List<Pedido> obtenerTodosPedidos();
    Optional<Pedido> obtenerPedidoPorId(Integer id);
    Pedido crearPedido(Pedido pedido);
    Optional<Pedido> actualizarPedido(Integer id, Pedido pedido);
    void eliminarPedido(Integer id);
}