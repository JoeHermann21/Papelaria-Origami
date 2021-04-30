/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
import Modelo.Fabricante;
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
public class fabricanteDAO {

    public Fabricante consultarById(Integer id) {
        try {
            Connection con = conectaDB.getConexao();
            
            Fabricante fab = new Fabricante(id);

            String sql = "select * from fabricante where id = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, fab.getId());

            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                fab.setId(resultado.getInt("id"));
                fab.setDescricao(resultado.getString("descricao"));
                fab.setSigla(resultado.getString("sigla"));
                fab.setCnpj(resultado.getString("cnpj"));
            }
            return fab;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Fabricante consultarByDescricao(String descricao) {
        Fabricante f = null;
        
        try (Connection con = conectaDB.getConexao();
                PreparedStatement comando = 
                con.prepareStatement("select id, descricao, sigla, cnpj "
                        + "from fabricante " +
                            "where descricao = ? ");){
                                                    
            comando.setString(1, descricao);
            ResultSet resultado = comando.executeQuery();
                                                   
            while (resultado.next()) {   
                Integer id = resultado.getInt("id");            
                String sigla = resultado.getString("sigla");
                String cnpj = resultado.getString("cnpj");           
                
                f = new Fabricante(id, descricao, sigla, cnpj);
            }
           
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
         return f;
    }
    
    public void cadastrar(Fabricante fabri) throws ClassNotFoundException, SQLException {

        try {
            Connection con = conectaDB.getConexao();      

            String sql = "insert into fabricante(descricao, sigla, cnpj) values(?,?,?)";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, fabri.getDescricao());
            comando.setString(2,  fabri.getSigla());
            comando.setString(3, fabri.getCnpj());
            
            comando.execute();

            System.out.println("CADASTROU");
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR: " + e);
        }
    }
    
    public void RemoverFabri(Fabricante fabri)
            throws ClassNotFoundException, SQLException {
        try (Connection con = conectaDB.getConexao()) {
            String sql = "delete from fabricante where id = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, fabri.getId());

            comando.execute();
        }
    }
    
    public void atualizar(Fabricante fabri) throws ClassNotFoundException, SQLException {
        try (
                Connection con = conectaDB.getConexao()) {
            String sql = "update fabricante SET descricao  = ?, sigla = ?, cnpj = ? WHERE id =?;";
            PreparedStatement atualizar = con.prepareStatement(sql);
            atualizar.setString(1, fabri.getDescricao());
            atualizar.setString(2, fabri.getSigla());
            atualizar.setString(3,  fabri.getCnpj());
            atualizar.setInt(4,  fabri.getId());

            atualizar.execute();

        }

    }
    
    public List<Fabricante> consultarTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Fabricante> listafabricante;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select * from fabricante";
            PreparedStatement comando = con.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();
            listafabricante = new ArrayList<>();
            while (resultado.next()) {
                Fabricante f = new Fabricante();
                f.setId(resultado.getInt("id"));
                f.setDescricao(resultado.getString("descricao"));
                f.setSigla(resultado.getString("sigla"));
                f.setCnpj(resultado.getString("cnpj"));
                
                
                listafabricante.add(f);
            }

        }
        return listafabricante;
    }
    
    
}
    

