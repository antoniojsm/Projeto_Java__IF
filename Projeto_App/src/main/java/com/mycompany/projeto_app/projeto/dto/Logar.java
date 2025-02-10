/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_app.projeto.dto;

import static javax.swing.SpringLayout.WIDTH;

/**
 *
 * @author anton
 */
public class Logar {
    public void logar(){
        try{
            String user = usernameField.getText();
            String password = new String (passwordField.getPassword());
            
            UsuarioDTO objUsuario= new UsuarioDTO (WIDTH, user, password);
            objUsuario.setUser(user);
            objUsuario.setPassword(password);
            
            UsuarioDAO usuario =  new UsuarioDAO();
            ResultSet rsUserDao= usuario.autenticacaoUsuario(objUsuario);
            
            if(rsUserDao.next()){
                Tela_App app_Tela = new Tela_App();
                app_Tela.setVisible(true);
                dispose();
            }else {
                JOptionPane.showMenssageDialog(null"dados Invalidos")
                limparCampos();
            }
            
        }catch(SQLException e){
            JOpitionPane.showMessageDialog(null, e.getMenssage());
        }
    }
}
