/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.funcionarioDAO.criptografar;
import Modelo.Carrinho;
import Modelo.Cliente;
import Modelo.Endereco;
import Modelo.Funcionario;
import Modelo.Pedido;
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
public class clienteDAO {

    public static String criptografar(String senha) {
        try {
            MessageDigest digs = MessageDigest.getInstance("SHA-256");
            digs.update((new String(senha)).getBytes("UTF8"));
            String senhaCript = new String(digs.digest());
            return senhaCript;

        } catch (Exception e) {
            System.out.println("Erro ao criptografar" + e);
            return "";
        }

    }
    private static final String INSERT = "INSERT INTO cliente (id, email, senha, repeteSenha, nome, cpf)"
            + " VALUES (nextval('seq_cliente'), ?, ?, ?, ?, ?)";

    public void cadastrar(Cliente cliente) throws ClassNotFoundException, SQLException {

        try {
            Connection conexao = conectaDB.getConexao();

            PreparedStatement conecta = conexao.prepareStatement(INSERT);
            conecta.setString(1, cliente.getEmail());
            conecta.setString(2, criptografar(cliente.getSenha()));
            conecta.setString(3, criptografar(cliente.getRepeteSenha()));
            conecta.setString(4, (cliente.getNome()));
            conecta.setString(5, (cliente.getCpf()));

            conecta.execute();
            System.out.println("CADASTROU");
            conexao.close();
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR: " + e);
        }
    }

    public boolean checkLogin(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection conexao = conectaDB.getConexao();
        PreparedStatement ps = null;
        ResultSet resultado = null;
        boolean check = false;

//        ps = conexao.prepareStatement("SELECT cl.id, cl.telefone, cl.endereco, cl.usuario, cl.carrinho, cl.email "
//                + "FROM cliente cl, usuario u, carrinho ca "
//                + "where cl.email = ? and u.senha = ? "
//                + "and cl.usuario=u.id and cl.carrinho=ca.id ");
        ps = conexao.prepareStatement("select * from cliente where email = ? and senha = ?");

        ps.setString(1, cliente.getEmail());
        ps.setString(2, criptografar(cliente.getSenha()));

        resultado = ps.executeQuery();

        if (resultado.next()) {
            check = true;
            System.out.println("Email e senha corretos!");
        } else {
            System.out.println("Email ou senha incorretos!");
        }

        conexao.close();
        ps.close();
        resultado.close();

        return check;
    }

    public Cliente consultarByEmail(String email) {

        try {
            Connection con = conectaDB.getConexao();

            String sql = "SELECT * FROM cliente where email = ?";

            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, email);

            ResultSet resultado = comando.executeQuery();
            Cliente c = new Cliente();
            while (resultado.next()) {

                Integer id = resultado.getInt("id");

                Integer telefone = resultado.getInt("telefone");

                Endereco endereco = new Endereco();
                enderecoDAO enderecodao = new enderecoDAO();

                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");

                if (resultado.getInt("endereco") != 0) {
                    endereco = enderecodao.consultarById(resultado.getInt("endereco"));
                }

                // Integer usuario = resultado.getInt("usuario");
                Carrinho carrinho = new Carrinho();
                carrinhoDAO carrinhodao = new carrinhoDAO();
                if (resultado.getInt("carrinho") != 0) {
                    carrinho = carrinhodao.consultarById(resultado.getInt("carrinho"));
                }

                c = new Cliente(id, telefone, endereco, carrinho, email, nome, cpf);

            }
            con.close();
            return c;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente consultarById(Integer id) {

        try {
            Connection con = conectaDB.getConexao();

            String sql = "SELECT cl.id, cl.telefone, cl.endereco, cl.carrinho, cl.email, cl.nome, cl.cpf "
                    + "FROM cliente cl, carrinho ca "
                    + "where cl.id=? "
                    + "and cl.carrinho=ca.id ";

            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();
            Cliente c = new Cliente();
            while (resultado.next()) {
                Integer telefone = resultado.getInt("telefone");

                enderecoDAO enderecodao = new enderecoDAO();
                Endereco endereco = enderecodao.consultarById(resultado.getInt("endereco"));

                carrinhoDAO carrinhodao = new carrinhoDAO();
                Carrinho carrinho = carrinhodao.consultarById(resultado.getInt("carrinho"));

                String email = resultado.getString("email");
                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");

                c = new Cliente(id, telefone, endereco, carrinho, email, nome, cpf);

            }

            con.close();
            return c;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void RemoverFunc(Cliente cliente) throws ClassNotFoundException, SQLException {
        try (Connection con = conectaDB.getConexao()) {
            String sql = "delete from cliente where id = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, cliente.getId());

            comando.execute();
            con.close();
        }
    }

    public void atualizar(Cliente cliente) throws ClassNotFoundException, SQLException {
        try (
                Connection con = conectaDB.getConexao()) {
            String sql = "UPDATE public.cliente "
                    + "SET telefone=?, endereco=?, carrinho=?, email=?, cpf=? "
                    + "WHERE id=?;";
            PreparedStatement atualizar = con.prepareStatement(sql);
            atualizar.setInt(1, cliente.getTelefone());
            atualizar.setInt(2, cliente.getEndereco().getId());
            atualizar.setInt(3, cliente.getCarrinho().getId());
            atualizar.setString(4, cliente.getEmail());            
            atualizar.setString(5, cliente.getCpf());
            atualizar.setInt(6, cliente.getId());
            
            atualizar.execute();
            con.close();

        }

    }

    public List<Cliente> consultarTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Cliente> listacliente;

        Cliente c = null;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select * from cliente";
            PreparedStatement comando = con.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();
            listacliente = new ArrayList<>();
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                Integer telefone = resultado.getInt("telefone");

                enderecoDAO enderecodao = new enderecoDAO();
                Endereco endereco = enderecodao.consultarById(resultado.getInt("endereco"));

                carrinhoDAO carrinhodao = new carrinhoDAO();
                Carrinho carrinho = carrinhodao.consultarById(resultado.getInt("carrinho"));

                String email = resultado.getString("email");
                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");

                c = new Cliente(id, telefone, endereco, carrinho, email, nome, cpf);
                listacliente.add(c);
            }
            con.close();
        }
        return listacliente;
    }

    public void novaSenha(Cliente cliente) throws ClassNotFoundException, SQLException {
        try (
                Connection con = conectaDB.getConexao()) {
            String sql = "update public.cliente set senha = ?, repeteSenha = ?  where email = ?";
            PreparedStatement atualizar = con.prepareStatement(sql);

            atualizar.setString(1, criptografar(cliente.getSenha()));
            atualizar.setString(2, criptografar(cliente.getRepeteSenha()));
            atualizar.setString(3, cliente.getEmail());

            atualizar.execute();

        }

    }
}
