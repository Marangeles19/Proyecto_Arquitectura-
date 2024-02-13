package com.microservice.ventafisica.service.impl;

import com.microservice.ventafisica.model.DetalleVenta;
import com.microservice.ventafisica.repo.IDetalleRepo;
import com.microservice.ventafisica.repo.IGenericRepo;
import com.microservice.ventafisica.service.IDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleServiceImpl extends CRUDImpl<DetalleVenta, Integer> implements IDetalleService {
    @Autowired
    private IDetalleRepo repo;

    @Override
    protected IGenericRepo<DetalleVenta, Integer> getGenericRepo() {
        return repo;
    }
}
