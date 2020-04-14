package com.netec.application.usuario.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.netec.application.usuario.model.entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {

}
