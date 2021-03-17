/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author amaranta
 */
public class categoria {
    private int Id;
    private String descricao;
    private String sigla;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
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

    public categoria(){
        
    }
    public categoria(int Id, String descricao, String sigla){
        this.Id=Id;
        this.descricao=descricao;
        this.sigla=sigla;
    }
}
