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
public class CadastroLivroDAO {
    private Connection connection;
    // Método para cadastrar um livro

    public CadastroLivroDAO() {
        connection = ConexaoMySQL.getConnection();
    }
    
    
    
    public void cadastrarlivro(CadastroLivrosDTO livro) {
       connection= ConexaoMySQL.getConnection();
        try {
            String query = "INSERT INTO cadastrolivros (titulo_livro, autor_livro, disponibilidade) VALUES (?, ?, ?)";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, livro.getTitulo_livro());
                pst.setString(2, livro.getAutor_livro());
                pst.setInt(3, livro.getDisponibilidade());
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar livro: " + e.getMessage());
        }
    }

    // Método para listar todos os livros
    public List<CadastroLivrosDTO> listarLivros() {
        List<CadastroLivrosDTO> livros = new ArrayList<>();
        try {
            String query = "SELECT * FROM cadastrolivros";
            try (Statement st = connection.createStatement();
                 ResultSet rs = st.executeQuery(query)) {
                while (rs.next()) {
                    int id = rs.getInt("id_livro");
                    String titulo = rs.getString("titulo_livro");
                    String autor = rs.getString("autor_livro");
                    int disponibilidade = rs.getInt("disponibilidade");
                    CadastroLivrosDTO livro = new CadastroLivrosDTO(id, titulo, autor, disponibilidade);
                    livros.add(livro);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar livros: " + e.getMessage());
        }
        return livros;
    }

    // Método para atualizar um livro
    public void atualizarLivro(CadastroLivrosDTO livro) {
        try {
            String query = "UPDATE cadastrolivros SET titulo_livro = ?, autor_livro = ?, disponibilidade = ? WHERE id_livro = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, livro.getTitulo_livro());
                ps.setString(2, livro.getAutor_livro());
                ps.setInt(3, livro.getDisponibilidade());
                ps.setInt(4, livro.getId_livro());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar livro: " + e.getMessage());
        }
    }

    // Método para excluir um livro
    public void excluirLivro(int id_livro) {
        try {
            String query = "DELETE FROM cadastrolivros WHERE id_livro = ?";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setInt(1, id_livro);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir livro: " + e.getMessage());
        }
    }

    public void excluirAluno(int cpf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
