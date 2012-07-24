package cloud.quierescomprar.dao;

import java.util.List;


import cloud.quierescomprar.model.OfertaVenta;

public interface OfertaVentaDao {

	public List<OfertaVenta> listaOfertaVenta();
	public int registroOfertaVenta(OfertaVenta objOfertaVenta);
	
	
}


