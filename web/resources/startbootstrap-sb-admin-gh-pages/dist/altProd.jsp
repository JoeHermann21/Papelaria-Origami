<%@page import="model.funcionario"%>
<%@page import="model.produto"%>
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
    <title>Cadastrar produtos</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link href="css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>
    
        <link rel="stylesheet" href="resources/startbootstrap-sb-admin-gh-pages/dist/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="resources/startbootstrap-sb-admin-gh-pages/dist/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="resources/startbootstrap-sb-admin-gh-pages/dist/css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="resources/startbootstrap-sb-admin-gh-pages/dist/css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="resources/startbootstrap-sb-admin-gh-pages/dist/css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="resources/startbootstrap-sb-admin-gh-pages/dist/css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="resources/startbootstrap-sb-admin-gh-pages/dist/css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="resources/startbootstrap-sb-admin-gh-pages/dist/css/style2.css" type="text/css">
        <link rel="stylesheet" href="resources/startbootstrap-sb-admin-gh-pages/dist/css/styles.css" type="text/css">
	<link rel="stylesheet" type="text/css" href="Login_v13/css/main.css">
       
         <script language="javascript">
            function produto()
            {
                var desc = document.frmAddProd.txtDescricao; //get form name "LoginForm" and textbox name "txt_username" store in variable username
                var qntdd = document.frmAddProd.txtQntdd; //get form name "LoginForm" and textbox name "txt_password" store in variable password
                var fabri = document.frmAddProd.txtFabricante;
                var data = document.frmAddProd.txtDataEntrada;
                var cate = document.frmAddProd.txtCategoria;
                var preco = document.frmAddProd.txtPreco;
                if (qntdd.value == null || qntdd.value == "") //check username textbox not blank
                {
                    window.alert("Campo quantidade obrigatório"); //alert message
                    qntdd.style.background = '#ff0000'; //set textbox color
                    qntdd.focus();
                    return false;
                }
                if (desc.value == null || desc.value == "") //check password textbox not blank
                {
                    window.alert("Campo descrição obrigatório"); //alert message
                    desc.style.background = '#ff0000'; //set textbox color
                    desc.focus();
                    return false;
                }
                if (fabri.value == null || fabri.value == "") //check password textbox not blank
                {
                    window.alert("Campo fabricante obrigatório"); //alert message
                    fabri.style.background = '#ff0000'; //set textbox color
                    fabri.focus();
                    return false;
                }
                if (data.value == null || data.value == "") //check password textbox not blank
                {
                    window.alert("Campo data obrigatório"); //alert message
                    data.style.background = '#ff0000'; //set textbox color
                    data.focus();
                    return false;
                }
                if (cate.value == null || cate.value == "") //check password textbox not blank
                {
                    window.alert("Campo categoria obrigatório"); //alert message
                    cate.style.background = '#ff0000'; //set textbox color
                    cate.focus();
                    return false;
                }
                if (preco.value == null || preco.value == "") //check password textbox not blank
                window.alert("Campo preço obrigatório"); //alert message
                    preco.style.background = '#ff0000'; //set textbox color
                    preco.focus();
                    return false;
                }
            }
    </script>
</head>

<body class="sb-nav-fixed">
    
    <%
           funcionario fun = (funcionario) session.getAttribute("funcionario");
           if(fun == null){
               request.getRequestDispatcher("/resources/Login_v13/LoginFUN.jsp").forward(request,response);
           }
       %>
    
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="index.html">Controle geral</a>
            <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2" />
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="button"><i class="fas fa-search"></i></button>
                    </div>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="http://localhost:8080/Papelaria/">Logout</a>
                        <div class="dropdown-divider"></div>
                    </div
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="http://localhost:8080/Papelaria/ProdutoControle?acao=listaProd">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Painel de Controle
                            </a><a class="nav-link" href="cadProd.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Manter Produtos
                            </a>
                             <div class="sb-sidenav-menu-heading">Serviços</div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                
                                    <a class="nav-link" href="dadosCli.jsp">Dados do cliente</a>
                                    <a class="nav-link" href="http://localhost:8080/Papelaria/ProdutoControle?acao=listaEsgostados">Produtos esgotando</a>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <a class="nav-link" href="register.jsp">Alterar perfil</a>
                            </a>
                           
                    <div class="sb-sidenav-footer">
                        <div class="small">Logado em:</div>
                        Papelaria Resende
                    </div>
                </nav>
            </div>
 <div id="layoutSidenav_content">
                    <div class="container-fluid">
                        <h1 class="mt-4">Painel de Controle</h1>
                         <%
                            String msg = (String) request.getAttribute("cadProdmsg");
                            if (msg != null) {
                        %>
                         <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p> <h5 id="titulo"><%= msg%></h5></p>
                                    </div>
                                </div>
                       
                        <%
                            }
                            produto prod = (produto) request.getAttribute("lprod");
                        %>
                <form method="get" action="/Papelaria/ProdutoControle" >
                    <div class="row">
                        <div class="col-lg-8 col-md-6">  
                            <div class="checkout__input">
                                <p>ID<span>*</span></p>
                                <input type="text" name="txtID" id="ID" readonly="true" value=<%=prod.getId()%>>
                            </div>
                            <div class="checkout__input">
                                <p>Descrição<span>*</span></p>
                                <input type="text" name="txtDescricao" id="descricao" value=<%=prod.getDescricao()%> >
                            </div>
                            <div class="checkout__input">
                                <p>Data de entrada<span>*</span></p>
                                <input type="date" name="txtDataEntrada" id="DataEntrada" value=<%=prod.getDataEntrada()%>>
                            </div>
                            
                            <div class="checkout__input">
                                <p>Fabricante<span>*</span></p>
                                <input type="text" name="txtFabricante" id="fabricante"value=<%=prod.getFabricante()%>>
                            </div>
                            
                            <div class="checkout__input">
                                <p>Quantidade<span>*</span></p>
                                <input type="number" name="txtQntdd" id="qntdd" value=<%=prod.getQuantidade()%>>
                            </div>                            
                            
                            <div class="checkout__input">
                                <p>Preço<span>*</span></p>
                                <input type="numeric" name="txtPreco" id="preco" value=<%=prod.getPreco()%>>
                            </div>
                             <div class="form__btn col-md-offset-0">
                                            <input type="submit" value="Salvar" name="acao">
                             </div>
                        </div>
                        </div>
                </form> 
            </div>
        </div>
 </div>
    <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Criado por Amaranta e Matheus Ricardo; Website 2020</div>
                            <div>
                                <a href="#">Pplitica de privacidade</a>
                                &middot;
                                <a href="#">Termos &amp; Condições</a>
                            </div>
                        </div>
                    </div>
                </footer>
    <!-- Checkout Section End -->
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
<script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/datatables-demo.js"></script>

</body>

</html>
