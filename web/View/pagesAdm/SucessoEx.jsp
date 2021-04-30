<%-- 
    Document   : SucessoEx
    Created on : 24/10/2020, 20:17:53
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <h1>Resultado da execução....</h1>
        <%
            String m = (String) request.getAttribute("mensagem");
        %>
        <h1><%=
            m
            %></h1>
    </body>
</html>
