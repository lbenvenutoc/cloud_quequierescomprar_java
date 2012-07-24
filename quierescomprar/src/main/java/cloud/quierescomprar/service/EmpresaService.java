package cloud.quierescomprar.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import cloud.quierescomprar.model.Empresa;

@WebService
public interface EmpresaService {
	
	@WebResult(name="empresas")
	public List<Empresa> listaEmpresas();
	
	public int registroEmpresa(@WebParam(name="objEmpresa") Empresa objEmpresa);
	
}



