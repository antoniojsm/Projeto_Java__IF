/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_app.projeto.dao;

import com.mycompany.projeto_app.projeto.dto.UsuarioDTO;
import com.mycompany.projeto_app.projeto.factory.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author anton
 */
public class UsuarioDAO{
    private Connection connection;
    public UsuarioDAO(){
        System.out.println(connection+"");
        connection = ConexaoMySQL.getConnection();
        }
    public ResultSet autenticacaoUsuario(UsuarioDTO usuario){
        try{
            String sql="SELECT * FROM usuario WHERE usuario=? AND senha=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, usuario.getUser());
            pst.setString(2, usuario.getPassword());
            
            ResultSet rs = pst.executeQuery();
            return rs;
            
            
        }catch (SQLException e){
            System.err.println("Erro ao realizar operação: " + e.getMessage()); 
            return null; 
        }
    }
}
