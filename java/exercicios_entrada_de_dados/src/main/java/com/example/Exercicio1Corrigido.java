package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Exercicio1Corrigido {
    String inputFile = "java\\exercicios_entrada_de_dados\\arquivo.txt";

    List<Aluno> alunos = new ArrayList<>();
    double somaTotalNota = 0;
    int totalAlunos = 0;

    // metodo
    public void app() {
        String linha = "";
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                String nome = partes[0];
                double somaNotas = 0;
                double numeroNotas = 0;

                try {
                    for (int i = 0; i < partes.length; i++) {
                        somaNotas += Double.parseDouble(partes[i]);
                        numeroNotas++;
                    }
                } catch (NumberFormatException e) {
                    somaNotas += 0;
                }
                double media = somaNotas / numeroNotas;
                alunos.add(new Aluno(nome, media));

                somaTotalNota += media;
                totalAlunos++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Aluno alunoMaiorNota = alunos.get(0);
        Aluno alunoMenorNota = alunos.get(0);

        // percorre a lista de alunos para encontar o aluno de maior e menor média
        for (Aluno aluno : alunos) {
            if (aluno.getMedia() > alunoMaiorNota.getMedia()) {
                alunoMaiorNota = aluno;
            }
            if (aluno.getMedia() < alunoMenorNota.getMedia()) {
                alunoMenorNota = aluno;
            }
        }
        double mediaGeralTurma = somaTotalNota / totalAlunos; // media geral

        System.out.println("");
        System.out.println("Aluno com a maior nota: " + alunoMaiorNota.getNome() + " - Média: " + alunoMaiorNota.getMedia());
        System.out.println("Aluno com a menor nota: " + alunoMenorNota.getNome() + " - Média: " + alunoMenorNota.getMedia());
        System.out.println("Média geral da turma: " + mediaGeralTurma);
    }
}
