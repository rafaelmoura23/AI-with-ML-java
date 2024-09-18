// import java.util.Random;

public class CadeiaMarkovSimples {

    // Definição dos estados
    private static final int ENSOLARADO = 0;
    private static final int NUBLADO = 1;
    private static final int CHUVOSO = 2;

    // Matriz de transição
    private static final double[][] matrizTransicao = {
            {0.7, 0.2, 0.1},  // Probabilidades de transição a partir de ENSOLARADO
            {0.3, 0.4, 0.3},  // Probabilidades de transição a partir de NUBLADO
            {0.2, 0.3, 0.5}   // Probabilidades de transição a partir de CHUVOSO
    };

    // Estado inicial
    private int estadoAtual;

    // Construtor para iniciar com um estado
    public CadeiaMarkovSimples(int estadoInicial) {
        this.estadoAtual = estadoInicial;
    }

    // Método para simular a transição de estado
    public void transicaoProximoDia() {
        double[] probabilidades = matrizTransicao[estadoAtual];
        double rand = Math.random();

        // Determina o próximo estado com base nas probabilidades
        if (rand < probabilidades[0]) {
            estadoAtual = ENSOLARADO;
        } else if (rand < probabilidades[0] + probabilidades[1]) {
            estadoAtual = NUBLADO;
        } else {
            estadoAtual = CHUVOSO;
        }
    }

    // Método para obter o estado atual em formato de string
    public String obterEstadoAtual() {
        switch (estadoAtual) {
            case ENSOLARADO:
                return "Ensolarado";
            case NUBLADO:
                return "Nublado";
            case CHUVOSO:
                return "Chuvoso";
            default:
                return "Desconhecido";
        }
    }
}
