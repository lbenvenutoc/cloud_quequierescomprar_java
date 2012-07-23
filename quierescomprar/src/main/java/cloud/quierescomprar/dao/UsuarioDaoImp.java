package cloud.quierescomprar.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cloud.quierescomprar.model.Oferta;
import cloud.quierescomprar.model.Usuario;
import cloud.quierescomprar.util.HibernateUtil;

public class UsuarioDaoImp implements UsuarioDao {

	public List<Usuario> listaUsuariosTotal() {
		Session sesion = HibernateUtil.getSessionFactory();
		
		
		List<Usuario> listaUsuarios=null;
		Query q= null;
		q=sesion.createQuery("from Usuario u");
	   
		listaUsuarios=q.list();
		
		return listaUsuarios;
	}

}
