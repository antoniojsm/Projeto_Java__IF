/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_app.projeto.dao;

import com.mycompany.projeto_app.projeto.factory.ConexãoMySQL;
import java.sql.Connection;

/**
 *
 * @author anton
 */
public class Cadastro_Livros {
    private Connection connection;
    
    public Cadastro_Livros (){
        connection = ConexãoMySQL.getConnection(); 
    }
}
