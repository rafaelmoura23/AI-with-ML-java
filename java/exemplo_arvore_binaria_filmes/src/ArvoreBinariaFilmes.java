import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ArvoreBinariaFilmes {
    private Filme raiz;


    public void adicionarFilme(String titulo, int ano, String genero, double nota) {
        raiz = adicionarRecursivo(raiz, titulo, ano, genero, nota);
    }


    private Filme adicionarRecursivo(Filme atual, String titulo, int ano, String genero, double nota) {
        if (atual == null) {
            return new Filme(titulo, ano, genero, nota);
        }


        if (titulo.compareTo(atual.titulo) < 0) {
            atual.esquerda = adicionarRecursivo(atual.esquerda, titulo, ano, genero, nota);
        } else if (titulo.compareTo(atual.titulo) > 0) {
            atual.direita = adicionarRecursivo(atual.direita, titulo, ano, genero, nota);
        } else {
            System.out.println("Filme com este título já existe!");
        }


        return atual;
    }


    public Filme buscarFilme(String titulo) {
        return buscarRecursivo(raiz, titulo);
    }


    private Filme buscarRecursivo(Filme atual, String titulo) {
        if (atual == null || atual.titulo.equals(titulo)) {
            return atual;
        }


        if (titulo.compareTo(atual.titulo) < 0) {
            return buscarRecursivo(atual.esquerda, titulo);
        } else {
            return buscarRecursivo(atual.direita, titulo);
        }
    }


    public void sugerirFilmes(String titulo) {
        Filme encontrado = buscarFilme(titulo);
        if (encontrado != null) {
            System.out.println("Filme encontrado: " + encontrado.titulo + ", Ano: " + encontrado.ano + ", Gênero: " + encontrado.genero + ", Nota: " + encontrado.nota);


            List<Filme> filmesProximos = new ArrayList<>();
            coletarFilmesProximos(raiz, encontrado.nota, filmesProximos);


            System.out.println("Sugestões de filmes com notas próximas:");
            for (Filme filme : filmesProximos) {
                if (!filme.titulo.equals(encontrado.titulo)) {
                    System.out.println("Título: " + filme.titulo + ", Ano: " + filme.ano + ", Gênero: " + filme.genero + ", Nota: " + filme.nota);
                }
            }
        } else {
            System.out.println("Filme não encontrado na árvore.");
        }
    }


    private void coletarFilmesProximos(Filme atual, double notaBase, List<Filme> listaFilmes) {
        if (atual != null) {
            if (Math.abs(atual.nota - notaBase) <= 0.25) {
                listaFilmes.add(atual);
            }
            coletarFilmesProximos(atual.esquerda, notaBase, listaFilmes);
            coletarFilmesProximos(atual.direita, notaBase, listaFilmes);
        }
    }


    public void exibirFilmesInOrder() {
        if (raiz == null) {
            System.out.println("Nenhum filme na árvore.");
        } else {
            System.out.println("Lista de Filmes (em ordem alfabética):");
            exibirInOrder(raiz);
        }
    }


    private void exibirInOrder(Filme atual) {
        if (atual != null) {
            exibirInOrder(atual.esquerda);
            System.out.println("Título: " + atual.titulo + ", Ano: " + atual.ano + ", Gênero: " + atual.genero + ", Nota: " + atual.nota);
            exibirInOrder(atual.direita);
        }
    }


    public void carregarFilmesDeArquivo(String caminhoArquivo) {
        String linha;
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            br.readLine(); // Pular a primeira linha (cabeçalho)
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                String titulo = dados[0];
                int ano = Integer.parseInt(dados[1]);
                String genero = dados[2];
                double nota = Double.parseDouble(dados[3]);
                adicionarFilme(titulo, ano, genero, nota);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
