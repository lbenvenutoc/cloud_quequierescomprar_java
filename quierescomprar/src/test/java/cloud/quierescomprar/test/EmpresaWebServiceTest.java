package cloud.quierescomprar.test;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import cloud.quierescomprar.dao.EmpresaDao;
import cloud.quierescomprar.dao.EmpresaDaoImp;
import cloud.quierescomprar.dao.UsuarioDao;
import cloud.quierescomprar.dao.UsuarioDaoImp;
import cloud.quierescomprar.model.Empresa;
import cloud.quierescomprar.model.Usuario;
import cloud.quierescomprar.service.EmpresaServiceImp;
import cloud.quierescomprar.service.OfertaServiceImp;

public class EmpresaWebServiceTest {


	@Test
	public void testListaEmpresas() {
		EmpresaServiceImp servicio= new EmpresaServiceImp();
		Assert.assertEquals(1, servicio.listaEmpresas().size());
		
		//IMPRESION DE RESULTADOS EN CONSOLA
		for(Empresa objEmpresa:servicio.listaEmpresas())
		{			
			System.out.println("C_EMPRESA "+objEmpresa.getCEmpresa());
			System.out.println("RUC "+objEmpresa.getRuc());
			System.out.println("Razon Social "+objEmpresa.getRazonSocial());
			
		}
	
	}
	
	@Test
	public void testRegistrarEmpresas(){
		
		//OBTENER LISTAS TOTALES (DAO)
		EmpresaDao empresaDao= new EmpresaDaoImp();
		List<Empresa>listaEmpresas=empresaDao.listaEmpresas();
		
		UsuarioDao usuarioDao= new UsuarioDaoImp();
		List<Usuario>listaUsuarios=usuarioDao.listaUsuariosTotal();
		
		Usuario usuario= new Usuario();
		usuario=listaUsuarios.get(0);
		
	    EmpresaServiceImp servicio= new EmpresaServiceImp();
//		Assert.assertEquals(1, servicio.registrarEmpresas(objEmpresa));
	}

}