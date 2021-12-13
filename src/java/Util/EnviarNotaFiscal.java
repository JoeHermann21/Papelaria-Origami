/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import DAO.carrinhoDAO;
import DAO.itemDAO;
import Modelo.Carrinho;
import Modelo.Categoria;
import Modelo.Cliente;
import Modelo.Endereco;
import Modelo.Fabricante;
import Modelo.Funcionario;
import Modelo.Item;
import Modelo.Pedido;
import Modelo.Produto;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author andre
 */
public class EnviarNotaFiscal {

    private String emailDestinatario;

    private String assunto;
    private String msg;

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean enviarGmail(int idPedido) throws SQLException, ClassNotFoundException {
        boolean retorno = false;
        //Get the session object  
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session s = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("papelOrigami.sup@gmail.com", "P@p2021origami");//email e senha usuário 
            }
        });

        //compose message  
        try {
            MimeMessage message = new MimeMessage(s);
            message.setFrom(new InternetAddress("papelOrigami.sup@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("guilhermejoazeiro@gmail.com"));
            Pedido p = new Pedido();
            Funcionario fu = new Funcionario();
            Cliente cl = new Cliente();
            Endereco e = new Endereco();
            Fabricante fa = new Fabricante();
            Categoria ca = new Categoria();

            Carrinho carrinho = new Carrinho();

            String mensagem = null;
            StringBuilder texto = new StringBuilder();
            texto.append("PAPELARIA ORIGAMI");
            texto.append("<br/>");
            texto.append(" -------------------- ");
            texto.append("<br/>");
            texto.append("Data da Compra: ").append((Date) p.getDataCompra());
            texto.append("<br/>");
            texto.append(" -------------------- ");
            texto.append("<br/>");
            texto.append("Cliente: ").append(cl.getNome());
            texto.append("<br/>");
            texto.append("CPF: ").append(cl.getCpf());
            texto.append("<br/>");
            texto.append(" -------------------- ");
            texto.append("<br/>");
            texto.append(" Itens da compra ");
            texto.append("<br/>");
            texto.append(produtosCarrinho(idPedido));

            texto.append("<br/>");
            texto.append(" -------------------- ");
            texto.append("<br/>");
            texto.append("Valor total: ").append(carrinho.getValor());
            setMsg(texto.toString());

            int numero;
            Random num = new Random();
            numero = (num.nextInt(1000) + 1) * 1000000000;

            message.setSubject("Nota Fiscal Nº " + numero);
            message.setContent(this.msg, "text/html; charset=utf-8");

            Transport.send(message);

            retorno = true;

        } catch (MessagingException e) {
            retorno = false;
            e.printStackTrace();
        }
        return retorno;
    }

    public List<Item> produtosCarrinho(int pedido) throws SQLException, ClassNotFoundException {

        itemDAO idao = new itemDAO();
        List<Item> listaitem = idao.itemPedido(pedido);

        for (Item item : listaitem) {
            item.getId();
            item.getProduto().getDescricao();
            item.getValor();
            item.getQuantidade();
            item.getCarrinho();
            item.getPedido();
        }

        return listaitem;
    }

    public boolean enviarHotmail(Pedido ped) throws ClassNotFoundException, SQLException {
        Pedido pedido = new Pedido();
        boolean retorno = false;
        
        //Get the session object  
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

        Session s = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("papelOrigami.sup@outlook.com", "P@p2021origami");//email e senha usuário 
            }
        });
        s.setDebug(true);
        //compose message  
        try {
            List<Item> item = produtosCarrinho(ped.getId());
            pedido = item.get(0).getPedido();
            Cliente cliente = pedido.getCliente();
            MimeMessage message = new MimeMessage(s);
            message.setFrom(new InternetAddress("papelOrigami.sup@outlook.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(pedido.getCliente().getEmail()));

            String mensagem = null;
            StringBuilder texto = new StringBuilder();
            texto.append("<h2 align='center'>Papelaria Origami</h2><br>");
            texto.append("<h2>SEU PEDIDO FOI CONFIRMADO</h2><br/>");
            texto.append("<br/>");
            texto.append(" -------------------- ");
            texto.append("<br/>");
            texto.append("Data da Compra: ").append((Date) pedido.getDataCompra());
            texto.append("<br/>");
            texto.append("Data prevista para entrega: ").append((Date) pedido.getDataEntrega());
            texto.append("<br/>");
            //texto.append("Vendedor: ").append(fu.getNome());
            texto.append("<br/>");
            texto.append(" -------------------- ");
            texto.append("<br/>");
            texto.append("Cliente: ").append(pedido.getCliente().getNome());
            texto.append("<br/>");
            texto.append("CPF: ").append(cliente.getCpf());
            texto.append("<br/>");
            texto.append(" -------------------- ");
            texto.append("<br/>");
            texto.append(" Itens da compra ");
            
            for (Item i : item) {
                texto.append("<br/>");
                texto.append("Produto: ").append(i.getProduto().getTitulo());
                texto.append("<br/>");
                texto.append("Preço: ").append(i.getProduto().getPreco());
                texto.append("<br/>");
                texto.append("Quantidade: ").append(i.getQuantidade());
                texto.append("<br/>");
                texto.append("Valor: ").append(i.getValor());
                texto.append("<br/>");
                texto.append(" -------------------- ");
            }
            texto.append("<br/>");
            texto.append("<h1> Valor Total: R$").append(pedido.getValor());
            texto.append("</h1> ");
            setMsg(texto.toString());

            int numero;
            Random num = new Random();
            numero = (num.nextInt(1000) + 1) * 1000000000;

            message.setSubject("Nota Fiscal Nº " +numero );
            message.setContent(this.msg, "text/html; charset=utf-8");

            Transport.send(message);

            retorno = true;

        } catch (MessagingException e) {
            retorno = false;
            e.printStackTrace();
        }
        return retorno;
    }

    @Override
    public String toString() {
        return "EnviarNotaFiscal{ "
                + "emailDestinatario= " + emailDestinatario
                + " assunto= " + assunto
                + " msg= " + msg + '}';
    }

}
