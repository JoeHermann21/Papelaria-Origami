
<%@page import="Modelo.Funcionario"%>
<%@page import="Modelo.Categoria"%>
<%@page import="Modelo.Fabricante"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Produto"%>
<html lang="pt-br">

    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Alterar produtos</title>
        <link href="http://localhost:8080/PapelariaOrigami/View/pagesAdm/css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="http://localhost:8080/PapelariaOrigami/View/pagesLogin/css/styles_1.css" rel="stylesheet" type="text/css"/>
        <!-- Google Font -->
        <link href="../pagesLogin/css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>

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
        <div class="container-fluid">
            <h1 class="mt-4">Painel de Controle</h1>
            <div class="col-lg-6">
                <div class="checkout__input">
                    <p> <h5 id="titulo"></h5></p>
                </div>
            </div>

            <%
                Produto prod = (Produto) request.getAttribute("lprod");
            %>
            <form method="POST" action="/PapelariaOrigami/editarProduto" enctype="multipart/form-data">
                <div class="row">
                    <div class="col-lg-8 col-md-6">
                        <div class="form-group">
                            <label class="small mb-1" for="inputID">ID*</label>
                            <input class="form-control py-1" name="txtID" id="ID" readonly="true" value="<%=prod.getId()%>">
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputDescricao">Titulo*</label>
                            <input class="form-control py-1" id="inputTitulo" type="text" name="txtTitulo" value="<%=prod.getTitulo()%>"/>
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputDescricao">Descrição*</label>
                            <input class="form-control py-1" name="txtDescricao" id="descricao" value="<%=prod.getDescricao()%>">
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputData">Data Entrada*</label>
                            <input class="form-control py-1" type="date" name="txtDataEntrada" id="DataEntrada" value="<%=prod.getDataEntrada()%>">
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputFabricante">Fabricante*</label>
                            <select class="form-control py-1" type="text" name="txtFabricante" id="fabricante" value="<%=prod.getFabricante().getDescricao()%>"  />
                            <% List<Fabricante> lfab = (List<Fabricante>) request.getAttribute("lfab");
                                for (Fabricante f : lfab) {
                                    out.print("<option value=" + f.getDescricao() + ">" + f.getDescricao() + "</option>");
                                }
                            %>                                                                                              
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputCategoria">Categoria*</label>
                            <select class="form-control py-1" type="text" name="txtCategoria" id="categoria" value="<%=prod.getCategoria().getDescricao()%>" />
                            <% List<Categoria> lcat = (List<Categoria>) request.getAttribute("lcat");
                                for (Categoria c : lcat) {
                                    out.print("<option value=" + c.getDescricao() + ">" + c.getDescricao() + "</option>");
                                }
                            %>                                                                                              
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputQuantidade">Quantidade*</label>
                            <input class="form-control py-1" id="inputQuantidade" type="number"  min="0" name="txtQntdd" id="qntdd" value="<%=prod.getQuantidade()%>">
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputMaterial">Peso total*</label>
                            <input class="form-control py-1" id="inputPreco" type="numeric" name="txtPeso" value="<%=prod.getPeso()%>"/>
                        </div>
                        
                        <div class="form-group">
                            <label class="small mb-1" for="inputMaterial">Material que é feito*</label>
                            <input class="form-control py-1" id="inputPreco" type="text" name="txtMaterial" value="<%=prod.getMaterial()%>"/>
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputEmbalagem">Unidades por embalagem*</label>
                            <input class="form-control py-1" id="inputAtencao" type="text"  name="txtUniEmbalagem" value="<%=prod.getUniEmbalagem()%>"/>
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputCor">Cor*</label>
                            <input class="form-control py-1" id="inputAtencao" type="text"  name="txtCor" placeholder="Digite a cor do produto" value="<%=prod.getCor()%>"/>
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputDimensao">Dimensões do produto*</label>
                            <input class="form-control py-1" id="inputAtencao" type="text"  name="txtDimensao" placeholder="Digite as dimensões do produto" value="<%=prod.getDimensao()%>"/>
                        </div>
                        
                        <div class="form-group">
                            <label class="small mb-1" for="inputQuantidadeMinima">Valor minimo para criar Alerta*</label>
                            <input class="form-control py-1" type="number"  min="0" name="txtQuantidadeMinima" id="quantidadeMinima" value="<%=prod.getQuantidadeMinima()%>" />
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputID">Preço*</label>
                            <input class="form-control py-1" id="inputPreco" type="number" min="0.00" max="1000000000.00" value="<%=prod.getPreco()%>"
                                   step="0.01"  min="0" name="txtPreco" placeholder="Digite o valor da unidade" />
                        </div>
                        <div class="form-group">
                            <label class="small mb-1" for="inputID">Imagem*</label>
                            <input class="form-control py-1" id="inputFile" type="file"  name="file" />
                        </div>
                        <div class="form__btn col-md-offset-0">
                            <input class="button1" type="submit" value="Salvar" name="acao">
                        </div>
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