package cloud.quierescomprar.model;


public class Compra {
	 	private String c_compra;
	 	private Usuario c_usuario;
	    private String fecha;
	    private String tipoPago;
	    private String n_tarjeta;
	    private double total;
	    
		public String getC_compra() {
			return c_compra;
		}
		public void setC_compra(String c_compra) {
			this.c_compra = c_compra;
		}
		public Usuario getC_usuario() {
			return c_usuario;
		}
		public void setC_usuario(Usuario c_usuario) {
			this.c_usuario = c_usuario;
		}
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
		public String getTipoPago() {
			return tipoPago;
		}
		public void setTipoPago(String tipoPago) {
			this.tipoPago = tipoPago;
		}
		public String getN_tarjeta() {
			return n_tarjeta;
		}
		public void setN_tarjeta(String n_tarjeta) {
			this.n_tarjeta = n_tarjeta;
		}
		public double getTotal() {
			return total;
		}
		public void setTotal(double total) {
			this.total = total;
		}
	    
	    
	
}
