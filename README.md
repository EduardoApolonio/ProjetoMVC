# ProjetoMVC

Sistema de biblioteca simples, feito com Spring Boot seguindo o padrão MVC.

## Tecnologias

- Java 21
- Spring Boot 4.1.2
- Spring Web MVC
- Thymeleaf
- Maven

## Estrutura

```
src/main
├── java/com/example/ProjMVC
│   ├── Controller   # LivroController: recebe as requisições
│   ├── Model        # Livro: título, autor e ISBN
│   └── ProjMvcApplication.java
└── resources/templates/livros
    ├── inicio.html  # página inicial
    └── lista.html   # listagem de livros
```

## Como executar

Pré-requisito: JDK 21 instalado.

```bash
./mvnw spring-boot:run
```

No Windows (CMD/PowerShell), use `mvnw.cmd spring-boot:run`.

A aplicação sobe em http://localhost:8080.

## Rotas

| Rota            | Descrição                |
|-----------------|--------------------------|
| `/livros`       | Página inicial           |
| `/livros/lista` | Lista de livros cadastrados |

## Autor

Eduardo Apolonio
