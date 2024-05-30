<%-- 
    Document   : Login
    Created on : 27/11/2023, 09:49:18 AM
    Author     : josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="CSS/estilos.css" type="text/css">
        <title>Login</title>
    </head>
    <body>
        <div class="container text-center mt-5">
            <h1>Diligencie los siguientes campos para continuar</h1>
        </div>
        <div class="container text-center mt-2"> 
            <form class="mx-auto align-items-center" action="controladorLogin" method="post" style="width: 400px">
                <div class="form-group">
                    <label class="form-label" for="correo">Correo:</label>
                    <div class="mb-3">
                        <input class="form-control" type="text" id="correo" name="correo" required style="border-color: black"><br>
                    </div>
                </div>
                <div class="form-group">
                    <label class="form-label" for="password">Contraseña:</label>
                    <div class="mb-3">
                        <input class="form-control" id="password" type="password" name="password" required style="border-color: black"><br>
                    </div>
                </div>
                <input class="btn btn-warning" type="submit" value="Ingresar" id="ingresar">
            </form>
        </div>
        <% if (request.getParameter("error") != null) { %>
        <p style="color: red;">Error de autenticación. Verifica tu usuario y contraseña.</p>
        <% }%>
    </body>
</html>
