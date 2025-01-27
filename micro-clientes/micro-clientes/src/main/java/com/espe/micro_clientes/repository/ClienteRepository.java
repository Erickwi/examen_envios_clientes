package com.espe.micro_clientes.repository;


import org.springframework.data.repository.CrudRepository;

import com.espe.micro_clientes.model.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}

