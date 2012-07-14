package cloud.quierescomprar.test;

import org.junit.Assert;
import org.junit.Test;

import cloud.quierescomprar.service.OfertaServiceImp;

public class OfertaWebServiceTest {

		
	@Test
	public void testListaOfertas() {
		OfertaServiceImp servicio= new OfertaServiceImp();
		Assert.assertEquals(1, servicio.listaOfertas().size());
	}

}
