/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.checkout;
import model.produto;
import util.conectaBD;
import model.funcionario;

/**
 *
 * @author amaranta
 */
public class FuncionarioDAO {
     private static final String INSERT = "INSERT INTO funcionario (id, nome, sobrenome, registro, senha, confSenha) VALUES (nextval('seq_func'), ?, ?, ?, ?, ?);";
  
    private static final String ALTERAR = "UPDATE funcionario SET nome=?, sobrenome = ?, senha=?, confSenha=? WHERE registro=?;";

    private static final String DELETAR = "DELETE FROM funcionario where registro=?;";
    
    private static final String LISTAR = "select id, nome, sobrenome, registro from funcionario;";
    
    private static final String SELECT = "select id, nome,sobrenome, registro from funcionario where id = ?;";
    
    public void cadastrar(funcionario fun) throws ClassNotFoundException, SQLException {
        
        try {
            Connection conexao = conectaBD.getConexao();

            PreparedStatement conecta = conexao.prepareStatement(INSERT);
            // Parameters start with 1 
            conecta.setString(1, fun.getNome());
            conecta.setString(2, fun.getSobrenome());
            conecta.setInt(3, fun.getRegistro());
            conecta.setString(4, fun.getSenha());
            conecta.setString(5, fun.getConfSenha() );
            conecta.execute();
            conecta.close();
        } catch (SQLException e) {
           System.out.println("Erro"+ e.getMessage());
        }
    }
    public void Deletar(funcionario fun) throws ClassNotFoundException, SQLException {
        Connection conexao = conectaBD.getConexao();

        PreparedStatement comando = conexao.prepareStatement(DELETAR);
        comando.setInt(1, fun.getRegistro());
        comando.execute();
        conexao.close();
    }
    public void Alterar(funcionario fun) throws ClassNotFoundException, SQLException {
        Connection conexao = conectaBD.getConexao();
        PreparedStatement comando = conexao.prepareStatement(ALTERAR);
        comando.setString(1, fun.getNome());
        comando.setString(2, fun.getSobrenome());
        comando.setString(3, fun.getSenha());
        comando.setString(4, fun.getConfSenha());
        comando.setInt(5, fun.getRegistro());
        comando.execute();
        conexao.close();
    }
    public List<funcionario> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection conexao = conectaBD.getConexao();
        PreparedStatement conecta = conexao.prepareStatement(LISTAR);

        ResultSet resultado = conecta.executeQuery();

        List todosProdutos = new ArrayList<produto>();
        while (resultado.next()) {
            funcionario func = new funcionario();
            
            func.setId(resultado.getInt("id"));
            func.setNome(resultado.getString("nome"));
            func.setSobrenome(resultado.getString("sobrenome"));
            func.setRegistro(resultado.getInt("registro"));
            
        }
        conexao.close();
        return todosProdutos;
    }
    
    public funcionario Select(funcionario func) throws ClassNotFoundException, SQLException {
        Connection conexao = conectaBD.getConexao();
        PreparedStatement conecta = conexao.prepareStatement(SELECT);
        
        conecta.setInt(1, func.getId());
        ResultSet resultado = conecta.executeQuery();
        if (resultado.next()) {
            func.setId(resultado.getInt("id"));
            func.setNome(resultado.getString("nome"));
            func.setRegistro(resultado.getInt("cpf"));
            func.setSobrenome(resultado.getString("email"));
        }
        conexao.close();
        return func;
    }
}
