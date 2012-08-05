package cloud.quierescomprar.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cloud.quierescomprar.model.OfertaVenta;
import cloud.quierescomprar.util.HibernateUtil;

public class CompraDaoImp implements CompraDao {

	public String[] listaComprasPorEmpresa(int codEmpresa, String emailUsuario) {

		Session sesion = HibernateUtil.getSessionFactory();

		List<OfertaVenta> listaCompras = null;
		Query q = null;
		q = sesion
				.createQuery("from OfertaVenta c join fetch c.oferta o where c.usuario.id.email=:email and c.id.CEmpresa=:codEmpresa");
		Date newDate = new Date();
		q.setString("email", emailUsuario);
		q.setBigDecimal("codEmpresa", new BigDecimal(codEmpresa));

		listaCompras = q.list();

		String[] listaComprasString = new String[listaCompras.size()];
		int i = 0;
		for (OfertaVenta objCompra : listaCompras) {
			listaComprasString[i] = objCompra.getOferta().getDescripcion()
					
					+ "#"
					+ objCompra.getOferta().getPrecio()
					+ "#"
					+ objCompra.getOferta().getDescuento()
					+ "#"
					+ objCompra.desMedioPago();
			i++;

		}

		return listaComprasString;

	}

}
