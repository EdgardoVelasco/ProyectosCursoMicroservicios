package com.netec.application.pedido.model.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netec.application.pedido.model.clients.IClienteFeign;
import com.netec.application.pedido.model.dao.PedidoDao;
import com.netec.application.pedido.model.entity.Cliente;
import com.netec.application.pedido.model.entity.Pedido;

@Service
public class ServicioPedidoImpl implements IServicePedido{
	@Autowired
    private PedidoDao daoPedido;
	
	@Autowired
	private IClienteFeign clienteF;
	
	private static Logger log=LoggerFactory.getLogger(ServicioPedidoImpl.class);
	
	@Override
	@Transactional(readOnly = true)
	public List<Pedido> findAll() {
		return (List<Pedido>)daoPedido.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Pedido findById(Long id) {
		return daoPedido.findById(id).orElse(new Pedido());
	}

	@Override
	public Pedido save(Long idCliente) {
		Cliente cl=clienteF.findById(idCliente);
		if(cl.getNombre()==null) {
			return new Pedido();
		}
		
		log.info("trabajando en puerto: "+cl.getPort());
		return daoPedido.save(new Pedido(cl.getId(), LocalDate.now()));
	}

	@Override
	public void deleteById(Long id) {
		daoPedido.deleteById(id);
		
	}

}
