/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Devolucao;
import Util.conectaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amaranta
 */
public class devolucaoDAO {

    public void cadastrarDevolucao(Devolucao dev) throws ClassNotFoundException, SQLException {

        try {
            Connection con = conectaDB.getConexao();

            String sql = "insert into devolucao(nome, cpf, email, numpedido, motivo, path, filename) values(?,?,?,?,?,?,?)";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, dev.getNome());
            comando.setString(2, dev.getCpf());
            comando.setString(3, dev.getEmail());
            comando.setInt(4, dev.getNumPedido());
            comando.setString(5, dev.getMotivo());
            comando.setString(6, dev.getPath());
            comando.setString(7, dev.getFileName());

            comando.execute();

            System.out.println("CADASTROU");
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR: " + e);
        }
    }

    public List<Devolucao> consultarTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Devolucao> listacategoria;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select * from devolucao ORDER BY id";
            PreparedStatement comando = con.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();
            listacategoria = new ArrayList<>();
            while (resultado.next()) {
                Devolucao d = new Devolucao();
                d.setId(resultado.getInt("id"));
                d.setNumPedido(resultado.getInt("numPedido"));
                d.setNome(resultado.getString("nome"));
                d.setEmail(resultado.getString("email"));
                d.setCpf(resultado.getString("cpf"));
                d.setMotivo(resultado.getString("motivo"));
                d.setPath(resultado.getString("path"));
                d.setFileName(resultado.getString("filename"));

                listacategoria.add(d);
            }

        }
        return listacategoria;
    }

    public List<Devolucao> listByDescricao(String nomeCli) throws ClassNotFoundException, SQLException {
        ArrayList<Devolucao> listaDevolucao;

        Devolucao d = null;
        listaDevolucao = new ArrayList<>();
        try (Connection con = conectaDB.getConexao();
                PreparedStatement comando
                = con.prepareStatement("SELECT * FROM devolucao WHERE nome ilike '" + nomeCli + "%'");) {

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");
                String email = resultado.getString("email");
                Integer numeroPedido = resultado.getInt("numPedido");
                String motivo = resultado.getString("motivo");
                String path = resultado.getString("path");
                String fileName = resultado.getString("filename");

                d = new Devolucao(id, nome, cpf, email, numeroPedido, motivo, path, fileName);
                listaDevolucao.add(d);
            }

        }
        return listaDevolucao;
    }

    public String retornarCaminho(Integer id) throws SQLException, ClassNotFoundException {

        String caminho = null;

        try (Connection con = conectaDB.getConexao();
                PreparedStatement comando
                = con.prepareStatement("select path from devolucao where id = ?;");) {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                caminho = resultado.getString("path");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return caminho;
    }

    public Devolucao consultarById(Integer id) {

        Devolucao d = null;

        try (Connection con = conectaDB.getConexao();
                PreparedStatement comando
                = con.prepareStatement("select * from devolucao where id = " + id + "");) {

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                Integer numeroPedido = resultado.getInt("numpedido");
                String cpf = resultado.getString("cpf");
                String motivo = resultado.getString("motivo");
                String path = resultado.getString("path");
                String fileName = resultado.getString("filename");

                d = new Devolucao(id, nome, cpf, email, numeroPedido, motivo, path, fileName);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return d;
    }
}
