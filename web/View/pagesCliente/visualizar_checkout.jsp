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
        <title>Endereço</title>

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
    <script>

        function limpa_formulário_cep() {
            //Limpa valores do formulário de cep.
            document.getElementById('rua').value = ("");
            document.getElementById('bairro').value = ("");
            document.getElementById('cidade').value = ("");
            document.getElementById('uf').value = ("");
        }

        function meu_callback(conteudo) {
            if (!("erro" in conteudo)) {
                //Atualiza os campos com os valores.
                document.getElementById('rua').value = (conteudo.logradouro);
                document.getElementById('bairro').value = (conteudo.bairro);
                document.getElementById('cidade').value = (conteudo.localidade);
                document.getElementById('uf').value = (conteudo.uf);
            } //end if.
            else {
                //CEP não Encontrado.
                limpa_formulário_cep();
                alert("CEP não encontrado.");
            }
        }

        function pesquisacep(valor) {

            //Nova variável "cep" somente com dígitos.
            var cep = valor.replace(/\D/g, '');

            //Verifica se campo cep possui valor informado.
            if (cep != "") {

                //Expressão regular para validar o CEP.
                var validacep = /^[0-9]{8}$/;

                //Valida o formato do CEP.
                if (validacep.test(cep)) {

                    //Preenche os campos com "..." enquanto consulta webservice.
                    document.getElementById('rua').value = "...";
                    document.getElementById('bairro').value = "...";
                    document.getElementById('cidade').value = "...";
                    document.getElementById('uf').value = "...";

                    //Cria um elemento javascript.
                    var script = document.createElement('script');

                    //Sincroniza com o callback.
                    script.src = 'https://viacep.com.br/ws/' + cep + '/json/?callback=meu_callback';

                    //Insere script no documento e carrega o conteúdo.
                    document.body.appendChild(script);

                } //end if.
                else {
                    //cep é inválido.
                    limpa_formulário_cep();
                    alert("Formato de CEP inválido.");
                }
            } //end if.
            else {
                //cep sem valor, limpa formulário.
                limpa_formulário_cep();
            }
        }
        ;

    </script>
    <body>

        <!-- Humberger Begin -->
        <div class="humberger__menu__overlay"></div>
        <div class="humberger__menu__wrapper">
            <div class="humberger__menu__logo">
                <a href="#"><img src="View/pagesCliente/img/logo.png" alt=""></a>
            </div>
            <div class="humberger__menu__cart">
                <ul>                    
                    <li><a href="#"><i class="fa fa-shopping-bag"></i> <span><% out.print(cli.getCarrinho().getItemArray().size()); %></span></a></li>
                </ul>
                <div class="header__cart__price">item: <span><% out.print(cli.getCarrinho().getValor()); %></span></div>
            </div>
            <div class="humberger__menu__widget">
                <div class="header__top__right__language">
                    <img src="img/brasil.png" alt="">
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
                                
                                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span><% out.print(cli.getCarrinho().getItemArray().size()); %></span></a></li>
                            </ul>
                            <div class="header__cart__price">item: <span><% out.print(cli.getCarrinho().getValor()); %></span></div>
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
                            <h2>Checkout</h2>
                            <div class="breadcrumb__option">
                                <a href="index.jsp">Home</a>
                                <span>Checkout</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->
        <%
            Endereco end = (Endereco) request.getAttribute("endereco");
            if (end != null) {

        %>
        <!-- Checkout Section Begin -->
        <section class="checkout spad">
            <div class="container">
                <div class="checkout__form">

                    <h3>Enviaremos seu pedido para este endereço.</h3>
                    <h4>obs: Se desejar alterar seus dados, basta mudar o que você precisar, e clicar no botão "Alterar"</h4>
                    <form method="POST" action="/PapelariaOrigami/atualizarEndereco">
                        <div class="row">
                            <div class="col-lg-8 col-md-6">
                                <div class="row">
                                    <div class="col-lg-6">   
                                        <div class="checkout__input">
                                            <label>Email: *
                                                <input name="txtEmail" type="text" id="email" size="60" value="<%=cli.getEmail()%>"/></label><br />
                                        </div>

                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <label>Cep:
                                                <input name="txtCep" type="text" id="cep" size="10" maxlength="9" value="<%=end.getCep()%>"
                                                       onblur="pesquisacep(this.value);" /></label><br />
                                            <label><a>Não sabe seu CEP?</a></label>           
                                            <label><a href="http://www.buscacep.correios.com.br/sistemas/buscacep/">Clique Aqui</a></label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-6">   
                                        <div class="checkout__input">
                                            <label>Rua: *
                                                <input name="txtRua" type="text" id="rua" size="60" value="<%=end.getLogradouro()%>"/></label><br />
                                        </div>

                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <label>Estado: *
                                                <input name="txtUF" type="text" id="uf" size="2" readonly="true" value="<%=end.getUf()%>" /></label><br />
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <label>Cidade: *
                                                <input name="txtCidade" type="text" id="cidade" size="40" readonly="true" value="<%=end.getCidade()%>" /></label><br />
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <label>Bairro: *
                                                <input name="txtBairro" type="text" id="bairro" size="40" value="<%=end.getBairro()%>"/></label><br />
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <p>Número<span>*</span></p>
                                            <input type="text" name="txtNumero" id="numero"  class="form-control" value="<%=end.getNumero()%>">
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <p>Complemento</p>
                                            <input type="text" name="txtComple" id="complemento"  class="form-control" value="<%=end.getComplemento()%>">
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <p>Telefone<span>*</span></p>
                                            <input type="text" name="txtTel" id="telefone"  class="form-control" value="<%=cli.getTelefone()%>">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                                    <input class="btn btn-primary" type="submit" value="Alterar" name="alt">
                                </div>
                                        <% if(cli.getCarrinho().getValor() != 0 ){ %>
                                <div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                                    <a class="btn btn-primary" href="View/pagesCliente/pagamento.jsp">Proseguir para o pagamento</a>
                                </div>  
                                <% } %>
                                <% } else {
                                %>
                                <h2>Endereco vazio</h2>
                                <%
                                    }
                                %>
                                <p>
                                <p>

                            </div>
                            <div class="col-lg-4 col-md-6">
                                <a href="#"><img src="View/pagesCliente/img/entrega1.png" alt=""></a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        <!-- Checkout Section End -->

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