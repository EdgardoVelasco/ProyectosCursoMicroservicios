package com.netec.application.cliente.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Clientes")
public class Cliente implements Serializable{	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;//Autogenerar PK
	private String nombre;
	private Integer edad;
	
	@Column(name = "apellido_p")
	private String apellidoP;
	
	@Column(name="apellido_m")
	private String apellidoM;
	private String direccion;
	
	@Column(name="correo_electronico")
	private String correoElectronico;
	private String rfc;
	@Transient
	private Integer port;
	
	public Cliente() {}
	public Cliente(String nombre, Integer edad, String apellidoP, String apellidoM, String direccion,
			String correoElectronico, String rfc) {
		this.nombre = nombre;
		this.edad = edad;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.direccion = direccion;
		this.correoElectronico = correoElectronico;
		this.rfc = rfc;
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
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getApellidoP() {
		return apellidoP;
	}
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	public String getApellidoM() {
		return apellidoM;
	}
	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	
	
	private static final long serialVersionUID = 524742896111306948L;
	
}
