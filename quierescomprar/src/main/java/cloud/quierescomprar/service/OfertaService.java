package cloud.quierescomprar.service;

import java.util.List;


import javax.jws.WebResult;
import javax.jws.WebService;

import cloud.quierescomprar.model.Oferta;




@WebService
public interface OfertaService {
	
	@WebResult(name="ofertas")
	public List<Oferta> listaOfertas();
	
}
