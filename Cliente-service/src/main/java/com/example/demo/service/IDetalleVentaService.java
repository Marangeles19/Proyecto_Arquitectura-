package com.example.demo.service;

import com.example.demo.model.Cliente;

public interface IDetalleVentaService {

    double calcularDescuento();

    double calcualarTotal();

    Cliente buscarCliente();

    String generarFactura();
}
