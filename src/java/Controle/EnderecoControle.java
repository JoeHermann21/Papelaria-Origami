/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.clienteDAO;
import DAO.enderecoDAO;
import Modelo.Cliente;
import Modelo.Endereco;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jboss.weld.context.http.HttpRequestContext;

/**
 *
 * @author Guilherme
 */
@WebServlet(name = "EnderecoControle", urlPatterns = {"/EnderecoControle", "/cadastrarEndereco", "/meuendereco", "/atualizarEndereco"})
public class EnderecoControle extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/meuendereco")) {
            visualizar(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/cadastrarEndereco")) {
            try {
                cadastrar(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(EnderecoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (uri.equals(request.getContextPath() + "/atualizarEndereco")) {
            try {
                alterar(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(EnderecoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Endereco endereco = new Endereco();
        enderecoDAO enderecoDAO = new enderecoDAO();

        clienteDAO cliDAO = new clienteDAO();

        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        String emailcli = cliente.getEmail();

        String email = request.getParameter("txtEmail");

        String cep = request.getParameter("txtCep");
        endereco.setCep(cep);

        String rua = request.getParameter("txtRua");
        endereco.setLogradouro(rua);

        String estado = request.getParameter("txtUF");
        endereco.setUf(estado);

        String cidade = request.getParameter("txtCidade");
        endereco.setCidade(cidade);

        String bairro = request.getParameter("txtBairro");
        endereco.setBairro(bairro);

        int numero = Integer.parseInt(request.getParameter("txtNumero"));
        endereco.setNumero(numero);
        
        int telefone = Integer.parseInt(request.getParameter("txtTel"));
        cliente.setTelefone(telefone);        

        String complemento = request.getParameter("txtComple");
        endereco.setComplemento(complemento);

        endereco.setId(enderecoDAO.cadastrar(endereco));
        System.out.println(endereco.getId());
        cliente.setEndereco(endereco);
        cliDAO.atualizar(cliente);
        response.sendRedirect("/PapelariaOrigami/meuendereco");
    }

    private void visualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        Endereco end = new Endereco();
        end = cliente.getEndereco();
        System.out.println(end.getCep());

        if (end.getId() == 0) {
            response.sendRedirect("http://localhost:8080/PapelariaOrigami/View/pagesCliente/checkout.jsp");
        } else {
            request.setAttribute("endereco", end);
            request.getRequestDispatcher("/View/pagesCliente/visualizar_checkout.jsp").forward(request, response);
        }

    }

    private void deletar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        Endereco end = new Endereco();
        enderecoDAO endDAO = new enderecoDAO();

        endDAO.RemoverProd(end);
    }

    private void alterar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, UnsupportedEncodingException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Endereco endereco = new Endereco();
        enderecoDAO enderecoDAO = new enderecoDAO();

        clienteDAO cliDAO = new clienteDAO();

        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        String emailcli = cliente.getEmail();

        endereco.setId(cliente.getEndereco().getId());

        String email = request.getParameter("txtEmail");

        String cep = request.getParameter("txtCep");
        endereco.setCep(cep);

        String rua = request.getParameter("txtRua");
        endereco.setLogradouro(rua);

        String estado = request.getParameter("txtUF");
        endereco.setUf(estado);

        String cidade = request.getParameter("txtCidade");
        endereco.setCidade(cidade);

        String bairro = request.getParameter("txtBairro");
        endereco.setBairro(bairro);

        int numero = Integer.parseInt(request.getParameter("txtNumero"));
        endereco.setNumero(numero);

        int telefone = Integer.parseInt(request.getParameter("txtTel"));
        cliente.setTelefone(telefone);      
        
        String complemento = request.getParameter("txtComple");
        endereco.setComplemento(complemento);

        System.out.println(endereco.getId());
        cliente.setEndereco(endereco);
        System.out.println(cliente.getEndereco());
        enderecoDAO.atualizar(endereco);
        response.sendRedirect("http://localhost:8080/PapelariaOrigami/View/pagesCliente/pagamento.jsp");
    }

}
