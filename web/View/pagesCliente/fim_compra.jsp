<!DOCTYPE html>
<html lang="PT-BR">
    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Compra Finalizada</title>

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
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

        <style>
            body{text-align: center; padding-top: 50px}

            .estrelas input[type=radio] {
                display: none;
            }
            .estrelas label i.fa{
                font-size: 2.5em
            }
            .estrelas label i.fa:before {
                content:'\f005';
                color: #FC0;
            }
            .estrelas input[type=radio]:checked ~ label i.fa:before {
                color: #CCC;
            }
        </style>
    </head>

    <body>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

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
                            <h2>Papelaria Origami</h2>
                            <div class="breadcrumb__option">
                                <a href="index.jsp">Home </a>
                                <span>Contato</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Contact Section Begin -->
        <section class="contact spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                        <div class="contact__widget">
                            <span class="icon_phone"></span>
                            <h4>Telefone</h4>
                            <p>+55 11.1188.888</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                        <div class="contact__widget">
                            <span class="icon_pin_alt"></span>
                            <h4>Endereço</h4>
                            <p>Rua Francisco Martis Nº512 - Mogi das Cruzes SP </p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                        <div class="contact__widget">
                            <span class="icon_clock_alt"></span>
                            <h4>Aberto entre</h4>
                            <p>8h às 12h e 13h às 20h</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                        <div class="contact__widget">
                            <span class="icon_mail_alt"></span>
                            <h4>Email</h4>
                            <p>papelariaOrigami@gmail.com</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Classifique sua satisfação</h2>
                    </div>
                </div>
            </div>
        </div>
        <div class="estrelas">
            <input type="radio" id="cm_star-empty" name="fb" value="" checked/>
            <label for="cm_star-1"><i class="fa"></i></label>
            <input type="radio" id="cm_star-1" name="fb" value="1"/>
            <label for="cm_star-2"><i class="fa"></i></label>
            <input type="radio" id="cm_star-2" name="fb" value="2"/>
            <label for="cm_star-3"><i class="fa"></i></label>
            <input type="radio" id="cm_star-3" name="fb" value="3"/>
            <label for="cm_star-4"><i class="fa"></i></label>
            <input type="radio" id="cm_star-4" name="fb" value="4"/>
            <label for="cm_star-5"><i class="fa"></i></label>
            <input type="radio" id="cm_star-5" name="fb" value="5"/>
        </div>
        <!-- Contact Section End -->
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2><font color="#FF0000">Parabéns!! Você finalizou sua compra com sucesso!</font></h2>
                    </div>
                </div>
            </div>
        </div>
        <img src="img/congratulations.png" alt=""/>
        <br>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h3>Fique atento ao seu e-mail, logo mais enviaremos sua nota fiscal e atualizações sobre a entrega do produto.</h3>
                    </div>
                </div>

            </div>
        </div>
        <br>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Agradeçemos sua compra, e esperamos que nossos serviços tenham te atendido da melhor forma possível. Obrigado!</h2>
                    </div>
                </div>
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