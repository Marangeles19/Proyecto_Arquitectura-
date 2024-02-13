package com.microservice.ventafisica.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleRepo<T,ID> extends IGenericRepo<T,ID> {

}
