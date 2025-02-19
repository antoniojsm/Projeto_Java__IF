/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_app.projeto.dto;

/**
 *
 * @author anton
 */
public class CadastroLivros{
    private int id_livro;
    private String titulo_livro;
    private String autor_livro;
    private int disponibilidade;

    public CadastroLivros(int id_livro, String titulo_livro, String autor_livro, int disponibilidade) {
        this.id_livro = id_livro;
        this.titulo_livro = titulo_livro;
        this.autor_livro = autor_livro;
        this.disponibilidade = disponibilidade;
        
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
}
