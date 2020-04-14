package com.netec.application.cliente.model.service;

import java.util.List;

import com.netec.application.cliente.model.entity.Cliente;

public interface IServiceCliente {
	
	public List<Cliente> findAll();
	public Cliente findById(Long id);
	public Cliente save(Cliente cl);
	public void deleteById(Long id);
	

}
