/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Carrinho;
import Modelo.Cliente;
import Modelo.Endereco;
import Modelo.Funcionario;
import Modelo.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Util.conectaDB;

/**
 *
 * @author Guilherme
 */
public class pedidoDAO {

    public int cadastrar(Pedido ped) throws ClassNotFoundException, SQLException {
        int id = 0;
        try {
            Connection con = conectaDB.getConexao();

            String sql = "INSERT INTO pedido"
                    + " (data_compra, data_entrega, status, cliente, valor )"
                    + "  VALUES (?, ?, ?, ?, ?) RETURNING id";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setDate(1, (Date) ped.getDataCompra());
            comando.setDate(2, (Date) ped.getDataEntrega());
            comando.setBoolean(3, ped.isStatus());
            // comando.setInt(4, ped.getCarrinho().getId());
            comando.setInt(4, ped.getCliente().getId());
            //comando.setInt(6, ped.getFuncionario().getId());
            comando.setDouble(5, ped.getValor());

            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                id = resultado.getInt("id");
            }

            System.out.println("CADASTROU");
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR: " + e);
        }
        return id;
    }

    public Pedido consultarById(Integer id) {

        Pedido p = null;
        try {
            Connection con = conectaDB.getConexao();

            String sql = "SELECT * FROM pedido where id = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Date datacompra = resultado.getDate("data_compra");
                Date dataentrega = resultado.getDate("data_entrega");
                Boolean status = resultado.getBoolean("status");
                Double valor = resultado.getDouble("valor");

                carrinhoDAO cdao = new carrinhoDAO();
                Carrinho carrinho = cdao.consultarById(resultado.getInt("carrinho"));

                clienteDAO cldao = new clienteDAO();
                Cliente cliente = cldao.consultarById(resultado.getInt("cliente"));

                // funcionarioDAO fdao = new funcionarioDAO();
                // Funcionario funcionario = fdao.consultarById(resultado.getInt("funcionario"));
                p = new Pedido(id, datacompra, dataentrega, status, carrinho, cliente, valor);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    public ArrayList<Pedido> consultarByClienteId(int idCliente) throws ClassNotFoundException, SQLException {
        ArrayList<Pedido> listapedido;

        Pedido pe = null;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select pe.id, pe.data_compra, pe.data_entrega, pe.status, it.produto, it.valor, it.qtdd "
                    + "from pedido pe, item it "
                    + "where pe.cliente = ? and it.pedido = pe.id";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, idCliente);
            ResultSet resultado = comando.executeQuery();
            listapedido = new ArrayList<>();
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                Date datacompra = resultado.getDate("data_compra");
                Date dataentrega = resultado.getDate("data_entrega");
                Boolean status = resultado.getBoolean("status");
                Double valor = resultado.getDouble("valor");

                //carrinhoDAO cdao = new carrinhoDAO();
             //   Carrinho carrinho = cdao.consultarById(resultado.getInt("carrinho"));

               // clienteDAO cldao = new clienteDAO();
                //Cliente cliente = cldao.consultarById(resultado.getInt("cliente"));

               // funcionarioDAO fdao = new funcionarioDAO();
               // Funcionario funcionario = fdao.consultarById(resultado.getInt("funcionario"));

                pe = new Pedido(id, datacompra, dataentrega, status);

                listapedido.add(pe);
            }

        }
        return listapedido;
    }

    public ArrayList<Pedido> consultarByCliente(int idCliente) throws ClassNotFoundException, SQLException {
        ArrayList<Pedido> listapedido;

        Pedido pe = null;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select * from pedido where cliente = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, idCliente);
            ResultSet resultado = comando.executeQuery();
            listapedido = new ArrayList<>();
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                Date datacompra = resultado.getDate("data_compra");
                Date dataentrega = resultado.getDate("data_entrega");
                Boolean status = resultado.getBoolean("status");
                Double valor = resultado.getDouble("valor");

                carrinhoDAO cdao = new carrinhoDAO();
                Carrinho carrinho = cdao.consultarById(resultado.getInt("carrinho"));

                clienteDAO cldao = new clienteDAO();
                Cliente cliente = cldao.consultarById(resultado.getInt("cliente"));

               // funcionarioDAO fdao = new funcionarioDAO();
               // Funcionario funcionario = fdao.consultarById(resultado.getInt("funcionario"));

                pe = new Pedido(id, datacompra, dataentrega, status, carrinho, cliente, valor);

                listapedido.add(pe);
            }

        }
        return listapedido;
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
            String sql = "UPDATE pedido "
                    + " SET data_compra=?, data_entrega=?, status=?, carrinho=?, cliente=?, funcionario=? "
                    + " WHERE id=?";
            PreparedStatement atualizar = con.prepareStatement(sql);
            atualizar.setDate(1, (Date) ped.getDataCompra());
            atualizar.setDate(2, (Date) ped.getDataEntrega());
            atualizar.setBoolean(3, ped.isStatus());
            atualizar.setInt(4, ped.getCarrinho().getId());
            atualizar.setInt(5, ped.getCliente().getId());
            atualizar.setInt(6, ped.getFuncionario().getId());
            atualizar.setInt(7, ped.getId());

            atualizar.execute();

        }
    }

    public ArrayList<Pedido> consultarTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Pedido> listapedido;

        Pedido pe = null;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select * from pedido where cliente is not null and valor is not null and data_entrega is not null";
            PreparedStatement comando = con.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();
            listapedido = new ArrayList<>();
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                Date datacompra = resultado.getDate("data_compra");
                Date dataentrega = resultado.getDate("data_entrega");
                Boolean status = resultado.getBoolean("status");
                Double valor = resultado.getDouble("valor");                
                Carrinho carrinho = new Carrinho();
                carrinho.setId(resultado.getInt("carrinho"));

                clienteDAO cldao = new clienteDAO();
                Cliente cliente = cldao.consultarById(resultado.getInt("cliente"));

                pe = new Pedido(id, datacompra, dataentrega, status, carrinho, cliente, valor);

                listapedido.add(pe);
            }
            con.close();
        }
        return listapedido;
    }
    
    public ArrayList<Pedido> consultarTodosPedidosCli() throws ClassNotFoundException, SQLException {
        ArrayList<Pedido> listapedido;

        Pedido pe = null;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select pe.id, cli.email, ed.id as idEnd, ed.cep, ed.uf, ed.cidade, ed.bairro, ed.logradouro, ed.numero, ed.complemento from pedido pe, cliente cli, endereco ed " 
                    +   "where pe.status= 'false' and pe.cliente = cli.id and cli.endereco = ed.id order by pe.id DESC";
            PreparedStatement comando = con.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();
            listapedido = new ArrayList<>();
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String email = resultado.getString("email");                
                String cep = resultado.getString("cep");
                String uf = resultado.getString("uf");
                String cidade = resultado.getString("cidade");
                String bairro = resultado.getString("bairro");
                String logradouro = resultado.getString("logradouro");
                Integer numero = resultado.getInt("numero");
                String complemento = resultado.getString("complemento");
                
                Cliente cliente = new Cliente();
                cliente.setEmail(email);
                Endereco end = new Endereco(id, cep, uf, cidade, bairro, logradouro, numero, complemento);
                
                cliente.setEndereco(end);
                pe = new Pedido(id, cliente);

                listapedido.add(pe);
            }
            con.close();
        }
        return listapedido;
    }
     public void atualizarStatus (Pedido ped) throws ClassNotFoundException, SQLException {
        try (
                Connection con = conectaDB.getConexao()) {
            String sql = "UPDATE pedido "
                    + " SET status= 'true' "
                    + " WHERE id=?";
            PreparedStatement atualizar = con.prepareStatement(sql);                 
            atualizar.setInt(1, ped.getId());

            atualizar.execute();

        }
    }
}
