package cloud.quierescomprar.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import cloud.quierescomprar.dao.OfertaDao;
import cloud.quierescomprar.dao.OfertaDaoImp;
import cloud.quierescomprar.dao.UsuarioDao;
import cloud.quierescomprar.dao.UsuarioDaoImp;
import cloud.quierescomprar.model.Oferta;
import cloud.quierescomprar.model.OfertaVenta;
import cloud.quierescomprar.model.OfertaVentaId;
import cloud.quierescomprar.model.Usuario;
import cloud.quierescomprar.service.OfertaServiceImp;

public class OfertaWebServiceTest {
	
	
	@Test
	public void testListaOfertas() {
		OfertaServiceImp servicio= new OfertaServiceImp();
		Assert.assertEquals(1, servicio.listaOfertas().size());
		
		//IMPRESION DE RESULTADOS EN CONSOLA
		for(Oferta objOferta:servicio.listaOfertas())
		{
			
			System.out.println("EMPRESA "+objOferta.getEmpresa().getRuc()+"-"+objOferta.getEmpresa().getRazonSocial());
			System.out.println("DESCRIPCION OFERTA "+objOferta.getDescripcion());
			System.out.println("PRECIO "+objOferta.getPrecio());
			System.out.println("DESCUENTO "+objOferta.getDescuento());
			System.out.println("PRECIO OFERTA "+(objOferta.getPrecio().doubleValue()*objOferta.getDescuento().doubleValue()));
			
		}
	
	}
	
	
	@Test
	public void testRegistroOferta(){
		
		//OBTENER LISTAS TOTALES (DAO)
		OfertaDao ofertaDao= new OfertaDaoImp();
		List<Oferta>listaOfertas=ofertaDao.listaOfertasTotal();
		
		UsuarioDao usuarioDao= new UsuarioDaoImp();
		List<Usuario>listaUsuarios=usuarioDao.listaUsuariosTotal();
		
		//SE SETEA LA LLAVE PRIMARIA DE OFERTA_VENTA
		OfertaVentaId id= new OfertaVentaId	(listaOfertas.get(0).getId().getCOferta(), new Short("1"), listaUsuarios.get(0).getId().getEmail(), listaOfertas.get(0).getId().getCEmpresa());
	
		Usuario usuario= new Usuario();
		usuario=listaUsuarios.get(0);
		
		//SE INICIALIZAN LOS DATOS DE OFERTA_VENTA
		OfertaVenta objOfertaVenta= new OfertaVenta(id, listaOfertas.get(0), usuario, "EF");
		
		//LLAMADA AL SERVICIO DE OFERTAS
		OfertaServiceImp servicio= new OfertaServiceImp();
		Assert.assertEquals(1, servicio.registroOfertaVenta(objOfertaVenta));
	}

}
