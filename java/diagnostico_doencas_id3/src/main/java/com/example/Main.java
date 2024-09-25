package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {  // Função principal para interação com o usuário
        // Constrói a árvore de decisão
        public static void main(String[] args) {

        No arvore = DiagnosticoSaudeID3.construirArvore();

        // Coleta sintomas do usuário
        Scanner scanner = new Scanner(System.in);
        Map<String, String> sintomas = new HashMap<>();

        System.out.println("Você tem febre? (Sim/Não): ");
        sintomas.put("Febre", scanner.nextLine());

        System.out.println("Você tem tosse? (Sim/Não): ");
        sintomas.put("Tosse", scanner.nextLine());

        System.out.println("Você tem dor de garganta? (Sim/Não): ");
        sintomas.put("Dor de Garganta", scanner.nextLine());

        // Previsão de doença com base nos sintomas
        String previsao = arvore.prever(sintomas);
        System.out.println("Possível doença: " + previsao);

        scanner.close();
    }
}
