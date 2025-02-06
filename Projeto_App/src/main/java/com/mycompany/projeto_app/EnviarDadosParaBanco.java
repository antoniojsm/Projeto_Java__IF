/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_app;

/**
 *
 * @author anton
 */
import com.mycompany.projeto_app.projeto.gui.TelaApp;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EnviarDadosParaBanco extends TelaApp {
    private final JTextField texto1;
    private final JTextField texto2;
    private final JButton botao1;

    public EnviarDadosParaBanco() {
        setTitle("Enviar Dados para o Banco");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel para organizar os componentes
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        // Campos de texto
        texto1 = new JTextField(20);
        texto2 = new JTextField(20);

        // Botão para enviar dados
        botao1 = new JButton("Enviar Dados");

        // Adiciona os componentes ao painel
        painel.add(new JLabel("Nome:"));
        painel.add(texto1);
        painel.add(new JLabel("Email:"));
        painel.add(texto2);
        painel.add(botao1);

        // Adiciona o painel ao JFrame
        add(painel);

        // Configura o listener do botão
        botao1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarDadosParaBanco();
            }
        });
    }

    private void enviarDadosParaBanco() {
        String usuario = texto1.getText();
        String senha = texto2.getText();

        if (usuario.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/teste_java", "root", "neto123")) {
            // Query SQL para inserir dados
            String sql = "INSERT INTO usuarios (usuario, senha) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Define os valores dos parâmetros
            pstmt.setString(1,usuario );
            pstmt.setString(2,senha );

            // Executa a inserção
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Dados enviados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                texto1.setText(""); // Limpa o campo
                texto2.setText(""); // Limpa o campo
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao enviar dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EnviarDadosParaBanco().setVisible(true));
    }
}
