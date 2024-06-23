import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class GerenciadorBiblioteca {
    private Biblioteca biblioteca;
    private Scanner scanner;

    public GerenciadorBiblioteca() {
        biblioteca = new Biblioteca();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            exibirMenu();
            int opcao = Console.lerInt("Escolha uma opção:");

            switch (opcao) {
                case 1:
                    adicionarLivro();
                    break;
                case 2:
                    adicionarUsuario();
                    break;
                case 3:
                    realizarEmprestimo();
                    break;
                case 4:
                    devolverEmprestimo();
                    break;
                case 5:
                    listarLivros();
                    break;
                case 6:
                    listarUsuarios();
                    break;
                case 7:
                    listarEmprestimos();
                    break;
                case 8:
                    salvarDados();
                    break;
                case 9:
                    carregarDados();
                    break;
                case 10:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Adicionar Livro");
        System.out.println("2. Adicionar Usuário");
        System.out.println("3. Realizar Empréstimo");
        System.out.println("4. Devolver Empréstimo");
        System.out.println("5. Listar Livros");
        System.out.println("6. Listar Usuários");
        System.out.println("7. Listar Empréstimos");
        System.out.println("8. Salvar Dados");
        System.out.println("9. Carregar Dados");
        System.out.println("10. Sair");
    }

    private void adicionarLivro() {
        String titulo = Console.lerString("Digite o título do livro:");
        String nomeAutor = Console.lerString("Digite o nome do autor:");
        String emailAutor = Console.lerString("Digite o email do autor:");
        String biografiaAutor = Console.lerString("Digite a biografia do autor:");
        String nomeCategoria = Console.lerString("Digite o nome da categoria:");

        Autor autor = new Autor(nomeAutor, emailAutor, biografiaAutor);
        Categoria categoria = new Categoria(nomeCategoria);
        Livro livro = new Livro(titulo, autor, categoria);

        biblioteca.adicionarLivro(livro);
        System.out.println("Livro adicionado com sucesso!");
    }

    private void adicionarUsuario() {
        String nome = Console.lerString("Digite o nome do usuário:");
        String email = Console.lerString("Digite o email do usuário:");
        String endereco = Console.lerString("Digite o endereço do usuário:");

        Usuario usuario = new Usuario(nome, email, endereco);

        biblioteca.adicionarUsuario(usuario);
        System.out.println("Usuário adicionado com sucesso!");
    }

    private void realizarEmprestimo() {
        String nomeUsuario = Console.lerString("Digite o nome do usuário:");
        String tituloLivro = Console.lerString("Digite o título do livro:");

        Usuario usuario = biblioteca.buscarUsuarioPorNome(nomeUsuario);
        Livro livro = biblioteca.buscarLivroPorTitulo(tituloLivro);

        if (usuario != null && livro != null) {
            try {
                Emprestimo emprestimo = new Emprestimo(biblioteca.getEmprestimos().size() + 1, usuario, livro, LocalDate.now(), LocalDate.now().plusDays(14));
                biblioteca.realizarEmprestimo(emprestimo);
                System.out.println("Empréstimo realizado com sucesso!");
            } catch (LivroNaoDisponivelException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Usuário ou Livro não encontrado.");
        }
    }

    private void devolverEmprestimo() {
        int idEmprestimo = Console.lerInt("Digite o ID do empréstimo:");

        Emprestimo emprestimo = null;
        for (Emprestimo e : biblioteca.getEmprestimos()) {
            if (e.getId() == idEmprestimo) {
                emprestimo = e;
                break;
            }
        }

        if (emprestimo != null) {
            biblioteca.devolverEmprestimo(emprestimo);
            System.out.println("Empréstimo devolvido com sucesso!");
        } else {
            System.out.println("Empréstimo não encontrado.");
        }
    }

    private void listarLivros() {
        System.out.println("Livros:");
        for (Livro livro : biblioteca.getLivros()) {
            System.out.println(livro);
        }
    }

    private void listarUsuarios() {
        System.out.println("Usuários:");
        for (Usuario usuario : biblioteca.getUsuarios()) {
            System.out.println(usuario.getDetalhes());
        }
    }

    private void listarEmprestimos() {
        System.out.println("Empréstimos:");
        for (Emprestimo emprestimo : biblioteca.getEmprestimos()) {
            System.out.println(emprestimo);
        }
    }

    private void salvarDados() {
        try {
            biblioteca.salvarDados();
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private void carregarDados() {
        try {
            biblioteca.carregarDados();
            System.out.println("Dados carregados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        GerenciadorBiblioteca gerenciador = new GerenciadorBiblioteca();
        gerenciador.iniciar();
    }
}