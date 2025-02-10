/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_app.projeto.dto;

import com.mycompany.projeto_app.projeto.dao.UsuarioDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.SpringLayout.WIDTH;

/**
 *
 * @author anton
 */
public class TelaApp {
    
    
    public void limparCampos(){
        txtUsuario.setText(null);
        txtSenha.setText(null);
        txtUsuario.resquestFocus();
    }
    public void logar(){
        //"String sql="select*from usuarios where email=? and senha=?";
        try{
            String user = txtUsuario.getText();
            String password = new String (txtSenha.getPassword());
            
            UsuarioDTO objUsuario= new UsuarioDTO (WIDTH, user, password);
            objUsuario.setUser(user);
            objUsuario.setPassword(password);
            
            UsuarioDAO usuario =  new UsuarioDAO();
            ResultSet rsUserDao= usuario.autenticacaoUsuario(objUsuario);
            
            if(rsUserDao.next()){
                TelaApp appTela = new TelaApp();
                appTela.setVisible(true);
                dispose();
            }else {
                JOptionPane.showMessageDialog(null, "dados Invalidos");
                limparCampos();
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
