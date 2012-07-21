package cloud.quierescomprar.service;

import javax.jws.WebParam;

import cloud.quierescomprar.model.Empresa;

public interface EmpresaService {

	public Empresa consultarEmpresa(@WebParam(name = "codigoEmpresa") String codigoEmpresa);
	
    public String registrarEmpresa(@WebParam(name = "CodigoEmpresa") String codigoEmpresa) ;
}
