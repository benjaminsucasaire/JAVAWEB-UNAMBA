/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.cliente;
import MODELO.clienteDAO;
import MODELO.empleado;
import MODELO.empleadoDAO;
import MODELO.producto;
import MODELO.productoDAO;
import MODELO.venta;
import MODELO.ventaDAO;
import config.GenerarSerie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ABUE-RYZEN
 */
@WebServlet(name = "controlador", urlPatterns = {"/controlador"})
public class controlador extends HttpServlet {

    /*cliente*/
    empleadoDAO empDAO = new empleadoDAO();
    empleado emp = new empleado();
    int idempleado;
    /**/
 /*cliente*/
    clienteDAO cliDAO = new clienteDAO();
    cliente cli = new cliente();
    int idcliente;
    /**/
 /*producto*/
    productoDAO proDAO = new productoDAO();
    producto pro = new producto();
    int idproducto;

    /**/
 /*Venta*/
    venta ven = new venta();
    List<venta> lista = new ArrayList<>();
    int item;
    int codigoproducto;
    String descripcion;
    double precio;
    int cantidad;
    double subtotal;
    double totalpagar;
    /*sacarel =""*/
    String numeroserie="";
    ventaDAO venDAO = new ventaDAO();

    /**/
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String capturarclic = request.getParameter("capturarclic");
        String accion = request.getParameter("accion");
        int capturar;
        if (capturarclic.equals("principal")) {
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        }
        if (capturarclic.equals("empleado")) {
            //inicio
            switch (accion) {

                case "Listar":
                    List lista = empDAO.listar();
                    request.setAttribute("trabajador", lista);
                    break;

                case "Agregar":
                    String DNI = request.getParameter("txtdni");
                    String Nombre = request.getParameter("txtnombre");
                    String Telefono = request.getParameter("txttelefono");
                    String Estado = request.getParameter("txtestado");
                    String User = request.getParameter("txtuser");

                    emp.setDni(DNI);
                    emp.setNombre(Nombre);
                    emp.setTelefono(Telefono);
                    emp.setEstado(Estado);
                    emp.setUser(User);
                    empDAO.agregar(emp);
                    request.getRequestDispatcher("controlador?capturar=empleado&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    idempleado = Integer.parseInt(request.getParameter("idcapturar"));
                    empDAO.eliminar(idempleado);
                    request.getRequestDispatcher("controlador?capturar=empleado&accion=Listar").forward(request, response);
                    break;
                case "Modificar":
                    idempleado = Integer.parseInt(request.getParameter("idcapturar"));
                    empleado valor = empDAO.Listar_Modificar(idempleado);
                    request.setAttribute("trab", valor);
                    request.getRequestDispatcher("controlador?capturar=empleado&accion=Listar").forward(request, response);

                    break;

                case "Actualizar":
                    String DNIs = request.getParameter("txtdni");
                    String Nombres = request.getParameter("txtnombre");
                    String Telefonos = request.getParameter("txttelefono");
                    String Estados = request.getParameter("txtestado");
                    String Users = request.getParameter("txtuser");

                    emp.setDni(DNIs);
                    emp.setNombre(Nombres);
                    emp.setTelefono(Telefonos);
                    emp.setEstado(Estados);
                    emp.setUser(Users);
                    emp.setIdEmpleado(idempleado);
                    empDAO.modificar(emp);
                    request.getRequestDispatcher("controlador?capturar=empleado&accion=Listar").forward(request, response);
                    break;

                default:
                    throw new AssertionError();
            }
            //fin
            request.getRequestDispatcher("empleado.jsp").forward(request, response);
        }

        /*cliente*/
        if (capturarclic.equals("cliente")) {
            //inicio
            switch (accion) {

                case "Listar":
                    List lista = cliDAO.listar();
                    request.setAttribute("trabajador", lista);
                    break;

                case "Agregar":
                    String DNI = request.getParameter("txtdni");
                    String Nombre = request.getParameter("txtnombre");
                    String Direccion = request.getParameter("txtdireccion");
                    String Estado = request.getParameter("txtestado");

                    cli.setDni(DNI);
                    cli.setNombre(Nombre);
                    cli.setDireccion(Direccion);
                    cli.setEstado(Estado);

                    cliDAO.agregar(cli);
                    request.getRequestDispatcher("controlador?capturar=cliente&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    idcliente = Integer.parseInt(request.getParameter("idcapturar"));
                    cliDAO.eliminar(idcliente);
                    request.getRequestDispatcher("controlador?capturar=cliente&accion=Listar").forward(request, response);
                    break;
                case "Modificar":
                    idcliente = Integer.parseInt(request.getParameter("idcapturar"));
                    cliente valor = cliDAO.Listar_Modificar(idcliente);
                    request.setAttribute("clie", valor);
                    request.getRequestDispatcher("controlador?capturar=cliente&accion=Listar").forward(request, response);

                    break;

                case "Actualizar":
                    String DNIc = request.getParameter("txtdni");
                    String Nombrec = request.getParameter("txtnombre");
                    String Direccionc = request.getParameter("txtdireccion");
                    String Estadoc = request.getParameter("txtestado");

                    cli.setDni(DNIc);
                    cli.setNombre(Nombrec);
                    cli.setDireccion(Direccionc);
                    cli.setEstado(Estadoc);
                    cli.setIdCliente(idcliente);
                    cliDAO.modificar(cli);
                    request.getRequestDispatcher("controlador?capturar=cliente&accion=Listar").forward(request, response);
                    break;

                default:
                    throw new AssertionError();
            }
            //fin
            request.getRequestDispatcher("cliente.jsp").forward(request, response);
        }
        /*producto*/
        if (capturarclic.equals("producto")) {
            //inicio
            switch (accion) {

                case "Listar":
                    List lista = proDAO.listar();
                    request.setAttribute("trabajador", lista);
                    break;

                case "Agregar":
                    String Nombre = request.getParameter("txtnombre");
                    double Precio = Double.parseDouble(request.getParameter("txtprecio"));
                    int Stock = Integer.parseInt(request.getParameter("txtstock"));
                    String Estado = request.getParameter("txtestado");

                    pro.setNombre(Nombre);
                    pro.setPrecio(Precio);
                    pro.setStock(Stock);
                    pro.setEstado(Estado);

                    proDAO.agregar(pro);
                    request.getRequestDispatcher("controlador?capturar=producto&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    idproducto = Integer.parseInt(request.getParameter("idcapturar"));
                    proDAO.eliminar(idproducto);
                    request.getRequestDispatcher("controlador?capturar=producto&accion=Listar").forward(request, response);
                    break;
                case "Modificar":
                    idproducto = Integer.parseInt(request.getParameter("idcapturar"));
                    producto valor = proDAO.Listar_Modificar(idproducto);
                    request.setAttribute("prod", valor);
                    request.getRequestDispatcher("controlador?capturar=producto&accion=Listar").forward(request, response);

                    break;

                case "Actualizar":
                    String Nombrep = request.getParameter("txtnombre");
                    double preciop = Double.parseDouble(request.getParameter("txtprecio"));
                    int stockp = Integer.parseInt(request.getParameter("txtstock"));
                    String Estadop = request.getParameter("txtestado");

                    pro.setNombre(Nombrep);
                    pro.setPrecio(preciop);
                    pro.setStock(stockp);
                    pro.setEstado(Estadop);
                    pro.setIdProducto(idproducto);
                    proDAO.modificar(pro);
                    request.getRequestDispatcher("controlador?capturar=producto&accion=Listar").forward(request, response);
                    break;

                default:
                    throw new AssertionError();
            }
            //fin
            request.getRequestDispatcher("producto.jsp").forward(request, response);
        }

        ////////////////////////////////////////////NUEVA VENTA
        //BUSCAR CLIENTE
        if (capturarclic.equals("nuevaventa")) {
            ven = new venta();
            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("codigocliente");
                    cli.setDni(dni);
                    cli = cliDAO.buscar(dni);
                    request.setAttribute("cliec", cli);
                    break;
                //BUSCAR PRODUCTO
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    pro = proDAO.listarId(id);
                    /*esto nos permite ver nuestra despues de agregarlo al momento de buscarproducto */
                    request.setAttribute("cliec", cli);
                    request.setAttribute("producto", pro);
                    /*esto nos permite ver nuestra lista de productos cuando buscamos otro producto*/
                    request.setAttribute("lista", lista);
                    /*esto nos permite ver nuestra cliente cuando buscamos otro producto */
                    request.setAttribute("totalpagar", totalpagar);
                    break;

                case "Agregar":
                    /*esto nos permite ver nuestra cliente cuando buscamos otro producto */
                    request.setAttribute("cliec", cli);
                    totalpagar = 0.0;
                    /*item funciona como un contador*/
                    item = item + 1;
                    codigoproducto = pro.getIdProducto();
                    descripcion = request.getParameter("nombreproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cantidad = Integer.parseInt(request.getParameter("cantidad"));
                    subtotal = precio * cantidad;
                    ven = new venta();
                    ven.setItem(item);
                    ven.setIdProducto(codigoproducto);
                    ven.setDescripcionProducto(descripcion);
                    ven.setPrecio(precio);
                    ven.setCantidad(cantidad);
                    ven.setSubTotal(subtotal);
                    lista.add(ven);
                    /*se agregara un for, este for para recorrrer la cantidad de datos que existen en la lista*/
                    for (int i = 0; i < lista.size(); i++) {
                        totalpagar = totalpagar + lista.get(i).getSubTotal();
                    }
                    request.setAttribute("totpagar", totalpagar);
                    request.setAttribute("lista", lista);
                    break;
                case "GenerarVenta":
                    //Actualizar Stock
                    for (int i = 0; i <lista.size(); i++) {
                        producto pr= new producto();
                        int cantidad=lista.get(i).getCantidad();
                        int idproducto=lista.get(i).getIdProducto();
                        productoDAO  aO=new productoDAO();
                        pr=aO.buscar(idproducto);
                        int sac=pr.getStock()-cantidad;
                        aO.actualizarstock(idproducto, sac);
                    }
                    //////////////////guardar venta
                    ven.setIdCliente(cli.getIdCliente());
                    ven.setIdEmpleado(1);
                    ven.setNumeroSerie(numeroserie);
                    ven.setFecha("2019-06-14");
                    ven.setMonto(totalpagar);
                    ven.setEstado("1");
                    venDAO.guardarVenta(ven);
                    //guardar detalle ventas
                    int idv = Integer.parseInt(venDAO.IdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        ven = new venta();
                        ven.setIdVenta(idv);
                        ven.setIdProducto(lista.get(i).getIdProducto());
                        ven.setCantidad(lista.get(i).getCantidad());
                        ven.setPrecio(lista.get(i).getPrecio());
                        /*Guardar los datos en el parametro */
                        venDAO.guardarDetalleventas(ven);
                    }

                    break;

                default:

                        
                    request.getRequestDispatcher("venta.jsp").forward(request, response);

            }
                    numeroserie = venDAO.GenerarSerie();
                     /* ven=new venta();
                    lista=new ArrayList<>();
                    item=0;
                    totalpagar=0.0;*/
                    /*si no tenemos registrado ninguna venta en nuestra BD*/

                    if (numeroserie == null) {
                        numeroserie = "00000001";
                        request.setAttribute("nserie", numeroserie);
                    } else {
                        int incrementar = Integer.parseInt(numeroserie);

                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
            request.getRequestDispatcher("venta.jsp").forward(request, response);

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
