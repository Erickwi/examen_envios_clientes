package com.espe.micro_clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroClientesApplication.class, args);
	}

}
