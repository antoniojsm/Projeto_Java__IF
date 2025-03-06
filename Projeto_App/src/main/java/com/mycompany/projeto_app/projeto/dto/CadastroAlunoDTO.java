/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_app.projeto.dto;

/**
 *
 * @author anton
 */
public class CadastroAlunoDTO {
    private int id_aluno;
    private String cpf;
    private String nome_aluno;
    private String email_aluno;
    private String emprestimo;
    private String entrega;

    public CadastroAlunoDTO(int id_aluno, String nome_aluno, String cpf, String email_aluno, String emprestimo, String entrega) {
        this.id_aluno = id_aluno;
        this.cpf = cpf;
        this.nome_aluno = nome_aluno;
        this.email_aluno = email_aluno;
        this.emprestimo = emprestimo;
        this.entrega = entrega;
    }

    public CadastroAlunoDTO(int id, String nome_aluno, int cpf, String email_aluno, String emprestimo, String entrega) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public String getEmail_aluno() {
        return email_aluno;
    }

    public String getEmprestimo() {
        return emprestimo;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public void setEmail_aluno(String email_aluno) {
        this.email_aluno = email_aluno;
    }

    public void setEmprestimo(String emprestimo) {
        this.emprestimo = emprestimo;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

   
    
}
