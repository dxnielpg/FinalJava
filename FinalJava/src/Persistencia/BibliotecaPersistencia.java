package Persistencia;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaPersistencia<T> {

    private final Converter<T> converter;

    public BibliotecaPersistencia(Converter<T> converter) {
        this.converter = converter;
    }

    public void salvar(List<T> lista, String arquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (T item : lista) {
                writer.write(converter.toString(item));
                writer.newLine();
            }
        }
    }

    public List<T> carregar(String arquivo) throws IOException {
        List<T> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                lista.add(converter.fromString(linha));
            }
        }
        return lista;
    }

    public interface Converter<T> {
        String toString(T obj);
        T fromString(String str);
    }
}
