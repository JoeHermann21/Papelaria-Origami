/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.categoriaDAO;
import DAO.fabricanteDAO;
import DAO.produtoDAO;
import Modelo.Categoria;
import Modelo.Fabricante;
import Modelo.Produto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme
 */
@WebServlet(name = "ProdutoControle", urlPatterns = {"/ProdutoControle",
    "/cadastrarProduto",
    "/editarProduto",
    "/painelControle",
    "/excluirProduto",
    "/iniciarCadastro",
    "/iniciarEdicao",
    "/listarEsgotado",
    "/excluirEsgotado",})
public class ProdutoControle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/painelControle")) {
            try {
                listarProdutos(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/excluirProduto")) {
            try {
                excluirProduto(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/iniciarCadastro")) {
            try {
                iniciarCadastro(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/iniciarEdicao")) {
            try {
                iniciarEdicao(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/listarEsgotado")) {
            try {
                listarEsgotado(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/excluirEsgotado")) {
            try {
                excluirEsgotado(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/cadastrarProduto")) {
            System.out.println("AQUI");
            try {
                cadastrar(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (uri.equals(request.getContextPath() + "/editarProduto")) {
            try {
                editarProduto(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ClassNotFoundException, SQLException, ServletException {
        Produto prod = new Produto();
        produtoDAO dao = new produtoDAO();
        fabricanteDAO fabDAO = new fabricanteDAO();
        categoriaDAO catDao = new categoriaDAO();

        String descricao = request.getParameter("txtDescricao");
        prod.setDescricao(descricao);

        String data = request.getParameter("txtDataEntrada");
        java.util.Date dataUtil = new java.util.Date();
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
        prod.setDataEntrada(dataSql);

        String txtCategoria = request.getParameter("txtCategoria");
        String txtFabricante = request.getParameter("txtFabricante");

        Fabricante fab = new Fabricante();

        fab = fabDAO.consultarByDescricao(txtFabricante);

        Categoria cat = new Categoria();

        cat = catDao.consultarByDescricao(txtCategoria);

        prod.setCategoria(cat);
        prod.setFabricante(fab);

        String qntdd = request.getParameter("txtQntdd");
        prod.setQuantidade(Integer.parseInt(qntdd));

        String preco = request.getParameter("txtPreco");
        prod.setPreco(Double.parseDouble(preco));

        if (descricao != null) {
            dao.cadastrar(prod);
            request.setAttribute("cadProdmsg", "O Produto " + descricao + " foi cadastrado com sucesso!");
             List<Categoria> categorias = catDao.consultarTodos();
        List<Fabricante> fabricante = fabDAO.consultarTodos();
        request.setAttribute("lcat", categorias);
        request.setAttribute("lfab", fabricante);
        request.getRequestDispatcher("/View/pagesAdm/cadProd.jsp").forward(request, response);
        }
    }

    private void editarProduto(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {

        Produto prod = new Produto();
        produtoDAO dao = new produtoDAO();
        fabricanteDAO fabDAO = new fabricanteDAO();
        categoriaDAO catDao = new categoriaDAO();

        String id = request.getParameter("txtID");
        prod.setId(Integer.parseInt(id));

        String descricao = request.getParameter("txtDescricao");
        prod.setDescricao(descricao);

        String data = request.getParameter("txtDataEntrada");
        java.util.Date dataUtil = new java.util.Date();
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
        prod.setDataEntrada(dataSql);

        String categoria = request.getParameter("txtCategoria");
        String fabricante = request.getParameter("txtFabricante");

        Fabricante fab = new Fabricante();
        Categoria cat = new Categoria();

        cat = catDao.consultarByDescricao(categoria);
        fab = fabDAO.consultarByDescricao(fabricante);

        prod.setCategoria(cat);
        prod.setFabricante(fab);

        String qntdd = request.getParameter("txtQntdd");
        prod.setQuantidade(Integer.parseInt(qntdd));

        String preco = request.getParameter("txtPreco");
        prod.setPreco(Double.parseDouble(preco));

        if (id != null) {
            dao.atualizar(prod);
            //request.setAttribute("salvProdmsg", "O Produto " + descricao + " foi alterado com sucesso!");
//            List<Produto> produtos = dao.consultarTodos();
//            request.setAttribute("lprod", produtos);
            //      request.getRequestDispatcher("/painelControle").include(request, response);

            response.sendRedirect("/PapelariaOrigami/painelControle");
        }
    }

    private void listarProdutos(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        Produto prod = new Produto();
        produtoDAO dao = new produtoDAO();
        fabricanteDAO fabDAO = new fabricanteDAO();
        categoriaDAO catDao = new categoriaDAO();
        List<Produto> produtos = dao.consultarTodos();
        request.setAttribute("lprod", produtos);
        request.getRequestDispatcher("/View/pagesAdm/index2.jsp").forward(request, response);
    }

    private void excluirProduto(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        Produto prod = new Produto();
        produtoDAO dao = new produtoDAO();
        String id = request.getParameter("txtID");
        prod.setId(Integer.parseInt(id));
        System.out.println(prod.getId());
        if (id != null) {
            dao.RemoverProd(prod);
            request.setAttribute("ExcProdmsg", "O Produto de código " + id + " foi apagado com sucesso!");
            List<Produto> produtos = dao.consultarTodos();
            request.setAttribute("lprod", produtos);
            request.getRequestDispatcher("View/pagesAdm/index2.jsp").forward(request, response);
        }
    }

    private void iniciarCadastro(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        Produto prod = new Produto();
        produtoDAO dao = new produtoDAO();
        fabricanteDAO fabDAO = new fabricanteDAO();
        categoriaDAO catDao = new categoriaDAO();

        List<Categoria> categorias = catDao.consultarTodos();
        List<Fabricante> fabricante = fabDAO.consultarTodos();
        request.setAttribute("lcat", categorias);
        request.setAttribute("lfab", fabricante);
        request.getRequestDispatcher("/View/pagesAdm/cadProd.jsp").forward(request, response);
    }

    private void iniciarEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        String idString = request.getParameter("txtID");
        Produto prod = new Produto();
        produtoDAO dao = new produtoDAO();
        fabricanteDAO fabDAO = new fabricanteDAO();
        categoriaDAO catDao = new categoriaDAO();

        if (idString != null) {
            int id = Integer.parseInt(idString);
            prod = dao.consultarById(id);

            List<Categoria> categorias = catDao.consultarTodos();
            List<Fabricante> fabricante = fabDAO.consultarTodos();
            request.setAttribute("lcat", categorias);
            request.setAttribute("lfab", fabricante);

            request.setAttribute("lprod", prod);

            request.getRequestDispatcher("/View/pagesAdm/altProd.jsp").forward(request, response);
        }
    }

    private void listarEsgotado(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        Produto prod = new Produto();
        produtoDAO dao = new produtoDAO();
        List<Produto> produtosEsg = dao.consultarEsgotando();
        request.setAttribute("lprodEsg", produtosEsg);
        request.getRequestDispatcher("/View/pagesAdm/esgotados.jsp").forward(request, response);
    }

    private void excluirEsgotado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        Produto prod = new Produto();
        produtoDAO dao = new produtoDAO();
        String id = request.getParameter("txtID");
        prod.setId(Integer.parseInt(id));
        System.out.println(prod.getId());
        if (id != null) {
            dao.RemoverProd(prod);
            request.setAttribute("cadProdmsg", "O Registro apagado com sucesso!");
            List<Produto> produtos = dao.consultarEsgotando();
            request.setAttribute("lprodEsg", produtos);
            request.getRequestDispatcher("View/pagesAdm/esgotados.jsp").forward(request, response);
        }
    }
   
}
