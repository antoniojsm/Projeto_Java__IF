/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_app.projeto.dao;

import com.mycompany.projeto_app.projeto.factory.ConexãoMySQL;
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
        connection = ConexãoMySQL.getConnection();
        }
    public ResultSet autenticacaoUsuario(UsuarioDTO usuario){
        try{
            String sql="SELECT * FROM usuario_bibblioteca WHERE user=? end password=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, usuario.getUser());
            pst.setString(2, usuario.getPassword());
            
            ResultSet rs = pst.executeQuery();
            return rs;
            
            
        }catch (SQLException e){
            System.out.println("erro ao realizar a operação"+e.getMessage());
            return null;
        }
    }
}
