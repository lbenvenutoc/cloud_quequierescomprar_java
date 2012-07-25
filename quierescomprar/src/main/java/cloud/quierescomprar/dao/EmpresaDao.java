package cloud.quierescomprar.dao;

import java.util.List;

import cloud.quierescomprar.model.Empresa;

public interface EmpresaDao {

	public Empresa ObtenerEmpresa(Empresa objEmpresa);
	public Empresa ObtenerEmpresaxRuc(Empresa objEmpresa);
	public int registrarEmpresa(Empresa objEmpresa);
	public List<Empresa> listaEmpresas();
	
}
