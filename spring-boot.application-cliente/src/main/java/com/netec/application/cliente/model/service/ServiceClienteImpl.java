package com.netec.application.cliente.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netec.application.cliente.model.dao.ClienteDao;
import com.netec.application.cliente.model.entity.Cliente;

@Service //Spring lo registra cómo servicio
public class ServiceClienteImpl implements IServiceCliente {
	//Crear un objeto de la implementacion de interface
	//Cliente Dao 
	//utilizar el objeto creado dentro de esta clase
	
    @Autowired //inyecto la dependencia 	
	private ClienteDao clienteDao;
    

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>)clienteDao.findAll(); //Iterable<Cliente>
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(new Cliente());
	}

	@Override
	public Cliente save(Cliente cl) {
		return clienteDao.save(cl);
	}

	@Override
	public void deleteById(Long id) {
		clienteDao.deleteById(id);
	}

	
}
