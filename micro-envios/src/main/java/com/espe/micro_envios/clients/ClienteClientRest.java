package com.espe.micro_envios.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.espe.micro_envios.model.entity.Cliente;

@FeignClient(name = "micro-clientes", url = "http://localhost:8083")
public interface ClienteClientRest {

    @GetMapping("/api/clientes/{id}")
    Cliente getClienteById(@PathVariable Long id);
}