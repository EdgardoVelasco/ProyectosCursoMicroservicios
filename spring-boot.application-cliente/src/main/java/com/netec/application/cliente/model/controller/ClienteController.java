package com.netec.application.cliente.model.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netec.application.cliente.model.entity.Cliente;
import com.netec.application.cliente.model.service.IServiceCliente;

//Maperamos los métodos del ServicioCliente a métodos de http
//GET, POST, PUT, DELETE

@RestController //Convierte el retorno de todos los métodos handler
//a json
public class ClienteController {
	
	@Autowired //Crear objeto de la implementación del servicio 
	private IServiceCliente cliente;
	
	@Value("${server.port}")
	private Integer port;
	
	//Get, Post, put, delete
	@GetMapping("/clientes") //http://localhost:port/clientes
	public List<Cliente> findAll(){
		//Stream convierte en un flujo de datos una colección
		//La iteración es secuencial
		//iniciales , intermedias , finales
		//  1            n            1
		return cliente.findAll().stream().peek(t->t.setPort(port)).collect(Collectors.toList()); //List<Cliente>->Json
	}
	
	@GetMapping("/cliente/{id}")
	public Cliente findById(@PathVariable Long id) {
		Cliente cl=cliente.findById(id);
		cl.setPort(port);
		return cl;
	}
	
	@PostMapping("/cliente-n")
	public Cliente save(@RequestBody Cliente cli) {
		return cliente.save(cli);
	}
	

	@DeleteMapping("/cliente-r/{id}")
	public String deleteById(@PathVariable Long id) {
		String mensaje="";
		try {
			cliente.deleteById(id);
			mensaje="borrado";
		}catch(Exception e) {
			mensaje="no existe";
		}
		return mensaje;
	}

}
