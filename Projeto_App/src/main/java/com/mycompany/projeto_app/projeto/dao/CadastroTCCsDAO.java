/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_app.projeto.dao;

import com.mycompany.projeto_app.projeto.dto.CadastroTCCsDTO;
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
 * @author matia
 */
public class CadastroTCCsDAO {
    private Connection connection;
    
    public CadastroTCCsDAO () {
        connection = ConexaoMySQL.getConnection();
}

    public void cadastrarTCCs (CadastroTCCsDTO TCCs) {
       connection= ConexaoMySQL.getConnection();
       try {
            String query = "INSERT INTO cadastrotccs (titulo_tcc, autor_tcc, orientador_tcc, ano_de_defesa, resumo) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, TCCs.getTitulo_tcc());
                pst.setString(2, TCCs.getAutor_tcc());
                pst.setString(3, TCCs.getOrientador_tcc());
                pst.setInt(4, TCCs.getAno_de_defesa());
                pst.setString(5, TCCs.getResumo());
                pst.executeUpdate();
            }
       } catch (SQLException e) {
            System.err.println("Erro ao cadastrar tcc: " + e.getMessage());
        }
    }
       public List<CadastroTCCsDTO> listarTCCs() {
        List<CadastroTCCsDTO> TCCs = new ArrayList<>();
        try {
            String query = "SELECT * FROM cadastrotccs";
            try (Statement st = connection.createStatement();
                 ResultSet rs = st.executeQuery(query)) {
                while (rs.next()) {
                    int id = rs.getInt("id_TCC");
                    String titulo = rs.getString("titulo_tcc");
                    String autor = rs.getString("autor_tcc");
                    String orientador = rs.getString("orientador_tcc");
                    int ano_de_defesa= rs.getInt("ano_de_defesa");
                    String resumo= rs.getString("resumo");
                    CadastroTCCsDTO tcc = new CadastroTCCsDTO(id, titulo, autor, orientador, ano_de_defesa, resumo);
                    TCCs.add(tcc); 
                    CadastroTCCsDTO tccs = new CadastroTCCsDTO(id, titulo, autor, orientador, ano_de_defesa, resumo);
                    TCCs.add(tccs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar Tccs: " + e.getMessage());
        }
        return TCCs;
    }


    // Método para atualizar um TCC
    public void atualizarTCCs(CadastroTCCsDTO TCCs) {
        try {
            String query = "UPDATE cadastroTCCs SET titulo_tcc = ?, autor_tcc = ?, orientador_tcc = ?, ano_de_defesa = ?, resumo = ? WHERE id_TCC = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, TCCs.getTitulo_tcc());
                ps.setString(2, TCCs.getAutor_tcc());
                ps.setString(3, TCCs.getOrientador_tcc());
                ps.setInt(4, TCCs.getAno_de_defesa());
                ps.setString(5, TCCs.getResumo());
                ps.setInt(6, TCCs.getId_TCC());
                ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar tcc: " + e.getMessage());
        }
    }
    
     // Método para excluir um TCC
    public void excluirTCC(int id_TCC) {
        connection = ConexaoMySQL.getConnection();
        try {
            String query = "DELETE FROM cadastrotccs WHERE id_TCC = ?";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setInt(1, id_TCC);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir tcc: " + e.getMessage());
        }
    }
}
   