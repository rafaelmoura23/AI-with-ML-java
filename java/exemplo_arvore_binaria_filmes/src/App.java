import java.util.Scanner;


public class App {
    public static void main(String[] args) {
       ArvoreBinariaFilmes arvoreFilmes = new ArvoreBinariaFilmes();
        Scanner scanner = new Scanner(System.in);


        // Carregar filmes do arquivo CSV
        arvoreFilmes.carregarFilmesDeArquivo("src\\filmes.csv");


        while (true) {
            System.out.println("\nMenu de Navegação:");
            System.out.println("1. Exibir todos os filmes");
            System.out.println("2. Buscar e sugerir filmes");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer


            switch (opcao) {
                case 1:
                    arvoreFilmes.exibirFilmesInOrder();
                    break;
                case 2:
                    System.out.print("Digite o título do filme: ");
                    String titulo = scanner.nextLine();
                    arvoreFilmes.sugerirFilmes(titulo);
                    break;
                case 3:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
