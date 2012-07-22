package cloud.quierescomprar.test;

import org.junit.Assert;
import org.junit.Test;

import cloud.quierescomprar.model.Oferta;
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

}
