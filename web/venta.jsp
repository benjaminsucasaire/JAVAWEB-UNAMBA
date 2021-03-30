<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--<link href="CSS/estilosregistroempleado.css" rel="stylesheet" type="text/css"/>-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Nueva Venta</title>
        
        <style>
            
            @media print{
                .parte01, .btn, .quitarcolumna{
                    display: none;
                }
            }
        </style>
    </head>

    <body>
        <!------------------------------------------------------------------------>
        <div class="d-flex">
            <div class="col-sm-5 parte01">
                <div class="card">

                    <form action="controlador?capturarclic=nuevaventa" method="POST">
                        <div class="card-body">
                            <div class="form-group" >
                                <label>Datos del cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex" >
                                    <input class="form-control" type="text" name="codigocliente" value="${cliec.getDni()}" placeholder="Ingrese DNI">
                                    <input class="btn btn-outline-info" type="submit" name="accion"   value="BuscarCliente">
                                </div>
                                <div class="col-sm-6" >
                                    <input class="form-control" type="text" name="nombrecliente"  value="${cliec.getNombre()}" placeholder="Datos del Cliente">
                                </div> 
                            </div>
                                <!--Datos del producto-->
                            <div class="form-group" >
                                <label>Datos Producto</label>
                            </div>
                            <div class="form-group d-flex" >
                                <div class="col-sm-6 d-flex" >
                                    <input class="form-control" type="text" name="codigoproducto" value="${producto.getIdProducto()}"  placeholder="Codigo">
                                    
                                    <button class="btn btn-outline-info" type="submit" name="accion"   value="BuscarProducto">Buscar</button>
                                </div>
                                <div class="col-sm-6" >
                                    <input class="form-control" type="text" name="nombreproducto"  value="${producto.getNombre()}" placeholder="Datos Producto">
                                </div>   
                            </div>
                            <div class="form-group d-flex" >
                                <div class="col-sm-5 d-flex" >
                                    <input class="form-control" type="text" name="precio" value="${producto.getPrecio()}" placeholder=" S/0.00">

                                </div>
                                <div class="col-sm-4">
                                    <input class="form-control" type="number" name="cantidad" value="1" placeholder="Cantidad">
                                </div>

                                <div class="col-sm-3" >
                                    <input class="form-control" type="text" name="stock"  value="${producto.getStock()}" placeholder="Stock">
                                </div> 

                            </div>
                                <!--Agregar productos al registro-->
                            <div class="form-group">
                                <div class="col-sm">
                                  <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-5 ml-auto">
                            <label>N°Serie:</label>
                            <input readonly=" " type="text" name="NroSerie" value="${nserie}" class="form-control">
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                    <th class="quitarcolumna">Acciones</th>    
                                </tr>

                            </thead>
                            <tbody>
                                    <!--el atributo lista biene desde el controlador-->
                        <c:forEach var="list" items="${lista}"> 
                            <tr>

                                <td>${list.getItem()}</td>
                                <td>${list.getIdProducto()}</td>
                                <td>${list.getDescripcionProducto()}</td>
                                <td>${list.getPrecio()}</td>
                                <td>${list.getCantidad()}</td>
                                <td>${list.getSubTotal()}</td> 
                                <td  class="d-flex" style="padding: 0px"> 
                                    
                                    <a class="btn" href="controlador?capturarclic=venta&accion=Eliminar&idcapturar=${list.getIdProducto()}"><img src="img/borrar.png" title="Eliminar" alt="eliminar"/> </a>
                                    <a class="btn" href="controlador?capturarclic=venta&accion=Modificar&idcapturar=${list.getIdProducto()}"><img src="img/modificar.png" title="editar" alt="editar"/></a>

                                </td>
                            </tr>
                        </c:forEach> 

                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a href="controlador?capturarclic=nuevaventa&accion=GenerarVenta" onclick="print()" class="btn btn-success" >Generar venta</a>
                            
                            <input  type="submit" name="accion" value="Cancelar" class="btn btn-danger" > 
                        </div>
                        <div class="col-sm-4 ml-auto">
                            <input readonly=" "  type="text"  value="S/. ${totpagar}0" name="txttotal" class="form-control" >
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


    </body>

</html>