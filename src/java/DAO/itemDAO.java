/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Item;
import Modelo.Pedido;
import Modelo.Produto;
import java.sql.Connection;
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
public class itemDAO {

    public void cadastrar(Item it) throws ClassNotFoundException, SQLException {

        try {
            Connection con = conectaDB.getConexao();

            String sql = "INSERT INTO item (qtdd, produto, valor) "
                    + "VALUES (?, ?, ?) ";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, it.getQuantidade());
            comando.setInt(2, it.getProduto().getId());
            comando.setDouble(3, it.getValor());

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
            String sql = "UPDATE item " +
                            "SET qtdd=?, produto=?, valor=? " +
                            " WHERE id=?";
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
}
