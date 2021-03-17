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
public class usuario {
    
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String repeteSenha;

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    public usuario(){
        
    }
    public usuario(int id, String email, String cpf, String senha, String nome, String repeteSenha){
        this.id= id;
        this.email = email;
        this.cpf= cpf;
        this.senha= senha;
        this.nome=nome;
        this.repeteSenha=repeteSenha;
    }

    /**
     * @return the repeteSenha
     */
    public String getRepeteSenha() {
        return repeteSenha;
    }

    /**
     * @param repeteSenha the repeteSenha to set
     */
    public void setRepeteSenha(String repeteSenha) {
        this.repeteSenha = repeteSenha;
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
