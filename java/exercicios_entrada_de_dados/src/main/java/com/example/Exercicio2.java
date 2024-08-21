package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class Exercicio2 {
    public void teste() {
        try {
            // URL da API pública do GitHub para obter informações de um usuário
            URL url = new URL("http://localhost:3000/usuarios");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("HTTP error code : " + status);
            }

            // resposta da API
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                StringBuilder content = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                // conteúdo JSON através da dependencia
                JSONArray usuarios = new JSONArray(content.toString());
                int totalUsuarios = 0;
                double somaIdades = 0;

                for (int i = 0; i < usuarios.length(); i++) {
                    JSONObject usuario = usuarios.getJSONObject(i);
                    String nome = usuario.getString("nome");
                    int idade = usuario.getInt("idade");
                    String cidade = usuario.getString("cidade");

                    System.out.println("Nome: " + nome + ", Idade: " + idade + ", Cidade: " + cidade);

                    totalUsuarios++;
                    somaIdades += idade;
                }

                double mediaIdade = somaIdades / totalUsuarios;
                System.out.println("Número total de usuários: " + totalUsuarios);
                System.out.println("Média de idade dos usuários: " + mediaIdade);
            } finally {
                con.disconnect();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
