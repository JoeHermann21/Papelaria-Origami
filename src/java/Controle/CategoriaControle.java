/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.categoriaDAO;
import Modelo.Categoria;
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
 * @author Amaranta
 */
@WebServlet(name = "CategoriaControle", urlPatterns = {"/CategoriaControle", "/listarCategorias",
    "/cadastrarCategoria",
    "/alterarCategoria",
    "/salvarCategoria",
    "/excluirCategoria"})
public class CategoriaControle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/listarCategorias")) {
            try {
                listarTodos(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FabricanteControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/excluirCategoria")) {
            try {
                excluir(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FabricanteControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/alterarCategoria")) {
            try {
                alterar(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FabricanteControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/cadastrarCategoria")) {
            try {
                cadastrar(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FabricanteControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/salvarCategoria")) {
            try {
                salvar(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FabricanteControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Categoria categ = new Categoria();
        categoriaDAO dao = new categoriaDAO();

        String descricao = request.getParameter("txtDescricao");
        categ.setDescricao(descricao);

        String sigla = request.getParameter("txtSigla");
        categ.setSigla(sigla);

        if (descricao != null) {
            try {
                dao.cadastrar(categ);
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaControle.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("cadCatemsg", "A categoria " + descricao + " foi cadastrada com sucesso!");
            request.getRequestDispatcher("/View/pagesAdm/cadCategoria.jsp").forward(request, response);
        }
    }

    private void listarTodos(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Categoria categ = new Categoria();
        categoriaDAO dao = new categoriaDAO();
        List<Categoria> categorias = dao.consultarTodos();
        request.setAttribute("lcate", categorias);
        request.getRequestDispatcher("/View/pagesAdm/listCategoria.jsp").forward(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Categoria categ = new Categoria();
        categoriaDAO dao = new categoriaDAO();
        String id = request.getParameter("txtID");
        categ.setId(Integer.parseInt(id));
        System.out.println(categ.getId());
        if (id != null) {
            dao.RemoverCateg(categ);
            request.setAttribute("delCatmsg", "A categoria de código " + id + " foi deletada com sucesso!");
            List<Categoria> categorias = dao.consultarTodos();
            request.setAttribute("lcate", categorias);
            request.getRequestDispatcher("/View/pagesAdm/listCategoria.jsp").forward(request, response);
        }
    }

    private void alterar(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Categoria categ = new Categoria();
        categoriaDAO dao = new categoriaDAO();
        String idString = request.getParameter("txtID");

        if (idString != null) {
            int id = Integer.parseInt(idString);
            categ = dao.consultarById(id);
            request.setAttribute("lcate", categ);

            request.getRequestDispatcher("/View/pagesAdm/altCategoria.jsp").forward(request, response);
        }
    }

    private void salvar(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Categoria categ = new Categoria();
        categoriaDAO dao = new categoriaDAO();
        String id = request.getParameter("txtID");
        categ.setId(Integer.parseInt(id));

        String descricao = request.getParameter("txtDescricao");
        categ.setDescricao(descricao);

        String sigla = request.getParameter("txtSigla");
        categ.setSigla(sigla);

        if (id != null) {
            dao.atualizar(categ);
            List<Categoria> categorias = dao.consultarTodos();
            request.setAttribute("lcate", categorias);
            request.setAttribute("salvCatemsg", "Categoria " + descricao + " foi alterada com sucesso!");
            request.getRequestDispatcher("/View/pagesAdm/listCategoria.jsp").forward(request, response);
        }
    }
}
