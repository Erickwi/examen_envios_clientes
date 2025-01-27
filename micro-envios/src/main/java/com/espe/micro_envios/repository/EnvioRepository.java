package com.espe.micro_envios.repository;

import org.springframework.data.repository.CrudRepository;

import com.espe.micro_envios.model.entity.Envio;

import java.util.List;

// @Repository
public interface EnvioRepository extends CrudRepository<Envio, Long> {

}