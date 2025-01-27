package com.espe.micro_envios.model.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "envios")
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String direccionEntrega;

    @Column(nullable = false)
    private Date fechaEnvio;

    @Column(nullable = false)
    private String estado;

    @OneToMany(mappedBy = "envio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnvioCliente> envioClientes;

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<EnvioCliente> getEnvioClientes() {
        return envioClientes;
    }

    public void setEnvioClientes(List<EnvioCliente> envioClientes) {
        this.envioClientes = envioClientes;
    }
}