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
public class CadastroLivrosDTO{
    private int id_livro;
    private String titulo_livro;
    private String autor_livro;
    private int disponibilidade;

    public CadastroLivrosDTO(int id_livro, String titulo_livro, String autor_livro, int disponibilidade) {
        this.id_livro = id_livro;
        this.titulo_livro = titulo_livro;
        this.autor_livro = autor_livro;
        this.disponibilidade = disponibilidade;
        
    }

    public CadastroLivrosDTO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public CadastroLivrosDTO(int id, String nome, String email, String cargo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public void setTitulo_livro(String titulo_livro) {
        this.titulo_livro = titulo_livro;
    }

    public void setAutor_livro(String autor_livro) {
        this.autor_livro = autor_livro;
    }

    public void setDisponibilidade(int disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getId_livro() {
        return id_livro;
    }

    public String getTitulo_livro() {
        return titulo_livro;
    }

    public String getAutor_livro() {
        return autor_livro;
    }

    public int getDisponibilidade() {
        return disponibilidade;
    }
    

    @Override
    public String toString() {
        return this.getTitulo_livro();
    }

    public void add(List<FuncionariosDTO> funcionarios) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    }
    
