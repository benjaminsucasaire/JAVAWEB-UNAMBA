package MODELO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class clienteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;


    /////////////////////////////////////////////
    //CREAR METODOS u OPERACIONES CRUD
    public List listar() {
        String sql = "select * from cliente";
        List<cliente> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente em = new cliente();
                em.setIdCliente(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNombre(rs.getString(3));
                em.setDireccion(rs.getString(4));
                em.setEstado(rs.getString(5));
                lista.add(em);
            }
        } catch (Exception e) {

        }
        return lista;
    }

    ////////////////////////////////////////////
    public cliente agregar(cliente em) {
        String sql = "insert into cliente(Dni,Nombre,Direccion,Estado) values (?,?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getDireccion());
            ps.setString(4, em.getEstado());
            ps.executeUpdate();

        } catch (Exception e) {
        
        }

        return em;
    }

/////////////////////
public void eliminar(int id) {
        String sql = "delete from cliente where IdCliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    } 
    
    
    
    //////////////////
public cliente Listar_Modificar(int id) {
        cliente emp = new cliente();
        String sql = "select * from cliente where IdCliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setDni(rs.getString(2));
                emp.setNombre(rs.getString(3));
                emp.setDireccion(rs.getString(4));
                emp.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return emp;
    }
  
///////////////////////7
public cliente modificar(cliente cli) {
        String sql = "update  cliente set Dni=?, Nombre=?, Direccion=?, Estado=? where IdCliente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNombre());
            ps.setString(3, cli.getDireccion());
            ps.setString(4, cli.getEstado());
            ps.setInt(5,cli.getIdCliente());
            
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return cli;
    }
///////////////////////////
public cliente buscar(String dni) {
        cliente c = new cliente();
        String sql = "select * from cliente where Dni="+dni;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setIdCliente(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEstado(rs.getString(5));

            }
        } catch (Exception e) {
        }
        return c;
    }

//////////////////////////
}
