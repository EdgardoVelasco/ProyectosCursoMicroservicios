package com.netec.application.pedido.model.service;

import java.util.List;

import com.netec.application.pedido.model.entity.Pedido;

public interface IServicePedido {
	
	public List<Pedido> findAll();
	public Pedido findById(Long id);
	public Pedido save(Long idCliente);
	public void deleteById(Long id);

}
