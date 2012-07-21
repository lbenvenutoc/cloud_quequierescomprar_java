package cloud.quierescomprar.dao;

import cloud.quierescomprar.model.*;

public interface Oferta2Dao {

	Oferta2 obtenerOferta2(String codigo);
	
	String registrarOferta2(Oferta2 oferta);
	
	String consultarOferta2(Oferta2 consultar);
	
}
