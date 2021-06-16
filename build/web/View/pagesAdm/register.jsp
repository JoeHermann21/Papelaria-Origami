
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Criar user Funcionario</title>
        <link href="../pagesLogin/css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="View/pagesLogin/css/styles.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <script language="javascript">
        function validate()
        {
            var cpf = document.LoginFun.txtCPF; //get form name "LoginForm" and textbox name "txt_reg" store in variable username
            var registro = document.LoginFun.txtRegistro;
            var nome = document.LoginFun.txtNome;
            var sobrenome = document.LoginFun.txtSobrenome;
            var senha = document.LoginFun.txtSenha;
            var rep_senha = document.LoginFun.txtConfSenha;

            if (cpf.value == null || cpf.value == "") //check username textbox not blank
            {
                window.alert("Atenção"); //alert message
                cpf.style.background = '#f08080'; //set textbox color
                cpf.focus();
                return false;
            }
            if (registro.value == null || registro.value == "") //check username textbox not blank
            {
                window.alert("Atenção"); //alert message
                registro.style.background = '#f08080'; //set textbox color
                registro.focus();
                return false;
            }
            if (nome.value == null || nome.value == "") //check password textbox not blank
            {
                window.alert("Atenção"); //alert message
                nome.style.background = '#f08080'; //set textbox color
                nome.focus();
                return false;
            }
            if (sobrenome.value == null || sobrenome.value == "") //check username textbox not blank
            {
                sobrenome.alert("Atenção"); //alert message
                sobrenome.style.background = '#f08080'; //set textbox color
                sobrenome.focus();
                return false;
            }
            if (senha.value == null || senha.value == "") //check password textbox not blank
            {
                window.alert("Atenção"); //alert message
                senha.style.background = '#f08080'; //set textbox color
                senha.focus();
                return false;
            }
            if (rep_senha.value == null || rep_senha.value == "") //check password textbox not blank
            {
                window.alert("Atenção"); //alert message
                rep_senha.style.background = '#f08080'; //set textbox color
                rep_senha.focus();
                return false;
            }
        }

        function formatarCampo(campoTexto) {
            campoTexto.value = mascaraCpf(campoTexto.value);
        }
        function mascaraCpf(valor) {
            return valor.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/g, "\$1.\$2.\$3\-\$4");
        }
    </script>

    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Cadastro de Funcionário</h3></div>
                                    <div class="card-body">

                                        <form method="POST" action="/PapelariaOrigami/cadastrarFunc" name="LoginFun" onsubmit="return validate();">
                                            <div class="form-row">
                                                <div class="form-group">
                                                    <label class="small mb-1" for="inputEmailAddress">ID</label>
                                                    <input class="form-control py-2" id="numID" name="txtID" type="number" readonly="true"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <span class="small mb-1" for="inputEmailAddress">Número Registro*</span>
                                                <input class="form-control py-4" id="numReg" name="txtRegistro" type="number"/>
                                                <span class="small mb-1"></span>
                                            </div>
                                            <div class="form-group">
                                                <span class="small mb-1" for="inputEmailAddress">CPF*</span>
                                                <input class="form-control py-4" id="numCPF" name="txtCPF" type="text" maxlength="11"
                                                       onblur="javascript: formatarCampo(this);"/>
                                                <span class="small mb-1"></span>
                                            </div>
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputFirstName">Nome*</label>
                                                        <input class="form-control py-4" id="nome" name="txtNome" type="text" placeholder="Nome" pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputLastName">Sobrenome*</label>
                                                        <input class="form-control py-4" id="sobrenome" name="txtSobrenome" type="text" placeholder="Sobrenome" pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputPassword">Senha*</label>
                                                        <input class="form-control py-4" id="senha" name="txtSenha" type="password" placeholder="Enter password" data-validate = "Senha não é forte o suficiente" />
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputConfirmPassword">Confirmar Senha*</label>
                                                        <input class="form-control py-4" name="txtRepeteSenha" id="confirmaSenha" type="password" placeholder="Confirm password" />
                                                    </div>
                                                </div>
                                                *Obrigatório
                                            </div>
                                            <div class="form-group mt-4 mb-0">
                                                <input class="btn btn-primary btn-block" type="submit" value="Cadastrar" name="cad">
                                            </div>
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
                            <div class="text-muted">Criado por Origamis Website 2021</div>
                            <div>
                                <a href="#">Pplitica de privacidade</a>
                                &middot;
                                <a href="#">Termos &amp; CondiÃ§Ãµes</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/main.js"></script>
    </body>
</html>
