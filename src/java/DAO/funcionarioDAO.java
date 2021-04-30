/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Funcionario;
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
public class funcionarioDAO {

    public boolean checkLogin(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        Connection conexao = conectaDB.getConexao();
        PreparedStatement ps = null;
        ResultSet resultado = null;
        boolean check = false;

        ps = conexao.prepareStatement("SELECT u.id, u.nome, f.sobrenome, f.registro, u.cpf, u.senha " +
                                        "FROM usuario u, funcionario f " +
                                        "WHERE f.registro = ? and u.senha = ? and u.id=f.id");
        ps.setInt(1, funcionario.getRegistro());
        ps.setString(2, funcionario.getSenha());

        resultado = ps.executeQuery();

        if (resultado.next()) {
            check = true;
            System.out.println("Usuário e senha corretos!");
        } else {
            System.out.println("Usuário ou senha incorretos!");
        }
        conexao.close();
        ps.close();
        resultado.close();

        return check;
    }

    public void cadastrar(Funcionario func) throws ClassNotFoundException, SQLException {

        try {
            Connection con = conectaDB.getConexao();

            String sql = "insert into funcionario(sobrenome, registro) values(?,?)";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, func.getSobrenome());
            comando.setInt(2, func.getRegistro());

            comando.execute();

            System.out.println("CADASTROU");
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR: " + e);
        }
    }

    public Funcionario consultarById(Integer id) {

        try {
            Connection con = conectaDB.getConexao();

            String sql = "SELECT * FROM funcionario WHERE id=? ";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();
            Funcionario f = new Funcionario();
            while (resultado.next()) {
                f.setId(resultado.getInt("id"));
                f.setSobrenome(resultado.getString("sobrenome"));
                f.setRegistro(resultado.getInt("registro"));

            }
            return f;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void RemoverFunc(Funcionario func)
            throws ClassNotFoundException, SQLException {
        try (Connection con = conectaDB.getConexao()) {
            String sql = "delete from funcionario where id = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, func.getId());

            comando.execute();
        }
    }

    public void atualizar(Funcionario func) throws ClassNotFoundException, SQLException {
        try (
                Connection con = conectaDB.getConexao()) {
            String sql = "update funcionario SET sobrenome  = ?, registro = ? WHERE id =?;";
            PreparedStatement atualizar = con.prepareStatement(sql);
            atualizar.setString(1, func.getSobrenome());
            atualizar.setInt(2, func.getRegistro());
            atualizar.setInt(3, func.getId());

            atualizar.execute();

        }

    }

    public List<Funcionario> consultarTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Funcionario> listafuncionario;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select * from funcionario";
            PreparedStatement comando = con.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();
            listafuncionario = new ArrayList<>();
            while (resultado.next()) {
                Funcionario f = new Funcionario();
                f.setId(resultado.getInt("id"));
                f.setSobrenome(resultado.getString("sobrenome"));
                f.setRegistro(resultado.getInt("registro"));

                listafuncionario.add(f);
            }

        }
        return listafuncionario;
    }
}
