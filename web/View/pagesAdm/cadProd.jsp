<%@page import="Modelo.Funcionario"%>
<%@page import="Modelo.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Fabricante"%>
<html lang="pt-br">

    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Cadastrar produtos</title>

        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>

        <link href="View/pagesAdm/css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="View/pagesLogin/css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="sb-nav-fixed">
        <%
            Funcionario fun = (Funcionario) session.getAttribute("funcionario");
            if (fun == null) {
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
        <div class="container-fluid">
            <h1 class="mt-4">Painel de Controle</h1>
            <div class="col-lg-6">
                <div class="checkout__input">
                    <p> <h5 id="titulo"></h5></p>
                </div>
            </div>
            <%
                String cadProdmsg = (String) request.getAttribute("cadProdmsg");
                if (cadProdmsg != null) {
            %>
            <div class="col-lg-6">
                <div class="checkout__input">
                    <p> <h5 id="titulo"><%= cadProdmsg%></h5></p>
                </div>
            </div>

            <%
                }
            %>
            <%
                String msgBanco = (String) request.getAttribute("msgErro");
                if (msgBanco != null) {
            %>
            <div class="col-lg-6">
                <div class="checkout__input">
                    <p> <h5 id="titulo"><%= msgBanco%></h5></p>
                </div>
            </div>

            <%
                }
            %>
            <form method="POST" action="/PapelariaOrigami/cadastrarProduto" enctype="multipart/form-data" >
                <div class="row">
                    <div class="col-lg-8 col-md-6"> 
                        <div class="form-group">
                            <label class="small mb-1" for="inputID">ID*</label>
                            <input class="form-control py-1" id="inputID" type="text" name="txtID" readonly="true"/>
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputDescricao">Titulo*</label>
                            <input class="form-control py-1" id="inputTitulo" type="text" name="txtTitulo" placeholder="Titulo do Produto" />
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputDescricao">Descrição*</label>
                            <input class="form-control py-1" id="inputDescricao" type="text" name="txtDescricao"placeholder="Descrição do Produto" />
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputDataEntrada">Data Entrada*</label>
                            <input class="form-control py-1" id="inputData" type="date" name="txtDataEntrada"placeholder="Data de entrada" />
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputFabricante">Fabricante*</label>
                            <select class="form-control py-1" id="inputCategoria" type="text" name="txtFabricante"/>
                            <% List<Fabricante> lfab = (List<Fabricante>) request.getAttribute("lfab");
                                out.print("<option value=</option>");
                                for (Fabricante f : lfab) {
                                    out.print("<option value=" + f.getDescricao() + ">" + f.getDescricao() + "</option>");
                                }
                            %>                                                                                              
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputCategoria">Categoria*</label>
                            <select class="form-control py-1" id="inputCategoria" type="text" name="txtCategoria"/>
                            <% List<Categoria> lcat = (List<Categoria>) request.getAttribute("lcat");
                                out.print("<option value=</option>");
                                for (Categoria c : lcat) {
                                    out.print("<option value=" + c.getDescricao() + ">" + c.getDescricao() + "</option>");
                                }
                            %>                                                                                              
                            </select>
                        </div>
                        <p>                          
                        <div class="form-group">
                            <label class="small mb-1" for="inputQuantidade">Quantidade*</label>
                            <input class="form-control py-1" id="inputQuantidade" type="number"  min="0" name="txtQntdd" placeholder="Digite o total de unidades" />
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputMaterial">Peso total*</label>
                            <input class="form-control py-1" id="inputPreco" type="numeric" name="txtPeso" placeholder="Digite o peso" />
                        </div>

                        <div class="form-group">
                            <label class="small mb-1" for="inputMaterial">Material que é feito*</label>
                            <input class="form-control py-1" id="inputPreco" type="text" name="txtMaterial" placeholder="Digite o material" />
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputEmbalagem">Unidades por embalagem*</label>
                            <input class="form-control py-1" id="inputAtencao" type="text"  name="txtUniEmbalagem" placeholder="Digite as unidades dentro da embalagem" />
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputCor">Cor*</label>
                            <input class="form-control py-1" id="inputAtencao" type="text"  name="txtCor" placeholder="Digite a cor do produto" />
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputDimensao">Dimensões do produto*</label>
                            <input class="form-control py-1" id="inputAtencao" type="text"  name="txtDimensao" placeholder="Digite as dimensões do produto" />
                        </div>

                        <div class="form-group">
                            <label class="small mb-1" for="inputID">Preço*</label>
                            <input class="form-control py-1" id="inputPreco" type="number" min="0.00" max="1000000000.00"
                                   step="0.01"  min="0" name="txtPreco" placeholder="Digite o valor da unidade" />
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputID">Valor minimo para criar Alerta*</label>
                            <input class="form-control py-1" id="inputAtencao" type="number"  min="0" name="txtQuantidadeMinima" placeholder="Digite o valor para criar alerta" />
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputID">Imagem*</label>
                            <input class="form-control py-1" id="inputFile" type="file"  name="file" accept="image/png, image/gif, image/jpeg" />
                        </div>

                        <input class="button1" type="submit" value="Cadastrar" name="acao">
                    </div>
            </form> 
        </div>
    </div>
</div>
<footer class="py-2 bg-light mt-auto">
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