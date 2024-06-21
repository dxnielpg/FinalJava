public class Autor extends Pessoa{

    private String biografia;

    public Autor(String nome, String email, String biografia) {
        super(nome, email);
        this.biografia = biografia;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    @Override
    public String getDetalhes() {
        return "Autor: " + getNome() + ", Email: " + getEmail() + ", Biografia: " + biografia;
    }
    
    

}
