package com.netec.application.inventario.servicio;

import java.util.List;

import com.netec.application.inventario.model.entity.Producto;

public interface IProductoServicio {
	 public List<Producto> findAll();
	 public Producto findById(Long id);
	 public List<Producto> findByType(String tipo);
	 public Producto save(Producto pr);
	 public void delete(Long id);

}
