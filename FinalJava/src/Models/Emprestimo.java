package Models;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private int id;
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(int id, Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.id = id;
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "Empréstimo ID: " + id + ", Livro: " + livro.getTitulo() + ", Usuário: " + usuario.getNome() +
               ", Data de Empréstimo: " + dataEmprestimo + ", Data de Devolução: " + dataDevolucao;
    }
    
    //Método para converter as informações da entidade para o txt
    public static Emprestimo fromString(String linha) {
        String[] partes = linha.split(";");
        if (partes.length == 5) {
            int id = Integer.parseInt(partes[0]);
            Usuario usuario = Usuario.fromString(partes[1]);
            Livro livro = Livro.fromString(partes[2]);
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            LocalDate dataEmprestimo = LocalDate.parse(partes[3], formatter);
            LocalDate dataDevolucao = LocalDate.parse(partes[4], formatter);
            return new Emprestimo(id, usuario, livro, dataEmprestimo, dataDevolucao);
        } else {
            throw new IllegalArgumentException("String de entrada inválida para criar um Emprestimo");
        }
    }
        
}