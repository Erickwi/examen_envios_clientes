package com.espe.micro_envios.repository;

import com.espe.micro_envios.model.entity.EnvioCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvioClienteRepository extends JpaRepository<EnvioCliente, Long> {
}