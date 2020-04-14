package com.netec.application.inventario.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.netec.application.inventario.model.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{
	@Query("SELECT u FROM Producto u WHERE u.tipo=:tipo")
	public List<Producto> findByType(@Param("tipo")String tipo);

}
