package com.netec.application.usuario.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netec.application.usuario.model.cliente.ProductoFeign;
import com.netec.application.usuario.model.dao.UsuarioDao;
import com.netec.application.usuario.model.entity.Producto;
import com.netec.application.usuario.model.entity.Usuario;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio{
	@Autowired
	private UsuarioDao dao;
	@Autowired
	private ProductoFeign feign;

	@Override
	public List<Usuario> findAll() {
		
		return (List<Usuario>)dao.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<Producto> listInvent(Long idCliente) {
		Usuario usr=this.findById(idCliente);
		if(usr==null) {
			return new ArrayList<Producto>();
		}
		
		return feign.findAll();
	}

	@Override
	public Usuario save(Usuario ur) {
		
		return dao.save(ur);
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
		
	}

}
