<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/estilosregistroempleado.css" rel="stylesheet" type="text/css"/>
        <!--<link href="CSS/estilosregistroempleado.css" rel="stylesheet" type="text/css"/>-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>FORMULARIO</title>
    </head>

    <body>
        <!--------------------------------------------------->   
        <div class="d-flex"style="margin-top: 20px" >
            <div class="card col-sm-3" style="margin-left: 60px">
                <div class="card-body">
                    <form action="controlador?capturarclic=empleado" method="POST">
                        <div class="form-group">
                            <h3 style="text-align: center">Empleado</h3>
                            <img src="img/empleado.png" height="90" width="90"/>
                        </div>
                        <div class="form-group">
                         
                            <input class="form-control" type="text" value="${trab.getDni()}" name="txtdni" placeholder="Ingese su DNI">
                        </div>
                        <div class="form-group">
                            
                            <input class="form-control" type="text" value="${trab.getNombre()}" name="txtnombre" placeholder="Ingese su Nombre">
                        </div>
                        <div class="form-group">
                           
                            <input class="form-control" type="text" value="${trab.getTelefono()}" name="txttelefono" placeholder="Ingese su telefono">
                        </div>
                        <div class="form-group">
                            
                            <input class="form-control" type="text" value="${trab.getEstado()}" name="txtestado" placeholder="Ingese su estado">
                        </div>
                        <div class="form-group">
                            
                            <input class="form-control" type="text" value="${trab.getUser()}" name="txtuser" placeholder="Ingese su Usuario">
                        </div>
                        <div class="form-group" style="margin-left: 25px">
                            <input class="btn btn-info" style="margin:5px 0px " type="submit" name="accion" value="Agregar">
                        <input class="btn btn-success" type="submit" name="accion" value="Actualizar">
                        </div>
                    </form>
                </div>
            </div>

            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>DNI</th>
                            <th>Nombre</th>
                            <th>Telefono</th>
                            <th>Estado</th>
                            <th>Usuario</th>
                            <th>Acciones</th>
                        </tr>

                    </thead>
                    <tbody>
                        <c:forEach var="emp" items="${trabajador}"> 
                            <tr>

                                <td>${emp.getIdEmpleado()}</td>
                                <td>${emp.getDni()}</td>
                                <td>${emp.getNombre()}</td>
                                <td>${emp.getTelefono()}</td>
                                <td>${emp.getEstado()}</td> 
                                <td>${emp.getUser()}</td>
                                <td id="mantenimiento" style="padding: 0px"> 
                                    
                                    <a class="btn" href="controlador?capturarclic=empleado&accion=Eliminar&idcapturar=${emp.getIdEmpleado()}"><img src="img/borrar.png" title="Eliminar" alt="eliminar"/> </a>
                                    <a class="btn" href="controlador?capturarclic=empleado&accion=Modificar&idcapturar=${emp.getIdEmpleado()}"><img src="img/modificar.png" title="editar" alt="editar"/></a>

                                </td>
                            </tr>
                        </c:forEach> 
                    </tbody>
                </table> 
            </div>        
        </div>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>

</html>