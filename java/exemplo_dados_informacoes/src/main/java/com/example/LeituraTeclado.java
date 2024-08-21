package com.example;

import java.util.Scanner;

public class LeituraTeclado {
    public void teste() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        System.out.println("Nome: " + nome + " | Idade: " + idade);
        scanner.close();
    }
}
