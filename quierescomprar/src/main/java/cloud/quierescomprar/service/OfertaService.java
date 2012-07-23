package cloud.quierescomprar.service;

import java.util.List;


import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import cloud.quierescomprar.model.Oferta;
import cloud.quierescomprar.model.OfertaVenta;




@WebService
public interface OfertaService {
	
	@WebResult(name="ofertas")
	public List<Oferta> listaOfertas();
	
	public int registroOfertaVenta(@WebParam(name="objOfertaVenta") OfertaVenta objOfertaVenta);
	
}
