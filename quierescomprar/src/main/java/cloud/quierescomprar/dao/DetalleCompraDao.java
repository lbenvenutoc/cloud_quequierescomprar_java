package cloud.quierescomprar.dao;

import cloud.quierescomprar.model.*;


public interface DetalleCompraDao {

	Compra obtenerCompra(String codigo);
	
	Producto obtenerProducto(String codigo);
	
	String registrarDetalleCompra(Compra compradetalle);
	
	String consultarDetalleCompra(Compra consultardetalle);
	
}
