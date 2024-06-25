package Models;

public class Autor extends Pessoa {
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

    public static Autor fromString(String linha) {
        String[] partes = linha.split(";");
        if (partes.length == 3) {
            String nome = partes[0].trim();
            String email = partes[1].trim();
            String biografia = partes[2].trim();
            return new Autor(nome, email, biografia);
        } else {
            throw new IllegalArgumentException("String de entrada inválida para criar um Autor");
        }
    }
}
