<!DOCTYPE html>
<html lang="PT-BR">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Login Cliente</title>
        <link href="css/styles.css" rel="stylesheet" />
        <link href="View/pagesAdm/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <script language="javascript">
        function validate()
        {
            var usuario = document.LoginForm.email; //get form name "LoginForm" and textbox name "txt_reg" store in variable username
            var senha = document.LoginForm.senha; //get form name "LoginForm" and textbox name "txt_pass" store in variable password

            if (usuario.value == null || usuario.value == "") //check username textbox not blank
            {
                window.alert("Digite seu e-mail"); //alert message
                usuario.style.background = '#f08080'; //set textbox color
                usuario.focus();
                return false;
            }
            if (senha.value == null || senha.value == "") //check password textbox not blank
            {
                window.alert("Digite sua senha"); //alert message
                senha.style.background = '#f08080'; //set textbox color
                senha.focus();
                return false;
            }
        }
    </script>
    <body class="bg-primary1">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
                                    <div class="card-body">
                                        <%
                                String msgAtencao = (String) request.getAttribute("msgAtencao");
                                if (msgAtencao != null) {
                                %>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                    <p> <h5 id="titulo"><%= msgAtencao%></h5></p>
                                    </div>
                                </div>
                            <%
                                }
                            %>
                                        <form method="POST" action="/PapelariaOrigami/loginCliente" name="LoginForm" onsubmit="return validate();">
                                            <div class="form-group" data-validate="Somente N�meros">
                                                <label class="small mb-1" for="inputNumReg">E-mail</label>
                                                <input class="form-control py-4" id="inputNumReg" type="email" name="email"  placeholder="Digite seu e-mail" />
                                            </div>
                                            <div class="form-group" data-validate="Senha insuficiente">
                                                <label class="small mb-1" for="inputPassword">Password</label>
                                                <input class="form-control py-4" id="inputPassword" type="password" name="senha" placeholder="Digite sua senha" />
                                            </div>
                                            <div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                                                <a class="small" href="http://localhost:8080/PapelariaOrigami/View/pagesLogin/registerCliente.jsp">N�o possuo cadastro</a>
                                                <a class="small" href="http://localhost:8080/PapelariaOrigami/View/pagesLogin/altSenha_cliente.jsp">Esqueci minha senha</a>
                                            </div>
                                            <div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                                                <input class="btn btn-primary btn-block" href="../pagesCliente/shop-grid.jsp" type="submit" value="Entrar" name="acao">
                                            </div>
                                            <%
                    String msgErro = (String) request.getAttribute("msgErro");
                    if (msgErro != null) {
                %>
                <div class="col-lg-6">
                    <div class="checkout__input">
                    <h5><%= msgErro%></h5>
                    </div>
                </div>
                <%
                    }
                %>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2020</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="View/pagesLogin/js/scripts.js"></script>
    </body>
</html>
