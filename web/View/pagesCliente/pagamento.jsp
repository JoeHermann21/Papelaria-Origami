<%@page import="Modelo.Cliente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.apache.jasper.tagplugins.jstl.ForEach"%>
<%@page import="Modelo.Produto"%>
<%@page import="Modelo.Carrinho"%>
<!DOCTYPE html>
<html lang="PT-BR">
    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Pagamento</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>


        <script>
            function formatarCampo(campoTexto) {
                campoTexto.value = mascaraCpf(campoTexto.value);
            }
            function mascaraCpf(valor) {
                return valor.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/g, "\$1.\$2.\$3\-\$4");
            }
            function formatarNumCartao(campoTexto) {
                campoTexto.value = mascaraNumCartao(campoTexto.value);
            }
            function mascaraNumCartao(valor) {
                return valor.replace(/(\d{4})(\d{4})(\d{4})(\d{4})/g, "\$1 \$2 \$3\ \$4");
            }
        </script>
        <%
            Cliente cli = (Cliente) session.getAttribute("cliente");
            if (cli == null) {
                response.sendRedirect("/PapelariaOrigami/View/pagesLogin/loginCliente.jsp");
            }
        %>
    </head>

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
                            <a href="./index.html"><img src="img/logo_com_titulo.jpg" width="130" height="130" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <nav class="header__menu">
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
                    </div>
                    <div class="col-lg-3">
                        <div class="header__cart">
                            <ul>
                                <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                            </ul>
                            <div class="header__cart__price">item: <span>$150.00</span></div>
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
                            <h2>Forma de Pagamento</h2>
                            <div class="breadcrumb__option">
                                <a href="index.jsp">Home</a>
                                <span>Pagamento</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Shoping Cart Section Begin -->
        <section class="shoping-cart spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">

                    </div>
                </div>
                <h4>Pagamento</h4>
                <form>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="shoping__checkout">
                                <ul>
                                    <h3>Total</h3>
                                    <li><h2> R$<%=cli.getCarrinho().getValor()%></h2></li>
                                </ul>
                                <ul>
                                    <li> <span>Dinheiro  <INPUT TYPE="RADIO" NAME="opcao" VALUE="dinheiro"></span></li>
                                    <div class="camposDinheiro">
                                        <a href="#"><img src="img/cash.png" alt=""></a><br>
                                        No momento da entrega em sua residência será verificado o valor. <br> 
                                        Caso seja divergênte ao valor total, a compra não será entregue.
                                    </div>
                                </ul>
                                <ul>
                                    <li> <span>PIX  <INPUT TYPE="RADIO" NAME="opcao" VALUE="pix"></span></li>
                                    <div class="camposPix">
                                        <a href="#"><img src="img/pix.png" alt=""></a><br>
                                        Faça a transferência para o código abaixo: <br> 
                                        XXX-XXX-XXX-XXX.
                                    </div>
                                </ul>
                                <ul>
                                    <li> <span>Cartão  <INPUT TYPE="RADIO" NAME="opcao" VALUE="cartao"></span></li>
                                    <div class="camposCartao">
                                        <a href="#"><img src="img/cartao.png" alt=""></a><br>
                                        <div class="checkout__input">
                                            <p>Nome Completo<span>*</span></p>
                                            <input type="text" name="txtNome" id="numeroCartao"  class="form-control" pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$">
                                        </div>
                                        <div class="checkout__input">
                                            <p>Número do Cartão<span>*</span></p>
                                            <input type="text" name="txtNumCartao" id="numeroCartao"  class="form-control" maxlength="16" required onblur="javascript: formatarNumCartao(this);">
                                        </div>
                                        <div class="checkout__input">
                                            <p>Código de segurança<span>*</span></p>
                                            <input type="text" name="txtNumSeg" id="numeroCartao"  class="form-control" maxlength="3" required>
                                        </div>
                                        <div class="checkout__input">
                                            <p>CPF<span>*</span></p>
                                            <input type="text" name="txtCpf" id="cpf"  class="form-control" maxlength="11" required onblur="javascript: formatarCampo(this);">
                                        </div>
                                        <div class="checkout__input">
                                            <p>Vencimento do cartão<span>*</span></p>
                                            <input type="month" name="txtVencimento" id="cpf"  class="form-control" required pattern="[0-9]{2}-[0-9]{2}">
                                        </div>
                                        <span> A vista<INPUT TYPE="RADIO" NAME="parcela" VALUE="avista" checked></span><br>
                                        <span> 3 Vezes<INPUT TYPE="RADIO" NAME="parcela" VALUE="3vezes" checked></span><br>
                                        <span> 5 Vezes<INPUT TYPE="RADIO" NAME="parcela" VALUE="5vezes" checked></span><br>
                                    </div>
                                </ul>
                                <a href="http://localhost:8080/PapelariaOrigami/novoPedido" name="confirma" class="primary-btn">Confirmar Pagamento</a>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <a href="#"><img src="img/pay.png" alt=""></a>
                        </div>
                    </div>
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


    </body>

</html>