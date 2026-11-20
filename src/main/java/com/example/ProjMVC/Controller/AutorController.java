package com.example.ProjMVC.Controller;

import com.example.ProjMVC.Model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/autores")
public class AutorController {

    private List<Autor> autores = new ArrayList<>();
    private long proximoId = 1;

    public List<Autor> getAutores() {
        return autores;
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Autor autor) {
        autor.setId(proximoId++);
        autores.add(autor);
        return "redirect:/inicio";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < autores.size()) {
            autores.remove(indice);
        }
        return "redirect:/inicio";
    }
}