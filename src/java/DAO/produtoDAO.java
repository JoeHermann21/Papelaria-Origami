/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
import Modelo.Fabricante;
import Modelo.Produto;
import util.conectaDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class produtoDAO {
    public void cadastrar(Produto prod) throws ClassNotFoundException, SQLException {

        try {
            Connection con = conectaDB.getConexao();      

            String sql = "insert into produto(descricao, dataentrada, quantidade, preco, categoria, fabricante) values(?,?,?,?,?,?)";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, prod.getDescricao());
            comando.setDate(2, (Date) prod.getDataEntrada());
            comando.setInt(3, prod.getQuantidade());
            comando.setDouble(4, prod.getPreco());                  
            comando.setInt(5, prod.getCategoria().getId());
            comando.setInt(6, prod.getFabricante().getId());

            comando.execute();

            System.out.println("CADASTROU");
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR: " + e);
        }
    }


    public Produto consultarById(Integer id) {
        
        Produto p = null;
        
        try (Connection con = conectaDB.getConexao();
                PreparedStatement comando = 
                con.prepareStatement("select p.id, p.descricao, p.dataentrada, p.quantidade, p.preco, p.categoria, p.fabricante "
                        + "from produto p, categoria c, fabricante f " +
                            "where p.id = ? and c.id=p.categoria and f.id=p.fabricante");){
                                                    
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
                                                   
            while (resultado.next()) {          
                String descricao = resultado.getString("descricao");                
                Date dataentrada = resultado.getDate("dataentrada");
                Integer quantidade = resultado.getInt("quantidade");
                Double preco = resultado.getDouble("preco");                
                
                categoriaDAO cdao = new categoriaDAO();
                Categoria categoria = cdao.consultarById(resultado.getInt("categoria"));
                fabricanteDAO fdao = new fabricanteDAO();
                Fabricante fabricante = fdao.consultarById(resultado.getInt("fabricante"));
                
                p = new Produto(id, descricao, dataentrada, quantidade, preco, categoria, fabricante);
            }
           
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
         return p;
    }

    public void RemoverProd(Produto prod)
            throws ClassNotFoundException, SQLException {
        try (Connection con = conectaDB.getConexao()) {
            String sql = "delete from produto where id = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, prod.getId());

            comando.execute();
        }
    }

    public void atualizar(Produto prod) throws ClassNotFoundException, SQLException {
        try (
                Connection con = conectaDB.getConexao()) {
            String sql = "update  produto "
                    + "SET descricao=?, dataentrada=?, quantidade=?, preco=?, categoria=?, fabricante=? "
                    + "WHERE id =?;";      
              
            PreparedStatement atualizar = con.prepareStatement(sql);           
            atualizar.setString(1, prod.getDescricao());
            atualizar.setDate(2, (java.sql.Date) (java.util.Date) prod.getDataEntrada());
            atualizar.setInt(3, prod.getQuantidade());
            atualizar.setDouble(4, prod.getPreco());
            atualizar.setInt(5, prod.getCategoria().getId());
            atualizar.setInt(6, prod.getFabricante().getId());
            atualizar.setInt(7, prod.getId());

            atualizar.execute();

        }

    }

    public List<Produto> consultarTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Produto> listaproduto;
        
        Produto p = null;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select * from produto";
            PreparedStatement comando = con.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();
            listaproduto = new ArrayList<>();
            while (resultado.next()) {
                Integer id = resultado.getInt("id"); 
                String descricao = resultado.getString("descricao");                
                Date dataentrada = resultado.getDate("dataentrada");
                Integer quantidade = resultado.getInt("quantidade");
                Double preco = resultado.getDouble("preco");                
                
                categoriaDAO cdao = new categoriaDAO();
                Categoria categoria = cdao.consultarById(resultado.getInt("categoria"));
                fabricanteDAO fdao = new fabricanteDAO();
                Fabricante fabricante = fdao.consultarById(resultado.getInt("fabricante"));
                
                p = new Produto(id, descricao, dataentrada, quantidade, preco, categoria, fabricante);
                listaproduto.add(p);
            }

        }
        return listaproduto;
    }
    public List<Produto> consultarEsgotando() throws ClassNotFoundException, SQLException {
        ArrayList<Produto> listaEsgotando;
        
        Produto pe = null;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select * from produto where quantidade <= 20";
            PreparedStatement comando = con.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();
            listaEsgotando = new ArrayList<>();
            while (resultado.next()) {
                Integer id = resultado.getInt("id"); 
                String descricao = resultado.getString("descricao");                
                Date dataentrada = resultado.getDate("dataentrada");
                Integer quantidade = resultado.getInt("quantidade");
                Double preco = resultado.getDouble("preco");                
                
                categoriaDAO cdao = new categoriaDAO();
                Categoria categoria = cdao.consultarById(resultado.getInt("categoria"));
                fabricanteDAO fdao = new fabricanteDAO();
                Fabricante fabricante = fdao.consultarById(resultado.getInt("fabricante"));
                
                pe = new Produto(id, descricao, dataentrada, quantidade, preco, categoria, fabricante);
                listaEsgotando.add(pe);
            }

        }
        return listaEsgotando;
    }
    public Produto consultarByDescricao(String descricao) {
        
        Produto p = null;
        
        try (Connection con = conectaDB.getConexao();
                PreparedStatement comando = 
                con.prepareStatement("select p.id, p.descricao, p.dataentrada, p.quantidade, p.preco, p.categoria, p.fabricante "
                        + "from produto p, categoria c, fabricante f " +
                            "where p.descricao = ? and c.id=p.categoria and f.id=p.fabricante");){
                                                    
            comando.setString(1, descricao);
            ResultSet resultado = comando.executeQuery();
                                                   
            while (resultado.next()) {   
                Integer id = resultado.getInt("id");            
                Date dataentrada = resultado.getDate("dataentrada");
                Integer quantidade = resultado.getInt("quantidade");
                Double preco = resultado.getDouble("preco");                
                
                categoriaDAO cdao = new categoriaDAO();
                Categoria categoria = cdao.consultarById(resultado.getInt("categoria"));
                fabricanteDAO fdao = new fabricanteDAO();
                Fabricante fabricante = fdao.consultarById(resultado.getInt("fabricante"));
                
                p = new Produto(id, descricao, dataentrada, quantidade, preco, categoria, fabricante);
            }
           
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
         return p;
    }
}
