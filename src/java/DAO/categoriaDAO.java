/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Util.conectaDB;

/**
 *
 * @author andre
 */
public class categoriaDAO {

    public Categoria consultarById(Integer id) {
        try {
            Connection con = conectaDB.getConexao();

            Categoria cat = new Categoria(id);

            String sql = "select * from categoria where id = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, cat.getId());

            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                cat.setId(resultado.getInt("id"));
                cat.setDescricao(resultado.getString("descricao"));
                cat.setSigla(resultado.getString("sigla"));
            }
            con.close();
            return cat;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Categoria consultarByDescricao(String descricao) {
        Categoria c = null;

        try (Connection con = conectaDB.getConexao();
                PreparedStatement comando
                = con.prepareStatement("SELECT id, descricao, sigla "
                        + "  FROM public.categoria "
                        + "where descricao = ? ");) {

            comando.setString(1, descricao);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String sigla = resultado.getString("sigla");

                c = new Categoria(id, descricao, sigla);
            }
            con.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    public void cadastrar(Categoria categ) throws ClassNotFoundException, SQLException {

        try {
            Connection con = conectaDB.getConexao();

            String sql = "insert into categoria(descricao, sigla) values(?,?)";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, categ.getDescricao());
            comando.setString(2, categ.getSigla());

            comando.execute();

            System.out.println("CADASTROU");
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR: " + e);
        }
    }

    public void RemoverCateg(Categoria categ)
            throws ClassNotFoundException, SQLException {
        try (Connection con = conectaDB.getConexao()) {
            String sql = "delete from categoria where id = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, categ.getId());

            comando.execute();
            con.close();
        }
    }

    public void atualizar(Categoria categ) throws ClassNotFoundException, SQLException {
        try (
                Connection con = conectaDB.getConexao()) {
            String sql = "update categoria SET descricao  = ?, sigla = ? WHERE id =?;";
            PreparedStatement atualizar = con.prepareStatement(sql);
            atualizar.setString(1, categ.getDescricao());
            atualizar.setString(2, categ.getSigla());
            atualizar.setInt(3, categ.getId());

            atualizar.execute();
            con.close();

        }

    }

    public List<Categoria> consultarTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Categoria> listacategoria;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select * from categoria ORDER BY id";
            PreparedStatement comando = con.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();
            listacategoria = new ArrayList<>();
            while (resultado.next()) {
                Categoria c = new Categoria();
                c.setId(resultado.getInt("id"));
                c.setDescricao(resultado.getString("descricao"));
                c.setSigla(resultado.getString("sigla"));

                listacategoria.add(c);
            }
            con.close();
        }
        return listacategoria;
    }

}
