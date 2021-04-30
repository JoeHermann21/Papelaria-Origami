/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Guilherme
 */
public class Fabricante {
    private int id;
    private String descricao;
    private String sigla;
    private String cnpj;

    public Fabricante() {
    }

    public Fabricante(int id, String descricao, String sigla, String cnpj) {
        this.id = id;
        this.descricao = descricao;
        this.sigla = sigla;
        this.cnpj = cnpj;
    }
    
    public Fabricante(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Fabricante{" + "id=" + id + ", descricao=" + descricao + ", sigla=" + sigla + ", cnpj=" + cnpj + '}';
    }

    
       
}
