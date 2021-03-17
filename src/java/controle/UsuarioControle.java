/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

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
import model.usuario;

/**
 *
 * @author amaranta
 */
@WebServlet(name = "UsuarioControle", urlPatterns = {"/UsuarioControle"})
public class UsuarioControle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            usuario user = new usuario();
            UsuarioDAO dao = new UsuarioDAO();
            String acao = request.getParameter("acao");

            if (acao.equals("Cadastrar")) {

                String nome = request.getParameter("txtnome");
                user.setNome(nome);

                String cpf = request.getParameter("txtcpf");
                user.setCpf(cpf);

                String email = request.getParameter("txtemail");
                user.setEmail(email);

                String senha = request.getParameter("txtsenha");
                user.setSenha(senha);

                String Rsenha = request.getParameter("txtRSenha");
                user.setRepeteSenha(Rsenha);
                if (cpf != null) {
                    dao.cadastrar(user);
                    request.setAttribute("cadUsermsg", "O Registro foi cadastrado com sucesso!");
                    request.getRequestDispatcher("/resources/Login_v13/LoginCLI.jsp").forward(request, response);
                }
            }
            if (acao.equals("ListarUsuario")) {
                List<usuario> luser = dao.consultarTodos();
                request.setAttribute("luser", luser);
                request.getRequestDispatcher("FODA-se").forward(request, response);
            }
            if (acao.equals("Alterar")) {

                String id = request.getParameter("txtid");
                user.setId(Integer.parseInt(id));
                user = dao.Select(user);
                request.setAttribute("luser", user);
                request.getRequestDispatcher("alterado").forward(request, response);
            }
            if (acao.equals("Salvar")) {

                String nome = request.getParameter("txtnome");
                user.setNome(nome);

                String cpf = request.getParameter("txtcpf");
                user.setCpf(cpf);

                String email = request.getParameter("txtemail");
                user.setEmail(email);

                String senha = request.getParameter("txtsenha");
                user.setSenha(senha);

                String Rsenha = request.getParameter("txtRsenha");
                user.setRepeteSenha(Rsenha);
                if (cpf != null) {
                    dao.Update(user);
                    request.setAttribute("cadUsermsg", "O Registro foi cadastrado com sucesso!");
                    request.getRequestDispatcher("Cadastrado").forward(request, response);
                }
            }
            if (acao.equals("Deletar")) {
                String id = request.getParameter("txtid");
                user.setId(Integer.parseInt(id));

                dao.Delete(user);
                request.getRequestDispatcher("Deletado").forward(request, response);
            }
            if (acao.equals("Selecionar")) {
                String nome = request.getParameter("txtnome");
                user.setNome(nome);

                user = dao.Select(user);
                request.setAttribute("luser", user);
                request.getRequestDispatcher("Selecionado").forward(request, response);
            }
            if (acao.equals("Entrar")) {
                HttpSession sessao = request.getSession();
                
                
                String email = request.getParameter("txtEmail");
                user.setEmail(email);

                String senha = request.getParameter("txtSenha");
                user.setSenha(senha);

                if (dao.checkLogin(user)) {
                    sessao.setAttribute("usuario", user);
                    request.getRequestDispatcher("/resources/inicial.jsp").forward(request, response);

                } else {
                    request.setAttribute("Erro", "Usuário ou senha inválidos");
                    request.getRequestDispatcher("/resources/Login_v13/LoginCLI.jsp").forward(request, response);
                }
            }
            if(acao.equals("Logout")){
                
                HttpSession sessao = request.getSession();
                sessao.setAttribute("usuario", null);
                request.getRequestDispatcher("/Papelaria/index.jsp").forward(request, response);
                
            }
        } catch (SQLException ex) {
            request.setAttribute("Erro", ex);
            request.getRequestDispatcher("resources/startbootstrap-sb-admin-gh-pages/dist/404.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            request.setAttribute("Erro", ex);
            request.getRequestDispatcher("resources/startbootstrap-sb-admin-gh-pages/dist/404.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("Erro", ex);
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
