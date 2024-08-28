package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exercicio4 {
    public void teste() {
        String arquivoCSV = "arquivo.csv";
        String linha = "";
        String novoArquivoCSV = "novo_arquivo.csv";
        String divisor = ","; // O divisor usado no CSV, neste caso é a vírgula

        double maiorValorTotal = 0.0;
        String produtoMaisCaro = "";

        // Buffer para armazenar os dados para o novo arquivo
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            if ((linha = br.readLine()) != null) {
                String[] colunas = linha.split(divisor);
                sb.append(String.join(divisor, colunas)).append(divisor).append("Valor Total").append("\n");
                System.out.println("Cabeçalho:");
                for (String coluna : colunas) {
                    System.out.print(coluna + " ");
                }
                System.out.println(" Valor Total");
                System.out.println("---------------------------");
            }

            System.out.println("Conteúdo:");
            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(divisor);
                String nome = valores[0];
                int quantidade = Integer.parseInt(valores[1]);
                double preco = Double.parseDouble(valores[2]);

                double valorTotal = quantidade * preco;

                if (valorTotal > maiorValorTotal) {
                    maiorValorTotal = valorTotal;
                    produtoMaisCaro = nome;
                }

                sb.append(String.join(divisor, valores)).append(divisor).append(valorTotal).append("\n");

                System.out.println("Produto: " + nome + ", Quantidade: " + quantidade + ", Preço: " + preco
                        + ", Valor Total: " + valorTotal);
            }

            System.out.println("Produto com o maior valor total em estoque: " + produtoMaisCaro + " com valor total: "
                    + maiorValorTotal);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(novoArquivoCSV))) {
                bw.write(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}