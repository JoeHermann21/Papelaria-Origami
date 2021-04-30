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
public class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private String senha ;
    private String repeteSenha;

    public Usuario() {
    }

    public Usuario(int id) {
        this.id = id;
    }
    
    public Usuario(int id, String nome, String cpf, String senha, String repeteSenha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.repeteSenha = repeteSenha;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRepeteSenha() {
        return repeteSenha;
    }

    public void setRepeteSenha(String repeteSenha) {
        this.repeteSenha = repeteSenha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", repeteSenha=" + repeteSenha + '}';
    }

    
    
    
}
