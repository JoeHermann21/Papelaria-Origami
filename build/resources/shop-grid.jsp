<%@page import="java.util.List"%>
<%@page import="model.usuario"%>
<%@page import="model.produto"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Shoping</title>

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
            if (user == null) {
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
                                    <li name="txtEmail"><i class="fa fa-envelope"></i><%=user.getEmail()%></li>
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
                            <a href="#"><img src="/Papelaria/resources/img/logoPequeno.png" alt=""></a>
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
                        <div class="hero__item set-bg"><img src="/Papelaria/resources/img/banner.jpg" alt=""></a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Hero Section End -->

        <!-- Product Section Begin -->
        <form > 
            <table width="100%" left="100%">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Descrição</th>
                                                <th>Quantidade</th>
                                                <th>Preço</th>
                                            </tr>
                                        </thead>
                                      <tbody>  
            <%
             List<produto> lprod = (List<produto>) request.getAttribute("lprod");
               for (produto p : lprod) {
                %>
                %><tr><%
                    
                %><td><%out.print(p.getId());%></td><%
                %><td><%out.print(p.getDescricao());%></td><%
                %><td><%out.print(p.getQuantidade());%></td><%
                %><td><%out.print(p.getPreco());%></td><%
                %><td> <a href="http://localhost:8080/Papelaria/ProdutoControle?txtId=<%=p.getId()%>&txtDescricao=<%=p.getDescricao()%>&txtQuantidade=1&txtPreco=<%=p.getPreco()%>&txtEmail=<%=user.getEmail()%>&acao=Carrinho">carrinho</a></td><%
                
                %></tr><%
                }%>
                 </tbody>
                                        <tfoot>
                                            <tr>
                                                <th>ID</th>
                                                <th>Descrição</th>
                                                <th>Quantidade</th>
                                                <th>Preço</th>
                                            </tr>
                                        </tfoot>
                                    </table>   
        </form>
        <!-- Product Section End -->
        <footer class="footer spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="footer__copyright">
                            <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                    Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                            <div class="footer__copyright__payment"><img src="/Papelaria/resources/img/payment-item.png" alt=""></div>
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