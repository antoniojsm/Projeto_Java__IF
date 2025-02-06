/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_app.projeto.dao;

/**
 *
 * @author anton
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoMySQL {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Carregar o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Configurar a conexão
            String url = "jdbc:mysql://127.0.0.1:3306/bibliotecaif"; // Nome do banco
            String user = "root"; // Usuário do MySQL
            String password = "neto123"; // Senha do MySQL

            // Estabelecer a conexão
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão realizada com sucesso!");

            // Executar uma consulta SQL
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM livros");

            // Exibir os resultados
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                System.out.println("ID: " + id + ", Nome: " + nome + ", Email: " + email);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erro na conexão: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close(); // Fechar a conexão
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
