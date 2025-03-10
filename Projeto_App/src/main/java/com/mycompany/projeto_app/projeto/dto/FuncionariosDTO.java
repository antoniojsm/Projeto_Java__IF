/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_app.projeto.dto;

import java.util.List;

/**
 *
 * @author anton
 */
public class FuncionariosDTO {
    private int id_funcionario;
    private String nome_funcionario;
    private String email_funcionario;
    private String cargo;

    public FuncionariosDTO(int id_funcionario, String nome_funcionario, String email_funcionario,
            String cargo) {
        this.id_funcionario = id_funcionario;
        this.nome_funcionario = nome_funcionario;
        this.email_funcionario = email_funcionario;
        this.cargo = cargo;

    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public String getEmail_funcionario() {
        return email_funcionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public void setEmail_funcionario(String email_funcionario) {
        this.email_funcionario = email_funcionario;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void add(List<FuncionariosDTO> funcionarios) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

}
