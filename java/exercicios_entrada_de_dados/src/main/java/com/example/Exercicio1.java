package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercicio1 {
    public void teste() {
        try (BufferedReader br = new BufferedReader(new FileReader("arquivo.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void teste1() {
        String arquivo = "arquivo.txt";
        String linha = "";
        String divisor = ","; // O divisor usado no , neste caso é a vírgula
        String alunoMaiorNota = "";
        String alunoMenorNota = "";
        double somaNotas = 0;
        int numeroDeNotas = 0;
        double maiorNota = Double.MIN_VALUE;
        double menorNota = Double.MAX_VALUE;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

            br.readLine();

            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
                String[] valores = linha.split(divisor);
                String nome = valores[0];
                

                for (int i = 1; i < valores.length; i++) {
                    double nota = Double.parseDouble(valores[i]);
                    System.err.println(linha);
                    System.err.println(nota);
                    somaNotas += nota;
                    numeroDeNotas++;
                    System.err.println(somaNotas);
                    System.err.println(numeroDeNotas);
                    System.err.println(nome);

                    if (nota > maiorNota) {
                        maiorNota = nota;
                        alunoMaiorNota = nome;
                    }
                    if (nota < menorNota) {
                        menorNota = nota;
                        alunoMenorNota = nome;
                    }
                }
            }
            double mediaGeral = somaNotas / numeroDeNotas;
            System.out.println("Média geral da turma: " + mediaGeral);
            System.out.println("Nome do aluno com a maior nota: " + alunoMaiorNota);
            System.out.println("Nome do aluno com a menor nota: " + alunoMenorNota);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
