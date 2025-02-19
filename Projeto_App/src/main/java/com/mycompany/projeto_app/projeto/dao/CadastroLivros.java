/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_app.projeto.dao;

import com.mycompany.projeto_app.projeto.factory.ConexaoMySQL;
import java.awt.List;
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
public class CadastroLivros {

    public static void excluirLivros(int id_livro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private Connection connection;
    
    public CadastroLivros(String titulo_livro, String autor_livro, int Disponibilidade){
        connection= ConexaoMySQL.getConnection();
    }
    public void cadastrarlivro(CadastroLivros Livros) {
        try {
            String query = "INSERT INTO cadastrolivros (id_livro, titulo_livro, autor_livro, disponibilidade) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setInt(1, Livros.getId_livro());
                pst.setString(2, Livros.getTitulo_livro());
                pst.setString(3, Livros.getAutor_livro());
                pst.setInt(4, Livros.getDisponibilidade());
                pst.executeUpdate();
                pst.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
        }
    }

    public List <CadastroLivros> listarLivros() {
        List <CadastroLivros> Livros = new ArrayList();
        try {
            String query = "SELECT * FROM cadastrolivros";
            try (Statement st = connection.createStatement()) {
                try (ResultSet rs = st.executeQuery(query)) {
                    while (rs.next()) {
                        int id = rs.getInt("id_livro");
                        String nome = rs.getString("titulo_livro");
                        String autor = rs.getString("autor_livro");
                        int disponibilidade = rs.getInt("disponibilidade");
                        CadastroLivros Livro = new CadastroLivros(nome, autor, id);
                        Livros.add(Livro);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
        }
        return Livros;
}
    
    public void atualizarProduto(CadastroLivros Livros) {
        try {
            String query = "UPDATE cadastrolivros SET titulo_livro = ?, autor_livro = ?, disponibilidade = ? WHERE id_livro  = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, Livros.getTitulo_livro());
                ps.setString(2, Livros.getAutor_livro());
                ps.setInt(3, Livros.getDisponibilidade());
                ps.setInt(4, Livros.getId_livro());

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

    public Object getId_livro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getTitulo_livro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getAutor_livro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getDisponibilidade() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


}
