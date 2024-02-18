package com.example.demo.service.Impl;

import com.example.demo.model.Pedido;
import com.example.demo.repo.IPedidoRepository;
import com.example.demo.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private IPedidoRepository pedidoRepository;

    @Override
    public List<Pedido> obtenerTodosPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> obtenerPedidoPorId(Integer id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Optional<Pedido> actualizarPedido(Integer id, Pedido pedido) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
        if (optionalPedido.isPresent()) {
            pedido.setIdPedido(id); // Asegurar que el ID coincida
            Pedido pedidoActualizado = pedidoRepository.save(pedido);
            return Optional.of(pedidoActualizado);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void eliminarPedido(Integer id) {
        pedidoRepository.deleteById(id);
    }
}
