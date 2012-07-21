package cloud.quierescomprar.service;

import cloud.quierescomprar.model.Compra;

//import cloud.quierescomprar.service.*;

//import cloud.quierescomprar.model.*;

public class CompraServiceImpl implements CompraService {

	//private UsuarioService usuarioService;
	private CompraService compraService;
	
	public Compra consultarCompra(String codigoCompra) {
		// TODO Auto-generated method stub
		return compraService.consultarCompra(codigoCompra);
	}

	public String registrarCompra(Compra compra) {
		// TODO Auto-generated method stub
		return compraService.registrarCompra(compra);
	}

}
