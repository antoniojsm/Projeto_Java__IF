/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_app.projeto.dao;

import com.mycompany.projeto_app.projeto.factory.ConexaoMySQL;
import java.sql.Connection;

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
}
