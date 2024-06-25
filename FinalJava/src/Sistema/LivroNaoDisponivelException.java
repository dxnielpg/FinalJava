package Sistema;
public class LivroNaoDisponivelException extends Exception {
    public LivroNaoDisponivelException(String mensagem) {
        super(mensagem);
    }
}
