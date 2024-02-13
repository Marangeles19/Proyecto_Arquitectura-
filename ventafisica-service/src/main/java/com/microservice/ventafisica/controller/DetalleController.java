package com.microservice.ventafisica.controller;

import com.microservice.ventafisica.api.InventarioClient;
import com.microservice.ventafisica.model.DetalleVenta;
import com.microservice.ventafisica.model.dto.ProductoDTO;
import com.microservice.ventafisica.model.dto.StockDTO;
import com.microservice.ventafisica.service.IDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle")
public class DetalleController {
    @Autowired
    private IDetalleService service;

    @Autowired
    private InventarioClient inventarioClient;
    @GetMapping
    public ResponseEntity<List<DetalleVenta>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody DetalleVenta obj){
        service.save(obj);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DetalleVenta> update(@RequestBody DetalleVenta obj){
        DetalleVenta response = service.findById(obj.getIdDetalleVenta());
        if (response == null){
            throw new RuntimeException();
        }
        return new ResponseEntity<>(service.update(obj),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id){
        DetalleVenta obj = service.findById(id);
        if (obj == null) {
            throw new RuntimeException();
        } else{
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/buscarProducto/{nombre}")
    public ResponseEntity<?> findProducto(@PathVariable("nombre") String nombre){
        StockDTO stock = inventarioClient.getStock(nombre);
        return new ResponseEntity<>(stock,HttpStatus.OK);
    }

}
























