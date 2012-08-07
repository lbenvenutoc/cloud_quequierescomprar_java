package cloud.quierescomprar.dao;

import java.util.List;

import cloud.quierescomprar.model.Oferta;
import cloud.quierescomprar.model.OfertaVenta;




public interface OfertaDao {
	
	
	
	public String[] listaOfertasDelDia();
	public int registroOfertaVenta(int codEmpresa,String codOferta,int codLinea,String email,String codMedioPago);
	
	
	
// Codigo Kid Rivera
	
	public String[] listaOfertasPorVencer(int dias);
	//public List<OfertaVenta> ListaOfertasMasVendidas();
	
}
