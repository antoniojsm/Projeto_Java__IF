/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_app.projeto.dto;

/**
 *
 * @author matia
 */
   public class CadastroTCCsDTO {
    
   
    private int id_TCC;
    private String titulo_tcc;
    private String autor_tcc;
    private String orientador_tcc;
    private int ano_de_defesa;
    private String resumo;

    public CadastroTCCsDTO(int id_TCC, String titulo_tcc, String autor_tcc, String orientador_tcc, int ano_de_defesa, String resumo) {
        this.id_TCC = id_TCC;
        this.titulo_tcc = titulo_tcc;
        this.autor_tcc = autor_tcc;
        this.orientador_tcc = orientador_tcc;
        this.ano_de_defesa = ano_de_defesa;
        this.resumo = resumo;
        
    }
    public void setId_TCC(int id_TCC) {
        this.id_TCC = id_TCC;
    }

    public void setTitulo_tcc(String titulo_tcc) {
        this.titulo_tcc = titulo_tcc;
    }

    public void setAutor_tcc(String autor_tcc) {
        this.autor_tcc = autor_tcc;
    }

    public void setOrientador_tcc(String orientador_tcc) {
        this.orientador_tcc = orientador_tcc;
    }
    public void setAno_de_defesa(int ano_de_defesa) {
        this.ano_de_defesa = ano_de_defesa;
    }
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }


    public int getId_TCC() {
        return id_TCC;
    }

    public String getTitulo_tcc() {
        return titulo_tcc;
    }

    public String getAutor_tcc() {
        return autor_tcc;
    }

    public String getOrientador_tcc() {
        return orientador_tcc;
    }
    public int getAno_de_defesa() {
        return ano_de_defesa;
    }

    public String getResumo() {
        return resumo;
    }

}

    

    

