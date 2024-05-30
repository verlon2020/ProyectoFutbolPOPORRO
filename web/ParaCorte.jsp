<%-- 
    Document   : ParaCorte
    Created on : 26/11/2023, 04:19:29 PM
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
        <title>Clientes para corte</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.html">
                    <img src="Images/back.png" alt="logo" style="height: 40px">
                </a>
            </div>
        </nav>
        <div class="container">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h1>Clientes seleccionados para corte</h1>
                    <h2>Numero del clientes: ${numeroCorte}</h2>
                </div>
            </div>
                <div class="panel-body">
                    <table class="table table-bordered table-dark rounded">
                        <tr>
                            <th>Cedula</th>
                            <th>Nombre</th>
                            <th>Dirección</th>
                            <th>Teléfono</th>
                            <th>Servicio</th>
                            <th>Meses de mora</th>
                            <th>Valor de deuda</th>
                        </tr>
                        <c:forEach items="${clientesTodos}" var="cli">
                        <tr>
                            <td>${cli.cedula}</td>
                            <td>${cli.nombre}</td>
                            <td>${cli.direccion}</td>
                            <td>${cli.telefono}</td>
                            <td>${cli.tipoServicio.nombre}</td>
                            <td class="text-center">${cli.mesesMora}</td>
                            <td>${cli.mesesMora * cli.tipoServicio.precio}</td>
                        </tr>  
                    </c:forEach>
                    </table>
                </div>
        </div>
    </body>
</html>
