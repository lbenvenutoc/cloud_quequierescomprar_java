package cloud.quierescomprar.model;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="compras")
public class ListaCompra {
	
	private String [] lista;

	public String[] getLista() {
		return lista;
	}

	public void setLista(String[] lista) {
		this.lista = lista;
	}
	
	

}
