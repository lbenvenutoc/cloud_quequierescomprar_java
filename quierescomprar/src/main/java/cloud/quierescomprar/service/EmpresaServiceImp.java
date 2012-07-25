package cloud.quierescomprar.service;

import java.util.List;

import cloud.quierescomprar.model.Empresa;
import cloud.quierescomprar.dao.EmpresaDao;
import cloud.quierescomprar.dao.EmpresaDaoImp;

import javax.jws.WebService;

@WebService(endpointInterface="cloud.quierescomprar.service.OfertaService")

public class EmpresaServiceImp implements EmpresaService {
	
	EmpresaDaoImp dao= new EmpresaDaoImp();
	
	public Empresa ObtenerEmpresa(Empresa objEmpresa) {
    	// TODO Auto-generated method stub
	return dao.obtenerEmpresa(objEmpresa);
    }

    public Empresa obtenerEmpresaxRuc(Empresa objEmpresa) {
    	// TODO Auto-generated method stub
	return dao.obtenerEmpresaxRuc(objEmpresa);
    }
    
	public int registrarEmpresa(Empresa objEmpresa) {
		// TODO Auto-generated method stub
		return dao.registrarEmpresa(objEmpresa);
	}

    public List<Empresa> listaEmpresas() {
	// TODO Auto-generated method stub
	return dao.listaEmpresas();
    }

	public int registroEmpresa(Empresa objEmpresa) {
		// TODO Auto-generated method stub
		return 0;
	}
    }

