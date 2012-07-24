package cloud.quierescomprar.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import org.hibernate.Session;

import cloud.quierescomprar.model.Empresa;
import cloud.quierescomprar.model.Oferta;
import cloud.quierescomprar.model.OfertaVenta;

import cloud.quierescomprar.service.OfertaService;
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

	public int registroOfertaVenta(OfertaVenta objOfertaVenta) {
		Session sesion = HibernateUtil.getSessionFactory();
		
		int retorno=0;
		Transaction tx = null;
		try {
			tx = sesion.beginTransaction();
			sesion.save(objOfertaVenta);
		
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

	public List<Oferta> listaOfertasTotal() {
		Session sesion = HibernateUtil.getSessionFactory();
		
		
		List<Oferta> listaOfertas=null;
		Query q= null;
		q=sesion.createQuery("from Oferta o join fetch o.empresa e");
	   
		listaOfertas=q.list();
		
		return listaOfertas;
	}

	
// Codigo Kid Rivera

	private List<Oferta> ofertas;
	
	public OfertaDaoImp()
		{
			this.ofertas = getOfertasPorVencer();
		}
	
	private List<Oferta> getOfertasPorVencer()
	{
		List<Oferta> OfertasPorVencer = new ArrayList<Oferta>();
		
		Empresa empresa1 = new Empresa();
		short emp1 = 1;
		empresa1.setCEmpresa(emp1);
		empresa1.setRazonSocial("Stav");
		empresa1.setRuc("10107999596");
		
		
        Oferta ofertas1 = new Oferta();
        ofertas1.setEmpresa(empresa1);
        ofertas1.setDescripcion("S/. 29.90 en vez de S/. 59.90 por 1 Pollo horneado para 4 personas + Yucas + Papas fritas + Papas sancochadas + Arepas + Salsas + 1 Ensalada Col Stav + 1 Jarra de Chicha en STAV Pollo horneado");
        ofertas1.setDestacado("La oferta incluye: 1 Pollo Horneado para 4 personas + Yucas + Papas fritas + Papas sancochadas + Arepas + Salsas + 1 Ensalada Col Stav + 1 Jarra de Chicha. Disfruta con tres personas más de este sabroso pollo horneado bien dorado y jugoso");
        ofertas1.setDebeSaber("Podrás usar este cupón hasta el 30 de agosto de 2012. 1 OferTOP para 4 personas, regala todos los que quieras. 1 OferTOP por mesa. Horario de atención: de lunes a domingo de 12 m. a 8 p.m.");
     /*  ofertas1.setFechaInicio(07,21,2012,00,00,00);
        ofertas1.setFechaFin("2012/07/26 00:00:00");
        ofertas1.setPrecio(29);
        ofertas1.setDescuento(20);
       */ 
        Oferta ofertas2 = new Oferta();
        ofertas2.setEmpresa(empresa1);
        ofertas2.setDescripcion("¡TODO INCLUIDO! Paga S/. 145 en OferTOP y obtén S/. 545 de descuento en la compra de 2 boletos aéreos Lima-Tumbes-Lima + 3 noches en el Hotel Royal Decameron Punta Sal para 2 + Sistema Todo Incluido");
        ofertas2.setDestacado("Una vez que tengas tu cupón, llama a NUEVO MUNDO VIAJES y solicita tu descuento: OPCIÓN 1: Viaja del 29 de julio al 1 de agosto Presenta este cupón de descuento en Nuevo Mundo Viajes hasta el 25 de julio y paga S/. 3,131 en vez de S/. 3,676 por 2 boletos aéreos Lima-Tumbes-Lima + traslados + 3 noches en el Hotel Royal Decameron Punta Sal para 2 + Sistema Todo incluido.");
        ofertas2.setDebeSaber("Oferta válida para viajar según la opción que elijas. OPCIÓN 1: Del 29 de julio al 1 de agosto / OPCIÓN 2: Del 1 al 4 de agosto.");
        
        Oferta ofertas3 = new Oferta();
        ofertas3.setEmpresa(empresa1);
        ofertas3.setDescripcion("Paga S/. 158 en OferTOP y obtén un descuento de S/. 864 por 2 boletos aéreos a Lima-Mendoza-Lima + Traslados + 3 noches en Huantala Hotel 4* + Visita a bodegas con NUEVO MUNDO VIAJES");
        ofertas3.setDestacado("Una vez que tengas tu cupón, llama a NUEVO MUNDO VIAJES y solicita tu descuento: pagarás S/. 3,932.60 en vez de S/. 4,638.60 por 2 boletos aéreos Lima-Santiago-Mendoza-Santiago-Lima + traslados + 3 noches en Huantala Hotel Boutique 4* + visita a bodegas.");
        ofertas3.setDebeSaber("Oferta válida para viajar del 01 al 30 de setiembre de 2012, fecha para culminar el viaje. La oferta debe comprarse hasta el 25 de julio y canjearse hasta el 27 de julio de 2012.");
        
               
        OfertasPorVencer.add(ofertas1);
        OfertasPorVencer.add(ofertas2);
        OfertasPorVencer.add(ofertas3);
        
		return OfertasPorVencer;
	}
	
	
	
	
		
	
}
