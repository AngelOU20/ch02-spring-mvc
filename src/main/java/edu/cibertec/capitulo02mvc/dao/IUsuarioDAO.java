package edu.cibertec.capitulo02mvc.dao;

import edu.cibertec.capitulo02mvc.model.UsuarioDTO;

import java.util.List;

public interface IUsuarioDAO {
    void insertarUsuario(UsuarioDTO usuario);
    List<UsuarioDTO> listarUsuarios();
    UsuarioDTO validarLogin(UsuarioDTO usuario);
    void eliminarUsuario(UsuarioDTO usuario);
}
