package com.netec.application.usuario.model.service;

import java.util.List;

import com.netec.application.usuario.model.entity.Producto;
import com.netec.application.usuario.model.entity.Usuario;

public interface IUsuarioServicio {
    public List<Usuario> findAll();
    public Usuario findById(Long id);
    public List<Producto> listInvent(Long idCliente);
    public Usuario save(Usuario ur);
    public void deleteById(Long id);
}
