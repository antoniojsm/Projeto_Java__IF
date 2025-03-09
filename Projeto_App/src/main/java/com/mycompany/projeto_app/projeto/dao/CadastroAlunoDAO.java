/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_app.projeto.dao;

import com.mycompany.projeto_app.projeto.dto.CadastroAlunoDTO;
import com.mycompany.projeto_app.projeto.dto.CadastroLivrosDTO;
import com.mycompany.projeto_app.projeto.factory.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anton
 */
public class CadastroAlunoDAO {
    private final Connection connection;
    // Método para cadastrar um livro

    public CadastroAlunoDAO() {
        connection = ConexaoMySQL.getConnection();
    }
    
  public void cadastraraluno(CadastroAlunoDTO aluno) {
    try {
        connection.setAutoCommit(false); // Desativa o autocommit
        String query = "INSERT INTO cadastroalunos (cpf, nome_aluno, email_aluno, emprestimo, entrega) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, aluno.getCpf());
            pst.setString(2, aluno.getNome_aluno());
            pst.setString(3, aluno.getEmail_aluno());
            pst.setString(4, aluno.getEmprestimo());
            pst.setString(5, aluno.getEntrega());
            pst.executeUpdate();
            connection.commit(); // Confirma a transação
        }
    } catch (SQLException e) {
        try {
            connection.rollback(); // Desfaz a transação em caso de erro
        } catch (SQLException ex) {
            System.err.println("Erro ao fazer rollback: " + ex.getMessage());
        }
        System.err.println("Erro ao cadastrar um novo aluno: " + e.getMessage());
    } finally {
        try {
            connection.setAutoCommit(true); // Restaura o autocommit
        } catch (SQLException e) {
            System.err.println("Erro ao restaurar autocommit: " + e.getMessage());
        }
    }
}

    // Método para listar todos os livros
    public List<CadastroAlunoDTO> listarAluno() {
    List<CadastroAlunoDTO> alunos = new ArrayList<>();
    try (PreparedStatement pst = connection.prepareStatement("SELECT * FROM cadastroalunos");
         ResultSet rs = pst.executeQuery()) {
        while (rs.next()) {
            int id = rs.getInt("id_aluno");
            String nome = rs.getString("nome_aluno");
            String cpf = rs.getString("cpf");
            String email = rs.getString("email_aluno");
            String emprestimo = rs.getString("emprestimo");
            String entrega = rs.getString("entrega");
            CadastroAlunoDTO aluno = new CadastroAlunoDTO(id, nome, cpf, email, emprestimo, entrega);
            alunos.add(aluno);
        }
    } catch (SQLException e) {
        System.err.println("Erro ao listar aluno: " + e.getMessage());
    }
    return alunos;
}
    // Método para atualizar um livro
    public void atualizarAluno(CadastroAlunoDTO aluno) {
        try {
            String query = "UPDATE cadastroalunos SET nome_aluno = ?, cpf = ?, email_aluno = ?, emprestimo = ?, entrega = ?  WHERE id_aluno = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, aluno.getNome_aluno());
                ps.setString(2, aluno.getCpf());
                ps.setString(4, aluno.getEmail_aluno());
                ps.setString(5, aluno.getEmprestimo());
                ps.setString(6, aluno.getEntrega());
                ps.setInt(7, aluno.getId_aluno());
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar aluno: " + e.getMessage());
        }
    }
    public void excluirAlunos(int id_aluno) {
        try {
            String query = "DELETE FROM cadastroalunos WHERE id_aluno = ?"; // Query SQL para excluir o aluno
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setInt(1, id_aluno); // Define o ID do aluno como parâmetro
                pst.executeUpdate(); // Executa a query
            } // O PreparedStatement é fechado automaticamente ao final do bloco try
        } catch (SQLException e) {
            System.err.println("Erro ao excluir o cadastro do aluno: " + e.getMessage());
        }
    }
}
