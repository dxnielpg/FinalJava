public class Livro {
    private String titulo;
    private Autor autor;
    private Categoria categoria;
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public Livro(String titulo, Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }
    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + ", autor=" + autor + ", categoria=" + categoria + "]";
    }

    

    
}