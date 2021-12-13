/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class Carrinho {

    private int id;
    private double valor;
    private String emailcli;
    private List<Item> itemArray = new ArrayList<>();
   

    public Carrinho() {
    }

    public Carrinho(int id) {
        this.id = id;
    }

    public Carrinho(int id, double valor, String emailcli) {
        this.id = id;
        this.valor = valor;
        this.emailcli = emailcli;
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

    public List<Item> getItemArray() {
        return itemArray;
    }

    public void setItemArray(List<Item> itemArray) {
        this.itemArray = itemArray;
    }    
     public void addItem(Item item){
         this.itemArray.add(item);
     }  
    public void removerItem(int id){
        for(int i=0; i< this.itemArray.size(); i++){
            Item it = this.itemArray.get(i);
            if(id == it.getId()){
                this.itemArray.remove(it);
                break;
            }            
        }
    }
    
    public void valorCarrinho(){
        
        for(int i = 0; i<this.itemArray.size(); i++){
            Item it = this.itemArray.get(i);
            this.valor += it.getValor();
        }
    }

  //  @Override
  //  public String toString() {
   //     return "Carrinho{" + "id=" + id + ", valor=" + valor + ", emailcli=" + emailcli + ", item=" + itemArray.get + '}';
  //  }

}
