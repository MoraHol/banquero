
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexis holguin
 */
public class Disponibles {

	List<Integer> recursos;

	public Disponibles() {
		recursos = new ArrayList<Integer>();
	}

	public List<Integer> getDisponibles() {
		return recursos;
	}

	public void setDisponible(int valor, int indice) {
		recursos.set(indice, valor);
	}

}