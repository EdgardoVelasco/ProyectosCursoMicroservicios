package com.netec.application.pedido.model.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.netec.application.pedido.model.entity.Cliente;



//@FeignClient(name="service-cliente", url="http://localhost:8001")

@FeignClient(name="service-cliente")// Se quita el url siempre y cuando tengamos Ribbon configurado
public interface IClienteFeign {
	
	@GetMapping("/cliente/{id}")
	public Cliente findById(@PathVariable Long id);
	
}
