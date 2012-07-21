package cloud.quierescomprar.model;

public class DetalleCompra {
	private String c_compra;
 	private Usuario c_oferta;
    private String fecha;
    private String cantidad;
    private String preciounit;
    private double total;
	public String getC_compra() {
		return c_compra;
	}
	public void setC_compra(String c_compra) {
		this.c_compra = c_compra;
	}
	public Usuario getC_oferta() {
		return c_oferta;
	}
	public void setC_oferta(Usuario c_oferta) {
		this.c_oferta = c_oferta;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getPreciounit() {
		return preciounit;
	}
	public void setPreciounit(String preciounit) {
		this.preciounit = preciounit;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
