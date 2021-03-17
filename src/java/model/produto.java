/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.sql.Date;

/**
 *
 * @author amaranta
 */
public class produto {

    private int id; 
    private String descricao;
    private String DataEntrada;
    private String fabricante;
    private int quantidade;
    private double preco;
   
    public produto() { 

    }

    public produto(int id, String descricao,  String DataEntrada, String fabricante, int quantidade, double preco) {
       
        this.id = id;
        this.descricao = descricao;
        this.DataEntrada = DataEntrada;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
        this.preco= preco;
    }
    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the DataEntrada
     */
    public  String getDataEntrada() {
        return DataEntrada;
    }

    /**
     * @param DataEntrada the DataEntrada to set
     */
    public void setDataEntrada( String DataEntrada) {
        this.DataEntrada = DataEntrada;
    }

    /**
     * @return the fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
