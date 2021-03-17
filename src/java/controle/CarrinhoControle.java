/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

//import DAO.carrinhoDAO;
import DAO.CarrinhoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.carrinho;
import model.produto;
import model.usuario;

/**
 *
 * @author amaranta
 */
@WebServlet(name = "carrinhoControle", urlPatterns = {"/carrinhoControle"})
public class CarrinhoControle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            
            carrinho carrinho = new carrinho();
            CarrinhoDAO dao = new CarrinhoDAO();

            String acao = request.getParameter("acao");

            if (acao.equals("Carrinho")) {

                int id = (Integer.parseInt(request.getParameter("txtId")));
                carrinho.setId(id);

                String descricao = request.getParameter("txtDescricao");
                carrinho.setProduto(descricao);

                double preco = (Double.parseDouble(request.getParameter("txtPreco")));
                carrinho.setValor(preco);

                int quantidade = (Integer.parseInt(request.getParameter("txtQuantidade")));
                carrinho.setQntdd(quantidade);

                String email = request.getParameter("txtEmail");
                carrinho.setEmailCli(email);

                dao.Cadastrar(carrinho);
                request.getRequestDispatcher("resources/shop-grid.jsp").forward(request, response);

            }
            
            

            if (acao.equals("ListarCart")) {
                
                String email = request.getParameter("txtEmail");
                carrinho.setEmailCli(email);
                
                List<carrinho> cart = dao.Listar();
                request.setAttribute("lCar", cart);
                request.getRequestDispatcher("resources/shoping-cart.jsp").forward(request, response);
                
            }
        } catch (ClassNotFoundException ex) {
            request.setAttribute("Erro", "CarrinhoControle: " +ex);
            request.getRequestDispatcher("resources/startbootstrap-sb-admin-gh-pages/dist/404.jsp").forward(request, response);

        } catch (SQLException ex) {
            request.setAttribute("Erro", "CarrinhoControle: " +ex);
            request.getRequestDispatcher("resources/startbootstrap-sb-admin-gh-pages/dist/404.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("Erro", "CarrinhoControle: " + ex);
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
