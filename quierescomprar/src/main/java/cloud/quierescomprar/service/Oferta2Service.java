package cloud.quierescomprar.service;

import javax.jws.WebParam;

import cloud.quierescomprar.model.Oferta2;;

public interface Oferta2Service {
	public Oferta2 consultarOferta2(@WebParam(name = "codigoOferta2") String codigoOferta2);
}
