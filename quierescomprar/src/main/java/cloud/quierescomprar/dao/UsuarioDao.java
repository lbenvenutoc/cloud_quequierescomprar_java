package cloud.quierescomprar.dao;

//import javax.jws.WebParam;

import cloud.quierescomprar.model.Usuario;


public interface UsuarioDao {
	//public Usuario consultarUsuario(@WebParam(name = "codigoUsuario") String codigoUsuario);
	
	Usuario obtenerUsario(String codigo);
	
	String registrarUsuario(Usuario usuario);
	
}
