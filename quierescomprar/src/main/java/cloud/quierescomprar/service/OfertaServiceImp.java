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
	
	
	public String[] listaOfertasDelDia(){
		return dao.listaOfertasDelDia();
	}


	public int registroOfertaVenta(int codEmpresa,String codOferta,int codLinea,String email,String codMedioPago) {
	
		return dao.registroOfertaVenta(codEmpresa,codOferta,codLinea,email,codMedioPago);
	}
	
	public List<Oferta> listaOfertasPorVencer(int dias){
		return dao.listaOfertasPorVencer(dias);
	}
}
