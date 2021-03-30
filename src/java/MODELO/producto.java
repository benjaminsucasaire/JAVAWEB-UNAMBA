
package MODELO;

public class producto {
  private  int IdProducto;
  private String Nombre;
   private double Precio;
  private int Stock;   
  private String estado;

    public producto() {
    }

    public producto(int IdProducto, String Nombre, double Precio, int Stock, String estado) {
        this.IdProducto = IdProducto;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Stock = Stock;
        this.estado = estado;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

  
}
