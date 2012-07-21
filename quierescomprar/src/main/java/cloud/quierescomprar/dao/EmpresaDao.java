package cloud.quierescomprar.dao;

import cloud.quierescomprar.model.*;

public interface EmpresaDao {
	
	Empresa obtenerEmpresa(String codigo);
	
	String registrarEmpresa(Empresa empresa);	
	
	String consultarEmpresa(Empresa consultar);	
	
}
	