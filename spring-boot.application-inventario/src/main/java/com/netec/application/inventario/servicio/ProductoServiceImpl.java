package com.netec.application.inventario.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netec.application.inventario.model.dao.ProductoDao;
import com.netec.application.inventario.model.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoServicio {
	@Autowired
	private ProductoDao productoDao;

	@Override
	public List<Producto> findAll() {
		return (List<Producto>)productoDao.findAll();
	}

	@Override
	public Producto findById(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findById(id).orElse(new Producto());
	}

	@Override
	public List<Producto> findByType(String tipo) {
		
		return productoDao.findByType(tipo);
	}

	@Override
	public Producto save(Producto pr) {
		
		return productoDao.save(pr);
	}

	@Override
	public void delete(Long id) {
		productoDao.deleteById(id);
		
	}

}
