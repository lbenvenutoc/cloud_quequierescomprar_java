package cloud.quierescomprar.test;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import cloud.quierescomprar.model.Compra;
import cloud.quierescomprar.service.CompraService;


public class CompraServiceTest {
	private CompraService compraService;
	
	public CompraServiceTest()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		this.compraService = (CompraService) context.getBean("compraServiceUsuario");
	}
	
	@Test
	public void testObtenerCompra()
	{
		Compra compra  = compraService.consultarCompra("01");
		Assert.assertEquals("01", compra.getC_compra());
		Assert.assertEquals("16-05-2011", compra.getFecha());
		Assert.assertEquals("Contado", compra.getTipoPago());
		Assert.assertEquals("Contado", compra.getN_tarjeta());
		Assert.assertEquals(0.00, compra.getTotal());
		
		
		//Assert.assertEquals("01", compra.getC_usuario().getC_usuario());
		//Assert.assertEquals("44534543", compra.getC_usuario().getDocumentoIdentidad());
		//Assert.assertEquals("Rebeca", compra.getC_usuario().getNombre());
		//Assert.assertEquals("Estrada", compra.getC_usuario().getApellidoPaterno());
		//Assert.assertEquals("Gómez", compra.getC_usuario().getApellidoMaterno());
		//Assert.assertEquals("Av. Dos de Mayo 1026 - San Isidro", compra.getC_usuario().getDireccion());
		//Assert.assertEquals("5752045", compra.getC_usuario().getTelefono());
		//Assert.assertEquals("1", compra.getC_usuario().getTipo());
		//Assert.assertEquals("Perú", compra.getC_usuario().getPais());
		//Assert.assertEquals("Lima", compra.getC_usuario().getDepartamento());
		
			
	}
	
	
	
	
}
