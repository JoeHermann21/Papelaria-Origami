/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.carrinhoDAO;
import DAO.clienteDAO;
import DAO.funcionarioDAO;
import DAO.itemDAO;
import DAO.pedidoDAO;
import DAO.produtoDAO;
import Modelo.Carrinho;
import Modelo.Cliente;
import Modelo.Endereco;
import Modelo.Funcionario;
import Modelo.Item;
import Modelo.Pedido;
import Modelo.Produto;
import Util.EnviarNotaFiscal;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
@WebServlet(name = "PedidoControle", urlPatterns = {"/PedidoControle", 
            "/novoPedido",
            "/mostrarPedido",
            "/meusPedidos", 
            "/pedidos", 
            "/enviarNotaFiscal", 
            "/reportarVendas"})
public class PedidoControle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/novoPedido")) {
            try {
                novoPedido(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(PedidoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/mostrarPedido")) {
            try {
                mostarPedido(request, response);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(PedidoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/meusPedidos")) {
            try {
                mostarMeusPedidos(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(PedidoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/pedidos")) {
            try {
                mostrarTodosPedidos(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(PedidoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/enviarNotaFiscal")) {
            try {
                confirmarPedido(request, response);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(PedidoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.equals(request.getContextPath() + "/reportarVendas")) {
            try {
                gerarRelatorioVendas(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private void novoPedido(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");

        if (cliente.getCarrinho().getItemArray().isEmpty()) {
            response.sendRedirect("http://localhost:8080/PapelariaOrigami/carrinho");
        } else {

            Pedido pedido = new Pedido();
            Carrinho carrinho = new Carrinho();
            pedidoDAO pedidoDao = new pedidoDAO();
            itemDAO itemDAO = new itemDAO();

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");
            Random random = new Random();
            String unique = "PO" + random.nextInt(89999 + 10000) + simpleDateFormat.format(new Date());

            pedido.setCliente(cliente);

            pedido.setCarrinho(carrinho);

            java.sql.Date data = new java.sql.Date(System.currentTimeMillis());

            pedido.setDataCompra(data);

            LocalDate localDate = LocalDate.now().plusDays(5);
            Date dataEntrega = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date dataSql = new java.sql.Date(dataEntrega.getTime());
            pedido.setDataEntrega(dataSql);

            System.out.println(data);
            System.out.println(dataSql);
            pedido.setStatus(false);

            carrinho = cliente.getCarrinho();

            System.out.println(pedido);
            pedido.setValor(carrinho.getValor());

            pedido.setId(pedidoDao.cadastrar(pedido));
            double valor = carrinho.getValor();

            for (int i = 0; i < carrinho.getItemArray().size(); i++) {
                carrinho.getItemArray().get(i).setPedido(pedido);
                itemDAO.adicionarPedido(carrinho.getItemArray().get(i));
            }
            System.out.println(pedido.getId());

            cliente.getCarrinho().setValor(0);
            cliente.getCarrinho().getItemArray().clear();
            session.setAttribute("cliente", cliente);

            response.sendRedirect("http://localhost:8080/PapelariaOrigami/View/pagesCliente/fim_compra.jsp");
        }
    }

    private void mostarPedido(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        ArrayList<Item> item = new ArrayList<Item>();
        itemDAO itemDAO = new itemDAO();

        int id = Integer.parseInt(request.getParameter("id"));
        Pedido pedido = new Pedido();
        pedido.setId(id);
        Carrinho carrinho = new Carrinho();
        pedidoDAO pedidoDao = new pedidoDAO();
        item.addAll(itemDAO.itemPedido(id));
        System.out.println(item);
        request.setAttribute("lItens", item);
        request.getRequestDispatcher("/View/pagesAdm/pedidosCli.jsp").forward(request, response);

    }

    private void mostarMeusPedidos(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        itemDAO itemDAO = new itemDAO();

        ArrayList<Item> item = new ArrayList<Item>();

        int id = cliente.getId();
        ArrayList<Pedido> pedido = new ArrayList<Pedido>();
        Carrinho carrinho = cliente.getCarrinho();
        System.out.println("");
        pedidoDAO pedidoDao = new pedidoDAO();
        // pedido = pedidoDao.consultarByCliente(id); 
        item.addAll(itemDAO.intensPedido(cliente));
        System.out.println(item);
        request.setAttribute("lcarrinho", carrinho);
        request.getRequestDispatcher("");

    }

    private void mostrarTodosPedidos(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        ArrayList<Pedido> pedido = new ArrayList<Pedido>();
        pedidoDAO pedidoDAO = new pedidoDAO();

        pedido.addAll(pedidoDAO.consultarTodosPedidosCli());

        request.setAttribute("lpedido", pedido);

        request.getRequestDispatcher("/View/pagesAdm/dadosCli.jsp").forward(request, response);
    }

    private void confirmarPedido(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        pedidoDAO pedidoDAO = new pedidoDAO();
        Pedido pedido = new Pedido();
        pedido.setId(id);

        EnviarNotaFiscal notafiscal = new EnviarNotaFiscal();
        notafiscal.enviarHotmail(pedido);
        produtoDAO prodDAO = new produtoDAO();

        ArrayList<Produto> prod = prodDAO.selecionarProdutoByPedido(id);
        for (Produto p : prod) {
            prodDAO.subtrairQuantidade(p);
        }
        System.out.println("sdsd");
        pedidoDAO.atualizarStatus(pedido);

        response.sendRedirect("http://localhost:8080/PapelariaOrigami/mostrarPedido?id=" + id);
    }

     private void gerarRelatorioVendas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        Document documento = new Document();
        itemDAO idao = new itemDAO();
        pedidoDAO pdao = new pedidoDAO();

        funcionarioDAO fdao = new funcionarioDAO();      
        
        clienteDAO cdao = new clienteDAO();
        
        HttpSession sessao = request.getSession();
        Funcionario func = (Funcionario) sessao.getAttribute("funcionario");

        Funcionario fun = fdao.consultarByReg(func.getRegistro());


        try {
            response.setContentType("apllication/pdf");
            response.addHeader("Content-Disposition", "inline; filename="
                    + "pedidos.pdf");

            PdfWriter.getInstance(documento, response.getOutputStream());

            java.sql.Date data = new java.sql.Date(System.currentTimeMillis());
            SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            documento.open();
            documento.add(new Paragraph("                                      Lista de Pedidos        "));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph("Data da emissão do relatório: " + formatarDate.format(data)));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph("Emitido por: " + fun.getNome() + " " + fun.getSobrenome()));
            documento.add(new Paragraph(" "));
//            documento.add(new Paragraph("Cliente: " + cli.getNome() + " "));
            documento.add(new Paragraph(" "));
//            documento.add(new Paragraph("CPF: " + cli.getCpf() + " "));
            documento.add(new Paragraph(" "));

            float[] columnWidths = {2, 3, 4, 3, 5, 4, 10};

            PdfPTable tabela = new PdfPTable(columnWidths);
            PdfPCell col1 = new PdfPCell(new Paragraph("Nº"));
            PdfPCell col2 = new PdfPCell(new Paragraph("Data Compra"));
            PdfPCell col3 = new PdfPCell(new Paragraph("Status"));
            PdfPCell col4 = new PdfPCell(new Paragraph("Produtos"));
            PdfPCell col5 = new PdfPCell(new Paragraph("Prev entrega"));
            PdfPCell col6 = new PdfPCell(new Paragraph("Valor itens"));
            PdfPCell col7 = new PdfPCell(new Paragraph("Dados End"));

            tabela.addCell(col1).setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabela.addCell(col2).setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabela.addCell(col3).setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabela.addCell(col4).setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabela.addCell(col5).setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabela.addCell(col6).setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabela.addCell(col7).setBackgroundColor(BaseColor.LIGHT_GRAY);

            List<Pedido> listapedido = pdao.consultarTodos();
            List<Item> listaitem = idao.consultarTodos();
            
            for (Pedido pedido : listapedido) {
                Endereco e = new Endereco();
                col1 = new PdfPCell(new Paragraph(pedido.getNumPedido() + ""));
                col2 = new PdfPCell(new Paragraph(pedido.getDataCompra() + ""));
                col3 = new PdfPCell(new Paragraph(pedido.isStatus() + ""));
                for (Item item : listaitem)
                {
                    col4 = new PdfPCell(new Paragraph(item.getProduto().getDescricao() + "R$ " + item.getProduto().getPreco()));
                            }
                col5 = new PdfPCell(new Paragraph(pedido.getDataEntrega() + ""));
                col6 = new PdfPCell(new Paragraph(pedido.getValor() + ""));
                col7 = new PdfPCell(new Paragraph(e.getLogradouro() + ".    Nº" + e.getNumero() + ". CEP: " + e.getCep() + " Bairro: " + e.getBairro() + " Cidade: " + e.getCidade() + "-" + e.getUf()));
                
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
}
