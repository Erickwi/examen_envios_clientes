package com.espe.micro_envios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.espe.micro_envios.clients")
public class MicroEnviosApplication {

	public static void main(String[] args) {

		SpringApplication.run(MicroEnviosApplication.class,args);
	}

}