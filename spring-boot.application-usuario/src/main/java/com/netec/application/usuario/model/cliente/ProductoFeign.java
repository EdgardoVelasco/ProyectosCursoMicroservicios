package com.netec.application.usuario.model.cliente;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.netec.application.usuario.model.entity.Producto;

//@FeignClient(name = "servicio-inventario", url="http://localhost:8007")
@FeignClient(name = "servicio-inventario")
public interface ProductoFeign {
	@GetMapping("/productos")
    public List<Producto> findAll();
}
