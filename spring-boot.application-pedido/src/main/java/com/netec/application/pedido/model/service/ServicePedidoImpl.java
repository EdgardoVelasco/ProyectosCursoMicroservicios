package com.netec.application.pedido.model.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.netec.application.pedido.model.dao.PedidoDao;
import com.netec.application.pedido.model.entity.Cliente;
import com.netec.application.pedido.model.entity.Pedido;

@Service
public class ServicePedidoImpl implements IServicePedido{
	@Autowired
    private PedidoDao daoPedido;
	@Autowired
	private RestTemplate restTemplete;
	
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
		Map<String, String> valores= new HashMap<String, String>();
		valores.put("id", idCliente.toString());
		
		String  url="http://localhost:8001/cliente/{id}";
		Cliente c=restTemplete.getForObject(url,Cliente.class, valores);
		if(c.getNombre()==null||c.getNombre().isEmpty()) {
		   return new Pedido();	
		}
		
		return daoPedido.save(new Pedido(c.getId(), LocalDate.now()));
	}

	@Override
	public void deleteById(Long id) {
	    daoPedido.deleteById(id);	
	}
	

}
