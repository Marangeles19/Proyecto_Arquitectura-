package com.example.demo.controller;

import com.example.demo.service.IFacturaVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factutaVenta")
public class FacturaVentaController {

    @Autowired
    private IFacturaVentaService ventaService;

    @GetMapping("/calcularTotal")
    public ResponseEntity<Double> calcularTotal() {
        double total = ventaService.calcularTotal();
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

    @GetMapping("/calcularSubtotalVenta")
    public ResponseEntity<Double> calcularSubtotalVenta() {
        double subtotalVenta = ventaService.calcularSubtotalVenta();
        return new ResponseEntity<>(subtotalVenta, HttpStatus.OK);
    }

    @GetMapping("/calcularIVA")
    public ResponseEntity<Double> calcularIVA() {
        double iva = ventaService.calcularIVA();
        return new ResponseEntity<>(iva, HttpStatus.OK);
    }

    @GetMapping("/calcularDescuento")
    public ResponseEntity<Double> calcularDescuento() {
        double descuento = ventaService.calcularDescuento();
        return new ResponseEntity<>(descuento, HttpStatus.OK);
    }
}
