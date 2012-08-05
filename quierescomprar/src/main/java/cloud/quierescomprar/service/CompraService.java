package cloud.quierescomprar.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;


import cloud.quierescomprar.dao.CompraDao;
import cloud.quierescomprar.dao.CompraDaoImp;
import cloud.quierescomprar.model.ListaCompra;


@Path("/Compra")
public class CompraService {
	
	private CompraDao dao;
	
	 @GET
     @Path("/lista/{codEmpresa}/{email}")
     @Produces("application/json")
	
	 //PARA PROBAR EL SW REST (http://localhost:8040/quierescomprar/rest/Compra/lista/1/orellana@sss.com)
	public ListaCompra listaComprasPorEmpresa(@PathParam("codEmpresa")int codEmpresa,@PathParam("email")String emailUsuario){
		dao= new CompraDaoImp();
		ListaCompra listaCom= new ListaCompra();
		listaCom.setLista(dao.listaComprasPorEmpresa(codEmpresa, emailUsuario));
		return listaCom;
		
		
	}

}
