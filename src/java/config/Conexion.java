package config;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

Connection con=null ;
String url = "jdbc:mysql://localhost:3306/sistema_venta";
     String usuario = "root";
   String pass = "";

    public Connection Conexion() throws ClassNotFoundException   {
        try {
           //colocamos la ruta de driver 
            Class.forName("com.mysql.jdbc.Driver");
            con =  (Connection) DriverManager.getConnection(url,usuario,pass);
            System.out.println("se conecto");
        } catch (SQLException e) {
            System.err.print("no se conecto");
          
        } 
      return con;
    }
}
