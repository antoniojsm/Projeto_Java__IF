/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_app.projeto.dao;

import com.mycompany.projeto_app.projeto.dto.CadastroLivrosDTO;
import com.mycompany.projeto_app.projeto.dto.FuncionariosDTO;
import com.mycompany.projeto_app.projeto.factory.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anton
 */
public class FuncionariosDAO {
     private Connection connection;
    // Método para cadastrar um livro

    public FuncionariosDAO() {
        connection = ConexaoMySQL.getConnection();
    }
    
    
    
    public void cadastrarFuncionario(FuncionariosDTO funcionarios) {
       connection= ConexaoMySQL.getConnection();
        try {
            String query = "INSERT INTO funcionarios (nome_funcionario, email_funcionario, cargo) VALUES (?, ?, ?)";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, funcionarios.getNome_funcionario());
                pst.setString(2, funcionarios.getEmail_funcionario());
                pst.setString(3, funcionarios.getCargo());
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar funcionario: " + e.getMessage());
        }
    }

    // Método para listar todos os livros
    public List<FuncionariosDTO> listarFuncionario() {
        List<FuncionariosDTO> funcionarios = new ArrayList<>();
        try {
            String query = "SELECT * FROM funcionarios";
            try (Statement st = connection.createStatement();
                 ResultSet rs = st.executeQuery(query)) {
                while (rs.next()) {
                    int id = rs.getInt("id_funcionario");
                    String nome = rs.getString("nome_funcionario");
                    String email = rs.getString("email_funcionario");
                    String cargo = rs.getString("cargo");
                    FuncionariosDTO funcionario = new FuncionariosDTO(id, nome, email, cargo);
                    funcionarios.add(funcionario);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar livros: " + e.getMessage());
        }
        return funcionarios;
    }

    // Método para atualizar um livro
    public void atualizarFuncionarios(FuncionariosDTO funcionario) {
        try {
            String query = "UPDATE funcionarios SET nome_funcionario = ?, email_funcionario = ?, cargo = ? WHERE id_funcionario = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, funcionario.getNome_funcionario());
                ps.setString(2, funcionario.getEmail_funcionario());
                ps.setString(3, funcionario.getCargo());
                ps.setInt(4, funcionario.getId_funcionario());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar funcionario: " + e.getMessage());
        }
    }

    // Método para excluir um livro
    public void excluirFuncionarios(int id_funcionario) {
        try {
            String query = "DELETE FROM funcionarios WHERE id_funcionario = ?";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setInt(1, id_funcionario);
                pst.executeUpdate();
                pst.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir funcionario: " + e.getMessage());
        }
    }
   }
