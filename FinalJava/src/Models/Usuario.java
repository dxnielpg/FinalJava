package Models;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Pessoa {
    private String endereco;
    private List<Emprestimo> historicoEmprestimos;

    public Usuario(String nome, String email, String endereco) {
        super(nome, email);
        this.endereco = endereco;
        this.historicoEmprestimos = new ArrayList<>();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Emprestimo> getHistoricoEmprestimos() {
        return historicoEmprestimos;
    }

    public void adicionarEmprestimoAoHistorico(Emprestimo emprestimo) {
        historicoEmprestimos.add(emprestimo);
    }

    public void exibirHistoricoEmprestimos() {
        if (historicoEmprestimos.isEmpty()) {
            System.out.println("Este usuário não possui histórico de empréstimos.");
        } else {
            System.out.println("Histórico de Empréstimos do Usuário:");
            for (Emprestimo emprestimo : historicoEmprestimos) {
                System.out.println(emprestimo);
            }
        }
    }

    @Override
    public String getDetalhes() {
        return "Usuario: \n" +
        "Nome: " + getNome() + 
        ", Email: " + getEmail() + 
        ", Endereço: " + endereco;
    }
    //Método FromString para converter string para a persistencia
    public static Usuario fromString(String linha) {
        String[] partes = linha.split(",");
        if (partes.length == 3) {
            String nome = partes[0].trim();
            String email = partes[1].trim();
            String endereco = partes[2].trim();
            return new Usuario(nome, email, endereco);
        } else {
            throw new IllegalArgumentException("String de entrada inválida para criar um Usuario");
        }
    }
}
