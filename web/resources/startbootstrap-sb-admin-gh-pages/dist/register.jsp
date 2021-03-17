<%@page import="model.funcionario"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Criar user Funcionario</title>
        <link href="http://localhost:8080/Papelaria/resources/startbootstrap-sb-admin-gh-pages/dist/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        
        <%
           funcionario fun = (funcionario) session.getAttribute("funcionario");
           if(fun == null){
               request.getRequestDispatcher("/resources/Login_v13/LoginFUN.jsp").forward(request,response);
           }
       %>
        
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Alterar</h3></div>
                                    <div class="card-body">
                                        
                            <%
                            String cadFunmsg = (String) request.getAttribute("cadFunmsg");
                            if (cadFunmsg != null) {
                        %>
                        <div class="checkout__input">
                                        <p><%= cadFunmsg%></p>
                        </div>
                        <%
                            }
                        %>
                                        <form method="POST" action="/Papelaria/FuncionarioControle" >
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputFirstName">Primeiro Nome</label>
                                                        <input class="form-control py-4" id="nome" name="txtNome" type="text" placeholder="Nome" />
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputLastName">Último Nome</label>
                                                        <input class="form-control py-4" name="txtSobrenome" id="sobrenome" type="text" placeholder="Sobrenome" />
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputEmailAddress">Número do registro</label>
                                                <input class="form-control py-4" id="numReg" name="txtNumReg" type="number" placeholder="Registro" />
                                            </div>
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputPassword">Senha</label>
                                                        <input class="form-control py-4" id="senha" name="txtSenha" type="password" placeholder="Enter password" data-validate = "Senha não é forte o suficiente" />
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputConfirmPassword">Confirmar Senha</label>
                                                        <input class="form-control py-4" name="txtConfSenha" id="confirmaSenha" type="password" placeholder="Confirm password" />
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group mt-4 mb-0">
                                                <input class="btn btn-primary btn-block" type="submit" value="Cadastrar" name="cad">
                                            </div>
                                            <div class="form-group mt-4 mb-0">
                                                <input class="btn btn-primary btn-block" type="submit" value="Deletar" name="cad">
                                            </div>
                                            <div class="form-group mt-4 mb-0">
                                                <input class="btn btn-primary btn-block" type="submit" value="Alterar" name="cad">
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
                            <div class="text-muted">Criado por Amaranta e Matheus Ricardo; Website 2020</div>
                            <div>
                                <a href="#">Politica de privacidade</a>
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
    
    </body>
</html>
