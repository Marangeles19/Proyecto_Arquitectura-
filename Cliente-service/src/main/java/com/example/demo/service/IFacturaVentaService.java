package com.example.demo.service;

public interface IFacturaVentaService {
    double calcularTotal();

    double calcularSubtotalVenta();

    double calcularIVA();

    double calcularDescuento();
}
