<%@page import="Modelo.Funcionario"%>
<%@page import="Modelo.Categoria"%>
<%@page import="java.util.List"%>
<html lang="pt-br">

    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Cadastrar Categorias</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/styles.css" type="text/css">
        <link href="View/pagesLogin/css/styles.css" rel="stylesheet" type="text/css"/>
    </head>

    <body class="sb-nav-fixed">
<%
           Funcionario fun = (Funcionario) session.getAttribute("funcionario");
           if(fun == null){
               response.sendRedirect("/PapelariaOrigami/View/pagesLogin/loginAdm.jsp");
           }
       %>

        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="index2.jsp">Controle geral</a>
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
                    <a class="nav-link dropdown-toggle" id="userDropdown" href="../pagesLogin/loginAdm.jsp" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="http://localhost:8080/PapelariaOrigami/Logout">Logout</a>
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
                            <div class="sb-sidenav-menu-heading">Cadastros</div>
                            <a class="nav-link" href="http://localhost:8080/PapelariaOrigami/painelControle">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Painel de Controle
                            </a>
                            <a class="nav-link" href="http://localhost:8080/PapelariaOrigami/iniciarCadastro">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Cadastrar Produtos
                            </a>
                            <a class="nav-link" href="http://localhost:8080/PapelariaOrigami/View/pagesAdm/cadCategoria.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Cadastrar Categorias
                            </a>
                            </a><a class="nav-link" href="http://localhost:8080/PapelariaOrigami/View/pagesAdm/cadFabricante.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Cadastrar Fabricantes
                            </a>
                            
                            <div class="sb-sidenav-menu-heading">Listas</div>
                            <a class="nav-link" href="http://localhost:8080/PapelariaOrigami/listarCategorias">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Categorias
                            </a>
                            <a class="nav-link" href="http://localhost:8080/PapelariaOrigami/listarFabricantes">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Fabricantes
                            </a>
                            
                            <div class="sb-sidenav-menu-heading">Serviços</div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                            <a class="nav-link" href="http://localhost:8080/PapelariaOrigami/View/pagesAdm/dadosCli.jsp">Dados do cliente</a>
                            <a class="nav-link" href="http://localhost:8080/PapelariaOrigami/listarEsgotado">Produtos esgotando</a>
                            <a class="nav-link" href="http://localhost:8080/PapelariaOrigami/listarFunc">Perfil Funcionário</a>
                            </a>

                            <div class="sb-sidenav-footer">
                                <div class="small">Logado em:</div>
                                Papelaria Origami
                            </div>
                        </div>
                </nav>
            </div>
                        <div id="layoutSidenav_content">
                            <div class="container-fluid">
                                <h1 class="mt-4">Cadastrar Categoria</h1>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p> <h5 id="titulo"></h5></p>
                                    </div>
                                </div>
                            <%
                            String cadCatemsg = (String) request.getAttribute("cadCatemsg");
                            if (cadCatemsg != null) {
                            %>
                            <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p> <h5 id="titulo"><%= cadCatemsg%></h5></p>
                                    </div>
                                </div>
                       
                            <%
                            }
                            %>
                                <form method="POST" action="/PapelariaOrigami/cadastrarCategoria">
                                    <div class="row">
                                        <div class="col-lg-8 col-md-6">  
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputID">ID*</label>
                                                <input class="form-control py-4" id="inputID" type="text" name="txtID" readonly="true"/>
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputID">Descrição*</label>
                                                <input class="form-control py-4" id="inputDescricao" type="text" name="txtDescricao"placeholder="Descrição do Produto" />
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputID">Sigla*</label>
                                                <input class="form-control py-4" id="inputData" type="text" name="txtSigla"placeholder="Sigla de identificação" maxlength="4" />
                                            </div>
                                            <p>
                                            <input class="button1" type="submit" value="Cadastrar" name="acao">
                                        </div>
                                </form> 
                            </div>
                        </div>
                    </div>
                    <footer class="py-4 bg-light mt-auto">
                        <div class="container-fluid">
                            <div class="d-flex align-items-center justify-content-between small">
                                <div class="text-muted">Criado por Origamis; Website 2021</div>
                                <div>
                                    <a href="#">Politica de privacidade</a>
                                    &middot;
                                    <a href="#">Termos &amp; Condições</a>
                                </div>
                            </div>
                        </div>
                    </footer>
            </div>
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