package cloud.quierescomprar.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;

import cloud.quierescomprar.model.Oferta;

import cloud.quierescomprar.util.HibernateUtil;




public class OfertaDaoImp implements OfertaDao{

		
	
	public List<Oferta> listaOfertas() {
		
		Session sesion = HibernateUtil.getSessionFactory();
		
		
		List<Oferta> listaOfertas=null;
		Query q= null;
		q=sesion.createQuery("from Oferta o join fetch o.empresa e where :fechaActual between o.fechaInicio and o.fechaFin");
	    Date newDate=new Date();
		q.setDate("fechaActual", newDate);
		listaOfertas=q.list();
		
		return listaOfertas;
		
		
	}

	
	

	
	
	
	
}
