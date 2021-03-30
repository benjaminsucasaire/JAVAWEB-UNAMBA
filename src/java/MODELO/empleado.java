
package MODELO;

public class empleado {
  private  int IdEmpleado;
  private String Dni;
  private String Estado; 
  private String Nombre;
  private String Telefono;
  private String User;  

    public empleado() {
    }

    public empleado(int IdEmpleado, String Dni, String Estado, String Nombre, String Telefono, String User) {
        this.IdEmpleado = IdEmpleado;
        this.Dni = Dni;
        this.Estado = Estado;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.User = User;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }
  
}
