/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.CarrinhoDAO;
import DAO.ProdutoDAO;
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
import model.carrinho;
import model.produto;

/**
 *
 * @author amaranta
 */
@WebServlet(name = "ProdutoControle", urlPatterns = {"/ProdutoControle"})
public class ProdutoControle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            produto prod = new produto();
            ProdutoDAO dao = new ProdutoDAO();
            String acao = request.getParameter("acao");

            if (acao.equals("Cadastrar")) {

                String descricao = request.getParameter("txtDescricao");
                prod.setDescricao(descricao);

                String DataEntrada = request.getParameter("txtDataEntrada");
                prod.setDataEntrada(DataEntrada);

                //String categoria = request.getParameter("txtCategoria");
                //prod.setCategoria(Integer.parseInt(categoria));
                String fabricante = request.getParameter("txtFabricante");
                prod.setFabricante(fabricante);

                String qntdd = request.getParameter("txtQntdd");
                prod.setQuantidade(Integer.parseInt(qntdd));

                String preco = request.getParameter("txtPreco");
                prod.setPreco(Double.parseDouble(preco));

                //String cate = request.getParameter("txtCategoria");
                //prod.setCategoria(Integer.parseInt(cate));
                if (descricao != null) {
                    dao.cadastrar(prod);
                    //parte para voltar na mesma página com mensagem de sucesso
                    request.setAttribute("cadProdmsg", "O Registro foi cadastrado com sucesso!");
                    request.getRequestDispatcher("resources/startbootstrap-sb-admin-gh-pages/dist/cadProd.jsp").forward(request, response);
                }
            }
            if (acao.equals("Excluir")) {

                String id = request.getParameter("txtID");
                prod.setId(Integer.parseInt(id));

                if (id != null) {
                    dao.Delete(prod);
                    //parte para voltar na mesma página com mensagem de sucesso
                    request.setAttribute("cadProdmsg", "O Registro apagado com sucesso!");
                    List<produto> produtos = dao.Listar();
                request.setAttribute("lprod", produtos);
                // vai entrar na pagina index com a variavel 'listaFuncionario' com a list prontas
                request.getRequestDispatcher("/resources/startbootstrap-sb-admin-gh-pages/dist/index.jsp").forward(request, response);
                }
            }
            if(acao.equals("Alterar")){
                String id = request.getParameter("txtID");
                prod.setId(Integer.parseInt(id));
                prod = dao.Select(prod);
                request.setAttribute("lprod",prod);
                request.getRequestDispatcher("/resources/startbootstrap-sb-admin-gh-pages/dist/altProd.jsp").forward(request, response);
            }
            if (acao.equals("Salvar")) {

                String id = request.getParameter("txtID");
                prod.setId(Integer.parseInt(id));

                String descricao = request.getParameter("txtDescricao");
                prod.setDescricao(descricao);

                String DataEntrada = request.getParameter("txtDataEntrada");
                prod.setDataEntrada(DataEntrada);

                //String categoria = request.getParameter("txtCategoria");
                //prod.setCategoria(Integer.parseInt(categoria));
                String fabricante = request.getParameter("txtFabricante");
                prod.setFabricante(fabricante);

                String qntdd = request.getParameter("txtQntdd");
                prod.setQuantidade(Integer.parseInt(qntdd));

                String preco = request.getParameter("txtPreco");
                prod.setPreco(Double.parseDouble(preco));

                if (id != null) {
                    dao.Alterar(prod);
                    //parte para voltar na mesma página com mensagem de sucesso
                    request.setAttribute("cadProdmsg", "O Registro foi alterado com sucesso!");
                    List<produto> produtos = dao.Listar();
                    request.setAttribute("lprod", produtos);
                    // vai entrar na pagina index com a variavel 'listaFuncionario' com a list prontas
                    request.getRequestDispatcher("resources/startbootstrap-sb-admin-gh-pages/dist/index.jsp").forward(request, response);
                }
            }
            if (acao.equals("Selecionar")) {
                String descricao = request.getParameter("txtdescricao");
                prod.setId(Integer.parseInt(descricao));
                if (descricao != null) {
                    prod = dao.SelectNome(prod);
                    request.setAttribute("lprod", prod);
                    //não sei onde vai exibir
                    request.getRequestDispatcher("resources/startbootstrap-sb-admin-gh-pages/dist/LoginCli.jsp");
                }
            }
            if (acao.equals("listaProd")) {

                List<produto> produtos = dao.Listar();
                request.setAttribute("lprod", produtos);
                // vai entrar na pagina index com a variavel 'listaFuncionario' com a list prontas
                request.getRequestDispatcher("resources/startbootstrap-sb-admin-gh-pages/dist/index.jsp").forward(request, response);
            }
            
            if (acao.equals("Carrinho")) {

                carrinho carrinho = new carrinho();
                CarrinhoDAO cardao = new CarrinhoDAO();

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

                cardao.Cadastrar(carrinho);
                request.getRequestDispatcher("resources/shoping-cart.jsp").forward(request, response);

            }
            
            if (acao.equals("ListarCart")) {
                
                CarrinhoDAO cardao = new CarrinhoDAO();
                carrinho carrinho = new carrinho();
                
                String email = request.getParameter("txtEmail");
                carrinho.setEmailCli(email);
                
                List<carrinho> cart = cardao.Listar();
                request.setAttribute("lCar", cart);
                request.getRequestDispatcher("resources/shoping-cart.jsp").forward(request, response);
                
            }
            
            if (acao.equals("Produtos")) {

                List<produto> produtos = dao.Listar();
                request.setAttribute("lprod", produtos);
                // vai entrar na pagina index com a variavel 'listaFuncionario' com a list prontas
                request.getRequestDispatcher("resources/shop-grid.jsp").forward(request, response);
            }
            if (acao.equals("listaEsgostados")) {

                List<produto> produtos = dao.ListarEsgotados();
                request.setAttribute("lEsgotados", produtos);
                // vai entrar na pagina index com a variavel 'listaFuncionario' com a list prontas
                request.getRequestDispatcher("resources/startbootstrap-sb-admin-gh-pages/dist/esgotados.jsp").forward(request, response);
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
