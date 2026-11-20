package com.example.ProjMVC.Controller;

import com.example.ProjMVC.Model.Categoria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private List<Categoria> categorias = new ArrayList<>();
    private int proximoId = 1;

    public List<Categoria> getCategorias() {
        return categorias;
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Categoria categoria) {
        categoria.setId(proximoId++);
        categorias.add(categoria);
        return "redirect:/inicio";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < categorias.size()) {
            categorias.remove(indice);
        }
        return "redirect:/inicio";
    }
}