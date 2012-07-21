package cloud.quierescomprar.service;

import javax.jws.WebParam;

import cloud.quierescomprar.model.*;

public interface UsuarioService {

	public Usuario consultarUsuario(@WebParam(name = "codigoUsuario") String codigoUsuario);

	
}
