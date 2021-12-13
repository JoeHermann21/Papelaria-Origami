<%@page import="Modelo.Funcionario"%>
<%@page import="Modelo.Categoria"%>
<%@page import="java.util.List"%>

<html lang="pt-br">
    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Lista de Categorias</title>
        <link href="View/pagesAdm/css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="View/pagesLogin/css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>
        <style>
            #pop{display:none;position:absolute;top:50%;left:50%;margin-left:-150px;margin-top:-100px;padding:10px;width:300px;height:200px;border:1px solid #d0d0d0;background-color: white}
        </style>

    </head>

    <body class="sb-nav-fixed">
        <%
            Funcionario fun = (Funcionario) session.getAttribute("funcionario");
           if(fun == null){
               response.sendRedirect("/PapelariaOrigami/View/pagesLogin/loginAdm.jsp");
           }
            Funcionario func = (Funcionario) session.getAttribute("logado");
        %>

        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="index2.jsp">Controle geral</a>
            <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>
            <a class="navbar-brand" href="index2.jsp">Usuário: <%=func.getNome()%>  <%=func.getSobrenome()%></a>
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
                        <a class="dropdown-item" href="http://localhost:8080/PapelariaOrigami/logout">Logout</a>
                        <div class="dropdown-divider"></div>
                    </div>
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
                    <a class="nav-link" href="http://localhost:8080/PapelariaOrigami/listarDevolucao">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Devolução
                    </a>

                    <div class="sb-sidenav-menu-heading">Serviços</div>
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                        <a class="nav-link" href="http://localhost:8080/PapelariaOrigami/pedidos">Dados do cliente</a>
                        <a class="nav-link" href="http://localhost:8080/PapelariaOrigami/listarEsgotado">Produtos esgotando</a>
                        <a class="nav-link" href="http://localhost:8080/PapelariaOrigami/listarFunc">Perfil Funcionário</a>
                    </a>

                    <div class="sb-sidenav-footer">
                        <div class="small">Logado em:</div>
                        Papelaria Origami
                    </div>
                </div>
            </div>
        </nav>
    </div>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid">
                <h1 class="mt-4">Lista de Categorias disponíveis</h1>
                <div class="row">
                </div>
                <%
                    String salvCatemsg = (String) request.getAttribute("salvCatemsg");
                    if (salvCatemsg != null) {
                %>
                <div class="col-lg-6">
                    <div class="checkout__input">
                        <p> <h5 id="titulo"><%= salvCatemsg%></h5></p>
                    </div>
                </div>

                <%
                    }
                %>

                <%
                    String delCatmsg = (String) request.getAttribute("delCatmsg");
                    if (delCatmsg != null) {
                %>
                <div class="col-lg-6">
                    <div class="checkout__input">
                        <p> <h5 id="titulo"><%= delCatmsg%></h5></p>
                    </div>
                </div>

                <%
                    }
                %>
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table mr-1"></i>
                        Tabela de Categorias
                    </div>
                    <div class="card-body">
                        <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0" action="/PapelariaOrigami/CategoriaDesc" method="get">
                            <div class="input-group">
                                <input class="form-control" type="text" placeholder="Pesquisar" name="txtDescricao" aria-describedby="basic-addon2" />
                                <div class="input-group-append">
                                    <button class="btn btn-primary" type="submit" name="acao"><i class="fas fa-search"></i></button>
                                </div>
                            </div>
                        </form>
                        <p>
                        <p>
                        <p>
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <div class="col-sm-12 col-md-6">
                                    <div id="dataTable_filter" class="dataTables_filter">
                                        <thead>
                                            <tr>
                                                <th>Código</th>
                                                <th>Descrição</th>
                                                <th>Sigla</th>
                                                <th>Excluir</th>
                                                <th>Alterar</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                List<Categoria> lcate = (List<Categoria>) request.getAttribute("lcate");

                                                for (Categoria c : lcate)
                                              {
                                            %><tr><%
                                                %><td><%out.print(c.getId());%></td><%
                                                %><td><%out.print(c.getDescricao());%></td><%
                                                %><td><%out.print(c.getSigla());%></td><%
                                                %><td> <a href="http://localhost:8080/PapelariaOrigami/excluirCategoria?txtID=<%=c.getId()%>" onclick="document.getElementById('pop').style.display = 'block';"><img src="View/pagesAdm/img2/icon_lixeira.png" height="20" width="20"></a></td><%
                                                %><td> <a href="http://localhost:8080/PapelariaOrigami/alterarCategoria?txtID=<%=c.getId()%>"><img src="View/pagesAdm/img2/icon_lapis.png" height="20" width="20"></a></td><%
                                                %></tr><%
                                            }
                                                %>                                  
                                        </tbody>

                                        <tfoot>
                                            <tr>
                                                <th>Código</th>
                                                <th>Descrição</th>
                                                <th>Sigla</th>
                                                <th>Excluir</th>
                                                <th>Alterar</th>
                                            </tr>
                                        </tfoot>
                                        </table>  
                                    </div>
                                </div>
                        </div>
                    </div>
                    </main>
                    <footer class="py-4 bg-light mt-auto">
                        <div class="container-fluid">
                            <div class="d-flex align-items-center justify-content-between small">
                                <div class="text-muted">Criado por Origamis Website 2021</div>
                                <div>
                                    <a href="#">Pplitica de privacidade</a>
                                    &middot;
                                    <a href="#">Termos &amp; Condições</a>
                                </div>
                            </div>
                        </div>
                    </footer>
                </div>
            </div>
            <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
            <script src="View/pagesAdm/js/scripts.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
            <script src="assets/demo/chart-area-demo.js"></script>
            <script src="assets/demo/chart-bar-demo.js"></script>
            <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
            <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
            <script src="assets/demo/datatables-demo.js"></script>
            </body>
            </html>