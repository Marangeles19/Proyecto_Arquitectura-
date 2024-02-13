package com.microservice.inventario.controller;

import com.microservice.inventario.model.Stock;
import com.microservice.inventario.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {
    @Autowired
    private IStockService service;

    @GetMapping
    public ResponseEntity<List<Stock>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Stock obj){
        service.save(obj);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Stock> update(@RequestBody Stock obj){
        Stock response = service.findById(obj.getIdStock());
        if (response == null){
            throw new RuntimeException();
        }
        return new ResponseEntity<>(service.update(obj),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id){
        Stock obj = service.findById(id);
        if (obj == null) {
            throw new RuntimeException();
        } else{
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
























