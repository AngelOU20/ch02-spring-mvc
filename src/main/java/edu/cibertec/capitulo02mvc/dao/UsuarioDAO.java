package edu.cibertec.capitulo02mvc.dao;

import edu.cibertec.capitulo02mvc.model.UsuarioDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioDAO implements IUsuarioDAO {

    private List<UsuarioDTO> usuarios;

    public UsuarioDAO() {
        usuarios = new ArrayList<>();
        usuarios.add(new UsuarioDTO("Juan", "qw3w5", "Juan Perez"));
        usuarios.add(new UsuarioDTO("Carmen", "1wqe45", "Carmen Perez"));
        usuarios.add(new UsuarioDTO("Jose", "123aw", "Jose Perez"));
        usuarios.add(new UsuarioDTO("Manuel", "1as45", "Manuel Perez"));
    }

    @Override
    public void insertarUsuario(UsuarioDTO usuario) {
        usuarios.add(usuario);
    }

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return usuarios;
    }

    @Override
    public UsuarioDTO validarLogin(UsuarioDTO usuario) {
        if(usuario.getUsuario().equalsIgnoreCase("user") &&
                usuario.getClave().equals("admin"))
            usuario.setNombreCompleto("Nombre completo del usuario");
        else
            usuario = null;

        return usuario;
    }
}
