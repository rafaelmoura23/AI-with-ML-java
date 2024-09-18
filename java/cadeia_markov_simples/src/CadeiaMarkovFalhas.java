import java.util.Random;

public class CadeiaMarkovFalhas {
    public static void main(String[] args) {
        Random rd = new Random();
        int mes = 30;
        double falha = 0;
        double custo = 0;
        int cont1 = 0;
        int cont2 = 0;
        int cont3 = 0;

        for (int i = 1; i <= mes; i++) {
            double rand = rd.nextDouble(0, 1);
            if (rand > falha) {
                falha += 0.33;
            } else {
                falha = 0;
                if (rand <= 0.33) {
                    custo+=100;
                    cont1++;
                } else if (rand > 0.33 && rand < 0.66) {
                    custo+=200;
                    cont2++;
                } else{
                    custo+=300;
                    cont3++;
                }
            }
            
        }
        System.out.println("Falhas: " + falha);
        System.out.println("Custo: " + custo);
        System.out.println("Cont1: " + cont1);
        System.out.println("Cont2: " + cont2);
        System.out.println("Cont3: " + cont3);
       
    }

}
