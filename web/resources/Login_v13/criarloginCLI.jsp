<%@page import="model.usuario"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="pt-br">
<head>
	<title>Criar Login Cliente</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/startbootstrap-sb-admin-gh-pages/dist/css/bootstrap.min.css">
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
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body style="background-color: #999999;">
	<div class="limiter">
		<div class="container-login100">
			<div class="login100-more" style="background-image: url('images/bannerlogin.jpg');"></div>
			<div class="wrap-login100 p-l-50 p-r-50 p-t-72 p-b-50">
                                
                           <%
                            String cadUsermsg = (String) request.getAttribute("cadUsermsg");
                            if (cadUsermsg != null) {
                        %>
                         <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p> <h5 id="titulo"><%= cadUsermsg%></h5></p>
                                    </div>
                                </div>
                       
                        <%
                            }
                        %>
				<form class="login100-form validate-form" method="get" action="/Papelaria/UsuarioControle">
					<span class="login100-form-title p-b-59">
						Criar Login
					</span>
                                    <a href="#" class="dis-block txt1 hov1 p-r-30 p-t-10 p-b-10 p-l-30">
							<a href=http://localhost:8080/Papelaria/>
							<i class="fa fa-long-arrow-left m-l-5"></i>
							Voltar
                                                        </a>
						</a>
					<div class="wrap-input100 validate-input" data-validate="Obrigatório nome">
						<span class="label-input100">Nome Completo</span>
                                                <input class="input100" type="text" name="txtnome" id="NomeCompleto" placeholder="Nome" pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$" >
						<span class="focus-input100"></span>
					</div>
                                    
					<div class="wrap-input100 validate-input" data-validate="Somente Números">
						<span class="label-input100">CPF</span>
						<input class="input100" type="number" name="txtcpf" placeholder="CPF" id="cpfCli">
						<span class="focus-input100"></span>
					</div>
                                   
					<div class="wrap-input100 validate-input" data-validate = "seguir o modelo: ex@abc.xyz">
						<span class="label-input100">E-mail</span>
						<input class="input100" type="email" name="txtemail" id="emailCli" placeholder="exemplo@gmail.com">
						<span class="focus-input100"></span>
					</div>
                                    
					<div class="wrap-input100 validate-input" data-validate = "Senha não é forte o suficiente">
                                                <label class="label-input100" for="senha">Senha</label>
						<input class="input100" type="password" name="txtsenha" id="SenhaCli" placeholder="*************">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Senhas diferentes">
						<span class="label-input100">Repetir Senha</span>
						<input class="input100" type="password" name="txtRSenha" id="repeteSenhaCli" oninput="validate('SenhaCli','repeteSenhaCli')"  placeholder="*************">
						<span class="focus-input100"></span>
					</div> 
                                    <div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<input class="login100-form-btn" type="submit" value="Cadastrar" name="acao">

						</div>
					</div>
				</form>
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
        <script src="js/main.js"></script>
</body>
</html>