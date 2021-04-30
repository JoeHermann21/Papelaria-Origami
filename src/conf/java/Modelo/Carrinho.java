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
public class Carrinho {
    private int id;
    private double valor;
    private String emailcli;
    private Item item;

    public Carrinho() {
    }

    public Carrinho(int id) {
        this.id = id;
    }

    public Carrinho(int id, double valor, String emailcli, Item item) {
        this.id = id;
        this.valor = valor;
        this.emailcli = emailcli;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getEmailcli() {
        return emailcli;
    }

    public void setEmailcli(String emailcli) {
        this.emailcli = emailcli;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Carrinho{" + "id=" + id + ", valor=" + valor + ", emailcli=" + emailcli + ", item=" + item + '}';
    }
    
    
    
    

    
}
