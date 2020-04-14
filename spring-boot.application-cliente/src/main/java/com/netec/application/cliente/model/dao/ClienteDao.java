package com.netec.application.cliente.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.netec.application.cliente.model.entity.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long>{

	
}
