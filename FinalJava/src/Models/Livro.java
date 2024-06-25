package Models;

public class Livro {
    private String titulo;
    private Autor autor;
    private Categoria categoria;
    private boolean disponivel;

    public Livro(String titulo, Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.disponivel = true; // De início fica disponível.
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor=" + autor.getNome() +
                ", categoria=" + categoria +
                ", disponivel=" + disponivel +
                '}';
    }

    public static Livro fromString(String linha) {
        String[] partes = linha.split(",");
        if (partes.length == 3) {
            String titulo = partes[0].trim();
            Autor autor = Autor.fromString(partes[1]);
            Categoria categoria = Categoria.fromString(partes[2]);
            return new Livro(titulo, autor, categoria);
        } else {
            throw new IllegalArgumentException("String de entrada inválida para criar um Livro");
        }
    }
}
