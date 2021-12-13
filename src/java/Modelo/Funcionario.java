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
public class Funcionario extends Usuario {
    private int id;
    private String sobrenome;
    private int registro;

    public Funcionario() {
    }  

    public Funcionario(int id, String sobrenome, int registro) {
        this.id = id;
        this.sobrenome = sobrenome;
        this.registro = registro;
    }

    public Funcionario(int id) {
        super(id);
    }

    @Override
    public int getId() {
        return id;
    }

    
    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", sobrenome=" + sobrenome + ", registro=" + registro + '}';
    }
    
    
}
