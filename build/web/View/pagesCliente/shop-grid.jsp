<%@page import="Modelo.Produto"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="PT-BR">
    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Shopping</title>

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

    <body>
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
                    <img src="View/pagesCliente/img/language.png" alt="">
                    <div>Português</div>
                </div>
                <div class="header__top__right__auth">
                    <a href="../pagesLogin/loginCliente.jsp"><i class="fa fa-user"></i> Logout</a>
                </div>
            </div>
            <nav class="humberger__menu__nav mobile-menu">
                <ul>
                    <li class="active"><a href="index.jsp">Home</a></li>
                    <li><a href="shop-grid.jsp">Shop</a></li>
                    <li><a href="shoping-cart.jsp">Carrinho</a></li>
                    <li><a href="checkout.jsp">Meu endereço</a></li>
                    <li><a href="blog.html">Blog</a></li>
                    <li><a href="contact.jsp">Contato</a></li>
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
                    <li><i class="fa fa-envelope"></i>papelariaOrigami@gmail.com</li>
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
                                    <li><i class="fa fa-envelope"></i>papelariaOrigami@gmail.com</li>
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
                                    <img src="View/pagesCliente/img/language.png" alt="">
                                    <div>Português</div>
                                </div>
                                <div class="header__top__right__auth">
                                    <a href="#"><i class="fa fa-user"></i> Logout</a>
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
                                <li class="active"><a href="index.jsp">Home</a></li>
                                <li><a href="shop-grid.jsp">Shop</a></li>
                                <li><a href="shoping-cart.jsp">Carrinho</a></li>
                                <li><a href="checkout.jsp">Meu endereço</a></li>
                                <li><a href="blog.html">Blog</a></li>
                                <li><a href="contact.jsp">Contato</a></li>
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
        <section class="breadcrumb-section set_bg" data_setbg="http://localhost:8080/PapelariaOrigami/View/pagesCliente/img/breadcrumb.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <div class="breadcrumb__text">
                            <h2>Papelaria Origami</h2>
                            <div class="breadcrumb__option">
                                <a href="View/pagesCliente/shop-grid.jsp">Home</a>
                                <span>Shop</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Product Section Begin -->
        <section class="product spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-5">
                        <div class="sidebar">
                            <div class="sidebar__item">
                                <h4>Departamentos</h4>
                                <ul>
                                    <li><a href="#">Materiais de escrita</a></li>
                                    <li><a href="#">Cadernos</a></li>
                                    <li><a href="#">Canecas</a></li>
                                    <li><a href="#">Materiais de pintura</a></li>
                                </ul>
                            </div>
                            <div class="sidebar__item">
                                <h4>Faixa de preço</h4>
                                <div class="price-range-wrap">
                                    <div class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
                                         data-min="10" data-max="540">
                                        <div class="ui-slider-range ui-corner-all ui-widget-header"></div>
                                        <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                        <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                    </div>
                                    <div class="range-slider">
                                        <div class="price-input">
                                            <input type="text" id="minamount">
                                            <input type="text" id="maxamount">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="sidebar__item">
                                <div class="latest-product__text">
                                    <h4>Super Ofertas!</h4>
                                    <div class="latest-product__slider owl-carousel">
                                        <div class="latest-prdouct__slider__item">
                                            <table width="100%" cellspacing="0">
                                                <tbody>
                                                    <tr>
                                                <a href="#"><img src="View/pagesCliente/img/caneca/cane1.jpeg"></a>
                                                <div class="latest-product__item__text">
                                                    <h6>Caneca Hora de Aventura</h6>
                                                    <h6>350ml porcelanato</h6>
                                                    <span>$30.00</span>
                                                    <ul class="product__item__pic__hover">
                                                        <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                                    </ul>
                                                </div>
                                                </tr>   
                                                <tr>
                                                <a href="#"><img src="View/pagesCliente/img/caneca/cane2.jpeg"></a>
                                                <div class="latest-product__item__text">
                                                    <h6>Caneca Naruto</h6>
                                                    <h6>350ml plastico</h6>
                                                    <span>$18.00</span>
                                                    <ul class="product__item__pic__hover">
                                                        <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                                    </ul>
                                                </div>
                                                </tr> 
                                                <tr>
                                                <a href="#"><img src="View/pagesCliente/img/caneca/cane3.jpeg"></a>
                                                <div class="latest-product__item__text">
                                                    <h6>Garrafa Térmica prateada</h6>
                                                    <h6>350ml</h6>
                                                    <span>$30.00</span>
                                                    <ul class="product__item__pic__hover">
                                                        <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                                    </ul>
                                                </div>
                                                </tr>   
                                                </tbody>
                                            </table>  
                                        </div>
                                        <div class="latest-prdouct__slider__item">
                                            <table width="100%" cellspacing="0">
                                                <tbody>
                                                    <tr>
                                                <a href="#"><img src="View/pagesCliente/img/caneca/cane4.jpeg"></a>
                                                <div class="latest-product__item__text">
                                                    <h6>Garrafa Termica Rosa</h6>
                                                    <h6>650ml</h6>
                                                    <span>$40.00</span>
                                                    <ul class="product__item__pic__hover">
                                                        <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                                    </ul>
                                                </div>
                                                </tr>  
                                                <tr>
                                                <a href="#"><img src="View/pagesCliente/img/caneca/cane5.jpg">Clique para ver detalhes</a>
                                                <div class="latest-product__item__text">
                                                    <h6>Copo Metálico</h6>
                                                    <h6>550ml</h6>
                                                    <span>$50.00</span>
                                                </div>
                                                </tr>
                                                <tr>
                                                <a href="#"><img src="View/pagesCliente/img/caneca/cane6.jpeg"></a>
                                                <div class="latest-product__item__text">
                                                    <h6>Copo Harry Potter</h6>
                                                    <h6>350ml</h6>
                                                    <span>$35.00</span>
                                                    <ul class="product__item__pic__hover">
                                                        <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                                    </ul>
                                                </div>
                                                </tr>  
                                                </tbody>
                                            </table>  
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-9 col-md-7">
                        <div class="product__discount">
                            <div class="section-title product__discount__title">
                                <h2>PRODUTOS DISPONÍVEIS</h2>
                            </div>
                            <div class="row">
                                <div class="product__discount__slider owl-carousel">
                                    <div class="col-lg-4">
                                        <div class="product__discount__item">
                                            <div class="product__discount__item__pic set-bg"
                                                 data-setbg="View/pagesCliente/img/caderno/cad1.jpeg">
                                                <div class="product__discount__percent">-20%</div>
                                                <ul class="product__item__pic__hover">
                                                    <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                                </ul>
                                            </div>
                                            <div class="product__discount__item__text">
                                                <span>Tilibra</span>
                                                <h5><a href="#">Caderno Universitário Florido 10 Materias
                                                        Capa dura 20cm x 27,5cm 1 unid</a></h5>
                                                <div class="product__item__price">R$30.00 <span>R$36.00</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4">
                                        <div class="product__discount__item">
                                            <div class="product__discount__item__pic set-bg"
                                                 data-setbg="View/pagesCliente/img/caderno/cad2.jpeg">
                                                <div class="product__discount__percent">-20%</div>
                                                <ul class="product__item__pic__hover">
                                                    <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                                </ul>
                                            </div>
                                            <div class="product__discount__item__text">
                                                <span>Tilibra</span>
                                                <h5><a href="#">Caderno Universitário Azul bebê 10 Materias
                                                        Capa dura 20cm x 27,5cm 1 unid</a></h5>
                                                <div class="product__item__price">$30.00 <span>$36.00</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4">
                                        <div class="product__discount__item">
                                            <div class="product__discount__item__pic set-bg"
                                                 data-setbg="View/pagesCliente/img/caderno/cad3.jpeg">
                                                <div class="product__discount__percent">-20%</div>
                                                <ul class="product__item__pic__hover">
                                                    <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                                </ul>
                                            </div>
                                            <div class="product__discount__item__text">
                                                <span>Molin</span>
                                                <h5><a href="#">Caderno Universitário Escudo da Fé 10 Materias
                                                        Capa dura 20cm x 27,5cm 1 unid</a></h5>
                                                <div class="product__item__price">$30.00 <span>$36.00</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4">
                                        <div class="product__discount__item">
                                            <div class="product__discount__item__pic set-bg"
                                                 data-setbg="View/pagesCliente/img/caderno/cad4.jpeg">
                                                <div class="product__discount__percent">-20%</div>
                                                <ul class="product__item__pic__hover">
                                                    <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                                </ul>
                                            </div>
                                            <div class="product__discount__item__text">
                                                <span>Tilibra</span>
                                                <h5><a href="#">Caderno Universitário Dark 5 Materias
                                                        Capa dura 20cm x 27,5cm 1 unid</a></h5>
                                                <div class="product__item__price">$30.00 <span>$36.00</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4">
                                        <div class="product__discount__item">
                                            <div class="product__discount__item__pic set-bg"
                                                 data-setbg="View/pagesCliente/img/product/discount/pd-5.jpg">
                                                <img src="View/pagesCliente/img/caderno/cad5.jpeg" alt=""/>
                                                <div class="product__discount__percent">-20%</div>
                                                <ul class="product__item__pic__hover">
                                                    <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                                </ul>
                                            </div>
                                            <div class="product__discount__item__text">
                                                <span>Molin</span>
                                                <h5><a href="#">Mini Caderno 1 matéria
                                                        Capa dura 10cm x 17,5cm 1 unid</a></h5>
                                                <div class="product__item__price">$30.00 <span>$36.00</span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4">
                                        <div class="product__discount__item">
                                            <div class="product__discount__item__pic set-bg"
                                                 data-setbg="View/pagesCliente/img/caderno/cad6.jpeg">
                                                <div class="product__discount__percent">-20%</div>
                                                <ul class="product__item__pic__hover">
                                                    <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                                </ul>
                                            </div>
                                            <div class="product__discount__item__text">
                                                <span>FaberCastell</span>
                                                <h5><a href="#">Sketchbook de Desenho cor de Rosa
                                                        Capa dura 10cm x 17,5cm 1 unid</a></h5>
                                                <div class="product__item__price">$30.00 <span>$36.00</span></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="filter__item">
                            <div class="row">
                                <div class="col-lg-4 col-md-4">
                                    <div class="filter__found">
                                        <h6><span>14</span> Produtos a mostra</h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <%
                                List<Produto> lprod = (List<Produto>) request.getAttribute("lprod");
                                for (Produto p : lprod) {
                            %>
                            <div class="col-lg-4 col-md-6 col-sm-6">
                                <div class="product__item">
                                    <div class="product__item__pic set-bg" data-setbg="<%out.print(p.getPath());%>">
                                        <img src="Files/<%out.print(p.getFileName());%>">
                                        <ul class="product__item__pic__hover">
                                            <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                            <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                            <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="product__item__text">
                                        <h6><a href=""><%out.print(p.getDescricao());%></a></h6>
                                        <h5>R$<%out.print(p.getPreco());%></h5>
                                    </div>
                                </div>
                            </div>
                            <%  }%>
                            
                        </div>
                        <div class="product__pagination">
                            <a href="shop-grid.jsp">1</a>
                            <a href="shop-grid_2.jsp">2</a>
                            <a href="shop-grid_2.jsp"><i class="fa fa-long-arrow-right"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Product Section End -->

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