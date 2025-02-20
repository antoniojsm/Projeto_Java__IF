/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_app.projeto.dao;

import com.mycompany.projeto_app.projeto.dto.CadastroLivrosDTO;
import com.mycompany.projeto_app.projeto.factory.ConexaoMySQL;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author anton
 */
public class CadastroLivro {
    private Connection connection;
    
    public CadastroLivro(String titulo_livro, String autor_livro, int Disponibilidade){
        connection= ConexaoMySQL.getConnection();
    }
    public void cadastrarlivro(CadastroLivro Livros) {
        try {
            String query = "INSERT INTO cadastrolivros (id_livro, titulo_livro, autor_livro, disponibilidade) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, (String) Livros.getTitulo_livro());
                pst.setString(2, (String) Livros.getAutor_livro());
                pst.setInt(3, Livros.getDisponibilidade());
                pst.executeUpdate();
                pst.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
        }
    }

    public List <CadastroLivro> listarLivros() {
        List <CadastroLivro> Livros = new ArrayList();
        try {
            String query = "SELECT * FROM cadastrolivros";
            try (Statement st = connection.createStatement()) {
                try (ResultSet rs = st.executeQuery(query)) {
                    while (rs.next()) {
                        int id = rs.getInt("id_livro");
                        String nome = rs.getString("titulo_livro");
                        String autor = rs.getString("autor_livro");
                        int disponibilidade = rs.getInt("disponibilidade");
                        CadastroLivro Livro = new CadastroLivro(nome, autor, id);
                        Livros.add(Livro);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
        }
        return Livros;
}
    
    public void atualizarLivro(CadastroLivro Livros) {
        try {
            String query = "UPDATE cadastrolivros SET titulo_livro = ?, autor_livro = ?, disponibilidade = ? WHERE id_livro  = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1,Livros.getTitulo_livro());
                ps.setString(2, Livros.getAutor_livro());
                ps.setInt(3, Livros.getDisponibilidade());

                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
        }
    }

    public void excluirLivro(int id_livro) {
        try {
            String query = "DELETE FROM cadstrolivros WHERE id_livro = ?";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setInt(1, id_livro);
                pst.executeUpdate();
                pst.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
        }
    }
}
