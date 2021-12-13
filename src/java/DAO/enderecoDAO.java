/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Endereco;
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
public class enderecoDAO {

    public Endereco consultarById(Integer id) {

        Endereco en = null;

        try (Connection con = conectaDB.getConexao();
                PreparedStatement comando
                = con.prepareStatement("select * from endereco where id = ?");) {

            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                String cep = resultado.getString("cep");
                String uf = resultado.getString("uf");
                String cidade = resultado.getString("cidade");
                String bairro = resultado.getString("bairro");
                String logradouro = resultado.getString("logradouro");
                Integer numero = resultado.getInt("numero");
                String complemento = resultado.getString("complemento");

                en = new Endereco(id, cep, uf, cidade, bairro, logradouro, numero, complemento);
            }
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return en;
    }

    public List<Endereco> consultarTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Endereco> listaendereco;

        Endereco en = null;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select * from endereco";
            PreparedStatement comando = con.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();
            listaendereco = new ArrayList<>();
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String cep = resultado.getString("cep");
                String uf = resultado.getString("uf");
                String cidade = resultado.getString("cidade");
                String bairro = resultado.getString("bairro");
                String logradouro = resultado.getString("logradouro");
                Integer numero = resultado.getInt("numero");
                String complemento = resultado.getString("complemento");

                en = new Endereco(id, cep, uf, cidade, bairro, logradouro, numero, complemento);
                listaendereco.add(en);
            }
            con.close();
        }
        return listaendereco;
    }

    public Endereco consultarByEnderecoENumero(String logradouro, Integer numero) {

        Endereco en = null;

        try (Connection con = conectaDB.getConexao();
                PreparedStatement comando
                = con.prepareStatement("select * from endereco where logradouro = ? and numero = ?");) {

            comando.setString(1, logradouro);
            comando.setInt(2, numero);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String cep = resultado.getString("cep");
                String uf = resultado.getString("uf");
                String cidade = resultado.getString("cidade");
                String bairro = resultado.getString("bairro");
                String complemento = resultado.getString("complemento");

                en = new Endereco(id, cep, uf, cidade, bairro, logradouro, numero, complemento);
            }
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return en;
    }

    public int cadastrar(Endereco end) throws ClassNotFoundException, SQLException {
        int id = 0;
        try {
            Connection con = conectaDB.getConexao();

            String sql = "INSERT INTO public.endereco "
                    + "(cep, uf, cidade, bairro, logradouro, numero, complemento) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING id;";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, end.getCep());
            comando.setString(2, end.getUf());
            comando.setString(3, end.getCidade());
            comando.setString(4, end.getBairro());
            comando.setString(5, end.getLogradouro());
            comando.setInt(6, end.getNumero());
            comando.setString(7, end.getComplemento());

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

    public void atualizar(Endereco end) throws ClassNotFoundException, SQLException {
        try (
                Connection con = conectaDB.getConexao()) {
            String sql = "UPDATE endereco "
                    + "   SET cep=?, uf=?, cidade=?, bairro=?, logradouro=?, numero=?, complemento=? "
                    + " WHERE id = ?";

            PreparedStatement atualizar = con.prepareStatement(sql);
            atualizar.setString(1, end.getCep());
            atualizar.setString(2, end.getUf());
            atualizar.setString(3, end.getCidade());
            atualizar.setString(4, end.getBairro());
            atualizar.setString(5, end.getLogradouro());
            atualizar.setInt(6, end.getNumero());
            atualizar.setString(7, end.getComplemento());
            atualizar.setInt(8, end.getId());

            atualizar.execute();
            con.close();
        }

    }

    public void RemoverProd(Endereco end)
            throws ClassNotFoundException, SQLException {
        try (Connection con = conectaDB.getConexao()) {
            String sql = "delete from endereco where id = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, end.getId());

            comando.execute();
            con.close();
        }
    }
}
