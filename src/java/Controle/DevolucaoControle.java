/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import DAO.devolucaoDAO;
import Modelo.Devolucao;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 *
 * @author andre
 */
@WebServlet(name = "DevolucaoControle", urlPatterns = {"/DevolucaoControle",
    "/devolucaoProduto",
    "/listarDevolucao",
    "/visualizarDevolucao",
    "/listarByDescricao",
    "/devolucaoDesc"
})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class DevolucaoControle extends HttpServlet {
    private static String caminho = "C:\\Users\\Guilherme\\Documents\\NetBeansProjects\\PapelariaOrigami\\web\\Files";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/listarDevolucao")) {
            try {
                listarTodos(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FabricanteControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/visualizarDevolucao")) {
            try {
                visualizarDevolucao(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FabricanteControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/devolucaoDesc")) {
            try {
                listarByDescricao(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FabricanteControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/devolucaoProduto")) {
            System.out.println("AQUI");
            try {
                devolucao(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
     private void devolucao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        devolucaoDAO dao = new devolucaoDAO();
        Devolucao dev = new Devolucao();
        
        String nome = request.getParameter("txtNome");
        dev.setNome(nome);
        
        String cpf = request.getParameter("txtCpf");
        dev.setCpf(cpf);
        
        String email = request.getParameter("txtEmail");
        dev.setEmail(email);
        
        String numPedido = request.getParameter("txtNumPedido");
        dev.setNumPedido(Integer.parseInt(numPedido));
        
        String motivo = request.getParameter("txtMotivo");
        dev.setMotivo(motivo);
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");
        Random random = new Random();
        String unique = random.nextInt(89999 + 10000) + simpleDateFormat.format(new Date());
        System.out.println(unique);

        Part part = request.getPart("file");
        String fileName = unique + part.getSubmittedFileName();
        dev.setFileName(fileName);
        
        
        String path = caminho + File.separator + fileName;
        dev.setPath(path);
        InputStream is = part.getInputStream();

        boolean success = uploadFile(is, path);

        if (!motivo.isEmpty() && success) {
            dao.cadastrarDevolucao(dev);
            request.setAttribute("cadDevolucaoMsg", "Seu processo de devoluçãoo foi iniciado com sucesso!"
                    + " Fique atento ao seu e-mail, logo responderemos sua solicitação. Agradecemos por entrar em contato conosco!");
            request.getRequestDispatcher("/View/pagesCliente/devolucao.jsp").forward(request, response);
        } 
    }
     public boolean uploadFile(InputStream is, String path) {
        boolean test = false;

        try {
            byte[] byt = new byte[is.available()];
            is.read(byt);
            FileOutputStream fops = new FileOutputStream(path);
            fops.write(byt);
            fops.flush();
            fops.close();

            test = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;
    }
     
    private void listarTodos(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        Devolucao dev = new Devolucao();
        devolucaoDAO dao = new devolucaoDAO();
        
        List<Devolucao> devolucao ;
        
        if(request.getParameter("txtDescricao") == null){
            devolucao = dao.consultarTodos();
        }
        else{
            devolucao = dao.listByDescricao("txtDescricao");
        }
        request.setAttribute("ldevolucao", devolucao);
        request.getRequestDispatcher("/View/pagesAdm/listDevolucao.jsp").forward(request, response);
    }
    
    
    private void visualizarDevolucao(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        String idString = request.getParameter("txtID");
        Devolucao dev = new Devolucao();
        devolucaoDAO dao = new devolucaoDAO();

        if (idString != null) {
            int id = Integer.parseInt(idString);
            dev = dao.consultarById(id);

            request.setAttribute("ldevolucao", dev);

            request.getRequestDispatcher("/View/pagesAdm/view_devolucao.jsp").forward(request, response);
        }
    }
    
        public void deleteFile(String caminho) {
        File arquivo = new File(caminho);
        try {
            arquivo.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
    private void listarByDescricao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        Devolucao dev = new Devolucao();
        devolucaoDAO dao = new devolucaoDAO();

        String nome = request.getParameter("txtDescricao");
        dev.setNome(nome);
        
        List<Devolucao> categorias = dao.listByDescricao(nome);
        request.setAttribute("ldevolucao", categorias);
        request.getRequestDispatcher("/View/pagesAdm/listDevolucao.jsp").forward(request, response);
    }
}

