/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.carrinhoDAO;
import DAO.clienteDAO;
import DAO.itemDAO;
import DAO.pedidoDAO;
import DAO.produtoDAO;
import Modelo.Carrinho;
import Modelo.Cliente;
import Modelo.Pedido;
import Modelo.Produto;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ClienteControle", urlPatterns = {"/cadastrarCliente",
    "/loginCliente",
    "/editarCliente",
    "/salvarCliente",
    "/deletarCliente",
    "/atualizarSenha",
    "/areaCliente"})
public class ClienteControle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/listarCliente")) {
            try {
                listar(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/selecionarCliente")) {
            selecionar(request, response);
        } else if (uri.equals(request.getContextPath() + "/deletarCliente")) {
            try {
                deletar(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/areaCliente")){
            try {
                areaCliente(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/loginCliente")) {
            try {
                logar(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/cadastrarCliente")) {
            try {
                cadastrar(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/alterarCliente")) {
            try {
                alterar(request, response);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/atualizarSenha")) {
            try {
                atualizarSenha(request, response);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void logar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        Cliente cliente = new Cliente();
        clienteDAO dao = new clienteDAO();
        Carrinho carrinho = new Carrinho();
        itemDAO itemDAO = new itemDAO();
        carrinhoDAO carrinhoaDAO = new carrinhoDAO();

        HttpSession sessao = request.getSession();

        String email = request.getParameter("email");
        cliente.setEmail(email);
        String senha = request.getParameter("senha");
        cliente.setSenha(senha);
        //System.out.println(senha);

        if (dao.checkLogin(cliente)) {
            cliente = dao.consultarByEmail(email);
            carrinho = carrinhoaDAO.consultarByEmail(email);
            // carrinho.setItemArray(itemDAO.consultarTodosByEmail(email));
            cliente.setCarrinho(carrinho);
            sessao.setAttribute("cliente", cliente);
            sessao.setAttribute("logadocli", cliente);
            System.out.println(sessao.getAttribute("cliente"));
            response.sendRedirect("/PapelariaOrigami/shopGrid");
        } else {
            request.setAttribute("msgErro", "Registro ou senha Ã­nvalidos");
            request.getRequestDispatcher("/View/pagesLogin/loginCliente.jsp").forward(request, response);
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        Cliente cliente = new Cliente();
        clienteDAO dao = new clienteDAO();

        String nome = request.getParameter("txtNome");
        cliente.setNome(nome);

        String email = request.getParameter("txtEmail");
        cliente.setEmail(email);

        String senha = request.getParameter("txtSenha");
        cliente.setSenha(senha);

        String Rsenha = request.getParameter("txtRepeteSenha");        
        cliente.setRepeteSenha(Rsenha);
        
        String cpf = request.getParameter("txtCPF");
        cliente.setCpf(cpf);
        
        //System.out.println(cliente.getRepeteSenha());

        if (email != null && senha != null && senha.equals(Rsenha)) {
            dao.cadastrar(cliente);
            request.setAttribute("cadCliente", "O Registro foi cadastrado com sucesso!");
            request.getRequestDispatcher("/View/pagesLogin/loginCliente.jsp").forward(request, response);
        }
        if (senha != Rsenha) {
            request.setAttribute("senhaDiferente", "Senha e Repete senha estão diferentes");
            request.getRequestDispatcher("/View/pagesLogin/registerCliente.jsp").forward(request, response);
        }
    }

    private void deletar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, SQLException, IOException {
        Cliente cliente = new Cliente();
        clienteDAO dao = new clienteDAO();

        String numId = request.getParameter("idCliente");
        cliente.setId(Integer.parseInt(numId));

        if (numId != null) {
            dao.RemoverFunc(cliente);
            request.setAttribute("delCli", "O cliente foi removido");
            request.getRequestDispatcher("").forward(request, response);
        }
    }

    private void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        Cliente cliente = new Cliente();
        clienteDAO dao = new clienteDAO();

        String numId = request.getParameter("idCliente");
        cliente.setId(Integer.parseInt(numId));

        String nome = request.getParameter("txtNome");
        cliente.setNome(nome);

        String telefone = request.getParameter("txtTelefone");
        cliente.setTelefone(Integer.parseInt(telefone));

        String senha = request.getParameter("txtSenha");
        cliente.setSenha(senha);

        String repeteSenha = request.getParameter("txtRepeteSenha");
        cliente.setRepeteSenha(repeteSenha);

        if (numId != null) {
            dao.atualizar(cliente);
            request.setAttribute("atlCliente", "O cliente" + cliente.getNome() + " foi alterado com sucesso!");
            RequestDispatcher rd = request.getRequestDispatcher("..");
            rd.forward(request, response);
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        Cliente cliente = new Cliente();
        clienteDAO dao = new clienteDAO();

        String id = request.getParameter("txtid");
        cliente.setId(Integer.parseInt(id));
        if (id != null) {
            List<Cliente> lcliente = dao.consultarTodos();
            request.setAttribute("lcliente", lcliente);
            request.getRequestDispatcher("").forward(request, response);
        }
    }

    private void selecionar(HttpServletRequest request, HttpServletResponse response) {
        Cliente cliente = new Cliente();
        clienteDAO dao = new clienteDAO();

        String id = request.getParameter("txtid");
        cliente.setId(Integer.parseInt(id));
        if (id != null) {
            cliente = dao.consultarById(cliente.getId());
            request.setAttribute("cliente", cliente);

            request.getRequestDispatcher("");
        }
    }

    private void atualizarSenha(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        Cliente cli = new Cliente();
        clienteDAO dao = new clienteDAO();

        String email = request.getParameter("txtEmail");
        cli.setEmail(email);

        String senha = request.getParameter("txtSenha");
        cli.setSenha(senha);

        String repeteSenha = request.getParameter("txtRepeteSenha");
        cli.setRepeteSenha(repeteSenha);

        if (email != null && senha != null && senha.equals(repeteSenha)) {
            dao.novaSenha(cli);
            request.setAttribute("msgSucesso", "Sua senha foi alterada com sucesso!");
            request.getRequestDispatcher("/View/pagesLogin/altSenha_cliente.jsp").forward(request, response);
        } else {
            request.setAttribute("msgErro", "Senha e Repete Senha são diferentes!");
            request.getRequestDispatcher("/View/pagesLogin/altSenha_cliente.jsp").forward(request, response);
        }
    }
    
    private void areaCliente(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException{
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        
        pedidoDAO pedidoDao = new pedidoDAO();
        List<Pedido> lPedido = pedidoDao.consultarByCliente(cliente.getId());
        request.setAttribute("lped", lPedido);
        
        request.getRequestDispatcher("/View/pagesCliente/dados_completos.jsp").forward(request, response);
    }
}
