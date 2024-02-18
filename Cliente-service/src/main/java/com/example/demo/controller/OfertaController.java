package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.service.IOfertasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Ofertas")
public class OfertaController {

    @Autowired
    private IOfertasService ofertasService;

    @PostMapping("/agregarCliente")
    public ResponseEntity<Void> agregraCliente(@RequestBody Producto producto){
        ofertasService.agregarCliente(producto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteProducto")
    public ResponseEntity<Void> deleteProducto(@RequestBody Producto producto){
        ofertasService.deleteProducto(producto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
