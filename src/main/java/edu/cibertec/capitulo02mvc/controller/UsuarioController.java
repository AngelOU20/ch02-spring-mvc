package edu.cibertec.capitulo02mvc.controller;

import edu.cibertec.capitulo02mvc.dao.UsuarioDAO;
import edu.cibertec.capitulo02mvc.model.UsuarioDTO;
import edu.cibertec.capitulo02mvc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("loginMostrar")
    public String loginMostrar() {
        return "login";
    }

    @RequestMapping("loginAccion")
    public ModelAndView loginAccion(UsuarioDTO usuarioValida) {
        ModelAndView mv = null;

        UsuarioDTO ue = usuarioService.validarLogin(usuarioValida);

        if (ue == null) {
            mv = new ModelAndView("login", "msgError", "Usuario y clave no existen. Vuelva a intentar!");
        } else {
            mv = new ModelAndView("usuarioLista", "lista",
                    usuarioService.listarUsuarios());
        }
        return mv;
    }

    @RequestMapping("listaUsuarios")
    public ModelAndView listaUsuarios(UsuarioDTO usuario) {
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        return new ModelAndView("usuarioLista", "lista", usuarios);
    }

    @RequestMapping("usuarioCrear")
    public ModelAndView crearUsuario() {
        return new ModelAndView("usuarioDatos", "usuarioBean",
                new UsuarioDTO());
    }

    @RequestMapping("usuarioGrabar")
    public ModelAndView grabarUsuario(
            @Valid @ModelAttribute("usuarioBean") UsuarioDTO usuario,
            BindingResult resulta) {

        ModelAndView mv = null;

        if (resulta.hasErrors()) {
            mv = new ModelAndView("usuarioDatos", "usuarioBean", usuario);
        } else {
            usuarioService.insertarUsuario(usuario);
            mv = new ModelAndView("usuarioLista", "lista",
                    usuarioService.listarUsuarios());
        }

        return mv;
    }
}
