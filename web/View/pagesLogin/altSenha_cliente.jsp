<%@page import="Util.EnviarEmail"%>
<%
    String mensagemUsuario = null;
    if (request.getMethod().equals("POST")) {
        StringBuffer texto = new StringBuffer();
        EnviarEmail enviar = new EnviarEmail();
        enviar.setEmailDestinatario((request.getParameter("txtEmail")));
        enviar.setAssunto("Papelaria Origami");
    //uso StringBuffer para otimizar a concatenação 
        //de string
        
        texto.append("<h2 align='center'>Papelaria Origami</h2><br>");
        texto.append("<h2>SUA SENHA FOI ALTERADA:</h2><br/>");
        texto.append("Agradeçemos sua visita. Agora você pode fazer suas compras novamente");
        texto.append("<br/>");
        texto.append("Lembre-se de guardar sua senha com segurança.");
        texto.append("<br/>");
        texto.append("Fique por dentro de nossas novidades, sempre acesse a área do cliente.");
        texto.append("<br/>");
        texto.append("A senha alterada é correspondete ao email: ");
        texto.append(request.getParameter("txtEmail"));

        enviar.setMsg(texto.toString());

        boolean enviou = enviar.enviarHotmail();
        if (enviou) {

            mensagemUsuario = "Dados enviados com sucesso";

        } else {
            mensagemUsuario = "Não foi enviar as informações";

        }

    }

%>
<!DOCTYPE html>
<html lang="PT-BR">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Login Cliente</title>
        <script src="js/main.js"></script>
        <script src="View/pagesLogin/js/main.js"></script>
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
                            
                             <%
                                String msgSucesso = (String) request.getAttribute("msgSucesso");
                                if (msgSucesso != null) {
                                %>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                    <p> <h5 id="titulo"><%= msgSucesso%></h5></p>
                                    </div>
                                </div>
                            <%
                                }
                            %>
                                        <form method="POST" action="/PapelariaOrigami/atualizarSenha" name="LoginForm" onsubmit="return validate();">
                                            
                                            <div class="form-group">
                                                    <div class="wrap-input100 validate-input">
                                                        <label class="small mb-1" for="inputNumReg">E-mail</label>
                                                <input class="form-control py-4" id="inputNumReg" type="email" name="txtEmail"  placeholder="Digite seu e-mail"/>
                                                    </div>
                                            </div>
                                            <div class="form-group">
                                                    <div class="wrap-input100 validate-input" data-validate = "Senha não é forte o suficiente." oninput="">
                                                        <label class="small mb-1" for="inputPassword">Nova Senha</label>
                                                        <input class="form-control py-4" type="password" id="password" minlength="8" maxlength="12" placeholder="Digite sua senha"  name="txtSenha" minlength="6" maxlength="12" onKeyUp="verificaForcaSenha();" />
                                                        <span id="password-status"></span>
                                                    </div>
                                            </div>
                                            <div class="form-group">
                                                    <div class="wrap-input100 validate-input" data-validate = "Senhas diferentes">
                                                        <label class="small mb-1" for="inputConfirmPassword">Confirmar senha</label>
                                                        <input class="form-control py-4" id="inputConfirmPassword" type="password" required  placeholder="Confirme sua senha"  name="txtRepeteSenha" minlength="8" maxlength="12" required/>
                                                        <span class="focus-input100"></span>
                                                    </div>
                                            </div>
                                            <div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                                                <input class="btn btn-primary btn-block" type="submit" value="Atualizar" name="acao">
                                            </div>
                                             <div id="pass-info"></div>
                                            <%
                    String msgErro = (String) request.getAttribute("msgErro");
                    if (msgErro != null) {
                %>
                <div class="col-lg-6">
                    <div class="checkout__input">
                        <p> <h5 id="titulo"><%= msgErro%></h5></p>
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
        <script src="js/scripts.js"></script>
    </body>
</html>
