<%@page import="model.funcionario"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="http://localhost:8080/Papelaria/resources/Login_v13/css/util.css">
        <link rel="stylesheet" type="text/css" href="http://localhost:8080/Papelaria/resources/Login_v13/css/main.css">
        <!--===============================================================================================-->

        <script language="javascript">
            function validate()
            {
                var usuario = document.LoginForm.txtReg; //get form name "LoginForm" and textbox name "txt_reg" store in variable username
                var senha = document.LoginForm.txtPass; //get form name "LoginForm" and textbox name "txt_pass" store in variable password

                if (usuario.value == null || usuario.value == "") //check username textbox not blank
                {
                    window.alert("Digite seu Registro"); //alert message
                    usuario.style.background = '#f08080'; //set textbox color
                    senha.focus();
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
    </head>
    <body style="background-color: #999999;">
        <div class="limiter">
            <div class="container-login100">
                <div class="login100-more" style="background-image: url('http://localhost:8080/Papelaria/resources/Login_v13/images/bannerlogin.jpg');"></div>

                <div class="wrap-login100 p-l-50 p-r-50 p-t-72 p-b-50">
                    <form class="login100-form validate-form"   method="get" action="/Papelaria/LoginControle" name="LoginForm" onsubmit="return validate();">
                        <span class="login100-form-title p-b-59">
                            Login Funcionário
                        </span>
                        <a href="#" class="dis-block txt1 hov1 p-r-30 p-t-10 p-b-10 p-l-30">
							<a href=http://localhost:8080/Papelaria/>
							<i class="fa fa-long-arrow-left m-l-5"></i>
							Voltar
                                                        </a>
						</a>
                        <div class="wrap-input100 validate-input" data-validate = "seguir modelo: 11111">
                            <span class="label-input100">Número do Registro</span>
                            <input class="input100" type="numeric" name="txtReg" id="funReg" placeholder="Registro...">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate = "Senha">
                            <span class="label-input100">Senha</span>
                            <input class="input100" type="password" name="txtPass" id="funPass" placeholder="*************">
                            <span class="focus-input100"></span>
                        </div>
                        <div class="flex-m w-full p-b-33">
                            <div class="contact100-form-checkbox">
                                <input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">

                            </div>
                        </div>
                        
                        <%
                            String msge = (String) request.getAttribute("msgErro");
                            if (msge != null) {
                            %><h3 style="color:red"><%= msge%></h3><%
                            }
                            %>
                            
                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <button class="login100-form-btn">
                                    <input class="login100-form-btn" type="submit" name="login" value="Entrar" >
                                </button>
                            </div>
                        </div>
                    </form>



                    <%
                        String msg = (String) request.getAttribute("errologin");
                        if (msg != null) {
                    %>
                    <h3><%= msg%></h3>
                    <%
                        }
                    %>
                    </h3>
                </div>
            </div>
        </div>

        <!--===============================================================================================-->
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/daterangepicker/moment.min.js"></script>
        <script src="vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
    </body>
</html>