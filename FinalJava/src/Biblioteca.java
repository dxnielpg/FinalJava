import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;
    private Persistencia<Livro> persistenciaLivro;
    private Persistencia<Usuario> persistenciaUsuario;
    private Persistencia<Emprestimo> persistenciaEmprestimo;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.persistenciaLivro = new PersistenciaArquivo<>();
        this.persistenciaUsuario = new PersistenciaArquivo<>();
        this.persistenciaEmprestimo = new PersistenciaArquivo<>();
    }

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

    public void realizarEmprestimo(Emprestimo emprestimo) throws Exception {
        if (!emprestimo.getLivro().isDisponivel()) {
            throw new Exception("Livro não está disponível para empréstimo");
        }
        emprestimo.getLivro().setDisponivel(false);
        emprestimos.add(emprestimo);
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
