import java.io.IOException;
import java.util.List;

public interface Persistencia<T> {
    void salvar(List<T> lista, String arquivo) throws IOException;
    List<T> carregar(String arquivo) throws IOException, ClassNotFoundException;
}