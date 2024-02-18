package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.service.IProgramaFidelizOfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fidelizacioOferta")
public class ProgramaFidelizOfertaController {

    @Autowired
    private IProgramaFidelizOfertaService fidelizOfertaService;

    @PostMapping("/agregarProductoOferta")
    public ResponseEntity<Void> agrgarProducto(@RequestBody Producto producto){
        fidelizOfertaService.agregarProducto(producto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteProducto")
    public ResponseEntity<Void> deleteProducto(@RequestBody Producto producto){
        fidelizOfertaService.deleteProducto(producto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listarProducto")
    public ResponseEntity<List<Producto>>listarProducto(){
        List<Producto> productos = fidelizOfertaService.obtenerProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

}
