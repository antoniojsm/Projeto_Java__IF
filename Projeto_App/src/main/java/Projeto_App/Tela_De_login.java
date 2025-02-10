/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto_App;

/**
 *
 * @author anton
 */
import com.mycompany.projeto_app.projeto.gui.TelaApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tela_De_login extends JFrame {

    // Método para conectar ao banco de dados
    private Connection connect() {
        Connection conn = null;
        try {
            // URL de conexão com o banco de dados
            String url = "jdbc:mysql://127.0.0.1:3306/bibliotecaif";
            String user = "root"; // usuário do banco de dados
            String password = "neto123"; // senha do banco de dados

            // Estabelece a conexão
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return conn;
    }

    // Método para validar o login
    public boolean validateLogin(String username, String password) {
        Connection conn = connect();
        if (conn != null) {
            try {
                // Query para verificar se o usuário e senha existem no banco de dados
                String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                    return true; // Retorna true se o login for válido
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
                    return false; // Retorna false se o login for inválido
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao validar login: " + e.getMessage());
            }
        }
        return false; // Retorna false se houver erro na conexão
    }

    // Método principal para teste (opcional)
    public static void main(String[] args) {
        TelaApp login = new TelaApp();
        boolean isValid = login.validateLogin("usuario", "senha"); // Substitua com os valores reais
        if (isValid) {
            System.out.println("Login válido!");
        } else {
            System.out.println("Login inválido!");
        }
    }
}
