package com.example.ProjMVC.Controller;

import com.example.ProjMVC.Model.Emprestimo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private List<Emprestimo> emprestimos = new ArrayList<>();
    private long proximoId = 1;

    private final LivroController livroController;
    private final UsuarioController usuarioController;

    public EmprestimoController(LivroController livroController, UsuarioController usuarioController) {
        this.livroController = livroController;
        this.usuarioController = usuarioController;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    @PostMapping
    public String cadastrar(@RequestParam int livroIndice,
                            @RequestParam int usuarioIndice,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataEmprestimo,
                            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataDevolucao) {
        var livros = livroController.getLivros();
        var usuarios = usuarioController.getUsuarios();

        if (livroIndice >= 0 && livroIndice < livros.size()
                && usuarioIndice >= 0 && usuarioIndice < usuarios.size()) {
            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setId(proximoId++);
            emprestimo.setLivro(livros.get(livroIndice));
            emprestimo.setUsuario(usuarios.get(usuarioIndice));
            emprestimo.setDataEmprestimo(dataEmprestimo);
            emprestimo.setDataDevolucao(dataDevolucao);
            emprestimos.add(emprestimo);
        }
        return "redirect:/inicio";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < emprestimos.size()) {
            emprestimos.remove(indice);
        }
        return "redirect:/inicio";
    }
}