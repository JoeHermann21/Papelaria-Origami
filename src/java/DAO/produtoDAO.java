/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
import Modelo.Fabricante;
import Modelo.Produto;
import Util.conectaDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class produtoDAO {

    public void cadastrar(Produto prod) throws ClassNotFoundException, SQLException {

        try {
            Connection con = conectaDB.getConexao();

            String sql = "insert into produto(titulo, descricao, dataentrada, quantidade, peso, material, uniEmbalagem, cor, dimensao, preco, categoria, fabricante, quantminima, path, filename)"
                    + " values(?,?,?,?,?,?,?,?,?,?," + prod.getCategoria().getId() + "," + prod.getFabricante().getId() + ",?,?,?)";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, prod.getTitulo());
            comando.setString(2, prod.getDescricao());
            comando.setDate(3, (Date) prod.getDataEntrada());
            comando.setInt(4, prod.getQuantidade());
            comando.setDouble(5, prod.getPeso());
            comando.setString(6, prod.getMaterial());
            comando.setInt(7, prod.getUniEmbalagem());
            comando.setString(8, prod.getCor());
            comando.setString(9, prod.getDimensao());
            comando.setDouble(10, prod.getPreco());
            comando.setInt(11, prod.getQuantidadeMinima());
            comando.setString(12, prod.getPath());
            comando.setString(13, prod.getFileName());

            comando.execute();

            System.out.println("CADASTROU");
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR: " + e);
        }
    }

    public Produto consultarById(Integer id) {

        Produto p = null;

        try (Connection con = conectaDB.getConexao();
                PreparedStatement comando
                = con.prepareStatement("select p.id, p.descricao, p.titulo, p.dataentrada, p.quantidade, p.preco, p.peso, p.material, p.uniEmbalagem, p.cor, p.dimensao,  p.categoria, p.fabricante, p.quantMinima, p.path, p.filename "
                        + "from produto p, categoria c, fabricante f "
                        + "where p.id = ? and c.id=p.categoria and f.id=p.fabricante");) {

            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                String titulo = resultado.getString("titulo");
                String descricao = resultado.getString("descricao");
                Date dataentrada = resultado.getDate("dataentrada");
                Integer quantidade = resultado.getInt("quantidade");
                Double peso = resultado.getDouble("peso");
                String material = resultado.getString("material");
                Integer uniEmbalagem = resultado.getInt("uniEmbalagem");
                String cor = resultado.getString("cor");
                String dimensao = resultado.getString("dimensao");
                Double preco = resultado.getDouble("preco");
                String path = resultado.getString("path");
                String fileName = resultado.getString("filename");

                categoriaDAO cdao = new categoriaDAO();
                Categoria categoria = cdao.consultarById(resultado.getInt("categoria"));
                fabricanteDAO fdao = new fabricanteDAO();
                Fabricante fabricante = fdao.consultarById(resultado.getInt("fabricante"));

                Integer quantMinima = resultado.getInt("quantMinima");

                p = new Produto(id, titulo, descricao, dataentrada, quantidade, peso, material, uniEmbalagem, cor, dimensao, preco, categoria, fabricante, quantMinima, path, fileName);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    public void RemoverProd(Produto prod)
            throws ClassNotFoundException, SQLException {
        try (Connection con = conectaDB.getConexao()) {
            String sql = "delete from produto where id = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setInt(1, prod.getId());

            comando.execute();
        }
    }

    public void atualizar(Produto prod) throws ClassNotFoundException, SQLException {
        try (
                Connection con = conectaDB.getConexao()) {
            String sql = "update  produto "
                    + "SET titulo= ?, descricao=?, dataentrada=?, quantidade=?, peso=?, material=?,  uniEmbalagem=?, cor=?, dimensao=?, preco=?, categoria=?, fabricante=?, quantMinima=?, path=?, filename=? "
                    + "WHERE id =?;";

            PreparedStatement atualizar = con.prepareStatement(sql);
            atualizar.setString(1, prod.getTitulo());
            atualizar.setString(2, prod.getDescricao());
            atualizar.setDate(3, (java.sql.Date) (java.util.Date) prod.getDataEntrada());
            atualizar.setInt(4, prod.getQuantidade());
            atualizar.setDouble(5, prod.getPeso());
            atualizar.setString(6, prod.getMaterial());
            atualizar.setInt(7, prod.getUniEmbalagem());
            atualizar.setString(8, prod.getCor());
            atualizar.setString(9, prod.getDimensao());
            atualizar.setDouble(10, prod.getPreco());
            atualizar.setInt(11, prod.getCategoria().getId());
            atualizar.setInt(12, prod.getFabricante().getId());
            atualizar.setInt(13, prod.getQuantidadeMinima());
            atualizar.setString(14, prod.getPath());
            atualizar.setString(15, prod.getFileName());
            atualizar.setInt(16, prod.getId());

            atualizar.execute();
        }
    }

    public List<Produto> consultarTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Produto> listaproduto;

        Produto p = null;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select * from produto order by id";
            PreparedStatement comando = con.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();
            listaproduto = new ArrayList<>();
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String titulo = resultado.getString("titulo");
                String descricao = resultado.getString("descricao");
                Date dataentrada = resultado.getDate("dataentrada");
                Integer quantidade = resultado.getInt("quantidade");
                Double peso = resultado.getDouble("peso");
                String material = resultado.getString("material");
                Integer uniEmbalagem = resultado.getInt("uniEmbalagem");
                String cor = resultado.getString("cor");
                String dimensao = resultado.getString("dimensao");
                Double preco = resultado.getDouble("preco");
                String path = resultado.getString("path");
                String fileName = resultado.getString("filename");

                categoriaDAO cdao = new categoriaDAO();
                Categoria categoria = cdao.consultarById(resultado.getInt("categoria"));
                fabricanteDAO fdao = new fabricanteDAO();
                Fabricante fabricante = fdao.consultarById(resultado.getInt("fabricante"));

                Integer quantMinima = resultado.getInt("quantMinima");

                p = new Produto(id, titulo, descricao, dataentrada, quantidade, peso, material, uniEmbalagem, cor, dimensao, preco, categoria, fabricante, quantMinima, path, fileName);
                listaproduto.add(p);
            }

        }
        return listaproduto;
    }

    public List<Produto> consultarEsgotando() throws ClassNotFoundException, SQLException {
        ArrayList<Produto> listaEsgotando;

        Produto pe = null;

        try (
                Connection con = conectaDB.getConexao()) {

            String sql = "select * from produto where quantidade <= quantMinima";
            PreparedStatement comando = con.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();
            listaEsgotando = new ArrayList<>();
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String titulo = resultado.getString("titulo");
                String descricao = resultado.getString("descricao");
                Date dataentrada = resultado.getDate("dataentrada");
                Integer quantidade = resultado.getInt("quantidade");
                Double peso = resultado.getDouble("peso");
                String material = resultado.getString("material");
                Integer uniEmbalagem = resultado.getInt("uniEmbalagem");
                String cor = resultado.getString("cor");
                String dimensao = resultado.getString("dimensao");
                Double preco = resultado.getDouble("preco");
                String path = resultado.getString("path");
                String fileName = resultado.getString("filename");

                categoriaDAO cdao = new categoriaDAO();
                Categoria categoria = cdao.consultarById(resultado.getInt("categoria"));
                fabricanteDAO fdao = new fabricanteDAO();
                Fabricante fabricante = fdao.consultarById(resultado.getInt("fabricante"));

                Integer quantMinima = resultado.getInt("quantMinima");

                pe = new Produto(id, titulo, descricao, dataentrada, quantidade, peso, material, uniEmbalagem, cor, dimensao, preco, categoria, fabricante, quantMinima, path, fileName);
                listaEsgotando.add(pe);
            }

        }
        return listaEsgotando;
    }

    public Produto consultarByDescricao(String descricao) {

        Produto p = null;

        try (Connection con = conectaDB.getConexao();
                PreparedStatement comando
                = con.prepareStatement("select p.id, p.descricao, p.dataentrada, p.quantidade, p.preco, p.categoria, p.fabricante, p.quantMinima, p.path, p.filename "
                        + "from produto p, categoria c, fabricante f "
                        + "where p.descricao = ? and c.id=p.categoria and f.id=p.fabricante");) {

            comando.setString(1, descricao);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String titulo = resultado.getString("titulo");
                Date dataentrada = resultado.getDate("dataentrada");
                Integer quantidade = resultado.getInt("quantidade");
                Double peso = resultado.getDouble("peso");
                String material = resultado.getString("material");
                Integer uniEmbalagem = resultado.getInt("uniEmbalagem");
                String cor = resultado.getString("cor");
                String dimensao = resultado.getString("dimensao");
                Double preco = resultado.getDouble("preco");
                String path = resultado.getString("path");
                String fileName = resultado.getString("filename");

                categoriaDAO cdao = new categoriaDAO();
                Categoria categoria = cdao.consultarById(resultado.getInt("categoria"));
                fabricanteDAO fdao = new fabricanteDAO();
                Fabricante fabricante = fdao.consultarById(resultado.getInt("fabricante"));

                Integer quantMinima = resultado.getInt("quantMinima");

                p = new Produto(id, titulo, descricao, dataentrada, quantidade, peso, material, uniEmbalagem, cor, dimensao, preco, categoria, fabricante, quantMinima, path, fileName);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    public String retornarCaminho(Integer id) throws SQLException, ClassNotFoundException {

        String caminho = null;

        try (Connection con = conectaDB.getConexao();
                PreparedStatement comando
                = con.prepareStatement("select path from produto where id = ?;");) {
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

    public List<Produto> listByDescricao(String titulo) throws ClassNotFoundException, SQLException {
        ArrayList<Produto> listaProduto;

        Produto p = null;
        listaProduto = new ArrayList<>();
        try (Connection con = conectaDB.getConexao();
                PreparedStatement comando
                = con.prepareStatement("SELECT * FROM produto WHERE titulo ilike '" + titulo + "%'");) {

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String tit = resultado.getString("titulo");
                String desc = resultado.getString("descricao");
                Date dataentrada = resultado.getDate("dataentrada");
                Integer quantidade = resultado.getInt("quantidade");
                Double peso = resultado.getDouble("peso");
                String material = resultado.getString("material");
                Integer uniEmbalagem = resultado.getInt("uniEmbalagem");
                String cor = resultado.getString("cor");
                String dimensao = resultado.getString("dimensao");
                Double preco = resultado.getDouble("preco");
                String path = resultado.getString("path");
                String fileName = resultado.getString("filename");

                categoriaDAO cdao = new categoriaDAO();
                Categoria categoria = cdao.consultarById(resultado.getInt("categoria"));
                fabricanteDAO fdao = new fabricanteDAO();
                Fabricante fabricante = fdao.consultarById(resultado.getInt("fabricante"));

                Integer quantMinima = resultado.getInt("quantMinima");

                p = new Produto(id, tit, desc, dataentrada, quantidade, peso, material, uniEmbalagem, cor, dimensao, preco, categoria, fabricante, quantMinima, path, fileName);
                listaProduto.add(p);
            }

        }
        return listaProduto;
    }

    public List<Produto> listByDescricaoEsgotado(String titulo) throws ClassNotFoundException, SQLException {
        ArrayList<Produto> listaProduto;

        Produto p = null;
        listaProduto = new ArrayList<>();
        try (Connection con = conectaDB.getConexao();
                PreparedStatement comando
                = con.prepareStatement("select * from produto where quantidade <= quantMinima and titulo ilike '" + titulo + "%'");) {

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String tit = resultado.getString("titulo");
                String desc = resultado.getString("descricao");
                Date dataentrada = resultado.getDate("dataentrada");
                Integer quantidade = resultado.getInt("quantidade");
                Double peso = resultado.getDouble("peso");
                String material = resultado.getString("material");
                Integer uniEmbalagem = resultado.getInt("uniEmbalagem");
                String cor = resultado.getString("cor");
                String dimensao = resultado.getString("dimensao");
                Double preco = resultado.getDouble("preco");
                String path = resultado.getString("path");
                String fileName = resultado.getString("filename");

                categoriaDAO cdao = new categoriaDAO();
                Categoria categoria = cdao.consultarById(resultado.getInt("categoria"));
                fabricanteDAO fdao = new fabricanteDAO();
                Fabricante fabricante = fdao.consultarById(resultado.getInt("fabricante"));

                Integer quantMinima = resultado.getInt("quantMinima");

                p = new Produto(id, titulo, desc, dataentrada, quantidade, peso, material, uniEmbalagem, cor, dimensao, preco, categoria, fabricante, quantMinima, path, fileName);
                listaProduto.add(p);
            }

        }
        return listaProduto;
    }

    public List<Produto> consultarByCategoriaId(Integer id) {
        ArrayList<Produto> listaproduto = new ArrayList<>();
        Produto p = null;

        try (Connection con = conectaDB.getConexao();
                PreparedStatement comando
                = con.prepareStatement("select p.id, p.descricao, p.titulo, p.dataentrada, p.quantidade, p.preco, p.peso, p.material, p.uniEmbalagem, p.cor, p.dimensao,  p.categoria, p.fabricante, p.quantMinima, p.path, p.filename "
                        + "from produto p, categoria c, fabricante f "
                        + "where c.id = ? and c.id=p.categoria  and f.id=p.fabricante");) {

            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Integer idProduto = resultado.getInt("id");
                String titulo = resultado.getString("titulo");
                String descricao = resultado.getString("descricao");
                Date dataentrada = resultado.getDate("dataentrada");
                Integer quantidade = resultado.getInt("quantidade");
                Double peso = resultado.getDouble("peso");
                String material = resultado.getString("material");
                Integer uniEmbalagem = resultado.getInt("uniEmbalagem");
                String cor = resultado.getString("cor");
                String dimensao = resultado.getString("dimensao");
                Double preco = resultado.getDouble("preco");
                String path = resultado.getString("path");
                String fileName = resultado.getString("filename");

                categoriaDAO cdao = new categoriaDAO();
                Categoria categoria = cdao.consultarById(resultado.getInt("categoria"));
                fabricanteDAO fdao = new fabricanteDAO();
                Fabricante fabricante = fdao.consultarById(resultado.getInt("fabricante"));

                Integer quantMinima = resultado.getInt("quantMinima");

                p = new Produto(idProduto, titulo, descricao, dataentrada, quantidade, peso, uniEmbalagem, cor, dimensao, preco, path, fileName, categoria, fabricante);
                listaproduto.add(p);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaproduto;
    }

    public void subtrairQuantidade(Produto prod) throws SQLException, ClassNotFoundException {
        try (
                Connection con = conectaDB.getConexao()) {
            String sql = "update  produto "
                    + "SET quantidade = quantidade - ? "
                    + "WHERE id = ?;";

            PreparedStatement atualizar = con.prepareStatement(sql);

            atualizar.setInt(1, prod.getQuantidade());
            atualizar.setInt(2, prod.getId());

            atualizar.execute();

        }
    }

    public ArrayList<Produto> selecionarProdutoByPedido(Integer pedidoID) {
        ArrayList<Produto> listaproduto = new ArrayList<>();
        Produto p = null;

        try (Connection con = conectaDB.getConexao();
                PreparedStatement comando 
                        = con.prepareStatement("select pro.id, it.qtdd as quantidade "
                        + "from pedido pe, item it, produto pro "
                        + "where pro.id = it.produto and it.pedido = pe.id and pe.id = ?");) {

            comando.setInt(1, pedidoID);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Integer idProduto = resultado.getInt("id");                
                Integer quantidade = resultado.getInt("quantidade");
               
                p = new Produto(idProduto, quantidade);
                listaproduto.add(p);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaproduto;
    }
}
