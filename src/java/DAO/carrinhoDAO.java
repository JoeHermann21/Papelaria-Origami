/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Carrinho;
import Modelo.Item;
import java.sql.Connection;
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
public class carrinhoDAO {

    public int cadastrar(Carrinho carri) throws ClassNotFoundException, SQLException {
        int id = 0;
        try {
            Connection con = conectaDB.getConexao();

            String sql = "INSERT INTO carrinho (valor, emailcli) VALUES (?, ?) RETURNING id;";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setDouble(1, carri.getValor());
            comando.setString(2, carri.getEmailcli());

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

    public Carrinho consultarById(Integer id) {

        Carrinho c = null;
        try {
            Connection con = conectaDB.getConexao();

            String sql = "select * from carrinho ca, cliente cl "
                    + "where ca.id = ? and ca.emailcli=cl.email ";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Double valor = resultado.getDouble("valor");

                String emailcliente = resultado.getString("emailcli");

                itemDAO idao = new itemDAO();
                Item item = idao.consultarById(resultado.getInt("item"));

                //  c = new Carrinho(id, valor, emailcliente, item);
            }
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    public Carrinho consultarByEmail(String email) {
        Carrinho c = null;

        try {
            Connection con = conectaDB.getConexao();

            String sql = "select * from carrinho where emailcli = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, email);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");

                Double valor = resultado.getDouble("valor");

                String emailcliente = resultado.getString("emailcli");

                itemDAO idao = new itemDAO();
                Item item = idao.consultarById(resultado.getInt("item"));

                c = new Carrinho(id, valor, emailcliente);
            }
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    public void RemoverCarri(Carrinho carri)
            throws ClassNotFoundException, SQLException {
        try (Connection con = conectaDB.getConexao()) {
            String sql = "delete from carrinho where id = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, carri.getId());

            comando.execute();
            con.close();
        }
    }

    public void atualizar(Carrinho carri) throws ClassNotFoundException, SQLException {
        try (
                Connection con = conectaDB.getConexao()) {
            String sql = "update carrinho SET valor  = ?, emailcli = ? WHERE id =?";
            PreparedStatement atualizar = con.prepareStatement(sql);
            atualizar.setDouble(1, carri.getValor());
            atualizar.setString(2, carri.getEmailcli());
            //   atualizar.setInt(3, carri.getItem().getId());
            atualizar.setInt(3, carri.getId());

            atualizar.execute();
            con.close();

        }
    }

    public List<Carrinho> consultarTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Carrinho> listacarrinho;

        Carrinho c = null;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select * from carrinho";
            PreparedStatement comando = con.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();
            listacarrinho = new ArrayList<>();
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                Double valor = resultado.getDouble("valor");

                String emailcliente = resultado.getString("emailcli");

                itemDAO idao = new itemDAO();
                Item item = idao.consultarById(resultado.getInt("item"));

                //       c = new Carrinho(id, valor, emailcliente, item);
                listacarrinho.add(c);

            }

            con.close();

        }
        return listacarrinho;
    }

    public boolean checarCarrinho(String email) throws SQLException, ClassNotFoundException {
        Connection conexao = conectaDB.getConexao();
        PreparedStatement ps = null;
        ResultSet resultado = null;
        boolean check = false;

        ps = conexao.prepareStatement("select * from carrinho where emailcli = ?");

        ps.setString(1, email);

        resultado = ps.executeQuery();

        if (resultado.next()) {
            check = true;
            System.out.println("Carrinho existe!");
        } else {
            System.out.println("Carrinho não existe!");
        }

        conexao.close();
        ps.close();
        resultado.close();

        return check;
    }
}