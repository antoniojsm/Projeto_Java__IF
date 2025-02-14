/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto_App;

import com.mycompany.projeto_app.projeto.factory.ConexaoMySQL;
import com.mycompany.projeto_app.projeto.gui.TelaLogin;

/**
 *
 * @author anton
 */
public class Tela_De_login{
    public static void main(String[] args) {
        TelaLogin objTL=new TelaLogin();
        objTL.setVisible(true);
                ConexaoMySQL.getConnection();

   }
}