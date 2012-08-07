package cloud.quierescomprar.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cloud.quierescomprar.model.Oferta;
import cloud.quierescomprar.model.OfertaId;
import cloud.quierescomprar.model.OfertaVenta;
import cloud.quierescomprar.model.OfertaVentaId;
import cloud.quierescomprar.model.Usuario;
import cloud.quierescomprar.model.UsuarioId;
import cloud.quierescomprar.util.HibernateUtil;

public class OfertaDaoImp implements OfertaDao {

	public  String[] listaOfertasDelDia() {
		
	Session sesion = HibernateUtil.getSessionFactory();
		
		
		List<Oferta> listaOfertas=null;
		Query q= null;
		q=sesion.createQuery("from Oferta o join fetch o.empresa e where :fechaActual between o.fechaInicio and o.fechaFin");
	    Date newDate=new Date();
		q.setDate("fechaActual", newDate);
		
		listaOfertas=q.list();
		
		String[] listaOfertasString=new String[listaOfertas.size()] ;
		int i=0;
		for(Oferta objOferta:listaOfertas){
			listaOfertasString[i]=
			objOferta.getEmpresa().getRuc()+"-"+objOferta.getEmpresa().getRazonSocial()+"#"
					+objOferta.getDescripcion()+"#"
					+objOferta.getPrecio()+"#"
					+objOferta.getDescuento()+"#"
					+(objOferta.getPrecio().doubleValue()-objOferta.getPrecio().doubleValue()*objOferta.getDescuento().doubleValue()+"#"
							+objOferta.getFechaFin()+"#"
							+objOferta.getDetalle()+"#"
							+objOferta.getUrlImagen());
			i++;
			
		}
		
		return listaOfertasString;
		
	}

	public int registroOfertaVenta(int codEmpresa, String codOferta,
			int codLinea, String email, String codMedioPago) {
		Session sesion = HibernateUtil.getSessionFactory();

		int retorno = 0;
		Transaction tx = null;
		try {
			tx = sesion.beginTransaction();

			OfertaVenta objOfertaVenta = new OfertaVenta();
			objOfertaVenta.setId(new OfertaVentaId(codOferta, (short) codLinea,
					email, (short) codEmpresa));
			objOfertaVenta.setOferta(new Oferta(new OfertaId(
					(short) codEmpresa, codOferta), null, null, null, null,
					null, null));
			objOfertaVenta.setUsuario(new Usuario(new UsuarioId(
					(short) codEmpresa, email), null, null, null, null, null,
					null, null, null, null));
			objOfertaVenta.setCodMedioPago(codMedioPago);
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

	// Código Kid Rivera

	public String[] listaOfertasPorVencer(int dias) {
		Session sesion = HibernateUtil.getSessionFactory();

		List<Oferta> listaOfertasPorVencer = null;
		Query q = null;
		q = sesion
				.createQuery("from Oferta o join fetch o.empresa e where datediff(o.fechaFin,:fechaActual)=:dias");
		Date newDate = new Date();
		q.setDate("fechaActual", newDate);
		q.setInteger("dias", dias);
		listaOfertasPorVencer = q.list();

		String[] listaOfertasPorVencerString=new String[listaOfertasPorVencer.size()] ;
		int i=0;
		for(Oferta objOferta:listaOfertasPorVencer){
			listaOfertasPorVencerString[i]=
			objOferta.getEmpresa().getRuc()+"-"+objOferta.getEmpresa().getRazonSocial()+"#"
					+objOferta.getDescripcion()+"#"
					+objOferta.getPrecio()+"#"
					+objOferta.getDescuento()+"#"
					+(objOferta.getPrecio().doubleValue()-objOferta.getPrecio().doubleValue()*objOferta.getDescuento().doubleValue()+"#"
							+objOferta.getFechaFin()+"#"
							+objOferta.getDetalle()+"#"
							+objOferta.getUrlImagen());
			i++;
			
		}
		
		return listaOfertasPorVencerString;
		
	}

	/*
	 * private List<Oferta> ofertas;
	 * 
	 * public OfertaDaoImp() { this.ofertas = getOfertasPorVencer(); }
	 * 
	 * private List<Oferta> getOfertasPorVencer() { List<Oferta>
	 * OfertasPorVencer = new ArrayList<Oferta>();
	 * 
	 * Empresa empresa1 = new Empresa(); short emp1 = 1;
	 * empresa1.setCEmpresa(emp1); empresa1.setRazonSocial("Stav");
	 * empresa1.setRuc("10107999596");
	 * 
	 * 
	 * Oferta ofertas1 = new Oferta(); ofertas1.setEmpresa(empresa1);
	 * ofertas1.setDescripcion(
	 * "S/. 29.90 en vez de S/. 59.90 por 1 Pollo horneado para 4 personas + Yucas + Papas fritas + Papas sancochadas + Arepas + Salsas + 1 Ensalada Col Stav + 1 Jarra de Chicha en STAV Pollo horneado"
	 * ); ofertas1.setDestacado(
	 * "La oferta incluye: 1 Pollo Horneado para 4 personas + Yucas + Papas fritas + Papas sancochadas + Arepas + Salsas + 1 Ensalada Col Stav + 1 Jarra de Chicha. Disfruta con tres personas más de este sabroso pollo horneado bien dorado y jugoso"
	 * ); ofertas1.setDebeSaber(
	 * "Podrás usar este cupón hasta el 30 de agosto de 2012. 1 OferTOP para 4 personas, regala todos los que quieras. 1 OferTOP por mesa. Horario de atención: de lunes a domingo de 12 m. a 8 p.m."
	 * );
	 * 
	 * DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z"); Date
	 * inicio = dfm.parse("2012-07-21 08:00:00 -0500"); Date fin =
	 * dfm.parse("2012-07-21 18:00:00 -0500");
	 * 
	 * ofertas1.setFechaInicio(inicio); ofertas1.setFechaFin(fin); decimal
	 * precio = 29.00; ofertas1.setPrecio(precio); ofertas1.setDescuento =
	 * 20.00;
	 * 
	 * Oferta ofertas2 = new Oferta(); ofertas2.setEmpresa(empresa1);
	 * ofertas2.setDescripcion(
	 * "¡TODO INCLUIDO! Paga S/. 145 en OferTOP y obtén S/. 545 de descuento en la compra de 2 boletos aéreos Lima-Tumbes-Lima + 3 noches en el Hotel Royal Decameron Punta Sal para 2 + Sistema Todo Incluido"
	 * ); ofertas2.setDestacado(
	 * "Una vez que tengas tu cupón, llama a NUEVO MUNDO VIAJES y solicita tu descuento: OPCIÓN 1: Viaja del 29 de julio al 1 de agosto Presenta este cupón de descuento en Nuevo Mundo Viajes hasta el 25 de julio y paga S/. 3,131 en vez de S/. 3,676 por 2 boletos aéreos Lima-Tumbes-Lima + traslados + 3 noches en el Hotel Royal Decameron Punta Sal para 2 + Sistema Todo incluido."
	 * ); ofertas2.setDebeSaber(
	 * "Oferta válida para viajar según la opción que elijas. OPCIÓN 1: Del 29 de julio al 1 de agosto / OPCIÓN 2: Del 1 al 4 de agosto."
	 * );
	 * 
	 * Oferta ofertas3 = new Oferta(); ofertas3.setEmpresa(empresa1);
	 * ofertas3.setDescripcion(
	 * "Paga S/. 158 en OferTOP y obtén un descuento de S/. 864 por 2 boletos aéreos a Lima-Mendoza-Lima + Traslados + 3 noches en Huantala Hotel 4* + Visita a bodegas con NUEVO MUNDO VIAJES"
	 * ); ofertas3.setDestacado(
	 * "Una vez que tengas tu cupón, llama a NUEVO MUNDO VIAJES y solicita tu descuento: pagarás S/. 3,932.60 en vez de S/. 4,638.60 por 2 boletos aéreos Lima-Santiago-Mendoza-Santiago-Lima + traslados + 3 noches en Huantala Hotel Boutique 4* + visita a bodegas."
	 * ); ofertas3.setDebeSaber(
	 * "Oferta válida para viajar del 01 al 30 de setiembre de 2012, fecha para culminar el viaje. La oferta debe comprarse hasta el 25 de julio y canjearse hasta el 27 de julio de 2012."
	 * );
	 * 
	 * 
	 * OfertasPorVencer.add(ofertas1); OfertasPorVencer.add(ofertas2);
	 * OfertasPorVencer.add(ofertas3);
	 * 
	 * return OfertasPorVencer; }
	 */

}
