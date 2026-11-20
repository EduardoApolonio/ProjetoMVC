package com.example.ProjMVC.Controller;

import com.example.ProjMVC.Model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();
    private long proximoId = 1;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Usuario usuario) {
        usuario.setId(proximoId++);
        usuarios.add(usuario);
        return "redirect:/inicio";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < usuarios.size()) {
            usuarios.remove(indice);
        }
        return "redirect:/inicio";
    }
}