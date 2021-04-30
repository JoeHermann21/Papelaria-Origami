/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Guilherme
 */
public class Produto {
    private int id;
    private String descricao;
    private Date dataEntrada;    
    private int quantidade;
    private double preco;     
    private Categoria categoria;
    private Fabricante fabricante;

    public Produto() {
    }

    public Produto(int id, String descricao, Date dataEntrada, int quantidade, double preco, Categoria categoria, Fabricante fabricante) {
        this.id = id;
        this.descricao = descricao;
        this.dataEntrada = dataEntrada;
        this.quantidade = quantidade;
        this.preco = preco;
        this.categoria = categoria;
        this.fabricante = fabricante;
    }

    public Produto(int id) {
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

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto " + "id= " + id 
                + "\n descricao= " + descricao + 
                "\n dataEntrada= " + dataEntrada + 
                "\n quantidade= " + quantidade + 
                "\n preco= " + preco + 
                "\n categoria= " + categoria + 
                "\n fabricante= " + fabricante + 
                "\n ";
    }
    
    
    
}
