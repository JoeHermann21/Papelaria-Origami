/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.fabricanteDAO;
import Modelo.Fabricante;
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
@WebServlet(name = "FabricanteControle", urlPatterns = {"/FabricanteControle",
    "/listarFabricantes",
    "/cadastrarFabricantes",
    "/alterarFabricante",
    "/salvarFabricante",
    "/excluirFabricante"})
public class FabricanteControle extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/listarFabricantes")) {
            try {
                listarTodos(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FabricanteControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/excluirFabricante")) {
            try {
                excluir(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FabricanteControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/alterarFabricante")) {
            try {
                alterar(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FabricanteControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/cadastrarFabricantes")) {
            try {
                cadastrar(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FabricanteControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/salvarFabricante")) {
           try {
                salvar(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FabricanteControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Fabricante fabri = new Fabricante();
        fabricanteDAO dao = new fabricanteDAO();

        String descricao = request.getParameter("txtDescricao");
        fabri.setDescricao(descricao);

        String sigla = request.getParameter("txtSigla");
        fabri.setSigla(sigla);

        String cnpj = request.getParameter("txtCnpj");
        fabri.setCnpj(cnpj);

        if (descricao != null) {
            dao.cadastrar(fabri);
            request.setAttribute("cadFabrimsg", "O fabricante " + descricao + " foi cadastrado com sucesso!");
            request.getRequestDispatcher("/View/pagesAdm/cadFabricante.jsp").forward(request, response);
        }
    }

    private void listarTodos(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Fabricante fabri = new Fabricante();
        fabricanteDAO dao = new fabricanteDAO();
        List<Fabricante> fabricantes = dao.consultarTodos();
        request.setAttribute("lfabri", fabricantes);
        request.getRequestDispatcher("/View/pagesAdm/listFabricante.jsp").forward(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Fabricante fabri = new Fabricante();
        fabricanteDAO dao = new fabricanteDAO();

        String id = request.getParameter("txtID");
        fabri.setId(Integer.parseInt(id));
        System.out.println(fabri.getId());
        if (id != null) {
            dao.RemoverFabri(fabri);
            request.setAttribute("delFabriemsg", "O fabricante de código " + id + " foi deletado com sucesso!");
            List<Fabricante> categorias = dao.consultarTodos();
            request.setAttribute("lfabri", categorias);
            request.getRequestDispatcher("/View/pagesAdm/listFabricante.jsp").forward(request, response);
        }
    }

    private void alterar(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Fabricante fabri = new Fabricante();
        fabricanteDAO dao = new fabricanteDAO();
        
        String idString = request.getParameter("txtID");

        if (idString != null) {
            int id = Integer.parseInt(idString);
            fabri = dao.consultarById(id);
            request.setAttribute("lfabri", fabri);

            request.getRequestDispatcher("/View/pagesAdm/altFabricante.jsp").forward(request, response);
        }
    }

    private void salvar(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Fabricante fabri = new Fabricante();
        fabricanteDAO dao = new fabricanteDAO();
        String id = request.getParameter("txtID");
        fabri.setId(Integer.parseInt(id));

        String descricao = request.getParameter("txtDescricao");
        fabri.setDescricao(descricao);

        String sigla = request.getParameter("txtSigla");
        fabri.setSigla(sigla);

        String cnpj = request.getParameter("txtCnpj");
        fabri.setCnpj(cnpj);

        if (id != null) {
            dao.atualizar(fabri);
            List<Fabricante> fabricantes = dao.consultarTodos();
            request.setAttribute("lfabri", fabricantes);
            request.setAttribute("SalvFabrimsg", "Fabricante " + descricao + " foi alterado com sucesso!");
            request.getRequestDispatcher("/View/pagesAdm/listFabricante.jsp").forward(request, response);
        }
    }
}
