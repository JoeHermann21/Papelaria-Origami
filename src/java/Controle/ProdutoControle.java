/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.categoriaDAO;
import DAO.clienteDAO;
import DAO.fabricanteDAO;
import DAO.funcionarioDAO;
import DAO.produtoDAO;
import Modelo.Categoria;
import Modelo.Cliente;
import Modelo.Fabricante;
import Modelo.Funcionario;
import Modelo.Produto;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Guilherme
 */
@WebServlet(name = "ProdutoControle", urlPatterns = {"/ProdutoControle",
    "/cadastrarProduto",
    "/editarProduto",
    "/painelControle",
    "/excluirProduto",
    "/iniciarCadastro",
    "/iniciarEdicao",
    "/listarEsgotado",
    "/excluirEsgotado",
    "/shopGrid",
    "/ProdutoDesc",
    "/produto",
    "/reportar",
    "/ProdutoDescCliente",
    "/ProdutoDescEsgotados",
    "/reportarEsgotando", 
    "/categoriaProduto"
})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class ProdutoControle extends HttpServlet {

    private static String caminho = "C:\\Users\\Guilherme\\Documents\\NetBeansProjects\\PapelariaOrigami\\web\\Files";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/painelControle")) {
            try {
                listarProdutos(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (uri.equals(request.getContextPath() + "/ProdutoDesc")) {
            try {
                listarByDescricao(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(CategoriaControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (uri.equals(request.getContextPath() + "/ProdutoDescCliente")) {
            try {
                listarByDescricaoCliente(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(CategoriaControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (uri.equals(request.getContextPath() + "/ProdutoDescEsgotados")) {
            try {
                listarByDescricaoEsgotados(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(CategoriaControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/excluirProduto")) {
            try {
                excluirProduto(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/iniciarCadastro")) {
            try {
                iniciarCadastro(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/iniciarEdicao")) {
            try {
                iniciarEdicao(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/listarEsgotado")) {
            try {
                listarEsgotado(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/excluirEsgotado")) {
            try {
                excluirEsgotado(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/shopGrid")) {
            try {
                listarShopGrid(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/produto")) {
            detalhe(request, response);
        } else if (uri.equals(request.getContextPath() + "/reportar")) {
            gerarRelatorioProdutos(request, response);
        } else if (uri.equals(request.getContextPath() + "/reportarEsgotando")) {
            gerarRelatorioProdutosEsgotando(request, response);
        }  else if (uri.equals(request.getContextPath() + "/categoriaProduto")) {
            try {
                produtosCategoria(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/cadastrarProduto")) {
            System.out.println("AQUI");
            try {
                cadastrar(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            if (uri.equals(request.getContextPath() + "/editarProduto")) {
                try {
                    editarProduto(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        Produto prod = new Produto();
        produtoDAO dao = new produtoDAO();
        fabricanteDAO fabDAO = new fabricanteDAO();
        categoriaDAO catDao = new categoriaDAO();

        String titulo = request.getParameter("txtTitulo");
        prod.setTitulo(titulo);

        String descricao = request.getParameter("txtDescricao");
        prod.setDescricao(descricao);

        String data = request.getParameter("txtDataEntrada");
        java.util.Date dataUtil = new java.util.Date();
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
        prod.setDataEntrada(dataSql);

        String txtCategoria = request.getParameter("txtCategoria");
        String txtFabricante = request.getParameter("txtFabricante");

        Fabricante fab = new Fabricante();

        fab = fabDAO.consultarByDescricao(txtFabricante);

        Categoria cat = new Categoria();

        cat = catDao.consultarByDescricao(txtCategoria);

        prod.setCategoria(cat);
        prod.setFabricante(fab);

        String qntdd = request.getParameter("txtQntdd");
        prod.setQuantidade(Integer.parseInt(qntdd));

        String qntddMinima = request.getParameter("txtQuantidadeMinima");
        prod.setQuantidadeMinima(Integer.parseInt(qntddMinima));

        String peso = request.getParameter("txtPeso");
        prod.setPeso(Double.parseDouble(peso));

        String material = request.getParameter("txtMaterial");
        prod.setMaterial(material);

        String uniEmbalagem = request.getParameter("txtUniEmbalagem");
        prod.setUniEmbalagem(Integer.parseInt(uniEmbalagem));

        String cor = request.getParameter("txtCor");
        prod.setCor(cor);

        String dimensao = request.getParameter("txtDimensao");
        prod.setDimensao(dimensao);

        String preco = request.getParameter("txtPreco");
        prod.setPreco(Double.parseDouble(preco));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");
        Random random = new Random();
        String unique = random.nextInt(89999 + 10000) + simpleDateFormat.format(new Date());
        System.out.println(unique);

        Part part = request.getPart("file");
        String fileName = unique + part.getSubmittedFileName();
        prod.setFileName(fileName);

        String path = caminho + File.separator + fileName;
        prod.setPath(path);
        InputStream is = part.getInputStream();

        boolean success = uploadFile(is, path);

        if (!descricao.isEmpty() && success) {
            dao.cadastrar(prod);
            request.setAttribute("cadProdmsg", "O Produto " + titulo + " foi cadastrado com sucesso!");
            List<Categoria> categorias = catDao.consultarTodos();
            List<Fabricante> fabricante = fabDAO.consultarTodos();
            request.setAttribute("lcat", categorias);
            request.setAttribute("lfab", fabricante);
            request.getRequestDispatcher("/View/pagesAdm/cadProd.jsp").forward(request, response);
        } else {
            request.setAttribute("msgErro", "O campo descrição não pode ficar vazio!");
            List<Categoria> categorias = catDao.consultarTodos();
            List<Fabricante> fabricante = fabDAO.consultarTodos();
            request.setAttribute("lcat", categorias);
            request.setAttribute("lfab", fabricante);
            request.getRequestDispatcher("/View/pagesAdm/cadProd.jsp").forward(request, response);
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

    public void deleteFile(String caminho) {
        File arquivo = new File(caminho);
        try {
            arquivo.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void editarProduto(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {

        Produto prod = new Produto();
        produtoDAO dao = new produtoDAO();
        fabricanteDAO fabDAO = new fabricanteDAO();
        categoriaDAO catDao = new categoriaDAO();

        String id = request.getParameter("txtID");
        prod.setId(Integer.parseInt(id));

        String titulo = request.getParameter("txtTitulo");
        prod.setTitulo(titulo);

        String descricao = request.getParameter("txtDescricao");
        prod.setDescricao(descricao);

        String data = request.getParameter("txtDataEntrada");
        java.util.Date dataUtil = new java.util.Date();
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
        prod.setDataEntrada(dataSql);

        String categoria = request.getParameter("txtCategoria");
        String fabricante = request.getParameter("txtFabricante");

        Fabricante fab = new Fabricante();
        Categoria cat = new Categoria();

        cat = catDao.consultarByDescricao(categoria);
        fab = fabDAO.consultarByDescricao(fabricante);

        prod.setCategoria(cat);
        prod.setFabricante(fab);

        String qntdd = request.getParameter("txtQntdd");
        prod.setQuantidade(Integer.parseInt(qntdd));

        String quantidadeMinima = request.getParameter("txtQuantidadeMinima");
        prod.setQuantidadeMinima(Integer.parseInt(quantidadeMinima));

        String peso = request.getParameter("txtPeso");
        prod.setPeso(Double.parseDouble(peso));

        String material = request.getParameter("txtMaterial");
        prod.setMaterial(material);

        String uniEmbalagem = request.getParameter("txtUniEmbalagem");
        prod.setUniEmbalagem(Integer.parseInt(uniEmbalagem));

        String cor = request.getParameter("txtCor");
        prod.setCor(cor);

        String dimensao = request.getParameter("txtDimensao");
        prod.setDimensao(dimensao);

        String preco = request.getParameter("txtPreco");
        prod.setPreco(Double.parseDouble(preco));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");
        Random random = new Random();
        String unique = random.nextInt(89999 + 10000) + simpleDateFormat.format(new Date());
        System.out.println(unique);

        Part part = request.getPart("file");
        String fileName = unique + part.getSubmittedFileName();
        prod.setFileName(fileName);
        String tipo = part.getContentType();

        String path = caminho + File.separator + fileName;
        prod.setPath(path);
        InputStream is = part.getInputStream();

        boolean success = uploadFile(is, path);

        if (id != null) {
            String caminho = dao.retornarCaminho(prod.getId());
            deleteFile(caminho);
            dao.atualizar(prod);

            response.sendRedirect("/PapelariaOrigami/painelControle");
        }
    }

    private void listarProdutos(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        HttpSession sessao = request.getSession();
        Funcionario func = (Funcionario) sessao.getAttribute("funcionario");
        if(func == null){
           response.sendRedirect("/PapelariaOrigami/View/pagesLogin/loginAdm.jsp");
           return;
        }
        Produto prod = new Produto();
        produtoDAO dao = new produtoDAO();
        fabricanteDAO fabDAO = new fabricanteDAO();
        categoriaDAO catDao = new categoriaDAO();
        List<Produto> produtos = dao.consultarTodos();
        request.setAttribute("lprod", produtos);
        request.getRequestDispatcher("/View/pagesAdm/index2.jsp").forward(request, response);
    }

    private void listarShopGrid(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        Produto prod = new Produto();
        produtoDAO dao = new produtoDAO();
        fabricanteDAO fabDAO = new fabricanteDAO();
        categoriaDAO catDao = new categoriaDAO();
        List<Produto> produtos = dao.consultarTodos();
        List<Categoria> categorias = catDao.consultarTodos();
        request.setAttribute("lprod", produtos);
        request.setAttribute("lcat", categorias);

        request.getRequestDispatcher("/View/pagesCliente/shop-grid.jsp").forward(request, response);
    }

    private void excluirProduto(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        Produto prod = new Produto();
        produtoDAO dao = new produtoDAO();

        String id = request.getParameter("txtID");
        prod.setId(Integer.parseInt(id));
        System.out.println(prod.getId());

        String camminho = dao.retornarCaminho(prod.getId());
        if (id != null) {
            deleteFile(camminho);
            dao.RemoverProd(prod);
            request.setAttribute("ExcProdmsg", "O Produto de código " + id + " foi apagado com sucesso!");
            List<Produto> produtos = dao.consultarTodos();
            request.setAttribute("lprod", produtos);
            request.getRequestDispatcher("View/pagesAdm/index2.jsp").forward(request, response);
        }
    }

    private void iniciarCadastro(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        Produto prod = new Produto();
        produtoDAO dao = new produtoDAO();
        fabricanteDAO fabDAO = new fabricanteDAO();
        categoriaDAO catDao = new categoriaDAO();

        List<Categoria> categorias = catDao.consultarTodos();
        List<Fabricante> fabricante = fabDAO.consultarTodos();
        request.setAttribute("lcat", categorias);
        request.setAttribute("lfab", fabricante);
        request.getRequestDispatcher("/View/pagesAdm/cadProd.jsp").forward(request, response);
    }

    private void iniciarEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        String idString = request.getParameter("txtID");
        Produto prod = new Produto();
        produtoDAO dao = new produtoDAO();
        fabricanteDAO fabDAO = new fabricanteDAO();
        categoriaDAO catDao = new categoriaDAO();

        if (idString != null) {
            int id = Integer.parseInt(idString);
            prod = dao.consultarById(id);

            List<Categoria> categorias = catDao.consultarTodos();
            List<Fabricante> fabricante = fabDAO.consultarTodos();
            request.setAttribute("lcat", categorias);
            request.setAttribute("lfab", fabricante);

            request.setAttribute("lprod", prod);

            request.getRequestDispatcher("/View/pagesAdm/altProd.jsp").forward(request, response);
        }
    }

    private void listarEsgotado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        Produto prod = new Produto();
        produtoDAO dao = new produtoDAO();
        List<Produto> produtosEsg = dao.consultarEsgotando();
        request.setAttribute("lprodEsg", produtosEsg);
        request.getRequestDispatcher("/View/pagesAdm/esgotados.jsp").forward(request, response);
    }

    private void excluirEsgotado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        Produto prod = new Produto();
        produtoDAO dao = new produtoDAO();
        String id = request.getParameter("txtID");
        prod.setId(Integer.parseInt(id));
        System.out.println(prod.getId());
        if (id != null) {
            dao.RemoverProd(prod);
            request.setAttribute("cadProdmsg", "O Registro apagado com sucesso!");
            List<Produto> produtos = dao.consultarEsgotando();
            request.setAttribute("lprodEsg", produtos);
            request.getRequestDispatcher("View/pagesAdm/esgotados.jsp").forward(request, response);
        }
    }

    private void detalhe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Produto prod = new Produto();
        produtoDAO dao = new produtoDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        prod = dao.consultarById(id);
        request.setAttribute("produto", prod);
        request.getRequestDispatcher("View/pagesCliente/shop-details.jsp").forward(request, response);
    }

    private void listarByDescricao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        Produto produto = new Produto();
        produtoDAO dao = new produtoDAO();

        String titulo = request.getParameter("txtDescricao");
        produto.setTitulo(titulo);

        List<Produto> produtos = dao.listByDescricao(titulo);
        request.setAttribute("lprod", produtos);
        request.getRequestDispatcher("/View/pagesAdm/index2.jsp").forward(request, response);

        List<Produto> prodEsgotando = dao.listByDescricao(titulo);
        request.setAttribute("lprodEsg", prodEsgotando);
        request.getRequestDispatcher("/View/pagesAdm/esgotados.jsp").forward(request, response);
    }

    private void listarByDescricaoEsgotados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        Produto produto = new Produto();
        produtoDAO dao = new produtoDAO();

        String titulo = request.getParameter("txtTitulo");
        produto.setTitulo(titulo);

        // NA página de esgotados
        List<Produto> prodEsgotando = dao.listByDescricaoEsgotado(titulo);
        request.setAttribute("lprodEsg", prodEsgotando);
        request.getRequestDispatcher("/View/pagesAdm/esgotados.jsp").forward(request, response);

    }

    private void listarByDescricaoCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        Produto produto = new Produto();
        produtoDAO dao = new produtoDAO();

        String descricao = request.getParameter("txtDescricao");
        produto.setDescricao(descricao);

        List<Produto> produtos = dao.listByDescricao(descricao);
        request.setAttribute("lprod", produtos);
        request.getRequestDispatcher("/View/pagesCliente/shop-grid.jsp").forward(request, response);

    }

    private void gerarRelatorioProdutos(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Document documento = new Document();
        produtoDAO pdao = new produtoDAO();
        
        funcionarioDAO fdao = new funcionarioDAO();
        Funcionario fun = new Funcionario();
        
        HttpSession sessao = request.getSession();
        Funcionario func = (Funcionario) sessao.getAttribute("funcionario");

        fun = fdao.consultarByReg(func.getRegistro());
        
        
        try {
            response.setContentType("apllication/pdf");
            response.addHeader("Content-Disposition", "inline; filename="
                    + "produtos.pdf");
                    
            PdfWriter.getInstance(documento, response.getOutputStream());

            java.sql.Date data = new java.sql.Date(System.currentTimeMillis());
            SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            
            
            documento.open();
            documento.add(new Paragraph("                                      Lista de Produtos        "));
            documento.add(new Paragraph(""));
            documento.add(new Paragraph("Data da emissão do relatório: " + formatarDate.format(data)));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph("Emitido por: " + fun.getNome() +" " + fun.getSobrenome()));
            documento.add(new Paragraph(" "));

            float[] columnWidths = {2 , 3, 4, 3, 5, 4, 10};
            
            PdfPTable tabela = new PdfPTable(columnWidths);
            PdfPCell col1 = new PdfPCell(new Paragraph("ID"));
            PdfPCell col2 = new PdfPCell(new Paragraph("Título"));
            PdfPCell col3 = new PdfPCell(new Paragraph("Desc."));
            PdfPCell col4 = new PdfPCell(new Paragraph("Data Ent."));
            PdfPCell col5 = new PdfPCell(new Paragraph("Fabricante"));
            PdfPCell col6 = new PdfPCell(new Paragraph("Categ."));
            PdfPCell col7 = new PdfPCell(new Paragraph("Especificações"));
            
            tabela.addCell(col1).setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabela.addCell(col2).setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabela.addCell(col3).setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabela.addCell(col4).setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabela.addCell(col5).setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabela.addCell(col6).setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabela.addCell(col7).setBackgroundColor(BaseColor.LIGHT_GRAY);

            List<Produto> listaproduto = pdao.consultarTodos();

            for (Produto produto : listaproduto) {
                col1 = new PdfPCell(new Paragraph(produto.getId() + ""));
                col2 = new PdfPCell(new Paragraph(produto.getTitulo() + ""));
                col3 = new PdfPCell(new Paragraph(produto.getDescricao() + ""));
                col4 = new PdfPCell(new Paragraph(produto.getDataEntrada() + ""));
                col5 = new PdfPCell(new Paragraph(produto.getFabricante().descricao + ""));
                col6 = new PdfPCell(new Paragraph(produto.getCategoria().descricao + ""));
                col7 = new PdfPCell(new Paragraph("Quantidade: "+produto.getQuantidade()+".    R$" + produto.getPreco() + ". Peso: " + produto.getPeso() + "Kg Uni. Embalagem: " + produto.getUniEmbalagem() + ". Material: " + produto.getMaterial() + ".      Cor: " + produto.getCor() + ".     Dimesões: " + produto.getDimensao()));
               
               
                tabela.addCell(col1);
                tabela.addCell(col2);
                tabela.addCell(col3);
                tabela.addCell(col4);
                tabela.addCell(col5);
                tabela.addCell(col6);
                tabela.addCell(col7);
            }

            documento.add(tabela);
            documento.close();
        } catch (Exception e) {
            System.out.println(e);
            documento.close();
        }
    }
     
     private void gerarRelatorioProdutosEsgotando(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Document documento = new Document();
        produtoDAO pdao = new produtoDAO();
        
        funcionarioDAO fdao = new funcionarioDAO();
        Funcionario fun = new Funcionario();
        
        HttpSession sessao = request.getSession();
        Funcionario func = (Funcionario) sessao.getAttribute("funcionario");

        fun = fdao.consultarByReg(func.getRegistro());
        
        
        try {
            response.setContentType("apllication/pdf");
            response.addHeader("Content-Disposition", "inline; filename="
                    + "produtos.pdf");
                    
            PdfWriter.getInstance(documento, response.getOutputStream());

            java.sql.Date data = new java.sql.Date(System.currentTimeMillis());
            SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            
            
            documento.open();
            documento.add(new Paragraph("                                      Lista de Produtos Esgotando        "));
            documento.add(new Paragraph(""));
            documento.add(new Paragraph("Data da emissão do relatório: " + formatarDate.format(data)));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph("Emitido por: " + fun.getNome() +" " + fun.getSobrenome()));
            documento.add(new Paragraph(" "));

            float[] columnWidths = {2 , 3, 4, 3, 5, 4, 10};
            
            PdfPTable tabela = new PdfPTable(columnWidths);
            PdfPCell col1 = new PdfPCell(new Paragraph("ID"));
            PdfPCell col2 = new PdfPCell(new Paragraph("Título"));
            PdfPCell col3 = new PdfPCell(new Paragraph("Desc."));
            PdfPCell col4 = new PdfPCell(new Paragraph("Data Ent."));
            PdfPCell col5 = new PdfPCell(new Paragraph("Fabricante"));
            PdfPCell col6 = new PdfPCell(new Paragraph("Categ."));
            PdfPCell col7 = new PdfPCell(new Paragraph("Especificações"));
            
            tabela.addCell(col1).setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabela.addCell(col2).setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabela.addCell(col3).setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabela.addCell(col4).setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabela.addCell(col5).setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabela.addCell(col6).setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabela.addCell(col7).setBackgroundColor(BaseColor.LIGHT_GRAY);

            List<Produto> listaproduto = pdao.consultarTodos();

            for (Produto produto : listaproduto) {
                col1 = new PdfPCell(new Paragraph(produto.getId() + ""));
                col2 = new PdfPCell(new Paragraph(produto.getTitulo() + ""));
                col3 = new PdfPCell(new Paragraph(produto.getDescricao() + ""));
                col4 = new PdfPCell(new Paragraph(produto.getDataEntrada() + ""));
                col5 = new PdfPCell(new Paragraph(produto.getFabricante().descricao + ""));
                col6 = new PdfPCell(new Paragraph(produto.getCategoria().descricao + ""));
                col7 = new PdfPCell(new Paragraph("Quantidade: "+produto.getQuantidade()+".    R$" + produto.getPreco() + ". Peso: " + produto.getPeso() + "Kg Uni. Embalagem: " + produto.getUniEmbalagem() + ". Material: " + produto.getMaterial() + ".      Cor: " + produto.getCor() + ".     Dimesões: " + produto.getDimensao()));
               
               
                tabela.addCell(col1);
                tabela.addCell(col2);
                tabela.addCell(col3);
                tabela.addCell(col4);
                tabela.addCell(col5);
                tabela.addCell(col6);
                tabela.addCell(col7);
            }

            documento.add(tabela);
            documento.close();
        } catch (Exception e) {
            System.out.println(e);
            documento.close();
        }
    }
    private void produtosCategoria(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        Produto prod = new Produto();
        produtoDAO dao = new produtoDAO();
        categoriaDAO catDao = new categoriaDAO();

        int id = Integer.parseInt(request.getParameter("id"));

        List<Produto> produtos = dao.consultarByCategoriaId(id);
        List<Categoria> categorias = catDao.consultarTodos();
        request.setAttribute("lprod", produtos);
        request.setAttribute("lcat", categorias);
        request.getRequestDispatcher("/View/pagesCliente/shop-grid.jsp").forward(request, response);

    }
}
