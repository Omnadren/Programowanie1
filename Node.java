/**
 * 
 */

/**
 * @author Adam Szerszeń
 * klasa węzeł, która jest używana jako struktura
 */
public class Node<T extends Comparable<T>> {
  final T etykieta;
	Node<T> lewy, prawy, rodzic = null;
	Node (T etykieta) {
		this.etykieta = etykieta;
	}
	
	/**
	 * metoda zwracająca etykietę węzła
	 * @return zwraca referencję etykiety typu String
	 */
	public String zwrocEtykiete() {
		return etykieta.toString();
	}
}
