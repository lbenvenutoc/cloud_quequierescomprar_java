package cloud.quierescomprar.service;

import javax.jws.WebParam;

import cloud.quierescomprar.model.DetalleCompra;;

public interface DetalleCompraService {
	public DetalleCompra consultarDetalleCompra(@WebParam(name = "codigoDetalleCompra") String codigoDetalleCompra);
}
