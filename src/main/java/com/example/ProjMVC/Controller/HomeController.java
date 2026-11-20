package com.example.ProjMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final LivroController livroController;
    private final AutorController autorController;

    public HomeController(LivroController livroController,
                          AutorController autorController) {
        this.livroController = livroController;
        this.autorController = autorController;
    }

    @GetMapping({"/", "/inicio"})
    public String inicio(Model model) {
        model.addAttribute("livros", livroController.getLivros());
        model.addAttribute("autores", autorController.getAutores());
        return "livros/inicio";
    }
}