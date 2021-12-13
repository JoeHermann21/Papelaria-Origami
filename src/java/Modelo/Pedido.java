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
public class Pedido {

    private int id;
    private Date dataCompra;
    private Date dataEntrega;
    private boolean status;
    private double valor;
    private Carrinho carrinho;
    private Cliente cliente;
    private Funcionario funcionario;
    private String numPedido;

    public Pedido() {
    }

    public Pedido(int id) {
        this.id = id;
    }

    public Pedido(int id, Date dataCompra, Date dataEntrega, boolean status, Carrinho carrinho, Cliente cliente, Funcionario funcionario, double valor) {
        this.id = id;
        this.dataCompra = dataCompra;
        this.dataEntrega = dataEntrega;
        this.status = status;
        this.carrinho = carrinho;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.valor = valor;
    }

    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }

    public Pedido(int id, Date dataCompra, Date dataEntrega, boolean status, Carrinho carrinho, Cliente cliente, double valor) {
        this.id = id;
        this.dataCompra = dataCompra;
        this.dataEntrega = dataEntrega;
        this.status = status;
        this.carrinho = carrinho;
        this.cliente = cliente;
        this.valor= valor;

    }

    public Pedido(int id, Date dataCompra, Date dataEntrega, boolean status, double valor) {
        this.id = id;
        this.dataCompra = dataCompra;
        this.dataEntrega = dataEntrega;
        this.status = status;
        this.valor = valor;
    }

    public Pedido(int id, Date dataCompra, Date dataEntrega, boolean status) {
        this.id = id;
        this.dataCompra = dataCompra;
        this.dataEntrega = dataEntrega;
        this.status = status;
    }

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", dataCompra=" + dataCompra + ", dataEntrega=" + dataEntrega + ", status=" + status + ", carrinho=" + carrinho + ", cliente=" + cliente + ", funcionario=" + funcionario + '}';
    }

}
