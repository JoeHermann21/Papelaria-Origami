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
public class Item {
    private int id;
    private int quantidade;
    private Produto produto;
    private double valor;

    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }
    
    

    public Item(int id, int quantidade, Produto produto, double valor) {
        this.id = id;
        this.quantidade = quantidade;
        this.produto = produto;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", quantidade=" + quantidade + ", produto=" + produto + ", valor=" + valor + '}';
    }
    
    
    
}
