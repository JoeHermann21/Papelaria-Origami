
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.conectaBD;
import model.checkout;
import model.usuario;

/**
 *
 * @author amaranta
 */
public class checkoutDAO {
    private static final String INSERT = "INSERT INTO checkout (id, emailCli, cep, localidade, UF, cidade, bairro, logradouro, numero, complemento, telefone) VALUES (nextval('seq_checkout'), ?,?,?,?, ?, ?,?,?,?,?);";
    private static final String UPDATE = "UPDATE entrega SET nome=?, sobrenome=?, email=?, telefone=?, cpf=?, localidade=?, cep=?, numero=?, cidade=?, bairro=?, uf=?, longradouro=? WHERE id=?;";
    private static final String SELECT = "SELECT * FROM entrega WHERE nome = ?;";
    private static final String DELETAR = "DELETE FROM entrega where id=?;";
    private static final String LISTAR = "select * from checkout";
    
    public void cadastrar(checkout check) throws ClassNotFoundException, SQLException {
        
        try {
            usuario user = new usuario();
            Connection conexao = conectaBD.getConexao();
            PreparedStatement conecta = conexao.prepareStatement(INSERT);
            // Parameters start with 1 
            conecta.setString(1, check.getEmail());
            conecta.setInt(2, check.getCep());
            conecta.setString(3, check.getRua());
            conecta.setString(4, check.getUf());
            conecta.setString(5, check.getCidade());
            conecta.setString(6, check.getBairro());
            conecta.setString(7, check.getLogradouro());
            conecta.setInt(8, check.getNumero());
            conecta.setString(9, check.getComplemento());
            conecta.setInt(10, check.getTelefone());
            
            conecta.execute();
            conecta.close();
        } catch (SQLException e) {
           System.out.println("Erro"+ e.getMessage());
        }
    }
    public List<checkout> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection conexao = conectaBD.getConexao();
        PreparedStatement conecta = conexao.prepareStatement(LISTAR);

        ResultSet resultado = conecta.executeQuery();

        List todosProdutos = new ArrayList<checkout>();
        while (resultado.next()) {
            checkout check = new checkout();
            check.setEmail(resultado.getString("emailcli"));
            check.setId(resultado.getInt("id"));
            check.setCep(resultado.getInt("cep"));
            check.setUf(resultado.getString("uf"));
            check.setCidade(resultado.getString("cidade"));
            check.setRua(resultado.getString("rua"));
            check.setBairro(resultado.getString("bairro"));
            check.setNumero(resultado.getInt("numero"));
        }
        conexao.close();
        return todosProdutos;
    }

    public void Delete(checkout check) throws ClassNotFoundException, SQLException {

        Connection conexao = conectaBD.getConexao();
        PreparedStatement conecta = conexao.prepareStatement(DELETAR);

        conecta.setInt(1, check.getId());
        conecta.execute();
        conexao.close();
    }

    public checkout Select(checkout check) throws ClassNotFoundException, SQLException {
        Connection conexao = conectaBD.getConexao();
        PreparedStatement conecta = conexao.prepareStatement(SELECT);

        conecta.setInt(1, check.getId());
        ResultSet resultado = conecta.executeQuery();
        if (resultado.next()) {
            check.setId(resultado.getInt("id"));
            //check.seEmail(resultado.getEmail(colocar aqui o campo do email));
            check.setRua(resultado.getString("rua"));
            check.setUf(resultado.getString("uf"));
            check.setCidade(resultado.getString("cidade"));
            check.setBairro(resultado.getString("bairro"));
            check.setLogradouro(resultado.getString("logradouro"));
            check.setNumero(resultado.getInt("numero"));
            check.setComplemento(resultado.getString("complemento"));
            check.setTelefone(resultado.getInt("telefone"));
            
        }
        conexao.close();
        return check;
    }

    public void Update(checkout check) throws ClassNotFoundException, SQLException {

        Connection conexao = conectaBD.getConexao();
        PreparedStatement conecta = conexao.prepareStatement(UPDATE);

        conecta.setInt(13, check.getId());
            conecta.setInt(7, check.getCep());
            conecta.setString(6, check.getRua());
            conecta.setString(11, check.getUf());
            conecta.setString(9, check.getCidade());
            conecta.setString(10, check.getBairro());
            conecta.setString(12, check.getLogradouro());
            conecta.setInt(8, check.getNumero());
            conecta.setString(11, check.getComplemento());
            conecta.setInt(4, check.getTelefone());

        conecta.execute();
        conexao.close();
    }
}
