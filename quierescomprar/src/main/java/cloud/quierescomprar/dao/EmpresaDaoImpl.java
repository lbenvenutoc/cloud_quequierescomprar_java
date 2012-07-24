package cloud.quierescomprar.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cloud.quierescomprar.model.Empresa;

import cloud.quierescomprar.util.HibernateUtil;

public class EmpresaDaoImpl {

public List<Empresa> listaEmpresa() {
		
		Session sesion = HibernateUtil.getSessionFactory();
		
		
		List<Empresa> listaEmpresa=null;
		Query q= null;
		q=sesion.createQuery("from Empresa");
	    //Date newDate=new Date();
		//q.setDate("fechaActual", newDate);
		listaEmpresa=q.list();
		
		return listaEmpresa;
		
		
	}

	public int registroEmpresa(Empresa objEmpresa) {
		Session sesion = HibernateUtil.getSessionFactory();
		
		int retorno=0;
		Transaction tx = null;
		try {
			tx = sesion.beginTransaction();
			sesion.save(objEmpresa);
		
			tx.commit();
			retorno = 1;
		} catch (Exception ex) {
			tx.rollback();
			System.out.println(ex.toString());
			retorno = 0;
		} finally {
			sesion.close();
		}
		
		return retorno;
		
	}

	
}
