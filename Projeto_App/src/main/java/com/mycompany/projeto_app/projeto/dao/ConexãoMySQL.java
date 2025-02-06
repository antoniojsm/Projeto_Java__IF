/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_app.projeto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;




/**
 *
 * @author anton
 */
public class ConexãoMySQL {
    public static void main(String[] args) throws SQLException{
      Connection conexao=null;
            try {
                // Registrar o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
           conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bibliotecaif", "root", "neto123");
           ResultSet rsCliente=conexao.createStatement().executeQuery("SELECT * FROM livros");
           while(rsCliente.next()){
               System.out.println("id_livro:"+rsCliente.getString("id_livro"));
           }
            System.out.println("Conexão realizada com sucesso!");
           } catch (ClassNotFoundException ex){
            System.out.println("drive do banco não localzado");
           } catch (SQLException ex){
            System.out.println("Ocorreu um erro ao acessar o banco:" + ex.getMessage());
        } finally{
                if(conexao!=null){
                    conexao.close();
                }
            }
    }
}
