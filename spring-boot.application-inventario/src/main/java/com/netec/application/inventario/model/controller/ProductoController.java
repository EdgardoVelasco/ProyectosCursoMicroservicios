package com.netec.application.inventario.model.controller;

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

import com.netec.application.inventario.model.entity.Producto;
import com.netec.application.inventario.servicio.IProductoServicio;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ProductoController {
	@Autowired
	private IProductoServicio servicio;
	@Value("${server.port}")
	private Integer port;
	
	@GetMapping("/productos")
	public List<Producto> findAll(){
		return servicio.findAll().stream().peek(t->t.setPort(port))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/producto/{tipo}")
	public List<Producto> findByType(@PathVariable String tipo){
		return servicio.findByType(tipo);
	}
	
	@PostMapping("/producto-n")
	public Producto save(@RequestBody Producto producto) {
		return servicio.save(producto);
	}
	
	@HystrixCommand(fallbackMethod = "deleteAlternativo")
	@DeleteMapping("/producto-r/{id}")
	public String delete(Long id) {
			servicio.delete(id);
	return "eliminado";
		
	}
	public String deleteAlternativo(Long id) {
		return "no existe";
	}
	

}
