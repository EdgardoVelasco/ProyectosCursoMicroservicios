package com.netec.application.pedido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

//indica que nuestro proyecto va a buscar todos los clientes feign
@EnableFeignClients
//@RibbonClient(name="service-cliente") Sólo se comenta si estas utilizan Eureka
@EnableCircuitBreaker
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
