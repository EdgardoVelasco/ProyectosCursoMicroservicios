package com.netec.application.usuario.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netec.application.usuario.model.entity.Producto;
import com.netec.application.usuario.model.entity.Usuario;
import com.netec.application.usuario.model.service.IUsuarioServicio;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class UsuarioController {
	@Autowired
	private IUsuarioServicio servicio;
	
	@GetMapping("/usuarios")
	public List<Usuario> findAll(){
		return servicio.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario findById(@PathVariable Long id) {
		return servicio.findById(id);
	}
	
	@GetMapping("/productos/{idCliente}")
	public List<Producto> listProductos(@PathVariable Long idCliente){
		return servicio.listInvent(idCliente);
	}
	
	@PostMapping("/usuario-n")
	public Usuario save(@RequestBody Usuario usr ) {
		return  servicio.save(usr);
	}
	
	@HystrixCommand(fallbackMethod = "deleteAlternativo")
	@DeleteMapping("/usuario-r/{id}")
	public String delete(@PathVariable Long id) {
			servicio.deleteById(id);
	   return "eliminado";
	
	}
	
	public String deleteAlternativo(Long id) {
		return "no existe usuario";
	}

}
