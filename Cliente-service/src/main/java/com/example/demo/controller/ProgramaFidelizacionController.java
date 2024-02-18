package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.model.Pedido;
import com.example.demo.service.IProgramaFidelizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ProgarmaFidelizacion")
public class ProgramaFidelizacionController {

    @Autowired
    private IProgramaFidelizacionService fidelizacionService;

    @PostMapping("/registarPedido")
    public ResponseEntity<Void> registarPedido(@RequestBody Pedido pedido){
        fidelizacionService.registarPedido(pedido);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/otorgarPuntosFidelidad")
    public ResponseEntity<Void>otorgarPuntos(@RequestBody Cliente cliente){
        fidelizacionService.otorgarPuntos(cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
