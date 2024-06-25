package Sistema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Models.Autor;
import Models.Emprestimo;
import Models.Livro;
import Models.Usuario;
import Persistencia.BibliotecaPersistencia;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;
    private List<Autor> autores;
    private BibliotecaPersistencia<Livro> persistenciaLivro;
    private BibliotecaPersistencia<Usuario> persistenciaUsuario;
    private BibliotecaPersistencia<Emprestimo> persistenciaEmprestimo;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.persistenciaLivro = new BibliotecaPersistencia<>(new BibliotecaPersistencia.Converter<>() {
            @Override
            public String toString(Livro livro) {
                return livro.toString();
            }

            @Override
            public Livro fromString(String str) {
                return Livro.fromString(str);
            }
        });
        this.persistenciaUsuario = new BibliotecaPersistencia<>(new BibliotecaPersistencia.Converter<>() {
            @Override
            public String toString(Usuario usuario) {
                return usuario.toString();
            }

            @Override
            public Usuario fromString(String str) {
                return Usuario.fromString(str);
            }
        });
        this.persistenciaEmprestimo = new BibliotecaPersistencia<>(new BibliotecaPersistencia.Converter<>() {
            @Override
            public String toString(Emprestimo emprestimo) {
                return emprestimo.toString();
            }

            @Override
            public Emprestimo fromString(String str) {
                return Emprestimo.fromString(str);
            }
        });

    }

    // Métodos para gerenciar livros
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void removerLivro(Livro livro) {
        livros.remove(livro);
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    // Métodos para gerenciar usuários
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public Usuario buscarUsuarioPorNome(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                return usuario;
            }
        }
        return null;
    }

    // Métodos para gerenciar empréstimos
    public void realizarEmprestimo(Emprestimo emprestimo) throws LivroNaoDisponivelException {
        if (!emprestimo.getLivro().isDisponivel()) {
            throw new LivroNaoDisponivelException("Livro não está disponível para empréstimo");
        }
        emprestimo.getLivro().setDisponivel(false);
        emprestimos.add(emprestimo);

        // Adicionar empréstimo ao histórico do usuário
        emprestimo.getUsuario().adicionarEmprestimoAoHistorico(emprestimo);
    }

    public void devolverEmprestimo(Emprestimo emprestimo) {
        emprestimo.getLivro().setDisponivel(true);
        emprestimos.remove(emprestimo);
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    // Métodos para gerenciar autores
    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public void removerAutor(Autor autor) {
        autores.remove(autor);
    }

    public Autor buscarAutorPorNome(String nome) {
        for (Autor autor : autores) {
            if (autor.getNome().equalsIgnoreCase(nome)) {
                return autor;
            }
        }
        return null;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    // Métodos para salvar e carregar dados
    public void salvarDados() throws IOException {
        persistenciaLivro.salvar(livros, "livros.txt");
        persistenciaUsuario.salvar(usuarios, "usuarios.txt");
        persistenciaEmprestimo.salvar(emprestimos, "emprestimos.txt");
    }

    public void carregarDados() throws IOException {
        livros = persistenciaLivro.carregar("livros.txt");
        usuarios = persistenciaUsuario.carregar("usuarios.txt");
        emprestimos = persistenciaEmprestimo.carregar("emprestimos.txt");
    }
}
