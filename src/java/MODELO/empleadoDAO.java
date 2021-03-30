package MODELO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class empleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public empleado validar(String User, String Dni) {
        empleado em = new empleado();
        String sql = "select *from empleado where User=? and Dni=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, User);
            ps.setString(2, Dni);
            rs = ps.executeQuery();
            while (rs.next()) {
               em.setIdEmpleado(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNombre(rs.getString("Nombre"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

        return em;
    }

    /////////////////////////////////////////////
    //CREAR METODOS CONSULTAS
    public List listar() {
        String sql = "select * from empleado";
        List<empleado> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                empleado em = new empleado();
                em.setIdEmpleado(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNombre(rs.getString(3));
                em.setTelefono(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                lista.add(em);
            }
        } catch (Exception e) {

        }
        return lista;
    }

    ////////////////////////////////////////////
    public empleado agregar(empleado em) {
        String sql = "insert into empleado(Dni,Nombre,Telefono,Estado,User) values (?,?,?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getTelefono());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.executeUpdate();

        } catch (Exception e) {
        
        }

        return em;
    }

/////////////////////
public void eliminar(int id) {
        String sql = "delete from empleado where IdEmpleado=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    } 
    
    
    
    //////////////////
public empleado Listar_Modificar(int id) {
        empleado emp = new empleado();
        String sql = "select * from empleado where IdEmpleado=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setDni(rs.getString(2));
                emp.setNombre(rs.getString(3));
                emp.setTelefono(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return emp;
    }
  
///////////////////////7
public empleado modificar(empleado em) {
        String sql = "update  empleado set Dni=?, Nombre=?, Telefono=?, Estado=?, User=? where IdEmpleado=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getTelefono());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.setInt(6,em.getIdEmpleado());
            
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return em;
    }
///////////////////////////
}
