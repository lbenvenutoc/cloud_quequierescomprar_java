package cloud.quierescomprar.service;

import java.util.List;

import cloud.quierescomprar.model.Empresa;
import cloud.quierescomprar.dao.EmpresaDao;
import cloud.quierescomprar.dao.EmpresaDaoImpl;

import javax.jws.WebService;

@WebService(endpointInterface="cloud.quierescomprar.service.OfertaService")

public class EmpresaServiceImp implements EmpresaService {
	
	EmpresaDaoImpl dao= new EmpresaDaoImpl();
	
	public List<Empresa> listaEmpresas() {
		// TODO Auto-generated method stub
		return dao.listaEmpresa();
	}

	public int registroEmpresa(Empresa objEmpresa) {
		// TODO Auto-generated method stub
		return dao.registroEmpresa(objEmpresa);
	}

}


