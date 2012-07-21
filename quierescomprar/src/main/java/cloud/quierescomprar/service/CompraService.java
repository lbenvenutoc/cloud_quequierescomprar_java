package cloud.quierescomprar.service;

import javax.jws.WebParam;

import cloud.quierescomprar.model.Compra;

public interface CompraService {
	public Compra consultarCompra(@WebParam(name = "codigoCompra") String codigoCompra);
	
	public String registrarCompra(@WebParam(name = "compra") Compra compra);
}
