package com.netec.application.pedido;
//Esta clase nos va a ayudar a inyectar el rest templete
//dentro de nuestras clases

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfigRest {
	
    @Bean
	public RestTemplate registrarRestTemplete() {
		return  new RestTemplate();
	} 
}
