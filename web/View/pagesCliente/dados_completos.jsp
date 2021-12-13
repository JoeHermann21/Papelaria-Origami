<%@page import="java.util.List"%>
<%@page import="Modelo.Pedido"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.apache.jasper.tagplugins.jstl.ForEach"%>
<%@page import="Modelo.Produto"%>
<%@page import="Modelo.Carrinho"%>
<%@page import="Modelo.Cliente"%>
<%@page import="Modelo.Endereco"%>
<!DOCTYPE html>
<html lang="PT-BR">
    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Minha Conta</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="View/pagesCliente/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="View/pagesCliente/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="View/pagesCliente/css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="View/pagesCliente/css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="View/pagesCliente/css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="View/pagesCliente/css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="View/pagesCliente/css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="View/pagesCliente/css/style.css" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>


    </head>
    <%
        Cliente cli = (Cliente) session.getAttribute("cliente");
        if (cli == null) {
            response.sendRedirect("/PapelariaOrigami/View/pagesLogin/loginCliente.jsp");
        }


    %>

    <body>

        <!-- Humberger Begin -->
        <div class="humberger__menu__overlay"></div>
        <div class="humberger__menu__wrapper">
            <div class="humberger__menu__logo">
                <a href="#"><img src="img/logo.png" alt=""></a>
            </div>
            <div class="humberger__menu__cart">
                <ul>
                    <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                    <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                </ul>
                <div class="header__cart__price">item: <span>$150.00</span></div>
            </div>
            <div class="humberger__menu__widget">
                <div class="header__top__right__language">
                    <img src="View/pagesCliente/img/brasil.png" alt="">
                    <div>Português</div>
                </div>
                <div class="header__top__right__auth">
                    <a href="http://localhost:8080/PapelariaOrigami/logout"><i class="fa fa-user"></i> Logout</a>
                </div>
            </div>
            <nav class="humberger__menu__nav mobile-menu">
                <ul>
                    <li class="active"><a href="http://localhost:8080/PapelariaOrigami/">Home</a></li>
                    <li><a href="http://localhost:8080/PapelariaOrigami/shopGrid">Shop</a></li>
                    <li><a href="http://localhost:8080/PapelariaOrigami/carrinho">Carrinho</a></li>
                    <li><a href="http://localhost:8080/PapelariaOrigami/meuendereco">Meu endereço</a></li>
                    <li><a href="http://localhost:8080/PapelariaOrigami/View/pagesCliente/contact.jsp">Contato</a></li>
                    <li><a href="http://localhost:8080/PapelariaOrigami/areaCliente">Minha Conta</a></li>
                    <li><a href="http://localhost:8080/PapelariaOrigami/View/pagesCliente/devolucao.jsp">Devolução</a></li>
                </ul>
            </nav>
            <div id="mobile-menu-wrap"></div>
            <div class="header__top__right__social">
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-linkedin"></i></a>
                <a href="#"><i class="fa fa-pinterest-p"></i></a>
            </div>
            <div class="humberger__menu__contact">
                <ul>
                    <li><i class="fa fa-envelope"></i>papelOrigami.sup@outlook.com</li>
                    <li>Bem Vindo!!</li>
                </ul>
            </div>
        </div>
        <!-- Humberger End -->

        <!-- Header Section Begin -->
        <header class="header">
            <div class="header__top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="header__top__left">
                                <ul>
                                    <li><i class="fa fa-envelope"></i>papelOrigami.sup@outlook.com</li>
                                    <li>Bem Vindo!!</li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="header__top__right">
                                <div class="header__top__right__social">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-linkedin"></i></a>
                                    <a href="#"><i class="fa fa-pinterest-p"></i></a>
                                </div>
                                <div class="header__top__right__language">
                                    <img src="View/pagesCliente/img/brasil.png" alt="">
                                    <div>Português</div>
                                </div>
                                <div class="header__top__right__auth">
                                    <a href="http://localhost:8080/PapelariaOrigami/logout"><i class="fa fa-user"></i> Logout</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="header__logo">
                            <a href="./index.html"><img src="http://localhost:8080/PapelariaOrigami/View/pagesCliente/img/logo_com_titulo.jpg" width="130" height="130" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <nav class="header__menu">
                            <ul>
                                <li class="active"><a href="http://localhost:8080/PapelariaOrigami/">Home</a></li>
                                <li><a href="http://localhost:8080/PapelariaOrigami/shopGrid">Shop</a></li>
                                <li><a href="http://localhost:8080/PapelariaOrigami/carrinho">Carrinho</a></li>
                                <li><a href="http://localhost:8080/PapelariaOrigami/View/pagesCliente/checkout.jsp">Meu endereço</a></li>
                                <li><a href="http://localhost:8080/PapelariaOrigami/View/pagesCliente/contact.jsp">Contato</a></li>
                                <li><a href="http://localhost:8080/PapelariaOrigami/areaCliente">Minha Conta</a></li>
                                <li><a href="http://localhost:8080/PapelariaOrigami/View/pagesCliente/devolucao.jsp">Devolução</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-lg-3">
                        <div class="header__cart">

                            <ul>

                                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span><% out.print(cli.getCarrinho().getItemArray().size()); %></span></a></li>
                            </ul>
                            <div class="header__cart__price">item: <span><% out.print(cli.getCarrinho().getValor());%></span></div>

                        </div>
                    </div>
                </div>
                <div class="humberger__open">
                    <i class="fa fa-bars"></i>
                </div>
            </div>
        </header>
        <!-- Header Section End -->

        <!-- Hero Section Begin -->
        <section class="hero hero-normal">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="hero__categories">
                            <div class="hero__categories__all">
                                <i class="fa fa-bars"></i>
                                <span>Disponíveis</span>
                            </div>
                            <ul>
                                <li><a href="#">Materiais de escrita</a></li>
                                <li><a href="#">Cadernos</a></li>
                                <li><a href="#">Canecas</a></li>
                                <li><a href="#">Materiais de pintura</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="hero__search">
                            <div class="hero__search__form">
                                <form action="#">
                                    <div class="hero__search__categories">
                                        Pesquisa
                                        <span class="arrow_carrot-down"></span>
                                    </div>
                                    <input type="text" placeholder="O que você está procurando?">
                                    <button type="submit" class="site-btn">Pesquisar</button>
                                </form>
                            </div>
                            <div class="hero__search__phone">
                                <div class="hero__search__phone__icon">
                                    <i class="fa fa-phone"></i>
                                </div>
                                <div class="hero__search__phone__text">
                                    <h5>+55 11.1188.888</h5>
                                    <span>support 24/7 time</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Hero Section End -->

        <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <div class="breadcrumb__text">
                            <h2>Meus Dados</h2>
                            <div class="breadcrumb__option">
                                <a href="index.jsp">Home</a>
                                <span>Meus Dados</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!------------INFORMAÇÕES DA CONTA------------>
        <section class="shoping-cart spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">

                    </div>
                </div>
                <form>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="shoping__checkout">
                                <h2 align='center'>Informações da Conta</h2>
                                <ul>
                                    <div class="camposCartao">
                                        <div class="checkout__input">
                                            <p>Nome: </p>
                                            <input type="text" name="txtNome" id="nome"  class="form-control" readonly="true" value="<%=cli.getNome()%>">
                                        </div>
                                        <div class="checkout__input">
                                            <p>Telefone: </p>
                                            <input type="text" name="txtTelefone" id="telefone"  class="form-control" readonly="true" value="<%=cli.getTelefone()%>">
                                        </div>
                                        <div class="checkout__input">
                                            <p>CPF: </p>
                                            <input type="text" name="txtCpf" id="cpf"  class="form-control" readonly="true" value="<%=cli.getCpf()%>">
                                        </div>
                                        <div class="checkout__input">
                                            <p>E-mail: </p>
                                            <input type="text" name="txtEmail" id="email"  class="form-control" readonly="true" value="<%=cli.getEmail()%>">
                                        </div>
                                    </div>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <img src="img/congratulations.png" alt=""/>
                        </div>
                    </div>

                    <br>
                    <br>
                    <%
                        List<Pedido> lped = (List<Pedido>) request.getAttribute("lped");
                    %>
                    <h2 align='center'><%out.print(lped.size()); %> Meus Pedidos</h2>                                       
                    <section class="shoping-cart spad">
                        <div class="container">

                            <div class="row">

                                <div class="col-lg-12">
                                    <div class="shoping__cart__table">
                                        <table>                                             
                                            <thead>
                                                <tr>
                                                    <th class="shoping__product">Pedido</th>
                                                    <!-- <th>Produtos</th>
                                                     <th>Unidades </th> -->
                                                    <th>Valor Total</th>
                                                    <th>Data Envio</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    for (Pedido p : lped) {
                                                %> 
                                                <tr>

                                                    <td class="shoping__cart__item">
                                                        <h5><%out.print(p.getId()); %></h5>                                            
                                                    </td>
                                                    <!--
                                                    <td class="shoping__cart__price">

                                                    </td>
                                                    <td class="shoping__cart__quantity">
                                                        <h5>uni</h5>
                                                    </td>
                                                    -->
                                                    <td class="shoping__cart__total">
                                                        <h5><%out.print(p.getValor()); %></h5>
                                                    </td>
                                                    <td class="shoping__cart__total">
                                                        <h5><%out.print(p.getDataCompra()); %></h5>
                                                    </td>
                                                </tr>   
                                                <%  }%>
                                            </tbody>

                                        </table>
                                    </div>
                                </div>
                            </div>


                            <!------------ENDEREÇO------------>
                            <div class="row">
                                <%
                                    Endereco end = cli.getEndereco();
                                %>
                                <div class="col-lg-6">
                                    <div class="shoping__checkout">
                                        <h5><span>Endereço de Entrega</span></h5>
                                        <ul>
                                            <li>Logradouro: <span><%=end.getLogradouro()%> </span> </li>
                                            <li>CEP: <span><%=end.getCep()%></span></li>
                                            <li>Estado: <span><%=end.getUf()%></span></li>
                                            <li>Bairro: <span><%=end.getBairro()%></span></li>
                                            <li>Cidade: <span><%=end.getCidade()%></span></li>
                                            <li>Número: <span><%=end.getNumero()%></span></li>
                                            <li>Complemento: <span><%=end.getComplemento()%></span></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </form>

            </div>
        </section>
        <!-- Shoping Cart Section End -->

        <!-- Footer Section Begin -->
        <footer class="footer spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="footer__copyright">
                            <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                    Copyright &copy;<script>document.write(new Date().getFullYear());</script> Desenvolvido por Origamis <i class="fa fa-heart" aria-hidden="true"></i> 
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                            <div class="footer__copyright__payment"><img src="img/payment-item.png" alt=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Footer Section End -->

        <!-- Js Plugins -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>        
        <script src="View/pagesCliente/js/main.js"></script>




    </body>

</html>