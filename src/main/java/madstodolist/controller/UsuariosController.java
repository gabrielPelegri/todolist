package madstodolist.controller;

import madstodolist.model.Usuario;
import madstodolist.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UsuariosController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/registrados")
    public String getUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "listaUsuarios";
    }

    @RequestMapping("/registrados/{id}")
    public String getUsuarios(Model model, @PathVariable(value = "id") Long id){
       Usuario usuario= usuarioService.findById(id);
       model.addAttribute("usuario",usuario);
       return "descripcionUsuario";
    }
}
