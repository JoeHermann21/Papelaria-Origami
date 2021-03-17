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
import java.util.HashSet;
import java.util.List;
import model.checkout;
import model.usuario;
import model.carrinho;
import model.produto;
import util.conectaBD;

/**
 *
 * @author amaranta
 */
public class CarrinhoDAO {

    private static final String SELECT = "select * from carrinho where emailCli = ?;";

    public void Cadastrar(carrinho carrinho) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO carrinho (id, produto,qntdd, valor, emailcli ) VALUES (nextval('seq_cart'), ?, ?, ?, ?);";
        PreparedStatement ps;
        
//        produto carrinho = new produto();
//        usuario carrinho = new usuario();
        
        try {
            Connection conexao = conectaBD.getConexao();

            ps = conexao.prepareStatement(sql);

            ps.setString(1, carrinho.getProduto());
            ps.setInt(2, carrinho.getQntdd());
            ps.setDouble(3, carrinho.getValor());
            ps.setString(4, carrinho.getEmailCli());
            ps.execute();
            ps.close();

        } catch (Exception ex) {

            System.out.println("Erro - " + "Carrinho: " + ex.getMessage());

        }

    }//Cadastrar

    public List<carrinho> Listar() throws SQLException, ClassNotFoundException {

        PreparedStatement ps;
        String sql = "select * from carrinho where emailcli = ?;";

        Connection conexao = conectaBD.getConexao();

        ps = conexao.prepareStatement(sql);
        
        carrinho carrinho = new carrinho();
        
        ps.setString(1, carrinho.getEmailCli());
        
        ResultSet resultado = ps.executeQuery();

        List todosProdutos = new ArrayList<produto>();
        while (resultado.next()) {
            
            carrinho.setId(resultado.getInt("id"));
            carrinho.setProduto(resultado.getString("produto"));
            carrinho.setQntdd(resultado.getInt("qntdd"));
            carrinho.setValor(resultado.getDouble("valor"));
            carrinho.setEmailCli(resultado.getString("emailcli"));
            
            todosProdutos.add(carrinho);
        }
        ps.close();
        return todosProdutos;

    }

    public void Delete(produto prod) throws ClassNotFoundException, SQLException {

        PreparedStatement ps;
        String sql = "delete from carrinho where id = ?;";

        try {
            
            Connection conexao = conectaBD.getConexao();

            ps = conexao.prepareStatement(sql);

            ps.setInt(1, prod.getId());

            ps.execute();
            conexao.close();
        } catch (Exception e) {
        }
    }

    public carrinho SelectCart(carrinho carrinho) throws ClassNotFoundException, SQLException {
        Connection conexao = conectaBD.getConexao();
        PreparedStatement conecta = conexao.prepareStatement(SELECT);

        conecta.setString(1, carrinho.getEmailCli());
        ResultSet resultado = conecta.executeQuery();
        if (resultado.next()) {
            carrinho.setId(resultado.getInt("id"));
            carrinho.setProduto(resultado.getString("produto"));
            carrinho.setQntdd(resultado.getInt("qntdd"));
            carrinho.setValor(resultado.getDouble("valor"));
            carrinho.setEmailCli(resultado.getString("emailcli"));
        }
        conexao.close();
        return carrinho;
    }
}
