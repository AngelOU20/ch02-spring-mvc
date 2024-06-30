package edu.cibertec.capitulo02mvc.service;

import edu.cibertec.capitulo02mvc.dao.UsuarioDAO;
import edu.cibertec.capitulo02mvc.model.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public UsuarioDTO validarLogin(UsuarioDTO usuario) {
        return usuarioDAO.validarLogin(usuario);
    }

    @Override
    public void insertarUsuario(UsuarioDTO usuario) {
        usuarioDAO.insertarUsuario(usuario);
    }

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioDAO.listarUsuarios();
    }
}
