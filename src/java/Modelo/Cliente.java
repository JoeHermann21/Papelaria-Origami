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
public class Cliente extends Usuario {
    private Integer id;
    private Integer telefone;
    private Endereco endereco;
    private Integer usuario;
    private Carrinho carrinho;
    private String email;

    public Cliente(Integer id, Integer telefone, Endereco endereco, Integer usuario, Carrinho carrinho, String email) {
        this.id = id;
        this.telefone = telefone;
        this.endereco = endereco;
        this.usuario = usuario;
        this.carrinho = carrinho;
        this.email = email;
    }

    public Cliente(Integer id, Integer telefone, Endereco endereco, Carrinho carrinho, String email) {
        this.id = id;
        this.telefone = telefone;
        this.endereco = endereco;
        this.carrinho = carrinho;
        this.email = email;
    }

    public Cliente(Integer id, Integer telefone, Endereco endereco, Carrinho carrinho, String email, String nome, String cpf) {
        super(nome, cpf);
        this.id = id;
        this.telefone = telefone;
        this.endereco = endereco;
        this.carrinho = carrinho;
        this.email = email;
        
    }
    public Cliente() {
    }

    public Cliente(Integer id) {
        this.id = id;
    }
    /**
     *
     * @return
     */
    @Override
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public String getRepeteSenha() {
        return repeteSenha;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", telefone=" + telefone + ", endereco=" + endereco + ", usuario=" + usuario + ", carrinho=" + carrinho + ", email=" + email + '}';
    }

}
