package cloud.quierescomprar.service;

import java.util.List;

import cloud.quierescomprar.dao.OfertaDao;
import cloud.quierescomprar.dao.OfertaDaoImp;
import cloud.quierescomprar.model.Oferta;
import cloud.quierescomprar.model.OfertaVenta;

import javax.jws.WebService;


@WebService(endpointInterface="cloud.quierescomprar.service.OfertaService")
public class OfertaServiceImp implements OfertaService{
	
	
	
	OfertaDao dao= new OfertaDaoImp();
	
	
	public List<Oferta> listaOfertas(){
		return dao.listaOfertas();
	}


	public int registroOfertaVenta(OfertaVenta objOfertaVenta) {
	
		return dao.registroOfertaVenta(objOfertaVenta);
	}
	
	public List<Oferta> listaOfertasPorVencer(int dias){
		return dao.listaOfertasPorVencer(dias);
	}
}
