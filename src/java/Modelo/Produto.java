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
public class Produto {

    private int id;
    private String titulo;
    private String descricao;
    private Date dataEntrada;
    private int quantidade;
    private double peso;
    private String material;
    private int uniEmbalagem;
    private String cor;
    private String dimensao;
    private double preco;
    private Categoria categoria;
    private Fabricante fabricante;
    private int quantidadeMinima;
    private String path;
    private String fileName;

    public Produto() {
    }

    public Produto(int id, String titulo, String descricao, Date dataEntrada, int quantidade,
            Double peso, String material, int uniEmbalagem, String cor, String dimensao,
            double preco, Categoria categoria,
            Fabricante fabricante, int quantidadeMinima, String path, String fileName) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrada = dataEntrada;
        this.quantidade = quantidade;
        this.peso = peso;
        this.material = material;
        this.uniEmbalagem = uniEmbalagem;
        this.cor = cor;
        this.dimensao = dimensao;
        this.preco = preco;
        this.path = path;
        this.fileName = fileName;
        this.categoria = categoria;
        this.fabricante = fabricante;
        this.quantidadeMinima = quantidadeMinima;
    }

    public Produto(int idProduto, String titulo, String descricao, Date dataentrada, int quantidade, Double peso, int uniEmbalagem, String cor, String dimensao, Double preco, String path, String fileName,
            Categoria categoria, Fabricante fabricante) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrada = dataEntrada;
        this.quantidade = quantidade;
        this.peso = peso;
        this.material = material;
        this.uniEmbalagem = uniEmbalagem;
        this.cor = cor;
        this.dimensao = dimensao;
        this.preco = preco;
        this.path = path;
        this.fileName = fileName;
        this.categoria = categoria;
        this.fabricante = fabricante;
        this.quantidadeMinima = quantidadeMinima;
    }

    public Produto(int id, int quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the material
     */
    public String getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * @return the uniEmbalagem
     */
    public int getUniEmbalagem() {
        return uniEmbalagem;
    }

    /**
     * @param uniEmbalagem the uniEmbalagem to set
     */
    public void setUniEmbalagem(int uniEmbalagem) {
        this.uniEmbalagem = uniEmbalagem;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the dimensao
     */
    public String getDimensao() {
        return dimensao;
    }

    /**
     * @param dimensao the dimensao to set
     */
    public void setDimensao(String dimensao) {
        this.dimensao = dimensao;
    }

    public Produto(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Produto " + "id= " + id
                + "\n descricao= " + descricao
                + "\n dataEntrada= " + dataEntrada
                + "\n quantidade= " + quantidade
                + "\n preco= " + preco
                + "\n categoria= " + categoria
                + "\n fabricante= " + fabricante
                + "\n quantidadeMinima= " + quantidadeMinima
                + "\n path= " + path
                + "\n fileName= " + fileName
                + "\n material= " + material
                + "\n material= " + uniEmbalagem
                + "\n material= " + cor
                + "\n material= " + dimensao
                + "\n titulo= " + titulo;
    }

}
