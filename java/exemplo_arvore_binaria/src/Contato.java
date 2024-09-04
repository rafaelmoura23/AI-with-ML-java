public class Contato {
    String nome;
    String telefone;
    Contato esquerda; // Referência para o filho à esquerda
    Contato direita;  // Referência para o filho à direita


    Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.esquerda = null;
        this.direita = null;
    }
}
