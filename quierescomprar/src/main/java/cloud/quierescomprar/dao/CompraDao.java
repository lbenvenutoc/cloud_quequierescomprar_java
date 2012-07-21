package cloud.quierescomprar.dao;

import cloud.quierescomprar.model.*;

public interface CompraDao {

	Compra obtenerCompra(String codigo);
	
	Usuario obtenerUsuario(String codigo);
	
	String registrarCompra(Compra compra);
	
	String consultarCompra(Compra consultar);
	
}
