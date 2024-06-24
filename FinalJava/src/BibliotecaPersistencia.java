import java.io.*;
import java.util.List;

public class BibliotecaPersistencia<T> {
<<<<<<< feature/biblioteca

=======
>>>>>>> main
    public void salvar(List<T> lista, String arquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(lista);
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> carregar(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<T>) ois.readObject();
        }
    }
<<<<<<< feature/biblioteca
}
=======
}
>>>>>>> main
