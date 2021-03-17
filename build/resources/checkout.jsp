<%@page import="model.usuario"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>checkout</title>

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
        
        <script>
    
    function limpa_formulário_cep() {
            //Limpa valores do formulário de cep.
            document.getElementById('rua').value=("");
            document.getElementById('bairro').value=("");
            document.getElementById('cidade').value=("");
            document.getElementById('uf').value=("");
    }

    function meu_callback(conteudo) {
        if (!("erro" in conteudo)) {
            //Atualiza os campos com os valores.
            document.getElementById('rua').value=(conteudo.logradouro);
            document.getElementById('bairro').value=(conteudo.bairro);
            document.getElementById('cidade').value=(conteudo.localidade);
            document.getElementById('uf').value=(conteudo.uf);
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
            if(validacep.test(cep)) {

                //Preenche os campos com "..." enquanto consulta webservice.
                document.getElementById('rua').value="...";
                document.getElementById('bairro').value="...";
                document.getElementById('cidade').value="...";
                document.getElementById('uf').value="...";

                //Cria um elemento javascript.
                var script = document.createElement('script');

                //Sincroniza com o callback.
                script.src = 'https://viacep.com.br/ws/'+ cep + '/json/?callback=meu_callback';

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
    };

    </script>
</head>
      <%
            usuario user = (usuario) session.getValue("usuario");
            if (user != null) {
                user.getId();
                user.getCpf();
                user.getEmail();
                user.getNome();
                user.getSenha();
            } else {
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
                <a href="#"><img src="/Papelaria/resources/img/logo.png" alt=""></a>
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
            </div>
            <div id="mobile-menu-wrap"></div>
            <div class="header__top__right__social">
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-linkedin"></i></a>
                <a href="#"><i class="fa fa-pinterest-p"></i></a>
            </div>

        </div>
        <!-- Humberger End -->

        <!-- Header Section Begin -->
   <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                            <ul>
                                <li><%= user.getEmail()%></li>
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
                                <a href="http://localhost:8080/Papelaria/"><i class="fa fa-user"></i>Logout</a>
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
                        <a href="./index.jsp"><img src="/Papelaria/resources/img/logoPequeno.png" alt=""></a>
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
     
    <!-- Hero Section End -->
    <!-- Checkout Section Begin -->
    
    <body>
        
         <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">        
                <h4>Cadastro de entrega</h4>
                <form  method="get" action="/Papelaria/checkoutControle">
                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                            <div class="row">
                                <div class="col-lg-6">   
                                    <div class="checkout__input">
                                        <label>Email: *
                                            <input name="txtEmail" type="text" id="email" size="60"/></label><br />
                                    </div>

                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <label>Cep:
                                            <input name="txtCep" type="text" id="cep" value="" size="10" maxlength="9"
                                                   onblur="pesquisacep(this.value);" /></label><br />

                                        <label><a href="http://www.buscacep.correios.com.br/sistemas/buscacep/">Não sabe seu CEP?</a></label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">   
                                    <div class="checkout__input">
                                        <label>Rua: *
                                            <input name="txtRua" type="text" id="rua" size="60" readonly="true" /></label><br />
                                    </div>

                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <label>Estado: *
                                            <input name="txtUF" type="text" id="uf" size="2" readonly="true" /></label><br />
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <label>Cidade: *
                                            <input name="txtCidade" type="text" id="cidade" size="40" readonly="true" /></label><br />
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <label>Bairro: *
                                            <input name="txtBairro" type="text" id="bairro" size="40" readonly="true"/></label><br />
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Logradouro</p>
                                        <input type="text" name="txtLogra" id="logradouro"  class="form-control">
                                    </div>
                                </div>

                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Número<span>*</span></p>
                                        <input type="text" name="txtNumero" id="numero"  class="form-control">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Complemento</p>
                                        <input type="text" name="txtComple" id="complemento"  class="form-control" value="">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Telefone<span>*</span></p>
                                        <input type="text" name="txtTel" id="telefone"  class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="container-login100-form-btn">
                                <div class="wrap-login100-form-btn">
                                    <div class="login100-form-bgbtn"></div>
                                    <input class="login100-form-btn" type="submit" value="Cadastrar" name="cad">
                                </div> 
                            </div>

                            <button class="wrap-login100-form-btn">
                                <a href="inicial.jsp">Cancelar</a>
                            </button>

                        </div>
                        <div class="col-lg-4 col-md-6">
                            <a href="#"><img src="img/entrega1.png" alt=""></a>
                        </div>
                    </div>
                </form>
            </div>
            </div>
    </section>
   </body>
    <!-- Checkout Section End -->

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