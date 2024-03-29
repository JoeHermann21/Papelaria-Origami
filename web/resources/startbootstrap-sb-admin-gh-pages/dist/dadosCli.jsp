<%@page import="model.checkout"%>
<%@page import="java.util.List"%>
<%@page import="model.funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dados dos Clientes</title>
        <link href="css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>
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
                                <a class="nav-link" href="resources/startbootstrap-sb-admin-gh-pages/dist/register.jsp">Alterar perfil</a>
                            </a>
                           
                    <div class="sb-sidenav-footer">
                        <div class="small">Logado em:</div>
                        Papelaria Resende
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Painel de Controle</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Estoque</li>
                        </ol>
                        <div class="row">
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                Tabela de produtos
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                      <thead>
                                            <tr>
                                                <th>Cliente</th>
                                                <th>Código da compra</th>
                                                <th>CEP</th>
                                                <th>UF</th>
                                                <th>Cidade</th>
                                                <th>Número da casa</th>
                                                <th>Bairro</th>
                                                <th>Rua</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Cliente</th>
                                                <th>Código da compra</th>
                                                <th>CEP</th>
                                                <th>UF</th>
                                                <th>Cidade</th>
                                                <th>Número da casa</th>
                                                <th>Bairro</th>
                                                <th>Rua</th>
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <%
                        List<checkout> lprod = (List<checkout>) request.getAttribute("lprod");
                                            
                for (checkout check : lprod) {
            %><tr><%
                %><td><%out.print(check.getEmail());%></td><%
                %><td><%out.print(check.getId());%></td><%
                %><td><%out.print(check.getCep());%></td><%
                    %><td><%out.print(check.getUf());%></td><%
                %><td><%out.print(check.getCidade());%></td><%
                %><td><%out.print(check.getNumero());%></td><%
                %><td><%out.print(check.getBairro());%></td><%
                %><td><%out.print(check.getRua());%></td><%
                    %></tr><%
                    }
                %>  
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
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
        </div>
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
