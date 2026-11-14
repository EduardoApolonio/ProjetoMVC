package com.example.ProjMVC.Controller;
import com.example.ProjMVC.Model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/livros")
public class LivroController {
    @GetMapping
    public String inicio() {

        return "livros/inicio";
    }
    @GetMapping("/lista")
    public String exibirLivro(Model model)
    {
        Livro livro = new Livro();
        livro.setTitulo("Dom casmurro");
        livro.setAutor("Machado de Assis");
        livro.setIsbn("978-85-00-00000-0");

        model.addAttribute("livro", livro);
        return "livros/lista";
    }
}