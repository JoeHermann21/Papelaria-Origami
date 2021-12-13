<!DOCTYPE html>
<html lang="PT-BR">
    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Devolução</title>

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

        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>
    <body>
        <!-- Humberger Begin -->
        <div class="humberger__menu__overlay"></div>
        <div class="humberger__menu__wrapper">
            <div class="humberger__menu__logo">
                <img src="img/logo.png" alt=""/>
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
                    <a href="../pagesLogin/loginCliente.jsp"><i class="fa fa-user"></i> Logout</a>
                </div>
            </div>
            <nav class="humberger__menu__nav mobile-menu">
                <ul>
                    <ul>
                        <li class="active"><a href="http://localhost:8080/PapelariaOrigami/">Home</a></li>
                        <li><a href="http://localhost:8080/PapelariaOrigami/shopGrid">Shop</a></li>
                        <li><a href="http://localhost:8080/PapelariaOrigami/carrinho">Carrinho</a></li>
                        <li><a href="http://localhost:8080/PapelariaOrigami/meuendereco">Meu endereço</a></li>
                        <li><a href="http://localhost:8080/PapelariaOrigami/View/pagesCliente/contact.jsp">Contato</a></li>
                        <li><a href="http://localhost:8080/PapelariaOrigami/areaCliente">Minha Conta</a></li>
                        <li><a href="http://localhost:8080/PapelariaOrigami/View/pagesCliente/devolucao.jsp">Devolução</a></li>
                    </ul>
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
                    <li>Bem Vindo!! </li>                    
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
                </div>
            </div>
        </section>
        <!-- Hero Section End -->

        <!-- Contact Form Begin -->
        <div class="contact-form spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="contact__form__title">
                            <h2>ENVIE UMA IMAGEM DO PRODUTO, E O MOTIVO DA DEVOLUÇÃO</h2>
                        </div>
                    </div>
                </div>
                <%
                    String cadDevolucaoMsg = (String) request.getAttribute("cadDevolucaoMsg");
                    if (cadDevolucaoMsg != null) {
                %>
                <div class="contact__form__title">
                    <div class="checkout__input">
                        <p> <h4 id="titulo"><%= cadDevolucaoMsg%></h4></p>
                    </div>
                </div>

                <%
                    }
                %>
                <form method="POST" action="/PapelariaOrigami/devolucaoProduto" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col-lg-6 col-md-6">Nome
                            <input type="text" placeholder="Seu Nome" name="txtNome" id="nome" pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$">
                        </div>
                        <div class="col-lg-6 col-md-6">CPF
                            <input type="text" placeholder="Seu CPF" name="txtCpf" id="cpf" maxlength="11" required onblur="javascript: formatarCampo(this);">
                        </div>
                        <div class="col-lg-6 col-md-6">E-mail
                            <input type="email" placeholder="Seu E-mail" name="txtEmail" id="email">
                        </div>
                        <div class="col-lg-6 col-md-6">Número do pedido
                            <input type="number" placeholder="Número do pedido" name="txtNumPedido" id="numPedido">
                        </div>
                        <div class="col-lg-12">Motivo da devolução
                            <input placeholder="Escreva uma mensagem..." type="textarea" maxlength="200" name="txtMotivo" id="motivo">
                        </div>
                        <div class="col-lg-12">Anexe uma imagem do produto
                            <input class="form-control py-1" id="inputFile" type="file"  name="file" />
                        </div>
                        <div class="col-lg-12 text-center">
                            <button name="acao" type="submit" class="site-btn">Enviar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!-- Contact Form End -->

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