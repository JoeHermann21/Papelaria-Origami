/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.FuncionarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.funcionario;
import model.produto;

/**
 *
 * @author amaranta
 */
@WebServlet(name = "FuncionarioControle", urlPatterns = {"/FuncionarioControle"})
public class FuncionarioControle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String acao = request.getParameter("cad");

            funcionario func = new funcionario();
            FuncionarioDAO dao = new FuncionarioDAO();
            
            if (acao.equals("Cadastrar")) {

                String nome = request.getParameter("txtNome");
                func.setNome(nome);

                String sobrenome = request.getParameter("txtSobrenome");
                func.setSobrenome(sobrenome);

                String numReg = request.getParameter("txtNumReg");
                func.setRegistro(Integer.parseInt(numReg));

                String senha = request.getParameter("txtSenha");
                func.setSenha(senha);

                String confirmaSenha = request.getParameter("txtConfSenha");
                func.setConfSenha(confirmaSenha);

                if (numReg != null) {
                    dao.cadastrar(func);
                    //parte para voltar na mesma página com mensagem de sucesso
                    request.setAttribute("cadFunmsg", "O Registro do funcionário "+func.getNome()+" foi cadastrado com sucesso!");
                    RequestDispatcher rd = request.getRequestDispatcher("/resources/startbootstrap-sb-admin-gh-pages/dist/register.jsp");
                    rd.forward(request, response);
                }
            }
            if (acao.equals("Deletar")) {
                String numReg = request.getParameter("txtNumReg");
                func.setRegistro(Integer.parseInt(numReg));
                
                if(numReg != null){
                    dao.Deletar(func);
                    request.setAttribute("cadFunmsg", "O Registro do funcionário "+func.getNome()+" "+func.getSobrenome()+" foi cadastrado com sucesso!");
                    request.getRequestDispatcher("resources/startbootstrap-sb-admin-gh-pages/dist/register.jsp").forward(request, response);
                }
            }
            if(acao.equals("Alterar")){
                
                String nome = request.getParameter("txtNome");
                func.setNome(nome);

                String sobrenome = request.getParameter("txtSobrenome");
                func.setSobrenome(sobrenome);

                String numReg = request.getParameter("txtNumReg");
                func.setRegistro(Integer.parseInt(numReg));

                String senha = request.getParameter("txtSenha");
                func.setSenha(senha);

                String confirmaSenha = request.getParameter("txtConfSenha");
                func.setConfSenha(confirmaSenha);

                if (numReg != null) {
                    dao.Alterar(func);
                    //parte para voltar na mesma página com mensagem de sucesso
                    request.setAttribute("cadFunmsg", "O Registro do funcionário "+func.getNome()+" foi alterado com sucesso!");
                    RequestDispatcher rd = request.getRequestDispatcher("resources/startbootstrap-sb-admin-gh-pages/dist/register.jsp");
                    rd.forward(request, response);
                }
            }
            if (acao.equals("Listar")) {
                String id = request.getParameter("txtid");
                func.setId(Integer.parseInt(id));
                if (id != null) {
                    List<funcionario> lprod = dao.consultarTodos();
                    request.setAttribute("lprod", lprod);
                    request.getRequestDispatcher("resources/startbootstrap-sb-admin-gh-pages/dist/register.jsp").forward(request, response);
                }
            }if(acao.equals("Selecionar")){
                String id = request.getParameter("txtid");
                func.setId(Integer.parseInt(id));
                if(id != null){
                    func = dao.Select(func);
                    request.setAttribute("func", func);
                    //não sei onde vai exibir
                    request.getRequestDispatcher("resources/startbootstrap-sb-admin-gh-pages/dist/.jsp");
                }
            }
        } catch (SQLException ex) {
            request.setAttribute("Erro", ex);
            request.getRequestDispatcher("404.jsp");
        } catch (ClassNotFoundException ex) {
            request.setAttribute("Erro", ex);
            request.getRequestDispatcher("404.jsp");
        } catch (Exception ex) {
            request.setAttribute("Erro", ex);
            RequestDispatcher rd = request.getRequestDispatcher("404.jsp");
            rd.forward(request, response);
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
