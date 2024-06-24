import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;
    private BibliotecaPersistencia<Livro> persistenciaLivro;
    private BibliotecaPersistencia<Usuario> persistenciaUsuario;
    private BibliotecaPersistencia<Emprestimo> persistenciaEmprestimo;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.persistenciaLivro = new BibliotecaPersistencia<>();
        this.persistenciaUsuario = new BibliotecaPersistencia<>();
        this.persistenciaEmprestimo = new BibliotecaPersistencia<>();
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

    // Métodos para salvar e carregar dados
    public void salvarDados() throws IOException {
        persistenciaLivro.salvar(livros, "livros.dat");
        persistenciaUsuario.salvar(usuarios, "usuarios.dat");
        persistenciaEmprestimo.salvar(emprestimos, "emprestimos.dat");
    }

    public void carregarDados() throws IOException, ClassNotFoundException {
        livros = persistenciaLivro.carregar("livros.dat");
        usuarios = persistenciaUsuario.carregar("usuarios.dat");
        emprestimos = persistenciaEmprestimo.carregar("emprestimos.dat");
    }
}
