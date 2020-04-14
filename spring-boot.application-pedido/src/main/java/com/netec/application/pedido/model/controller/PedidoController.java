package com.netec.application.pedido.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netec.application.pedido.model.entity.Pedido;
import com.netec.application.pedido.model.service.IServicePedido;

@RestController
public class PedidoController {
	
  @Autowired	
  private IServicePedido servicePedido;
  
  @GetMapping("/pedidos")//http://localhost:8002/pedidos
  public List<Pedido> findAll(){
	  return servicePedido.findAll();
  }
  
  @GetMapping("/pedido/{id}")
  public Pedido findById(@PathVariable Long id) {
	  return servicePedido.findById(id);
  }
  
  @PostMapping("/pedido-n/{idCliente}")
  public Pedido save(@PathVariable Long idCliente) {
	  return servicePedido.save(idCliente);
  }
  
  @DeleteMapping("/pedido-r/{id}")
  public String deleteById(@PathVariable Long id) {
	  String mensaje="";
	  try {
		  servicePedido.deleteById(id);
		  mensaje="borrado";
	  }catch(Exception e) {
		  mensaje="no existe "+e;
	  }
	  return mensaje;
  }
	
	
}
