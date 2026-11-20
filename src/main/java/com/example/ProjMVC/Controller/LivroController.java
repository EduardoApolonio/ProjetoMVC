package com.example.ProjMVC.Controller;

import com.example.ProjMVC.Model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")

public class LivroController {

    private List<Livro> livros = new ArrayList<>();

    public List<Livro> getLivros() {
        return livros;
    }

    @GetMapping
    public String listar() {
        return "redirect:/inicio";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Livro livro) {
        livros.add(livro);
        return "redirect:/inicio";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < livros.size()) {
            livros.remove(indice);
        }
        return "redirect:/inicio";
    }
}