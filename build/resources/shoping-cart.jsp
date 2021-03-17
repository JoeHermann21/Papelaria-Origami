<%@page import="model.carrinho"%>
<%@page import="java.util.List"%>
<%@page import="model.usuario"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>carrinho</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
     <link rel="stylesheet" href="http://localhost:8080/Papelaria/resources/Login_v13/css/bootstrap.min.css"type="text/css">
    <link rel="stylesheet" href="http://localhost:8080/Papelaria/resources/Login_v13/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="http://localhost:8080/Papelaria/resources/Login_v13/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="http://localhost:8080/Papelaria/resources/Login_v13/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="http://localhost:8080/Papelaria/resources/Login_v13/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="http://localhost:8080/Papelaria/resources/Login_v13/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="http://localhost:8080/Papelaria/resources/Login_v13/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="http://localhost:8080/Papelaria/resources/Login_v13/css/main.css" type="text/css">
    <link rel="stylesheet" href="http://localhost:8080/Papelaria/resources/Login_v13/css/style.css" type="text/css">
        
    </head>

    <body>
        <%
                            usuario user = (usuario) session.getValue("usuario");
                            if(user == null){
                                request.getRequestDispatcher("/resources/Login_v13/LoginCLI.jsp").forward(request, response);
                            }
                                
                            %>
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
                <div class="header__cart__price">item: <span>R$ --</span></div>
            </div>
            <div class="humberger__menu__widget">
                <div class="header__top__right__language">
                    <img src="img/language.png" alt="">
                    <div>Português</div>
                    <span class="arrow_carrot-down"></span>

                </div>
                <div class="header__top__right__auth">
                    <li><a href="#">Login</a></li>
                </div>
            </div>
            <nav class="header__menu">
                        <ul>
                            <li><a href="http://localhost:8080/Papelaria/resources/inicial.jsp">Home</a></li>
                            <li><a href="http://localhost:8080/Papelaria/ProdutoControle?acao=Produtos">Produtos</a></li>
                            <li><a href="http://localhost:8080/Papelaria/resources/checkout.jsp">Perfil</a></li>
                            <li><a href="http://localhost:8080/Papelaria/resources/shoping-cart.jsp">Carrinho</a></li>
                            <li><a href="http://localhost:8080/Papelaria/resources/contact.jsp">Contato</a></li>
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
                    <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                    <li>Free Shipping for all Order of $99</li>
                </ul>
            </div>
        </div>
        <!-- Humberger End -->

        <!-- Header Section Begin -->
        <header class="header">
            <div class="header__top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6 col-md-6">
                            <div class="header__top__left">
                                <ul>
                                    <li><i class="fa fa-envelope"></i><%=user.getEmail()%></li>
                                    <li>papelResende@gmail.com</li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6">
                            <div class="header__top__right">
                                <div class="header__top__right__social">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-linkedin"></i></a>
                                    <a href="#"><i class="fa fa-pinterest-p"></i></a>
                                </div>
                                <div class="header__top__right__language">
                                    <img src="img/language.png" alt="">
                                    <div>Português</div>
                                    <span class="arrow_carrot-down"></span>
                                    <ul>
                                        <li><a href="#">Português</a></li>
                                    </ul>
                                </div>
                                <div class="header__top__right__auth">
                                    <a href="../index.jsp"><i class="fa fa-user"></i>Logout</a>
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
                            <a href="#"><img src="img/logoPequeno.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <nav class="header__menu">
                        <ul>
                            <li><a href="http://localhost:8080/Papelaria/resources/inicial.jsp">Home</a></li>
                            <li><a href="http://localhost:8080/Papelaria/ProdutoControle?acao=Produtos">Produtos</a></li>
                            <li><a href="http://localhost:8080/Papelaria/resources/checkout.jsp">Perfil</a></li>
                            <li><a href="http://localhost:8080/Papelaria/resources/shoping-cart.jsp">Carrinho</a></li>
                            <li><a href="http://localhost:8080/Papelaria/resources/contact.jsp">Contato</a></li>
                        </ul>
                    </nav>
                    </div>
                    <div class="col-lg-3">
                        <div class="header__cart">
                            <ul>
                                <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                            </ul>
                            <div class="header__cart__price">item: <span>R$ --</span></div>
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
        <section class="hero">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="hero__categories">
                            <div class="hero__categories__all">
                                <i class="fa fa-bars"></i>
                                <span>Disponíveis</span>
                            </div>
                            <ul>
                                <li><a href="#">Cadernos</a></li>
                                <li><a href="#">Escrita</a></li>
                                <li><a href="#">Canecas</a></li>
                                <li><a href="#">Pintura</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="hero__search">
                            <div class="hero__search__form">
                                <form action="#">
                                    <div class="hero__search__categories">
                                        Categorias
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
                                    <h5>+55 11.745.888</h5>
                                    <span>Atendimento 24h</span>
                                </div>
                            </div>
                        </div>
                        <div class="hero__item set-bg" data-setbg="img/bannerOferta.jpg">
                            <div class="hero__text">
                                <span></span>
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
                            <h2>Shopping Cart</h2>
                            <div class="breadcrumb__option">
                                <a href="./index.jsp">Home</a>
                                <span>Shopping Cart</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="product__discount">
                    <div class="section-title product__discount__title">
                        <h2>SEUS PRODUTOS</h2>
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
                        <div class="shoping__cart__table">
                            <table>
                                <thead>
                                    <tr>
                                        <th class="shoping__product">Produtos</th>
                                        <th>Valor</th>
                                        <th>Quantidade</th>
                                        <th>Total</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="shoping__cart__item">
                                            <img src="img/cart/cart-1.jpg" alt="">
                                            <h5>Caderno </h5>
                                        </td>
                                        <td class="shoping__cart__price">
                                            $55.00
                                        </td>
                                        <td class="shoping__cart__quantity">
                                            <div class="quantity">
                                                <div class="pro-qty">
                                                    <input type="text" value="1">
                                                </div>
                                            </div>
                                        </td>
                                        <td class="shoping__cart__total">
                                            $110.00
                                        </td>
                                        <td class="shoping__cart__item__close">
                                            <span class="icon_close"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="shoping__cart__item">
                                            <img src="img/cart/cart-2.jpg" alt="">
                                            <h5>Fresh Garden Vegetable</h5>
                                        </td>
                                        <td class="shoping__cart__price">
                                            $39.00
                                        </td>
                                        <td class="shoping__cart__quantity">
                                            <div class="quantity">
                                                <div class="pro-qty">
                                                    <input type="text" value="1">
                                                </div>
                                            </div>
                                        </td>
                                        <td class="shoping__cart__total">
                                            $39.99
                                        </td>
                                        <td class="shoping__cart__item__close">
                                            <span class="icon_close"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <%
                                List<carrinho> cart = (List<carrinho>) request.getAttribute("lCar");
            for (carrinho dados : cart) {
                
                dados.setTotal(dados.getValor() * dados.getQntdd());
                %><tr><%
                    %><td class="shoping__cart__total"><%
                                            %><h5><%=dados.getProduto()%></h5><%
                                       %></td><%
                %><td class="shoping__cart__total"><%
                                           %><h5><%=dados.getValor()%></h5><%
                                       %></td><%
                                           %><td class="shoping__cart__total"><%
                                           %><h5><%=dados.getValor()%></h5><%
                                       %></td><%
                                           %><td class="shoping__cart__total"><%
                %><h5><%=dados.getQntdd()%></h5><%
                                       %></td><%
                //out.print(dados.getTotal());
                %></tr><%
            }
                            %>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="shoping__cart__btns">
                            <a href="shoping-cart.jsp" class="primary-btn cart-btn cart-btn-right"><span class="icon_loading"></span>
                                Atualizar Carrinho
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        Forma de pagamento <p>
                            <input type="radio" name="webmaster" value="dinheiro"/> Dinheiro<br />
                            <input type="radio" name="webmaster" value="cartao"/> Cartão de Crédito : 
                            <input type="radio" name="parcela" value="cartao"/>  A vista
                            <input type="radio" name="parcela" value="cartao"/>  2X 
                            <input type="radio" name="parcela" value="cartao"/>  3X<br />
                            <input type="radio" name="webmaster" value="boleto"/> Boleto

                    </div>
                    <div class="col-lg-6">
                        <div class="shoping__checkout">
                            <h5>Total no Carinho</h5>
                            <ul>
                                <li>Total <span>$454.98</span></li>
                            </ul>
                            
                            <a href="#" class="primary-btn">Confirmar Compra</a>
                        </div>
                    </div>
                </div>
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
                                    Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                            <div class="footer__copyright__payment"><img src="img/payment-item.png" alt=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Footer Section End -->

        <!-- Js Plugins -->
        <script src="Login_v13/js/jquery-3.3.1.min.js"></script>
    <script src="Login_v13/js/bootstrap.min.js"></script>
    <script src="Login_v13/js/jquery.nice-select.min.js"></script>
    <script src="Login_v13/js/jquery-ui.min.js"></script>
    <script src="Login_v13/js/jquery.slicknav.js"></script>
    <script src="Login_v13/js/mixitup.min.js"></script>
    <script src="Login_v13/js/owl.carousel.min.js"></script>
    <script src="http://localhost:8080/Papelaria/resources/Login_v13/js/main_1.js"></script>
    </body>

</html>