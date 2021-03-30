
package MODELO;

public class venta {
  private  int IdVenta;
  private  int Item;
  private  int IdCliente;
  private  int IdEmpleado;
  private  int IdProducto;
  private String NumeroSerie;
  private String DescripcionProducto;
   private String Fecha;
   private double Precio;
   private  int Cantidad;
   private double SubTotal;
   private double Monto;
  private String Estado;   
  

    public venta() {
    }

    public venta(int IdVenta, int Item, int IdCliente, int IdEmpleado, int IdProducto, String NumeroSerie, String DescripcionProducto, String Fecha, double Precio, int Cantidad, double SubTotal, double Monto, String Estado) {
        this.IdVenta = IdVenta;
        this.Item = Item;
        this.IdCliente = IdCliente;
        this.IdEmpleado = IdEmpleado;
        this.IdProducto = IdProducto;
        this.NumeroSerie = NumeroSerie;
        this.DescripcionProducto = DescripcionProducto;
        this.Fecha = Fecha;
        this.Precio = Precio;
        this.Cantidad = Cantidad;
        this.SubTotal = SubTotal;
        this.Monto = Monto;
        this.Estado = Estado;
    }

    public int getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
    }

    public int getItem() {
        return Item;
    }

    public void setItem(int Item) {
        this.Item = Item;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNumeroSerie() {
        return NumeroSerie;
    }

    public void setNumeroSerie(String NumeroSerie) {
        this.NumeroSerie = NumeroSerie;
    }

    public String getDescripcionProducto() {
        return DescripcionProducto;
    }

    public void setDescripcionProducto(String DescripcionProducto) {
        this.DescripcionProducto = DescripcionProducto;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

  
}
