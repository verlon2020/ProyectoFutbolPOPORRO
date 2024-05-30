<%-- 
    Document   : Clientes
    Created on : 14/11/2023, 07:36:17 AM
    Author     : josue
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="CSS/estilos.css" type="text/css">
        <title>Listado de clientes</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.html">
                    <img src="Images/back.png" alt="logo" style="height: 40px">
                </a>
            </div>
        </nav>
        <!--formulario-->
        
        <div class="container">
            <div class="panel-body">
                <form action="controlador" method="post">
                    <div class="container">
                        <br>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="cedula">Cedula:</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="text" id="cedula" name="cedula" requred="true" value="${cliente.cedula}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="nombre">Nombre:</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="text" id="nombre" name="nombre" requred="true" value="${cliente.nombre}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="direccion">Dirección:</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="text" id="direccion" name="direccion" requred="true" value="${cliente.direccion}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="telefono">Teléfono:</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="text" id="telefono" name="telefono" requred="true" pattern="[0-9]+" value="${cliente.telefono}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="servicio">Servicio:</label> 
                            <div class="col-sm-10">
                                <select class="form-control" id="servicio" name="servicio">
                                    <option value="0">Por favor seleccione</option>
                                    <c:forEach items="${serviciosTodos}" var="ser">
                                        <option value="${ser.id}" ${servicio.id ==ser.id ? 'selected' : ''}>
                                            <c:out value="${ser.nombre}"></c:out>
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="mora">Meses de Mora:</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="text" id="mora" name="mora" requred="true" pattern="[0-9]+" value="${cliente.mesesMora}">
                            </div>
                        </div>
                        <br>
                        <div class="btn-group-justified">
                                <button type="submit" class="btn btn-info" name="action" value="agregar">Agregar</button>
                                <button type="submit" class="btn btn-success" name="action" value="editar">Editar</button>
                                <button type="submit" class="btn btn-warning" name="action" value="limpiar">Limpiar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        
        <!--lista de clientes-->
        <div class="container">
            <br>
            <h1>Información de clientes registrados</h1>
            <br>
            <div class="panel-body">
                <table class="table table-bordered table-dark rounded">
                    <tr>
                        <th>Cedula</th>
                        <th>Nombre</th>
                        <th>Dirección</th>
                        <th>Teléfono</th>
                        <th>Servicio</th>
                        <th>Meses de mora</th>
                        <th colspan="2" class="text-center">Acciones</th>
                    </tr>
                    <c:forEach items="${clientesTodos}" var="cli">
                        <tr>
                            <td>${cli.cedula}</td>
                            <td>${cli.nombre}</td>
                            <td>${cli.direccion}</td>
                            <td>${cli.telefono}</td>
                            <td>${cli.tipoServicio.nombre}</td>
                            <td class="text-center">${cli.mesesMora}</td>
                            <td class="text-center"><a class="btn btn-info" role="button" href="controlador?action=seleccionar&cedula=${cli.cedula}">Seleccionar</a></td>
                            <td class="text-center"><a class="btn btn-danger" role="button" href="controlador?action=borrar&cedula=${cli.cedula}">Borrar</a></td>
                        </tr>  
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
    