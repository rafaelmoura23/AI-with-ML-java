import java.util.Random;

public class CadeiaMarkovBolas {
    public static void main(String[] args) {
        Random rd = new Random();
        int qtdBolas = 10;
        int vermelho = 0;
        int azul = 0;
        // 0 = vermelha
        // 1 = azul

        for (int i = 1; i <= qtdBolas; i++) {
            double rand = rd.nextDouble(0, 1);
            if (rand == 1) {
                qtdBolas-=1;
                azul++;
            } else {
                qtdBolas+=0;
                vermelho++;
            }
        }
        System.out.println("Vermelha: " + vermelho);
        System.out.println("Azul: " + azul);
        System.out.println("Bolas: " + qtdBolas);

    }
}
