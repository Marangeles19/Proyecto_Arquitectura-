package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.IClienteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/clientes")

public class ClienteController {

    @Autowired
      private IClienteService clienteService;

    //-----------------------Agregar Cliente-------------------

    @PostMapping("/agregar")
    public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente obj) {
        clienteService.agregarCliente(obj);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //---------------------Buscar Cliente-----------

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable("id") long id) {
        return new ResponseEntity<>(clienteService.buscarCLiente(id), HttpStatus.OK);
    }


    // ------------------- Obtener Cliente----------------------------

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable("id") long id) {
        log.info("Fetching Customer with id {}", id);

       Cliente cliente = clienteService.getCliente(id);
        if (  null == cliente) {
            log.error("Client with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(cliente);
    }

    //--------------------- Crear Cliente------------------
    @PostMapping("/clientes")
    public ResponseEntity<Cliente> createCliente(@Validated @RequestBody Cliente cliente, BindingResult result){
        log.info("Creating cliente : {}", cliente);
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Cliente clienteDB = clienteService.createCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDB);
    }
//-----------------------------Update Cliente-------------------
@PutMapping(value = "/{id}")
public ResponseEntity<?> updateCliente(@PathVariable("id") long id, @RequestBody Cliente cliente) {
    log.info("Updating Customer with id {}", id);


    Cliente currentCliente = clienteService.getCliente(id);

    if ( null == currentCliente ) {
        log.error("Unable to update. Customer with id {} not found.", id);
        return  ResponseEntity.notFound().build();
    }
    cliente.setIdCliente((int) id);
    currentCliente = clienteService.updateCliente (cliente);
    return  ResponseEntity.ok(currentCliente);
}
//-------------------------------Delete Cliente------------------------------------
@DeleteMapping(value = "/{id}")
public ResponseEntity<Cliente> deleteCLiente(@PathVariable("id") long id) {
    log.info("Fetching & Deleting Cliente with id {}", id);

    Cliente cliente = clienteService.getCliente(id);
    if ( null == cliente ) {
        log.error("Unable to delete. Customer with id {} not found.", id);
        return  ResponseEntity.notFound().build();
    }

    cliente = clienteService.deleteCliente(cliente.getIdCliente());
    return  ResponseEntity.ok(cliente);
}

    @GetMapping("/calcularTotal")
    public ResponseEntity<Double> calcularTotal(){
        double total = clienteService.calcularTotal();
        return new ResponseEntity<>(clienteService.calcularTotal() , HttpStatus.OK);
    }

    @GetMapping("/generarFactura")
    public ResponseEntity<String> generarFactura() {
        String factura = clienteService.generarFactura();
        return new ResponseEntity<>(clienteService.generarFactura(), HttpStatus.OK);
    }
    private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String>  error =  new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
