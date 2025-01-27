package com.espe.micro_clientes.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.espe.micro_clientes.model.entity.Cliente;
import com.espe.micro_clientes.services.ClienteService;

@RestController
@RequestMapping("/api/clientes") // Cambia la ruta
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Cliente cliente) {
        return ResponseEntity.status(201).body(service.save(cliente));
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = service.findById(id);
        if (clienteOptional.isPresent()) {
            return ResponseEntity.ok().body(clienteOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteOptional = service.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente clienteDB = clienteOptional.get();
            clienteDB.setNombre(cliente.getNombre());
            clienteDB.setEmail(cliente.getEmail());
            clienteDB.setDireccion(cliente.getDireccion());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clienteDB));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = service.findById(id);
        if (clienteOptional.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}