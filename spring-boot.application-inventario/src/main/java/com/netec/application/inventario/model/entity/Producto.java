package com.netec.application.inventario.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Productos")
public class Producto implements Serializable{
  
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nombre;
   @Column(name = "fecha_cad")
   private LocalDate fechaCaducidad;
   private String tipo;
   @Transient
   private Integer port;
   
    public Producto() {}
  	public Producto(String nombre, LocalDate fechaCaducidad, String tipo) {
	super();
	this.nombre = nombre;
	this.fechaCaducidad = fechaCaducidad;
	this.tipo = tipo;
}


	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public LocalDate getFechaCaducidad() {
	return fechaCaducidad;
}


public void setFechaCaducidad(LocalDate fechaCaducidad) {
	this.fechaCaducidad = fechaCaducidad;
}


public String getTipo() {
	return tipo;
}


public void setTipo(String tipo) {
	this.tipo = tipo;
}

	private static final long serialVersionUID = -4747089905723643381L;

}
