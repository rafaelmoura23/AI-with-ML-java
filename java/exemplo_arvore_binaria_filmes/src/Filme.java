public class Filme {
    String titulo;
    int ano;
    String genero;
    double nota;
    Filme esquerda; // Filho à esquerda
    Filme direita; // Filho à direita

    Filme(String titulo, int ano, String genero, double nota) {
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
        this.nota = nota;
        this.esquerda = null;
        this.direita = null;
    }
}
