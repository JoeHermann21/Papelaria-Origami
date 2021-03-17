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
import model.produto;
import util.conectaBD;
import model.usuario;

/**
 *
 * @author amaranta
 */
public class UsuarioDAO {
    private static final String INSERT = "INSERT INTO usuer (id, nome, cpf, email, senha, repeteSenha) VALUES (nextval('seq_usa'),?, ?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE usuario SET nome=?, email=?, cpf=?,senha=? WHERE id=?;";
    private static final String DELETAR = "DELETE FROM usuario where id=?;";
    private static final String SELECT = "select id, nome, cpf, email from usuario where nome = ?;";
    private static final String VERIFICAR = "select email from usuer where email like ('%?') and senha like('%?');";
    private static final String LISTAR = "select id, nome, cpf, email from usuario;";
    
    public void cadastrar(usuario user) throws ClassNotFoundException, SQLException {
        
            try {
            Connection conexao = conectaBD.getConexao();

            PreparedStatement conecta = conexao.prepareStatement(INSERT);
            conecta.setString(1, user.getNome());
            conecta.setString(2, user.getCpf());
            conecta.setString(3, user.getEmail());
            conecta.setString(4, user.getSenha());
            conecta.setString(5, user.getRepeteSenha());
            conecta.execute();
            conecta.close();
            } catch (SQLException e) {
            System.out.println("Erro" + e.getMessage());
        }
    }
    
public List<usuario> consultarTodos()throws ClassNotFoundException, SQLException {
        Connection conexao = conectaBD.getConexao();
        PreparedStatement conecta = conexao.prepareStatement(LISTAR);
        
        ResultSet resultado = conecta.executeQuery();

        List todosProdutos = new ArrayList<produto>();
        while (resultado.next()) {
            usuario user = new usuario();
            user.setId(resultado.getInt("id"));
            user.setNome(resultado.getString("nome"));
            user.setCpf(resultado.getString("cpf"));
            user.setEmail(resultado.getString("email"));
            todosProdutos.add(user);
        }
        conexao.close();
        return todosProdutos;
    }
    public void Delete(usuario user) throws ClassNotFoundException, SQLException {
        
        Connection conexao = conectaBD.getConexao();
        PreparedStatement conecta = conexao.prepareStatement(DELETAR);
        
        conecta.setInt(1, user.getId());
        conecta.execute();
        conexao.close();
    }

    public usuario Select(usuario user) throws ClassNotFoundException, SQLException {
        Connection conexao = conectaBD.getConexao();
        PreparedStatement conecta = conexao.prepareStatement(SELECT);
        
        conecta.setString(1, user.getNome());
        ResultSet resultado = conecta.executeQuery();
        if (resultado.next()) {
            user.setId(resultado.getInt("id"));
            user.setNome(resultado.getString("nome"));
            user.setCpf(resultado.getString("cpf"));
            user.setEmail(resultado.getString("email"));
        }
        conexao.close();
        return user;
    }

    public boolean checkLogin(usuario user) throws ClassNotFoundException, SQLException {
        Connection conexao = conectaBD.getConexao();
        PreparedStatement ps = null;
        ResultSet resultado = null;
        boolean check = false;
       
            ps = conexao.prepareStatement("select * from usuer where email = ? and senha = ?");
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getSenha());

            resultado = ps.executeQuery();

            if (resultado.next()){
                check = true;
            }
            conexao.close();
            ps.close();
            resultado.close();
        
        return check;
    }
    
    public void Update(usuario user) throws ClassNotFoundException, SQLException {
        
        Connection conexao = conectaBD.getConexao();
        PreparedStatement conecta = conexao.prepareStatement(UPDATE);
        
        conecta.setString(1, user.getNome());
        conecta.setString(2, user.getEmail());
        conecta.setString(3, user.getCpf());
        conecta.setString(4, user.getSenha());
        conecta.setInt(5, user.getId());
        
        conecta.execute();
        conexao.close();
    }
}
