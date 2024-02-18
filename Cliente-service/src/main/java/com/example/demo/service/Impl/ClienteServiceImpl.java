package com.example.demo.service.Impl;

import com.example.demo.model.Cliente;
import com.example.demo.repo.IClienteRepository;
import com.example.demo.service.IClienteService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public abstract class ClienteServiceImpl implements IClienteService {

    private final IClienteRepository clienteRepository;

    public ClienteServiceImpl(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void agregarCliente(Cliente obj) {
        clienteRepository.save(obj);
    }

    @Override
    public Cliente getCliente(long id){
        Optional<Cliente> clienteOptional = clienteRepository.findById((int)id);
        if(clienteOptional.isPresent()){
            return clienteOptional.get();
        }else {
            throw new RuntimeException("Cliente no encotrado con el ID: " + id);
        }
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {

        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente deleteCliente(long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById((int)id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            clienteRepository.deleteById((int)id);
            return cliente;
        } else {
            throw new RuntimeException("Cliente no encontrado con Id " + id);
        }
    }

    @Override
    public Cliente  buscarCLiente(long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById((int)id);
        if (clienteOptional.isPresent()) {
            return clienteOptional.get();
        } else {
            throw new RuntimeException("Cliente no econtrado con Id " + id);
        }
    }
}
