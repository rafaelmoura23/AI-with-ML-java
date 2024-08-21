package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Exercicio5 {
    Scanner scanner = new Scanner(System.in);

    public void teste() {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
                    "postgres");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Nome: " + rs.getString("nome"));
            }
            show(con);
            adicionar(con);
            atualizar(con);
            deletar(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void show(Connection con) throws Exception {
        String query = "SELECT * FROM clientes";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Nome: " + rs.getString("nome") + ", Email: "
                        + rs.getString("email"));
            }
        }
    }

    private void adicionar(Connection con) throws Exception {
        System.out.println("Digite o ID do novo cliente:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o nome do novo cliente:");
        String nome = scanner.nextLine();
        System.out.println("Digite o e-mail do novo cliente:");
        String email = scanner.nextLine();

        String query = "INSERT INTO clientes (id, nome, email) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, nome);
            pstmt.setString(3, email);
        }
    }

    private void atualizar(Connection con) throws Exception {
        System.out.println("Digite o ID do cliente para atualizar o e-mail:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o novo e-mail:");
        String newEmail = scanner.nextLine();

        String query = "UPDATE clientes SET email = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, newEmail);
            pstmt.setInt(2, id);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Número de linhas atualizadas: " + rowsAffected);
        }
    }

    private void deletar(Connection con) throws Exception {
        System.out.println("Digite o ID do cliente para excluir:");
        int id = Integer.parseInt(scanner.nextLine());

        String query = "DELETE FROM clientes WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
        }
    }
}
