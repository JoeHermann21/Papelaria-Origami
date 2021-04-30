/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Carrinho;
import Modelo.Cliente;
import Modelo.Endereco;
import Modelo.Funcionario;
import Modelo.Pedido;
import Modelo.Usuario;
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
public class clienteDAO {
    private static final String INSERT = "INSERT INTO cliente (telefone, endereco, usuario, carrinho, email)"
            + " VALUES (?, ?, ?, ?, ?)";
    
    public void cadastrar(Cliente cliente) throws ClassNotFoundException, SQLException {
        
            try {
            Connection conexao = conectaDB.getConexao();      

            PreparedStatement conecta = conexao.prepareStatement(INSERT);
            conecta.setDouble(1, cliente.getTelefone());
            conecta.setInt(2, cliente.getEndereco().getId());
            conecta.setInt(3, cliente.getUsuario());
            conecta.setInt(4, cliente.getCarrinho().getId());
            conecta.setString(5, cliente.getEmail());
           
            conecta.execute();
            System.out.println("CADASTROU");
            } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR: " + e);
        }
    }
    
    public boolean checkLogin(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection conexao = conectaDB.getConexao();
        PreparedStatement ps = null;
        ResultSet resultado = null;
        boolean check = false;
       
            ps = conexao.prepareStatement("SELECT cl.id, cl.telefone, cl.endereco, cl.usuario, cl.carrinho, cl.email " +
                                            "FROM cliente cl, usuario u, carrinho ca " +
                                            "where cl.email = ? and u.senha = ? " +
                                            "and cl.usuario=u.id and cl.carrinho=ca.id ");
            ps.setString(1, cliente.getEmail());
            ps.setString(2, cliente.getSenha());

            resultado = ps.executeQuery();

            if (resultado.next()){
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
    
    public Cliente consultarById(Integer id) {

        try {
            Connection con = conectaDB.getConexao();

            String sql = "SELECT cl.id, cl.telefone, cl.endereco, cl.usuario, cl.carrinho, cl.email " +
                            "FROM cliente cl, usuario u, carrinho ca " +
                                "where cl.id=? " +
                                "and cl.usuario=u.id and cl.carrinho=ca.id ";
            
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();
            Cliente c = new Cliente();
            while (resultado.next()) {
                Integer telefone = resultado.getInt("telefone");
                
                enderecoDAO enderecodao = new enderecoDAO();
                Endereco endereco = enderecodao.consultarById(resultado.getInt("endereco"));
                
                Integer usuario = resultado.getInt("usuario");
                
                carrinhoDAO carrinhodao = new carrinhoDAO();
                Carrinho carrinho = carrinhodao.consultarById(resultado.getInt("carrinho"));

                String email = resultado.getString("email");
   
                c = new Cliente(id, telefone, endereco, usuario, carrinho, email);
                
                
            }
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
        }
    }

    public void atualizar(Cliente cliente) throws ClassNotFoundException, SQLException {
        try (
                Connection con = conectaDB.getConexao()) {
            String sql = "UPDATE public.cliente " +
                            "SET telefone=?, endereco=?, usuario=?, carrinho=?, email=?  " +
                                "WHERE id=?;";
            PreparedStatement atualizar = con.prepareStatement(sql);
            atualizar.setInt(1, cliente.getTelefone());
            atualizar.setInt(2, cliente.getEndereco().getId());
            atualizar.setInt(3, cliente.getUsuario());
            atualizar.setInt(4, cliente.getCarrinho().getId());            
            atualizar.setString(5, cliente.getEmail());
            atualizar.setInt(6, cliente.getId());

            atualizar.execute();

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
                
                Integer usuario = resultado.getInt("usuario");
                
                carrinhoDAO carrinhodao = new carrinhoDAO();
                Carrinho carrinho = carrinhodao.consultarById(resultado.getInt("carrinho"));

                String email = resultado.getString("email");
   
                c = new Cliente(id, telefone, endereco, usuario, carrinho, email);
                listacliente.add(c);
            }

        }
        return listacliente;
    }
}

