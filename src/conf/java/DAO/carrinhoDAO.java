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
import util.conectaDB;
/**
 *
 * @author Guilherme
 */
public class carrinhoDAO {
    public void cadastrar(Carrinho carri) throws ClassNotFoundException, SQLException {

        try {
            Connection con = conectaDB.getConexao();      

            String sql = "INSERT INTO carrinho (valor, emailcli, item) VALUES (?, ?, ?)";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setDouble(1, carri.getValor());
            comando.setString(2,  carri.getEmailcli());
            comando.setInt(3, carri.getItem().getId());
            
            comando.execute();

            System.out.println("CADASTROU");
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR: " + e);
        }
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
                
                c = new Carrinho(id, valor, emailcliente, item);
                
            }
            
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
        }
    }
    
    public void atualizar(Carrinho carri) throws ClassNotFoundException, SQLException {
        try (
                Connection con = conectaDB.getConexao()) {
            String sql = "update carrinho SET valor  = ?, emailcli = ?, item =? WHERE id =?";
            PreparedStatement atualizar = con.prepareStatement(sql);
            atualizar.setDouble(1, carri.getValor());
            atualizar.setString(2, carri.getEmailcli());
            atualizar.setInt(3,  carri.getItem().getId());
            atualizar.setInt(4,  carri.getId());
            

            atualizar.execute();

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
                
                c = new Carrinho(id, valor, emailcliente, item);
                
                listacarrinho.add(c);
            }

        }
        return listacarrinho;
    }
    }


