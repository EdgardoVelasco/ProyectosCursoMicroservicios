package com.netec.application.pedido.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Pedido implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="id_cliente")
	private Long idCliente; //FK
	@Transient
	private List<String> articulos;
	@Column(name="fecha_pedido")
	private LocalDate fechaPedido; //"año-mes-día"
	
	public Pedido() {}
	
	public Pedido(Long idCliente, LocalDate fechaPedido) {
		this.idCliente = idCliente;
		this.fechaPedido = fechaPedido;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public List<String> getArticulos() {
		return articulos;
	}
	public void setArticulos(List<String> articulos) {
		this.articulos = articulos;
	}
	public LocalDate getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	
	private static final long serialVersionUID = 6717277715941438031L;	

}
