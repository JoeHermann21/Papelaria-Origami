/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.funcionarioDAO;
import Modelo.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "FuncionarioControle", urlPatterns = {"/FuncionarioControle"})
public class FuncionarioControle extends HttpServlet {

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
        Funcionario funcionario = new Funcionario();  
        funcionarioDAO dao = new funcionarioDAO();
        
        String acao = request.getParameter("acao");
                
        if (acao.equals("Entrar")) {
            HttpSession sessao = request.getSession();

            String registro = request.getParameter("registro");
            funcionario.setRegistro(Integer.parseInt(registro));
            String senha = request.getParameter("senha");
            funcionario.setSenha(senha);
            System.out.println(senha);
            System.out.println(registro);

            if (dao.checkLogin(funcionario)) {
                sessao.setAttribute("funcionario", funcionario);
                request.getRequestDispatcher("/View/pagesAdm/index2.jsp").forward(request, response);
            } else {
                request.setAttribute("msgErro", "Registro ou senha ínvalidos");
                request.getRequestDispatcher("/View/pagesLogin/loginAdm.jsp").forward(request, response);
            }
        } else if (acao.equals("Cadastrar")){
            String nome = request.getParameter("txtNome");
            funcionario.setNome(nome);
            
            String sobrenome = request.getParameter("txtSobrenome");
            funcionario.setSobrenome(sobrenome);

            String cpf = request.getParameter("txtCpf");
            funcionario.setCpf(cpf);

            String registro = request.getParameter("txtRegistro");
            Integer intRegistro = Integer.parseInt(registro);
            funcionario.setRegistro(intRegistro);
            
            
            String senha = request.getParameter("txtSenha");
            funcionario.setSenha(senha);

            String Rsenha = request.getParameter("txtRepeteSenha");
            funcionario.setRepeteSenha(Rsenha);
            
            if (cpf != null && registro != null) {
                // dao.cadastrar(funcionario);
                request.setAttribute("cadFuncmsg", "O Registro foi cadastrado com sucesso!");
                request.getRequestDispatcher("/loginFuncionario.jsp").forward(request, response);
            }
        }
         if (acao.equals("Deletar")) {
                String numReg = request.getParameter("txtNumReg");
                funcionario.setRegistro(Integer.parseInt(numReg));
                
                if(numReg != null){
                    dao.RemoverFunc(funcionario);
                    request.setAttribute("cadFunmsg", "O Registro do funcionário "+funcionario.getNome()+" "+funcionario.getSobrenome()+" foi cadastrado com sucesso!");
                    request.getRequestDispatcher("").forward(request, response);
                }
            }
            if(acao.equals("Alterar")){
                
                String nome = request.getParameter("txtNome");
                funcionario.setNome(nome);

                String sobrenome = request.getParameter("txtSobrenome");
                funcionario.setSobrenome(sobrenome);

                String numReg = request.getParameter("txtNumReg");
                funcionario.setRegistro(Integer.parseInt(numReg));

                String senha = request.getParameter("txtSenha");
                funcionario.setSenha(senha);

                String repeteSenha = request.getParameter("txtRepeteSenha");
                funcionario.setRepeteSenha(repeteSenha);

                if (numReg != null) {
                   // dao.Alterar(funcionario);
                    request.setAttribute("cadFunmsg", "O Registro do funcionário "+funcionario.getNome()+" foi alterado com sucesso!");
                    RequestDispatcher rd = request.getRequestDispatcher("");
                    rd.forward(request, response);
                }
            }
            if (acao.equals("Listar")) {
                String id = request.getParameter("txtid");
                funcionario.setId(Integer.parseInt(id));
                if (id != null) {
                   // List<Funcionario> lprod = dao.consultarTodos();
                   // request.setAttribute("lprod", lprod);
                    request.getRequestDispatcher("").forward(request, response);
                }
            }if(acao.equals("Selecionar")){
                String id = request.getParameter("txtid");
                funcionario.setId(Integer.parseInt(id));
                if(id != null){
                   // funcionario = dao.select(funcionario);
                    request.setAttribute("func", funcionario);
                   
                    request.getRequestDispatcher("");
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
            Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
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
