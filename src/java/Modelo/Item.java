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
    private Carrinho carrinho; 
    private Pedido pedido;

    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, int quantidade, Produto produto, double valor, Carrinho carrinho) {
        this.id = id;
        this.quantidade = quantidade;
        this.produto = produto;
        this.valor = valor;
        this.carrinho = carrinho;
    }

    public Item(int id, int quantidade, Produto produto, double valor) {
        this.id = id;
        this.quantidade = quantidade;
        this.produto = produto;
        this.valor = valor;

    }
    
    public Item(int id, int quantidade, Produto produto, double valor, Carrinho carrinho, Pedido pedido) {
        this.id = id;
        this.quantidade = quantidade;
        this.produto = produto;
        this.valor = valor;
        this.carrinho = carrinho;
        this.pedido = pedido;
    }

    public Item(int id, int quantidade, Produto produto, double valor, Pedido pedido) {
        this.id = id;
        this.quantidade = quantidade;
        this.produto = produto;
        this.valor = valor;
        this.pedido = pedido;
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

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public double getValor() {
        return valor;
    }

    public void setValor() {
        this.valor = this.produto.getPreco() * this.getQuantidade();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", quantidade=" + quantidade + ", produto=" + produto + ", valor=" + valor + '}';
    }

}
