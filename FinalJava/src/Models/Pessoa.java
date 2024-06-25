package Models;

public abstract class Pessoa {
    private String nome;
    private String email;

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract String getDetalhes(); // Método abstrato

    public static Pessoa fromString(String linha) {
        String[] partes = linha.split(";");
        if (partes.length >= 3) {
            String tipoPessoa = partes[0].trim(); // Identifica se é "Usuario" ou "Autor")
            String nome = partes[1].trim();
            String email = partes[2].trim();
            // Dependendo do tipo de pessoa identificado, cria e retorna a instância adequada
            switch (tipoPessoa) {
                case "Usuario":
                    if (partes.length >= 4) {
                        String endereco = partes[3].trim();
                        return new Usuario(nome, email, endereco);
                    } else {
                        throw new IllegalArgumentException("String de entrada inválida para criar um Usuario");
                    }
                case "Autor":
                    if (partes.length >= 4) {
                        String biografia = partes[3].trim();
                        return new Autor(nome, email, biografia);
                    } else {
                        throw new IllegalArgumentException("String de entrada inválida para criar um Autor");
                    }
                default:
                    throw new IllegalArgumentException("Tipo de pessoa desconhecido: " + tipoPessoa);
            }
        } else {
            throw new IllegalArgumentException("String de entrada inválida para criar uma Pessoa");
        }
    }
}
