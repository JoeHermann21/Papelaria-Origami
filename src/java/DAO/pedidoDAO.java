/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modelo.Carrinho;
import Modelo.Cliente;
import Modelo.Funcionario;
import Modelo.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.conectaDB;
/**
 *
 * @author Guilherme
 */
public class pedidoDAO {

    public void cadastrar(Pedido ped) throws ClassNotFoundException, SQLException {

        try {
            Connection con = conectaDB.getConexao();      

            String sql = "INSERT INTO pedido " +
                            " (data_compra, data_entrega, status, carrinho, cliente, funcionario) " +
                            "  VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setDate(1, (Date) ped.getDataCompra());
            comando.setDate(2, (Date) ped.getDataEntrega());
            comando.setBoolean(3, ped.isStatus());
            comando.setInt(4, ped.getCarrinho().getId());                  
            comando.setInt(5, ped.getCliente().getId());
            comando.setInt(6, ped.getFuncionario().getId());

            comando.execute();

            System.out.println("CADASTROU");
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR: " + e);
        }
    }
    
    public Pedido consultarById(Integer id) {

        Pedido p = null;
        try {
            Connection con = conectaDB.getConexao();

            String sql = "SELECT pe.id, pe.data_compra, pe.data_entrega, pe.status, pe.carrinho, pe.cliente, pe.funcionario " +
                            "  FROM pedido pe, carrinho ca, cliente cl, funcionario f" +
                             "  WHERE pe.id=? and pe.carrinho=ca.id and pe.cliente=cl.id and pe.funcionario=f.id" ;
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Date datacompra = resultado.getDate("data_compra");
                Date dataentrega = resultado.getDate("data_entrega");
                Boolean status = resultado.getBoolean("status");
                
                carrinhoDAO cdao = new carrinhoDAO();
                Carrinho carrinho = cdao.consultarById(resultado.getInt("carrinho"));
                
                clienteDAO cldao = new clienteDAO();
                Cliente cliente = cldao.consultarById(resultado.getInt("cliente"));

                funcionarioDAO fdao = new funcionarioDAO();
                Funcionario funcionario = fdao.consultarById(resultado.getInt("funcionario"));

                p = new Pedido(id, datacompra, dataentrega, status, carrinho, cliente, funcionario);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return p;
    }
    
    public void RemoverPed(Pedido ped)
            throws ClassNotFoundException, SQLException {
        try (Connection con = conectaDB.getConexao()) {
            String sql = "delete from pedido where id = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, ped.getId());

            comando.execute();
        }
    }

 public void atualizar(Pedido ped) throws ClassNotFoundException, SQLException {
        try (
                Connection con = conectaDB.getConexao()) {
            String sql = "UPDATE pedido " +
                            " SET data_compra=?, data_entrega=?, status=?, carrinho=?, cliente=?, funcionario=? " +
                                    " WHERE id=?";
            PreparedStatement atualizar = con.prepareStatement(sql);            
            atualizar.setDate(1, (Date) ped.getDataCompra());
            atualizar.setDate(2, (Date) ped.getDataEntrega());
            atualizar.setBoolean(3, ped.isStatus());
            atualizar.setInt(4, ped.getCarrinho().getId());  
            atualizar.setInt(5, ped.getCliente().getId());
            atualizar.setInt(6, ped.getFuncionario().getId());
            atualizar.setInt(7, ped.getId());

            atualizar.execute();

        }}
 
public List<Pedido> consultarTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Pedido> listapedido;
        
        Pedido pe = null;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select * from pedido";
            PreparedStatement comando = con.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();
            listapedido = new ArrayList<>();
            while (resultado.next()) {
                Integer id = resultado.getInt("id"); 
                Date datacompra = resultado.getDate("data_compra");
                Date dataentrega = resultado.getDate("data_entrega");
                Boolean status = resultado.getBoolean("status");
                
                carrinhoDAO cdao = new carrinhoDAO();
                Carrinho carrinho = cdao.consultarById(resultado.getInt("carrinho"));
                
                clienteDAO cldao = new clienteDAO();
                Cliente cliente = cldao.consultarById(resultado.getInt("cliente"));

                funcionarioDAO fdao = new funcionarioDAO();
                Funcionario funcionario = fdao.consultarById(resultado.getInt("funcionario"));

                pe = new Pedido(id, datacompra, dataentrega, status, carrinho, cliente, funcionario);
                
                
                listapedido.add(pe);
            }

        }
        return listapedido;
    }

    }

