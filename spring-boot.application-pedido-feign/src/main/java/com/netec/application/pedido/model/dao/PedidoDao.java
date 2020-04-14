package com.netec.application.pedido.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.netec.application.pedido.model.entity.Pedido;

public interface PedidoDao extends CrudRepository<Pedido, Long>{
    
}
