/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.checkoutDAO;
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
import model.checkout;
import model.usuario;

/**
 *
 * @author amaranta
 */
@WebServlet(name = "checkoutControle", urlPatterns = {"/checkoutControle"})
public class checkoutControle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            
            usuario user = new usuario();
            checkout check = new checkout();
            checkoutDAO cdao = new checkoutDAO();
            String acao = request.getParameter("cad");
            if (acao.equals("Cadastrar")) {

                String cep = request.getParameter("txtCep");
                check.setCep(Integer.parseInt(cep));
                
                String email = request.getParameter("txtEmail");
                check.setEmail(email);

                String localidade = request.getParameter("txtRua");
                check.setRua(localidade);

                String uf = request.getParameter("txtUF");
                check.setUf(uf);

                String cidade = request.getParameter("txtCidade");
                check.setCidade(cidade);

                String bairro = request.getParameter("txtBairro");
                check.setBairro(bairro);

                String logradouro = request.getParameter("txtLogra");
                check.setLogradouro(logradouro);

                String numero = request.getParameter("txtNumero");
                check.setNumero(Integer.parseInt(numero));

                String complemento = request.getParameter("txtComple");
                check.setComplemento(complemento);
                
                String telefone = request.getParameter("txtTel");
                check.setComplemento(telefone);
                
                    cdao.cadastrar(check);
                    //parte para voltar na mesma página com mensagem de sucesso
                    request.setAttribute("cadCheckmsg", "O Registro foi cadastrado com sucesso!");
                    request.getRequestDispatcher("/resources/checkout.jsp").forward(request, response);
                
            }
            if(acao.equals("Excluir")){
                String id = request.getParameter("txtId");
                check.setId(Integer.parseInt(id));
                if(id != null){
                    cdao.Delete(check);
                    request.setAttribute("cadCheckmsg", "O Registro foi deletado com sucesso!");
                    RequestDispatcher rd = request.getRequestDispatcher("/resources/checkout.jsp");
                }
            }
            if(acao.equals("Alterar")){
                String id = request.getParameter("txtId");
                check.setId(Integer.parseInt(id));
                
                String email = request.getParameter("EMAIL DO CLIENTE");
                check.setCep(Integer.parseInt(email));
                
                String localidade = request.getParameter("txtRua");
                check.setRua(localidade);

                String uf = request.getParameter("txtUF");
                check.setUf(uf);

                String cidade = request.getParameter("txtCidade");
                check.setCidade(cidade);

                String bairro = request.getParameter("txtBairro");
                check.setBairro(bairro);

                String logradouro = request.getParameter("txtLogra");
                check.setLogradouro(logradouro);

                String numero = request.getParameter("txtNumero");
                check.setNumero(Integer.parseInt(numero));

                String complemento = request.getParameter("txtComple");
                check.setComplemento(complemento);

                String telefone = request.getParameter("txtTel");
                check.setTelefone(Integer.parseInt(telefone));
                if(id != null){
                    cdao.Update(check);
                    request.setAttribute("cadCheckmsg", "O Registro foi atualizado com sucesso!");
                    request.getRequestDispatcher("resources/checkout.jsp").forward(request, response);
                }
            }
            if(acao.equals("Selecionar")){
                String id = request.getParameter("txtId");
                check.setId(Integer.parseInt(id));
                if(id != null){
                    check = cdao.Select(check);
                    request.setAttribute("checkout", check);
                    //Aqui eu não sei pra onde mandar mas deixei para o endereço padrão
                    request.getRequestDispatcher("resources/startbootstrap-sb-admin-gh-pages/dist/checkout.jsp").forward(request, response);
                }
            }
            if (acao.equals("Listar")) {
                    List<checkout> lprod = cdao.consultarTodos();
                    request.setAttribute("lprod", lprod);
                    request.getRequestDispatcher("resources/startbootstrap-sb-admin-gh-pages/dist/dadosCli.jsp").forward(request, response);
                
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
