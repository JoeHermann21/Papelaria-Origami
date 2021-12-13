/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.funcionarioDAO;
import DAO.produtoDAO;
import DAO.usuarioDAO;
import Modelo.Funcionario;
import Modelo.Produto;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "FuncionarioControle", urlPatterns = {"/FuncionarioControle",
    "/loginFunc",
    "/cadastrarFunc",
    "/alterarFunc",
    "/salvarFunc",
    "/deletarFunc",
    "/listarFunc",
    "/FuncionarioDesc"})
public class FuncionarioControle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/listarFunc")) {
            try {
                listar(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/alterarFunc")) {
            selecionar(request, response);
        }if (uri.equals(request.getContextPath() + "/FuncionarioDesc")) {
            try {
                listarByDescricao(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/deletarFunc")) {
            try {
                deletar(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/loginFunc")) {
            try {
                logar(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/cadastrarFunc")) {
            try {
                cadastrar(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/salvarFunc")) {
            try {
                alterar(request, response);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void logar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        Funcionario funcionario = new Funcionario();
        funcionarioDAO dao = new funcionarioDAO();
        produtoDAO prodDAO = new produtoDAO();
        Produto prod = new Produto();

        HttpSession sessao = request.getSession();

        String registro = request.getParameter("registro");
        funcionario.setRegistro(Integer.parseInt(registro));
        String senha = request.getParameter("senha");
        funcionario.setSenha(senha);
        System.out.println(senha);
        System.out.println(registro);

        if (dao.checkLogin(funcionario)) {
            sessao.setAttribute("funcionario", funcionario);
      
            List<Produto> produtos = prodDAO.consultarTodos();
            request.setAttribute("lprod", produtos);
                        
            funcionario = dao.consultarByReg(Integer.parseInt(registro));
            sessao.setAttribute("logado", funcionario);
                       
            
            request.getRequestDispatcher("/View/pagesAdm/index2.jsp").forward(request, response);
        } else {
            request.setAttribute("msgErro", "O registro ou a senha está errado");
            request.setAttribute("msgAtencao", "ATENÇÃO!");
            request.getRequestDispatcher("/View/pagesLogin/loginAdm.jsp").forward(request, response);
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        
        Funcionario funcionario = new Funcionario();
        funcionarioDAO dao = new funcionarioDAO();
        usuarioDAO userDAO = new usuarioDAO();
        
        String nome = request.getParameter("txtNome");
        funcionario.setNome(nome);

        String sobrenome = request.getParameter("txtSobrenome");
        funcionario.setSobrenome(sobrenome);

        String cpf = request.getParameter("txtCPF");
        funcionario.setCpf(cpf);
        System.out.println(cpf);

//       String registro = request.getParameter("txtRegistro");
//       Integer intRegistro = Integer.parseInt(registro);
//        funcionario.setRegistro(intRegistro);

        String senha = request.getParameter("txtSenha");
        funcionario.setSenha(senha);

        String Rsenha = request.getParameter("txtRepeteSenha");
        funcionario.setRepeteSenha(Rsenha);
        
       
       if (senha != null && senha.equals(Rsenha)) {
            dao.cadastrar(funcionario);
            request.setAttribute("cadFuncmsg", "O novo funcionário foi cadastrado com sucesso! ");
            request.getRequestDispatcher("/View/pagesLogin/loginAdm.jsp").forward(request, response);
        }else {
            request.setAttribute("senhaDiferente", "Senha e Repete senha estão diferentes");
            request.getRequestDispatcher("/View/pagesAdm/register.jsp").forward(request, response);
        }
    }

    private void deletar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, SQLException, IOException {
        Funcionario funcionario = new Funcionario();
        funcionarioDAO dao = new funcionarioDAO();

        String id = request.getParameter("txtID");
        funcionario.setId(Integer.parseInt(id));

        if (id != null) {
            dao.RemoverFunc(funcionario);
            request.setAttribute("deleteFunmsg", "O funcionário foi removido com sucesso!");
            List<Funcionario> lprod = dao.consultarTodos();
            request.setAttribute("lfunc", lprod);
            request.getRequestDispatcher("/View/pagesAdm/listFuncionario.jsp").forward(request, response);
        }
    }

    private void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        Funcionario funcionario = new Funcionario();
        funcionarioDAO dao = new funcionarioDAO();
           
        String id = request.getParameter("txtID");
        funcionario.setId(Integer.parseInt(id));

        String nome = request.getParameter("txtNome");
        funcionario.setNome(nome);

        String sobrenome = request.getParameter("txtSobrenome");
        funcionario.setSobrenome(sobrenome);

        String numReg = request.getParameter("txtNumReg");
        funcionario.setRegistro(Integer.parseInt(numReg));
        
        String cpf = request.getParameter("txtCPF");
        funcionario.setCpf(cpf);

        String senha = request.getParameter("txtSenha");
        funcionario.setSenha(senha);

        String repeteSenha = request.getParameter("txtRepeteSenha");
        funcionario.setRepeteSenha(repeteSenha);

        if (numReg != null && !senha.isEmpty() && !repeteSenha.isEmpty() && !nome.isEmpty() && !cpf.isEmpty()) {
            dao.atualizar(funcionario);
            List<Funcionario> lfunc = dao.consultarTodos();
            request.setAttribute("lfunc", lfunc);
            request.setAttribute("cadFunmsg", "O Registro do funcionário " + funcionario.getNome() + " foi alterado com sucesso!");
            request.getRequestDispatcher("/View/pagesAdm/listFuncionario.jsp").forward(request, response);
        } else {
            List<Funcionario> lfunc = dao.consultarTodos();
            request.setAttribute("lfunc", lfunc);
            request.setAttribute("cadFunmsg", "Os campos tem qye ser preenchidos!");
            request.getRequestDispatcher("/View/pagesAdm/listFuncionario.jsp").forward(request, response);
        }
        
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        Funcionario funcionario = new Funcionario();
        funcionarioDAO dao = new funcionarioDAO();

        List<Funcionario> lfunc = dao.consultarTodos();
        request.setAttribute("lfunc", lfunc);
        request.getRequestDispatcher("/View/pagesAdm/listFuncionario.jsp").forward(request, response);
    }

    private void selecionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Funcionario funcionario = new Funcionario();
        funcionarioDAO dao = new funcionarioDAO();

        String id = request.getParameter("txtID");
        funcionario.setId(Integer.parseInt(id));
        
        if (id != null) {
            funcionario = dao.consultarById(funcionario.getId());
            request.setAttribute("lfunc", funcionario);

            request.getRequestDispatcher("/View/pagesAdm/altFuncionario.jsp").forward(request, response);
        }
    }
    private void listarByDescricao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        Funcionario funcionario = new Funcionario();
        funcionarioDAO dao = new funcionarioDAO();
        
        String descricao = request.getParameter("txtDescricao");
        funcionario.setNome(descricao);
        
        List<Funcionario> func = dao.listByDescricao(descricao);
        request.setAttribute("lfunc", func);
        request.getRequestDispatcher("/View/pagesAdm/listFuncionario.jsp").forward(request, response);
        
    }
}
