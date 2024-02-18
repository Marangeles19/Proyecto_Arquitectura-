package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.IDetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detalleVentas")
public class DetalleVentaContoller {

    @Autowired
    private IDetalleVentaService detalleVentaService;

    @GetMapping("/calcularDescuento")
    public ResponseEntity<Double> calcularDescuento(){
        double descuento = detalleVentaService.calcularDescuento();
        return new ResponseEntity<>(descuento , HttpStatus.OK);
    }

    @GetMapping("/calcularTotal")
    public ResponseEntity<Double> calcularTotal(){
        double total = detalleVentaService.calcualarTotal();
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

    @GetMapping("/buscarCliente")
    public ResponseEntity<Cliente> buscarCliente(){
        Cliente cliente = detalleVentaService.buscarCliente();
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PutMapping("/actualizarCliente")
    public ResponseEntity<Void> actializarCLiente(@RequestBody Cliente cliente){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/generarFactura")
    public ResponseEntity<String> generarFactura(){
        String factura = detalleVentaService.generarFactura();
        return new ResponseEntity<>(factura, HttpStatus.OK);
    }
}
