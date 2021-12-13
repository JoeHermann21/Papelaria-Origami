/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Carrinho;
import Modelo.Cliente;
import Modelo.Item;
import Modelo.Pedido;
import Modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Util.conectaDB;
import java.sql.Date;

/**
 *
 * @author Guilherme
 */
public class itemDAO {

    public void cadastrar(Item it) throws ClassNotFoundException, SQLException {

        try {
            Connection con = conectaDB.getConexao();

            String sql = "INSERT INTO item (qtdd, produto, valor, carrinho) "
                    + "VALUES (?, ?, ?, ?) ";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, it.getQuantidade());
            comando.setInt(2, it.getProduto().getId());
            comando.setDouble(3, it.getValor());
            comando.setInt(4, it.getCarrinho().getId());

            comando.execute();

            System.out.println("CADASTROU");
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR: " + e);
        }
    }

    public Item consultarById(Integer id) {

        Item i = null;
        try {
            Connection con = conectaDB.getConexao();

            String sql = "select * from item i, produto p where i.id = ? and i.produto=p.id ";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Integer quantidade = resultado.getInt("qtdd");

                produtoDAO pdao = new produtoDAO();
                Produto produto = pdao.consultarById(resultado.getInt("produto"));

                Double valor = resultado.getDouble("valor");

                i = new Item(id, quantidade, produto, valor);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    public void RemoverItem(Item it)
            throws ClassNotFoundException, SQLException {
        try (Connection con = conectaDB.getConexao()) {
            String sql = "delete from item where id = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, it.getId());

            comando.execute();
        }
    }

    public void atualizar(Item it) throws ClassNotFoundException, SQLException {
        try (
                Connection con = conectaDB.getConexao()) {
            String sql = "UPDATE item "
                    + "SET qtdd=?, produto=?, valor=? "
                    + " WHERE id=?";
            PreparedStatement atualizar = con.prepareStatement(sql);
            atualizar.setInt(1, it.getQuantidade());
            atualizar.setInt(2, it.getProduto().getId());
            atualizar.setDouble(3, it.getValor());
            atualizar.setInt(4, it.getId());

            atualizar.execute();

        }

    }

    public List<Item> consultarTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Item> listaitem;

        Item i = null;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select * from item";
            PreparedStatement comando = con.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();
            listaitem = new ArrayList<>();
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                Integer quantidade = resultado.getInt("qtdd");

                produtoDAO pdao = new produtoDAO();
                Produto produto = pdao.consultarById(resultado.getInt("produto"));

                Double valor = resultado.getDouble("valor");

                i = new Item(id, quantidade, produto, valor);
                listaitem.add(i);
            }

        }
        return listaitem;
    }

    public List<Item> consultarTodosByEmail(String email) throws SQLException, ClassNotFoundException {
        ArrayList<Item> listaitem;

        Item i = null;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select i.id, i.qtdd, i.valor, i.produto"
                    + " from item i, carrinho c "
                    + " where i.carrinho = c.id and  c.emailcli = ? and i.pedido IS NULL";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, email);
            ResultSet resultado = comando.executeQuery();
            listaitem = new ArrayList<>();
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                Integer quantidade = resultado.getInt("qtdd");

                produtoDAO pdao = new produtoDAO();
                Produto produto = pdao.consultarById(resultado.getInt("produto"));

                Double valor = resultado.getDouble("valor");

                i = new Item(id, quantidade, produto, valor);
                listaitem.add(i);
            }

        }

        return listaitem;
    }

    public List<Item> consultarTodosByCarrinhol(int idCarrinho) throws SQLException, ClassNotFoundException {
        ArrayList<Item> listaitem;

        Item i = null;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select i.id, i.qtdd, i.valor, i.produto"
                    + " from item i, carrinho c "
                    + " where i.carrinho = c.id and  c.emailcli = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, idCarrinho);
            ResultSet resultado = comando.executeQuery();
            listaitem = new ArrayList<>();
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                Integer quantidade = resultado.getInt("qtdd");

                produtoDAO pdao = new produtoDAO();
                Produto produto = pdao.consultarById(resultado.getInt("produto"));

                Double valor = resultado.getDouble("valor");

                i = new Item(id, quantidade, produto, valor);
                listaitem.add(i);
            }

        }

        return listaitem;
    }

    public void adicionarPedido(Item item) throws SQLException, ClassNotFoundException {
        try (
                Connection con = conectaDB.getConexao()) {
            String sql = "UPDATE item SET  pedido = ? WHERE id = ?";
            PreparedStatement atualizar = con.prepareStatement(sql);
            atualizar.setInt(1, item.getPedido().getId());
            atualizar.setInt(2, item.getId());

            atualizar.execute();

        }
    }

    public ArrayList<Item> intensPedido(Cliente cliente) throws SQLException, ClassNotFoundException {

        ArrayList<Item> listaItem;

        Item i = null;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = " select it.id, it.produto, it.qtdd as quantidade, it.valor, it.pedido, it.carrinho "
                    + "from item it, pedido pe "
                    + "where it.pedido = pe.id "
                    + "and pe.cliente = ?";
            PreparedStatement comando = con.prepareStatement(sql);

            comando.setInt(1, cliente.getId());
            ResultSet resultado = comando.executeQuery();
            listaItem = new ArrayList<Item>();
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                Integer quantidade = resultado.getInt("quantidade");

                produtoDAO pdao = new produtoDAO();
                Produto produto = pdao.consultarById(resultado.getInt("produto"));

                Double valor = resultado.getDouble("valor");
                
                
                pedidoDAO pedidoDao = new pedidoDAO();
                Pedido pe = pedidoDao.consultarById(resultado.getInt("pedido"));

                i = new Item(id, quantidade, produto, valor, pe);
                System.out.println(i);
                listaItem.add(i);

            }

        }
        System.out.println(listaItem);
        return listaItem;

    }

    public ArrayList<Item> itemPedido(int idPedido) throws SQLException, ClassNotFoundException {

        ArrayList<Item> listaItem;

        Item i = null;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = " select id, qtdd as quantidade, produto, valor, pedido from item where pedido = ?";
            PreparedStatement comando = con.prepareStatement(sql);

            comando.setInt(1, idPedido);
            ResultSet resultado = comando.executeQuery();
            listaItem = new ArrayList<Item>();
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                Integer quantidade = resultado.getInt("quantidade");

                produtoDAO pdao = new produtoDAO();
                Produto produto = pdao.consultarById(resultado.getInt("produto"));

                Double valor = resultado.getDouble("valor");

                // carrinhoDAO carrinhoDAO = new carrinhoDAO();
                //Carrinho carrinho = carrinhoDAO.consultarById(resultado.getInt("carrinho"));
                pedidoDAO pedidoDao = new pedidoDAO();
                Pedido pe = pedidoDao.consultarById(resultado.getInt("pedido"));

                i = new Item(id, quantidade, produto, valor, pe);
                System.out.println(i);
                listaItem.add(i);
            }

        }
        System.out.println(listaItem);
        return listaItem;

    }
}
