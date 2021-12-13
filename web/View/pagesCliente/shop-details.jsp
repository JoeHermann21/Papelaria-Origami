<%@page import="Modelo.Cliente"%>
<%@page import="Modelo.Produto"%>
<!DOCTYPE html>
<html lang="PT-BR">

    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Detalhes do Produto</title>

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
    </head>
    <%
        Cliente cli = (Cliente) session.getAttribute("cliente");
        if (cli == null) {
            response.sendRedirect("/PapelariaOrigami/View/pagesLogin/loginCliente.jsp");
        }

    %>
    <body>
        <%            Produto p = (Produto) request.getAttribute("produto");
        %>
        <!-- Humberger Begin -->
        <div class="humberger__menu__overlay"></div>
        <div class="humberger__menu__wrapper">
            <div class="humberger__menu__logo">
                <a href="#"><img src="View/pagesCliente/img/logo.png" alt=""></a>
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
                            <a href="./index.html"><img src="View/pagesCliente/img/logo_com_titulo.jpg" width="130" height="130" alt=""></a>
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

        <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <div class="breadcrumb__text">
                            <h2><%out.print(p.getTitulo());%></h2>
                            <div class="breadcrumb__option">
                                <a href="./index.html">Home</a>
                                <a href="./index.html">Detalhes</a>
                                <span></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Product Details Section Begin -->
        <form method="POST" action="/PapelariaOrigami/adicionarNoCarrinho">
            <input style="visibility: hidden" type="text" name="id" value="<% out.print(p.getId()); %>">
            <section class="product-details spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6 col-md-6">
                            <div class="product__details__pic">
                                <div class="product__item">
                                    <img class="product__item__pic set-bg" height="400" width="400"
                                         src="Files/<%out.print(p.getFileName());%>" alt="">
                                </div>
                                <div class="product__details__pic__slider owl-carousel">
                                    <img data-imgbigurl="img/product/details/product-details-2.jpg"
                                         src="img/product/details/thumb-1.jpg" alt="">
                                    <img data-imgbigurl="img/product/details/product-details-3.jpg"
                                         src="img/product/details/thumb-2.jpg" alt="">
                                    <img data-imgbigurl="img/product/details/product-details-5.jpg"
                                         src="img/product/details/thumb-3.jpg" alt="">
                                    <img data-imgbigurl="img/product/details/product-details-4.jpg"
                                         src="img/product/details/thumb-4.jpg" alt="">
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6">
                            <div class="product__details__text">
                                <h3><%out.print(p.getTitulo());%></h3>
                                <div class="product__details__rating">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star-half-o"></i>
                                </div>
                                <div class="product__details__price">R$<%out.print(p.getPreco());%></div>
                                <div class="product__details__quantity">
                                    <div class="quantity">
                                        <div class="pro-qty">
                                            <input type="number" value="1" name="txtQTD" min="1" max="50">

                                        </div>
                                    </div>
                                </div>
                                <input class="primary-btn" type="submit" value="Adicionar no carrinho">                            
                                <a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>

                                <div class="product__details__tab">
                                    <div class="tab-content">
                                        <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                            <div class="product__details__tab__desc">
                                                <h2>Informações do Produto</h2>
                                                <p>Descrição: <%out.print(p.getDescricao());%></p>
                                                <p>Peso: <%out.print(p.getPeso());%></p>
                                                <p>Material: <%out.print(p.getMaterial());%></p>
                                                <p>Unidade por embalagem: <%out.print(p.getUniEmbalagem());%></p>
                                                <p>Dimensões: <%out.print(p.getDimensao());%></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Product Details Section End -->
        </form>
        <!-- Footer Section Begin -->
        <footer class="footer spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="footer__copyright">
                            <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                    Copyright &copy;<script>document.write(new Date().getFullYear());</script> Desenvolvido por Origamis <i class="fa fa-heart" aria-hidden="true"></i> 
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                            <div class="footer__copyright__payment"><img src="View/pagesCliente/img/payment-item.png" alt=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>

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