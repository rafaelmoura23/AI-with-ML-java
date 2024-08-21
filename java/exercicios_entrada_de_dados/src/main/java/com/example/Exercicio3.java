package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exercicio3 {
    public void teste() {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
                    "postgres");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM produtos");

            String produtoMaisCaro = "";
            String produtoMaisBarato = "";
            double maiorPreco = Double.MIN_VALUE;
            double menorPreco = Double.MAX_VALUE;
            double somaPrecos = 0.0;
            int numeroDeProdutos = 0;

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");

                System.out.println("ID: " + id + ", Produto: " + nome + ", Preço: " + preco);

                // produto mais caro e mais barato
                if (preco > maiorPreco) {
                    maiorPreco = preco;
                    produtoMaisCaro = nome;
                }
                if (preco < menorPreco) {
                    menorPreco = preco;
                    produtoMaisBarato = nome;
                }

                somaPrecos += preco;
                numeroDeProdutos++;
            }

            // média dos preços
            double mediaPrecos = (numeroDeProdutos > 0) ? (somaPrecos / numeroDeProdutos) : 0.0;

            System.out.println("Produto mais caro: " + produtoMaisCaro + " com preço: " + maiorPreco);
            System.out.println("Produto mais barato: " + produtoMaisBarato + " com preço: " + menorPreco);
            System.out.println("Média dos preços dos produtos: " + mediaPrecos);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
