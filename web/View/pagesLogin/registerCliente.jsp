<!DOCTYPE html>
<html lang="PT-BR">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Criar Cadastro</title>
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/main.css" rel="stylesheet" />
        <link href="View/pagesLogin/css/styles.css" rel="stylesheet" />
        <link href="View/pagesLogin/css/main.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
        <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js"></script>
        <script src="js/main.js"></script>
        <script src="View/pagesLogin/js/main.js"></script>
        <script  src="https://code.jquery.com/jquery-3.5.1.min.js"  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="  crossorigin="anonymous"></script>
    </head>
    <script>
            function formatarCampo(campoTexto) {
                campoTexto.value = mascaraCpf(campoTexto.value);
            }
            function mascaraCpf(valor) {
                return valor.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/g, "\$1.\$2.\$3\-\$4");
        }
        </script>
    <body class="bg-primary1">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Criar Conta</h3></div>
                                    <div class="card-body">
                                        <form class="validate-form" method="POST" action="/PapelariaOrigami/cadastrarCliente">
                                            <div class="wrap-input100 validate-input" data-validate="Obrigatório nome">
                                                <label class="small mb-1" for="inputFirstName">Nome</label>
                                                <input class="form-control py-4" id="inputNome" type="text" aria-describedby="emailHelp" placeholder="Digite seu nome" name="txtNome" pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$"/>
                                                <span class="focus-input100"></span>
                                            </div>
                                            
                                            <div class="wrap-input100 validate-input" data-validate="Obrigatório CPF">
                                                <label class="small mb-1" for="inputCPF">CPF</label>
                                                <input class="form-control py-4" id="inputNome" type="text" aria-describedby="emailHelp" placeholder="Digite seu CPF" name="txtCPF"  maxlength="11"
                                                       onblur="javascript: formatarCampo(this);"/>
                                                <span class="focus-input100"></span>
                                            </div>
                                            
                                            <div class="wrap-input100 validate-input" data-validate = "seguir o modelo: ex@abc.xyz">
                                                <label class="small mb-1" for="inputEmailAddress">E-mail</label>
                                                <input class="form-control py-4" id="inputEmail" type="email" aria-describedby="emailHelp" placeholder="Digite seu email" name="txtEmail"/>
                                                <span class="focus-input100"></span>
                                            </div>

                                            <div class="form-row" form action="" method="post" id="passwordTest">
                                                <div class="col-md-6">
                                                    <div class="wrap-input100 validate-input" data-validate = "Senha não é forte o suficiente." oninput="">
                                                        <label class="small mb-1" for="inputPassword">Senha</label>
                                                        <input class="form-control py-4" type="password" id="password" minlength="8" maxlength="12" placeholder="Digite sua senha"  name="txtSenha" minlength="6" maxlength="12" onKeyUp="verificaForcaSenha();" />
                                                        <span id="password-status"></span>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="wrap-input100 validate-input" data-validate = "Senhas diferentes">
                                                        <label class="small mb-1" for="inputConfirmPassword">Confirmar senha</label>
                                                        <input class="form-control py-4" id="inputConfirmPassword" type="password" required  placeholder="Confirme sua senha"  name="txtRepeteSenha" minlength="8" maxlength="12" required/>
                                                        <span class="focus-input100"></span>
                                                    </div>
                                                </div>
                                                <div id="pass-info"></div>
                                                
                                            <%
                                        String senhaDiferente = (String) request.getAttribute("senhaDiferente");
                                        if (senhaDiferente != null) {
                                            %>
                            <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p> <h5 id="titulo"><%= senhaDiferente%></h5></p>
                                    </div>
                                </div>
                       
                            <%
                            }
                            %>
                                            </div>
                                            <div class="form-group mt-4 mb-0">
                                                <input class="btn btn-primary btn-block" type="submit" value="Cadastrar" name="acao">
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
