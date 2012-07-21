package cloud.quierescomprar.service;

import java.util.List;
import cloud.quierescomprar.dao.OfertaDao;
import cloud.quierescomprar.dao.OfertaDaoImp;
import cloud.quierescomprar.model.Oferta;
import javax.jws.WebService;

import cloud.quierescomprar.model.Empresa;

@WebService(endpointInterface="cloud.quierescomprar.service.EmpresaService")
public class EmpresaServiceImp implements EmpresaService{
	
	private EmpresaService empresaService;
	
	public Empresa consultarEmpresa(String codigoEmpresa) {
		// TODO Auto-generated method stub
		return empresaService.consultarEmpresa(codigoEmpresa);
	}

	@Override
	public String registrarEmpresa(String codigoEmpresa) {
		// TODO Auto-generated method stub
		return null;
	}
}

