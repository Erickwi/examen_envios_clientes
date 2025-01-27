package com.espe.micro_clientes.services;

import java.util.List;
import java.util.Optional;

import com.espe.micro_clientes.model.entity.Cliente;

public interface ClienteService {
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    Cliente save(Cliente estudiante);
    void deleteById(Long id);
}
