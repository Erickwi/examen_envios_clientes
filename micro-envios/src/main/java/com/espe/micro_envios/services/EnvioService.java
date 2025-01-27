package com.espe.micro_envios.services;

import java.util.List;
import java.util.Optional;

import com.espe.micro_envios.model.entity.Envio;
import com.espe.micro_envios.model.entity.Cliente;

public interface EnvioService {
	List<Envio> findAll();
	Envio save(Envio envio);
	Optional<Envio> findById(Long clienteId);
	void deleteById(Long id);
	Optional<Cliente> addClienteToEnvio(Long cursoId, Long estudianteId);
	Cliente getClienteById(Long estudianteId);
}