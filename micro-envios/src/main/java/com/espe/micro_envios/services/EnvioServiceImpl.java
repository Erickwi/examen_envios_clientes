package com.espe.micro_envios.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.espe.micro_envios.model.entity.Cliente;
import com.espe.micro_envios.model.entity.EnvioCliente;
import com.espe.micro_envios.repository.EnvioClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.espe.micro_envios.model.entity.Envio;
import com.espe.micro_envios.repository.EnvioRepository;
import com.espe.micro_envios.clients.ClienteClientRest;

@Service
public class EnvioServiceImpl implements EnvioService {

    @Autowired
    private EnvioRepository repository;

    @Autowired
    private EnvioClienteRepository envioClienteRepository;

    @Autowired
    private ClienteClientRest clienteClientRest;

    @Override
    public List<Envio> findAll() {
        return (List<Envio>) repository.findAll();
    }

    @Override
    public Envio save(Envio envio) {
        envio.setFechaEnvio(new Date());
        return repository.save(envio);
    }

    @Override
    public Optional<Envio> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Cliente> addClienteToEnvio(Long envioId, Long clienteId) {
        Optional<Envio> envioOptional = repository.findById(envioId);
        if (envioOptional.isPresent()) {
            Cliente cliente = clienteClientRest.getClienteById(clienteId);
            if (cliente != null) {
                EnvioCliente envioCliente = new EnvioCliente();
                envioCliente.setEnvio(envioOptional.get());
                envioCliente.setClienteId(cliente.getId());
                envioClienteRepository.save(envioCliente);
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }

    @Override
    public Cliente getClienteById(Long clienteId) {
        return clienteClientRest.getClienteById(clienteId);
    }
}