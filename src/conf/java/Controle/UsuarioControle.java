/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.clienteDAO;
import Modelo.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Guilherme
 */
@WebServlet(name = "UsuarioControle", urlPatterns = {"/UsuarioControle"})
public class UsuarioControle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
       Cliente cliente = new Cliente();
        clienteDAO dao = new clienteDAO();
        String acao = request.getParameter("acao");

        if (acao.equals("Entrar")) {
            HttpSession sessao = request.getSession();

            String email = request.getParameter("txtEmail");
            cliente.setEmail(email);

            String senha = request.getParameter("txtSenha");
            cliente.setSenha(senha);
            if (dao.checkLogin(cliente)) {
                sessao.setAttribute("cliente", cliente);
                request.getRequestDispatcher("/inicialCliente.jsp").forward(request, response);

            } else {
                request.setAttribute("Erro", "Usuário ou senha inválidos");
                request.getRequestDispatcher("/loginCliente.jsp").forward(request, response);
            }

        } else if (acao.equals("Cadastrar")) {
            String nome = request.getParameter("txtNome");
            cliente.setNome(nome);

            String cpf = request.getParameter("txtCpf");
            cliente.setCpf(cpf);

            String email = request.getParameter("txtEmail");
            cliente.setEmail(email);

            String senha = request.getParameter("txtSenha");
            cliente.setSenha(senha);

            String Rsenha = request.getParameter("txtRepeteSenha");
            cliente.setRepeteSenha(Rsenha);

            if (cpf != null) {
                dao.cadastrar(cliente);
                request.setAttribute("cadClimsg", "O Registro foi cadastrado com sucesso!");
                request.getRequestDispatcher("/loginCliente.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
