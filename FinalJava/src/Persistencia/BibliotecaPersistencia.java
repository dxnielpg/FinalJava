package Persistencia;
import java.io.*;
import java.util.List;

public class BibliotecaPersistencia<T> {

    // Interface Converter para lidar com a conversão de objetos para String e vice-versa
    private final Converter<T> converter;

    // Construtor que recebe um objeto Converter para operações de conversão
    public BibliotecaPersistencia(Converter<T> converter) {
        this.converter = converter;
    }

    // Método para salvar uma lista de objetos em um arquivo
    public void salvar(List<T> lista, String arquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            // Itera sobre a lista de objetos
            for (T item : lista) {
                // Converte cada objeto para String usando o método toString do Converter
                writer.write(converter.toString(item));
                writer.newLine(); // Escreve uma nova linha após cada objeto
            }
        }
    }

    // Interface para definir os métodos de conversão de/para String
    public interface Converter<T> {
        String toString(T obj); // Converte objeto para String
        T fromString(String linha); // Converte String para objeto
    }
}
