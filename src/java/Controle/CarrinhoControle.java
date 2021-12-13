/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.carrinhoDAO;
import DAO.clienteDAO;
import DAO.itemDAO;
import DAO.produtoDAO;
import DAO.usuarioDAO;
import Modelo.Carrinho;
import Modelo.Cliente;
import Modelo.Item;
import Modelo.Produto;
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
@WebServlet(name = "CarrinhoControle", urlPatterns = {"/CarrinhoControle", "/adicionarNoCarrinho", "/removerDoCarrinho", "/carrinho"})
public class CarrinhoControle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/removerDoCarrinho")) {
            try {
                removerDoCarrinho(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CarrinhoControle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CarrinhoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/carrinho")) {
            try {
                mostrarCarrinho(request, response);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(CarrinhoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/adicionarNoCarrinho")) {
            try {
                adicionarNoCarrinho(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(CarrinhoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void adicionarNoCarrinho(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Item item = new Item();
        Produto produto = new Produto();

        int id = Integer.parseInt(request.getParameter("id"));

        produtoDAO prodDao = new produtoDAO();
        produto = prodDao.consultarById(id);
        item.setProduto(produto);

        carrinhoDAO carrDAO = new carrinhoDAO();
        Carrinho crr = new Carrinho();

        itemDAO itemDAO = new itemDAO();

        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        String emailcli = cliente.getEmail();

        int qntd = Integer.parseInt(request.getParameter("txtQTD"));

        if (qntd > produto.getQuantidade()) {
            response.sendRedirect("/PapelariaOrigami/produto?id=" + id);
        } else {
            item.setQuantidade(qntd);
            item.setValor();

            if (!checarCarrinho(emailcli)) {
                crr.setEmailcli(emailcli);
                int idCarrinho = carrDAO.cadastrar(crr);

            }

            crr = carrDAO.consultarByEmail(emailcli);
            item.setCarrinho(crr);

            itemDAO.cadastrar(item);
            crr.setEmailcli(emailcli);
            crr.addItem(item);
            crr.valorCarrinho();
            carrDAO.atualizar(crr);

            cliente.setCarrinho(crr);
            session.setAttribute("cliente", cliente);

            response.sendRedirect("/PapelariaOrigami/carrinho");
        }
    }

    private void removerDoCarrinho(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        Item item = new Item();
        itemDAO itemDAO = new itemDAO();
        Carrinho carrinho = new Carrinho();

        int id = Integer.parseInt(request.getParameter("id"));
        item.setId(id);
        carrinho.removerItem(id);
        itemDAO.RemoverItem(item);

        response.sendRedirect("/PapelariaOrigami/carrinho");
    }

    private void mostrarCarrinho(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        Item item = new Item();
        Produto produto = new Produto();
        Carrinho carrinho = new Carrinho();
        carrinhoDAO carrDAO = new carrinhoDAO();

        itemDAO itemDAO = new itemDAO();

        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        String emailcli = cliente.getEmail();

        carrinho = cliente.getCarrinho();

        if (!checarCarrinho(emailcli)) {
            Carrinho crr = new Carrinho();
            crr.setEmailcli(emailcli);
            carrDAO.cadastrar(crr);
        }

        carrinho = carrDAO.consultarByEmail(emailcli);

        carrinho.setValor(0);

        carrinho.setItemArray(itemDAO.consultarTodosByEmail(emailcli));
        carrinho.valorCarrinho();
        carrDAO.atualizar(carrinho);
        System.out.println("daoo");
        cliente.setCarrinho(carrinho);
        session.setAttribute("cliente", cliente);
        request.setAttribute("lcarrinho", carrinho);
        request.getRequestDispatcher("/View/pagesCliente/shoping-cart.jsp").forward(request, response);
    }

    private boolean checarCarrinho(String email) throws SQLException, ClassNotFoundException {
        boolean existe = false;

        carrinhoDAO carrDAO = new carrinhoDAO();

        existe = carrDAO.checarCarrinho(email);

        return existe;
    }

}
