package com.espe.micro_envios.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.espe.micro_envios.model.entity.Envio;
import com.espe.micro_envios.services.EnvioService;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    @Autowired
    private EnvioService service;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Envio envio) {
        return ResponseEntity.status(201).body(service.save(envio));
    }

    @GetMapping
    public List<Envio> listar() {
        return service.findAll();
    }

    @GetMapping("/cliente/{clienteId}")
    public Optional<Envio> listarPorCliente(@PathVariable Long clienteId) {
        return service.findById(clienteId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}