/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.produto;
import util.conectaBD;

/**
 *
 * @author amaranta
 */
public class ProdutoDAO {

    private static final String INSERT = "INSERT INTO produto (id, descricao, DataEntrada, fabricante,quantidade, preco) VALUES (nextval('seq_prod'), ?, ?, ?, ?, ?);";
    private static final String ALTERAR = "UPDATE produto set descricao = ?, dataentrada = ?, fabricante = ?, quantidade = ?, preco = ? WHERE id=?;";
    private static final String SELECT = "SELECT id, descricao, quantidade, dataentrada, fabricante, preco FROM produto WHERE id = ?;";
    private static final String SELECTN = "SELECT id, descricao, quantidade, dataentrada, fabricante, preco FROM produto WHERE descricao= ?;";
    private static final String DELETAR = "DELETE FROM produto where id=?";
    private static final String LISTAR = "select id, descricao, quantidade, fabricante,preco from produto;";
    private static final String LISTARMenor = "select id, descricao, quantidade, fabricante,preco from produto where quantidade <= 20;";

    public void cadastrar(produto prod) throws ClassNotFoundException, SQLException {

        try {
            Connection conexao = conectaBD.getConexao();

            PreparedStatement conecta = conexao.prepareStatement(INSERT);
            // Parameters start with 1 
            conecta.setString(1, prod.getDescricao());
            conecta.setString(2, prod.getDataEntrada());
            conecta.setString(3, prod.getFabricante());
            conecta.setInt(4, prod.getQuantidade());
            conecta.setDouble(5, prod.getPreco());
            conecta.execute();
            conecta.close();
        } catch (SQLException e) {
            System.out.println("Erro" + e.getMessage());
        }
    }
    
    public List<produto> Listar() throws SQLException, ClassNotFoundException{
        
        Connection conexao = conectaBD.getConexao();

        PreparedStatement conecta = conexao.prepareStatement(LISTAR);
        ResultSet resultado = conecta.executeQuery();
        
        List todosProdutos = new ArrayList<produto>();
        while (resultado.next()) {
            produto prod = new produto();
            prod.setId(resultado.getInt("id"));
            prod.setDescricao(resultado.getString("descricao"));
            prod.setQuantidade(resultado.getInt("quantidade"));
            //prod.setDataEntrada(resultado.getString("dataentrada"));
            prod.setFabricante(resultado.getString("fabricante"));
            prod.setPreco(resultado.getDouble("preco"));
            todosProdutos.add(prod);
        }
        conecta.close();
        return todosProdutos;
    }
    public List<produto> ListarEsgotados() throws SQLException, ClassNotFoundException{
        
        Connection conexao = conectaBD.getConexao();

        PreparedStatement conecta = conexao.prepareStatement(LISTARMenor);
        ResultSet resultado = conecta.executeQuery();
        
        List todosProdutos = new ArrayList<produto>();
        while (resultado.next()) {
            produto prod = new produto();
            prod.setId(resultado.getInt("id"));
            prod.setDescricao(resultado.getString("descricao"));
            prod.setQuantidade(resultado.getInt("quantidade"));
            //prod.setDataEntrada(resultado.getString("dataentrada"));
            prod.setFabricante(resultado.getString("fabricante"));
            prod.setPreco(resultado.getDouble("preco"));
            todosProdutos.add(prod);
        }
        conecta.close();
        return todosProdutos;
    }
    
    public void Delete(produto prod) throws ClassNotFoundException, SQLException {

        Connection conexao = conectaBD.getConexao();
        PreparedStatement conecta = conexao.prepareStatement(DELETAR);

        conecta.setInt(1, prod.getId());
        conecta.execute();
        conexao.close();
    }

    public produto Select(produto prod) throws ClassNotFoundException, SQLException {
        Connection conexao = conectaBD.getConexao();
        PreparedStatement conecta = conexao.prepareStatement(SELECT);

        conecta.setInt(1, prod.getId());
        ResultSet resultado = conecta.executeQuery();
        if (resultado.next()) {
            prod.setId(resultado.getInt("id"));
            prod.setDescricao(resultado.getString("descricao"));
            prod.setQuantidade(resultado.getInt("quantidade"));
            prod.setDataEntrada(resultado.getString("dataentrada"));
            prod.setFabricante(resultado.getString("fabricante"));
            prod.setPreco(resultado.getDouble("preco"));
        }
        conexao.close();
        return prod;
    }
    public produto SelectNome(produto prod) throws ClassNotFoundException, SQLException {
        Connection conexao = conectaBD.getConexao();
        PreparedStatement conecta = conexao.prepareStatement(SELECTN);

        conecta.setString(1, prod.getDescricao());
        ResultSet resultado = conecta.executeQuery();
        if (resultado.next()) {
            prod.setId(resultado.getInt("id"));
            prod.setDescricao(resultado.getString("descricao"));
            prod.setQuantidade(resultado.getInt("quantidade"));
            prod.setDataEntrada(resultado.getString("dataentrada"));
            prod.setFabricante(resultado.getString("fabricante"));
            prod.setPreco(resultado.getDouble("preco"));
        }
        conexao.close();
        return prod;
    }

    public void Alterar(produto prod) throws ClassNotFoundException, SQLException {

        Connection conexao = conectaBD.getConexao();
        PreparedStatement conecta = conexao.prepareStatement(ALTERAR);

        conecta.setInt(6, prod.getId());
        conecta.setString(1, prod.getDescricao());
        conecta.setInt(4, prod.getQuantidade());
        conecta.setString(2, prod.getDataEntrada());
        conecta.setString(3, prod.getFabricante());
        conecta.setDouble(5, prod.getPreco());

        conecta.execute();
        conexao.close();
    }
}
