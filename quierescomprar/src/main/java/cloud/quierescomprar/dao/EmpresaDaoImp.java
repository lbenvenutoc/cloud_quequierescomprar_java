package cloud.quierescomprar.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cloud.quierescomprar.model.Empresa;
import cloud.quierescomprar.util.HibernateUtil;

public class EmpresaDaoImp implements EmpresaDao{

	public Empresa obtenerEmpresa(Empresa objEmpresa) {
		
		Session sesion=HibernateUtil.getSessionFactory();
		Empresa objEmpresaObt=null;
		try{
			Query q= null;
			q= sesion.createQuery("from Empresa e");
			q.setParameter("cod", objEmpresa.getCEmpresa());
			objEmpresaObt=(Empresa)q.uniqueResult();
		}catch (Exception ex) {
			System.out.println(ex);
		}finally {
			sesion.close();
		}
	
		return objEmpresaObt;
	}

		public Empresa obtenerEmpresaxRuc(Empresa objEmpresa) {
		Session sesion=HibernateUtil.getSessionFactory();
		Empresa objEmpresaObt=null;
		try{
			Query q= null;
			q= sesion.createQuery("from Empresa where ruc=:ruc");
			q.setParameter("ruc", objEmpresa.getRuc());
			objEmpresaObt=(Empresa)q.uniqueResult();
		}catch (Exception ex) {
			System.out.println(ex);
		}finally {
			sesion.close();
		}
	
		return objEmpresaObt;
	}
		public int registrarEmpresa(Empresa objEmpresa) {
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
		
		public List<Empresa> listaEmpresas() {
			
			Session sesion = HibernateUtil.getSessionFactory();
			
			List<Empresa> listaEmpresas=null;
			Query q= null;
			q=sesion.createQuery("from Empresa e");
			listaEmpresas=q.list();
			
			return listaEmpresas;
			
		}
			
			
	public Empresa ObtenerEmpresa(Empresa objEmpresa) {
		// TODO Auto-generated method stub
		return null;
	}

	public Empresa ObtenerEmpresaxRuc(Empresa objEmpresa) {
		// TODO Auto-generated method stub
		return null;
	}


}

