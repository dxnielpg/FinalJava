public class Usuario extends Pessoa {
    private String endereco;

    public Usuario(String nome, String email, String endereco) {
        super(nome, email);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String getDetalhes() {
        return "Nome: " + getNome() + ", Email: " + getEmail() + ", Endereço: " + endereco;
    }
}