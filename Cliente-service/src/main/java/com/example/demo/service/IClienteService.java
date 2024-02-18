package com.example.demo.service;

import com.example.demo.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface IClienteService {

    Cliente createCliente(Cliente cliente);

     Cliente updateCliente(Cliente cliente);

     Cliente deleteCliente(long cliente);

     Cliente getCliente(long id);

    void agregarCliente(Cliente obj);

    Double calcularTotal();

    String generarFactura();

    Cliente buscarCLiente(long id);



}