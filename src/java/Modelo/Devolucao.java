/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Amaranta
 */
public class Devolucao {

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private int numPedido;
    private String motivo;
    private String path;
    private String fileName;

    public Devolucao() {

    }

    public Devolucao(int id, String nome, String cpf, String email, int numPedido, String motivo, String path, String fileName) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.numPedido = numPedido;
        this.motivo = motivo;
        this.path = path;
        this.fileName = fileName;
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

    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
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
     * @return the numPedido
     */
    public int getNumPedido() {
        return numPedido;
    }

    /**
     * @param numPedido the numPedido to set
     */
    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    /**
     * @return the descricao
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the descricao to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Devolucao " + "id= " + getId()
                + "\n nome= " + nome
                + "\n cpf= " + cpf
                + "\n email= " + email
                + "\n numPedido= " + numPedido
                + "\n descricao= " + motivo
                + "\n path= " + path
                + "\n fileName= " + fileName
                + "\n";
    }
}
