/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Usuario;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class usuarioDAO {
    
     public static String criptografar(String senha){
        try{
            MessageDigest digs = MessageDigest.getInstance("SHA-256");
            digs.update((new String(senha)).getBytes("UTF8"));
            String senhaCript = new String(digs.digest());
            return senhaCript;            
        
        }catch (Exception e){
            System.out.println("Erro ao criptografar" + e);
            return "";
        }
    
    } 

    public Usuario consultarById(Integer id) {

        Usuario u = null;

        try (Connection con = conectaDB.getConexao();
                PreparedStatement comando = con.prepareStatement("select * from usuario where id = ?");) {

            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");
                String senha = resultado.getString("senha");
                String repetesenha = resultado.getString("repetesenha");

                u = new Usuario(id, nome, cpf, senha, repetesenha);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return u;
    }
    
    public List<Usuario> consultarTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Usuario> listausuario;

        Usuario u = null;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select * from usuario";
            PreparedStatement comando = con.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();
            listausuario = new ArrayList<>();
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");
                String senha = resultado.getString("senha");
                String repetesenha = resultado.getString("repetesenha");

                u = new Usuario(id, nome, cpf, senha, repetesenha);
                listausuario.add(u);
            }

        }
        return listausuario;
    }
    
    public Usuario consultarByNome(String nome) throws ClassNotFoundException, SQLException {
        
        Usuario u = null;
        
        try (Connection con = conectaDB.getConexao();
                PreparedStatement comando = 
                con.prepareStatement("select * from usuario where nome = ? ");){
                                                    
            comando.setString(1, nome);
            ResultSet resultado = comando.executeQuery();
                                                   
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String cpf = resultado.getString("cpf");
                String senha = resultado.getString("senha");
                String repetesenha = resultado.getString("repetesenha");

                u = new Usuario(id, nome, cpf, senha, repetesenha);
            }

        }
        return u;
    }
    
    public Usuario consultarByCpf(String cpf) throws ClassNotFoundException, SQLException {
        
        Usuario u = null;
        
        try (Connection con = conectaDB.getConexao();
                PreparedStatement comando = 
                con.prepareStatement("select * from usuario where cpf = ? ");){
                                                    
            comando.setString(1, cpf);
            ResultSet resultado = comando.executeQuery();
                                                   
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String senha = resultado.getString("senha");
                String repetesenha = resultado.getString("repetesenha");

                u = new Usuario(id, nome, cpf, senha, repetesenha);
            }

        }
        return u;
    }
    
    public void cadastrar(Usuario u) throws ClassNotFoundException, SQLException {

        try {
            Connection con = conectaDB.getConexao();   


            String sql = "INSERT INTO usuario " +
                        "(nome, cpf, senha, repetesenha) " +
                        "VALUES (?, ?, ?, ?);";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, u.getNome());
            comando.setString(2, u.getCpf());       
            comando.setString(3, criptografar(u.getSenha()));
            comando.setString(4, criptografar(u.getRepeteSenha()));           

            comando.execute();

            System.out.println("CADASTROU");
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR: " + e);
        }
    }
    
    public void atualizar(Usuario u) throws ClassNotFoundException, SQLException {
        try (
                Connection con = conectaDB.getConexao()) {
            String sql = "UPDATE usuario " +
                            " SET nome=?, cpf=?, senha=?, repetesenha=? " +
                            " WHERE id=?;";      
              
            PreparedStatement atualizar = con.prepareStatement(sql);
            atualizar.setString(1, u.getNome());
            atualizar.setString(2, u.getCpf());
            atualizar.setString(3, criptografar(u.getSenha()));
            atualizar.setString(4, criptografar(u.getRepeteSenha()));  
            atualizar.setInt(5, u.getId());

            atualizar.execute();

        }

    }
    
    public void RemoverUsuario(Usuario u)
            throws ClassNotFoundException, SQLException {
        try (Connection con = conectaDB.getConexao()) {
            String sql = "delete from usuario where id = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, u.getId());

            comando.execute();
        }
    }    
    
}
