package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Pedido;

public interface IProgramaFidelizacionService {

    void registarPedido(Pedido pedido);

    void otorgarPuntos(Cliente cliente);
}
