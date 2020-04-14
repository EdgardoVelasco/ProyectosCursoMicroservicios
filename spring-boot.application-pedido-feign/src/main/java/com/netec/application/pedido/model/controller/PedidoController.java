package com.netec.application.pedido.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netec.application.pedido.model.entity.Pedido;
import com.netec.application.pedido.model.service.IServicePedido;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class PedidoController {
	@Autowired
	private IServicePedido servicioPedido;
	
	@GetMapping("/pedidos")
	public List<Pedido> findAll(){
		return servicioPedido.findAll();
	}
	
	@GetMapping("/pedido/{id}")
	public Pedido findById(@PathVariable Long id) {
		return servicioPedido.findById(id);
	}
	
	@PostMapping("/pedido-n/{idCliente}")
	public Pedido save(@PathVariable Long idCliente) {
		return servicioPedido.save(idCliente);
	}
	
	//---Método deleteById antes de Hystrix---//
	/*@DeleteMapping("/pedido-r/{id}")
	public String deleteById(@PathVariable Long id) {
		String mensaje="";
		try {
		     servicioPedido.deleteById(id);
		     mensaje="eliminado";
		}catch(EmptyResultDataAccessException e) {
			mensaje="no existe";
		}
		return mensaje;
	}*/
	
	
	@HystrixCommand(fallbackMethod = "deleteAlternativo")
	@DeleteMapping("/pedido-r/{id}")
	public String deleteById(@PathVariable Long id) {
		     
		     try {
		    	 Thread.sleep(3000);
		    	 servicioPedido.deleteById(id);
		     }catch(Exception e) {
		    	 
		     }
		        
		return "se ha eliminado correctamente";
	}
	
	
	public String deleteAlternativo(Long id) {
		
		return "no existe el producto";
	}
	

}
