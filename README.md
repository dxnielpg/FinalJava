Biblioteca de Gerenciamento de Livros
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Informações Gerais sobre o Projeto

Este projeto é uma aplicação para o gerenciamento de uma biblioteca, permitindo a administração de livros, usuários, empréstimos e autores. O principal objetivo é criar uma plataforma que facilite o cadastro, consulta e gerenciamento de todas as entidades envolvidas em uma biblioteca.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Funcionalidades Principais

Cadastro e consulta de livros.
Registro e consulta de usuários.
Gerenciamento de empréstimos de livros.
Cadastro de autores e consulta de suas obras.
Persistência de dados em arquivos de texto.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Informações sobre as Classes e suas Relações

Biblioteca
Descrição: Classe principal que gerencia a coleção de livros, usuários, empréstimos e autores.
Relações:
Agregação de listas de Livro, Usuario, Emprestimo, e Autor.

Livro
Descrição: Representa um livro na biblioteca.
Relações:
Associação com Autor e Categoria.

Pessoa (abstrata)
Descrição: Classe abstrata base para Autor e Usuario.
Relações:
Herança de Autor e Usuario.

Autor
Descrição: Representa um autor de livros.
Relações:
Herda de Pessoa.

Usuario
Descrição: Representa um usuário da biblioteca.
Relações:
Herda de Pessoa.

Emprestimo
Descrição: Representa o empréstimo de um livro por um usuário.
Relações:
Associação com Usuario e Livro.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Relações entre Classes

Agregação: A classe Biblioteca agrega listas de Livro, Usuario, Emprestimo, e Autor.
Composição: A classe Emprestimo possui uma composição forte com Usuario e Livro, pois um empréstimo não faz sentido sem essas entidades.
Associação: Livro está associado a Autor e Categoria.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Uso do ChatGPT

O ChatGPT foi utilizado no desenvolvimento deste projeto para:
Consulta e Orientação: Obtenção de dicas e melhores práticas de desenvolvimento Java.
Geração de Conteúdo: Criação de documentação, incluindo este README, para garantir clareza e organização das informações.
Análise de Código: Revisão e validação de conceitos como herança, polimorfismo, agregação e composição no código.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Passos para Execução

Clone este repositório para sua máquina local:
git clone https://github.com/dxnielpg/FinalJava
Compile o código no App.java
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Referências e Recursos

ChatGPT da OpenAI para suporte e geração de conteúdo