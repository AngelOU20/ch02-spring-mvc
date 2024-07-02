package edu.cibertec.capitulo02mvc.service;

import edu.cibertec.capitulo02mvc.model.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {
    UsuarioDTO validarLogin(UsuarioDTO usuario);
    void insertarUsuario(UsuarioDTO usuario);
    List<UsuarioDTO> listarUsuarios();
    void eliminarUsuario(UsuarioDTO usuario);
    UsuarioDTO obtenerUsuario(int id);
}
