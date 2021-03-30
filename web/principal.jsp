<%-- 
    Document   : principal
    Created on : 06-mar-2021, 23:50:34
    Author     : ABUE-RYZEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <!--<link href="CSS/estiloprincipal.css" rel="stylesheet" type="text/css"/>--> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <!-------------------------------------------------------------------------------------------------------->
        <div>
            <nav class="navbar navbar-expand-lg navbar-light bg-info ">
                <!------------------------------------------------------------> 
                <a class="navbar-brand" href="#"><img src="img/slack.png" style="width: 40px;height:40px " alt=""/></a>
                
                
                
                <button class="navbar-toggler navbar-dark" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <!------------------------------------------------------------> 

                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">


                        <li class="nav-item">
                            <a  style="margin-left: 10px;border: none"  class="btn btn-outline-light" href="controlador?capturarclic=producto&accion=Listar" target="frame">Producto</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px;border: none" class="btn btn-outline-light" href="controlador?capturarclic=empleado&accion=Listar" target="frame">Empleado</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px;border: none" class="btn btn-outline-light" href="controlador?capturarclic=cliente&accion=Listar" target="frame">Cliente</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px;border: none" class="btn btn-outline-light" href="controlador?capturarclic=nuevaventa&accion=BuscarCliente" target="frame">Nueva Venta</a>
                        </li>
                    </ul>

                </div>
                    <div class="dropdown">
                        <button style="border: none;margin-right: 60px " class="btn btn-success dropdown-toogle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ${usuario.getNombre()}
                        </button>
                        <div class="dropdown-menu text-center">
                            <a class="dropdown-item" href="#">
                                <img src="img/empleado.png" alt="Usuario" width="60" height="60" />
                            </a>
                            <a class="dropdown-item" href="#">${usuario.getUser()}</a>
                            <a class="dropdown-item" href="#">${usuario.getUser()}@gmail.com</a>
                            <div class="dropdown-divider"></div>
                            <form action="Validar" method="POST">
                                <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button> 
                            </form>
                        </div>
                    </div>
            </nav>
        </div>
        <div class="m-4" style="height: 550px;">
            <iframe  name="frame" style=" width:100%; height: 100%;border: none"> </iframe> 
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>
