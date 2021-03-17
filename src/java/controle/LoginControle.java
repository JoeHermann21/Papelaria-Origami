/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.LoginDAO;
import DAO.ProdutoDAO;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import model.funcionario;
import model.produto;
import model.usuario;

/**
 *
 * @author amaranta
 */
@WebServlet(name = "LoginControle", urlPatterns = {"/LoginControle"})
public class LoginControle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        produto prod = new produto();
        ProdutoDAO pdao = new ProdutoDAO();
        try {
            funcionario fun = new funcionario();

            String acao = request.getParameter("login");
            LoginDAO logindao = new LoginDAO();

            if (acao.equals("Entrar")) //check button click event not null from login.jsp page button
            {
                HttpSession sessao = request.getSession();
                
                String registro = request.getParameter("txtReg");
                fun.setRegistro(Integer.parseInt(registro));
                String senha = request.getParameter("txtPass");
                fun.setSenha(senha);

                if (logindao.checkLogin(fun)) {
                    sessao.setAttribute("funcionario", fun);
                    List<produto> produtos = pdao.Listar();
                    request.setAttribute("lprod", produtos);
                    // vai entrar na pagina index com a variavel 'listaFuncionario' com a list prontas
                    request.getRequestDispatcher("resources/startbootstrap-sb-admin-gh-pages/dist/index.jsp").forward(request, response);
                } else {
                    request.setAttribute("msgErro", "Registro ou senha ínvalidos");
                    request.getRequestDispatcher("/resources/Login_v13/LoginFUN.jsp").forward(request, response);
                }
            }
        } catch (SQLException ex) {
            request.setAttribute("Erro","LoginControle: " + ex);
            request.getRequestDispatcher("resources/startbootstrap-sb-admin-gh-pages/dist/404.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            request.setAttribute("Erro", "LoginControle: " + ex);
            request.getRequestDispatcher("resources/startbootstrap-sb-admin-gh-pages/dist/404.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("Erro","LoginControle: " + ex);
            request.getRequestDispatcher("resources/startbootstrap-sb-admin-gh-pages/dist/404.jsp").forward(request, response);
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
