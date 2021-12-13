/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Funcionario;
import Modelo.Usuario;
import java.security.MessageDigest;
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
public class funcionarioDAO {
    
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

    public boolean checkLogin(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        Connection conexao = conectaDB.getConexao();
        PreparedStatement ps = null;
        ResultSet resultado = null;
        boolean check = false;

        ps = conexao.prepareStatement("SELECT id, nome, sobrenome, registro, cpf, senha " +
                                        "FROM funcionario " +
                                        "WHERE registro = ? and senha = ? ");
        ps.setInt(1, funcionario.getRegistro());
        ps.setString(2, criptografar(funcionario.getSenha()));

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

            String sql = "insert into funcionario(nome, sobrenome, registro , cpf, senha, repetesenha) values(?,?,nextval('seq_registro'),?,?,?)";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, func.getNome());
            comando.setString(2, func.getSobrenome());
            //comando.setInt(3, func.getRegistro());
            comando.setString(3, func.getCpf());
            comando.setString(4, criptografar(func.getSenha()));
            comando.setString(5, criptografar(func.getRepeteSenha()));

            comando.execute();

            System.out.println("CADASTROU");
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR: " + e);
        }
    }

    public Funcionario consultarById(Integer id) {

        try {
            Connection con = conectaDB.getConexao();

            String sql = "SELECT * FROM funcionario WHERE id= ? ";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();
            Funcionario f = new Funcionario();
            while (resultado.next()) {
                f.setSobrenome(resultado.getString("sobrenome"));
                f.setRegistro(resultado.getInt("registro"));
                f.setNome(resultado.getString("nome"));
                f.setCpf(resultado.getString("cpf"));
            }
            return f;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Funcionario consultarByReg(Integer registro) {

        try {
            Connection con = conectaDB.getConexao();

            String sql = "SELECT * FROM funcionario WHERE registro= ? ";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, registro);

            ResultSet resultado = comando.executeQuery();
            Funcionario f = new Funcionario();
            while (resultado.next()) {
                f.setSobrenome(resultado.getString("sobrenome"));
                //f.setRegistro(resultado.getInt("registro"));
                f.setNome(resultado.getString("nome"));
                //f.setCpf(resultado.getString("cpf"));

            }
            return f;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public Funcionario consultarByCPF(String cpf) {

        try {
            Connection con = conectaDB.getConexao();

            String sql = "SELECT cpf FROM funcionario WHERE cpf= ? ";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, cpf);

            ResultSet resultado = comando.executeQuery();
            Funcionario f = new Funcionario();
            while (resultado.next()) {
                f.setCpf(resultado.getString("cpf"));

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
            String sql = "update funcionario SET nome = ?, sobrenome  = ?, cpf = ?, registro = ?, senha = ?, repetesenha = ? WHERE id =?;";
            PreparedStatement atualizar = con.prepareStatement(sql);
            atualizar.setString(1, func.getNome());
            atualizar.setString(2, func.getSobrenome());
            atualizar.setString(3, func.getCpf());
            atualizar.setInt(4, func.getRegistro());
            atualizar.setString(5, criptografar(func.getSenha()));
            atualizar.setString(6, criptografar(func.getRepeteSenha()));  
            atualizar.setInt(7, func.getId());

            atualizar.execute();

        }

    }

    public List<Funcionario> consultarTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Funcionario> listafuncionario;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "SELECT id, nome, sobrenome, registro, cpf FROM funcionario ORDER BY id";
            PreparedStatement comando = con.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();
            listafuncionario = new ArrayList<>();
            while (resultado.next()) {
                Funcionario f = new Funcionario();
                f.setId(resultado.getInt("id"));
                f.setSobrenome(resultado.getString("sobrenome"));
                f.setRegistro(resultado.getInt("registro"));
                f.setNome(resultado.getString("nome"));
                f.setCpf(resultado.getString("cpf"));

                listafuncionario.add(f);
            }

        }
        return listafuncionario;
    }
    
    public List<Funcionario> listByDescricao(String descricao) throws ClassNotFoundException, SQLException {
        ArrayList<Funcionario> listaCategoriaDesc;

        try (
            Connection con = conectaDB.getConexao()) {

            String sql = "SELECT * FROM funcionario WHERE nome ilike '"+descricao+"%' or cpf ilike '"+descricao+"%' ";
            PreparedStatement comando = con.prepareStatement(sql);
                        
            ResultSet resultado = comando.executeQuery();
            
            listaCategoriaDesc = new ArrayList<>();
            while (resultado.next()) {
                Funcionario f = new Funcionario();
                f.setId(resultado.getInt("id"));
                f.setSobrenome(resultado.getString("sobrenome"));
                f.setRegistro(resultado.getInt("registro"));
                f.setNome(resultado.getString("nome"));
                f.setCpf(resultado.getString("cpf"));
                
                listaCategoriaDesc.add(f);
            }

        }
        return listaCategoriaDesc;
    }
}
