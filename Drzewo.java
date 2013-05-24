/**
 * 
 */

/**
 * @author Adam Szerszeń
 *
 */
public class Drzewo<T extends Comparable<T>> {
  private Node<T> root = null;
	
	/**
	 * metoda zwracająca referencję do korzenia drzewa
	 * @return zwracana jest referencja do korzenia drzewa
	 */
	public Node<T> returnRoot() {
		return root;
	}
	
	/**
	 * metoda szukająca węzła w drzewie o danej etykiecie;
	 * @param etykieta parametr, którego wartości etykiety szuka metoda;
	 * @return zwracana jest referencja do odnalezionego węzła
	 * @throws ThreeException gdy nie odnaleziono w drzewie węzła o podanej etykiecie zgłaszany jest wyjątek i komunikat
	 */
	public Node<T> search(T etykieta) throws ThreeException{
		Node<T> aktualny = root;
		while(aktualny != null && !(aktualny.etykieta.equals(etykieta)))
			aktualny = (aktualny.etykieta.compareTo(etykieta) > 0) ? aktualny.lewy : aktualny.prawy;
		if(aktualny == null)
			throw new ThreeException("Nie znaleziono podanego węzła!");
		return aktualny;
	}
	
	/**
	 * metoda dodająca nowy węzeł do drzewa o podanej etykiecie
	 * @param key parametr jest przekazywany jako nazwa etykiety węzła, który jest dodawany do drzewa
	 */
	public void insert(T etykieta) {
		if(root == null)
			root = new Node<T>(etykieta);
		else {
			Node<T> aktualny = root;
			Node<T> rodzic = null;
			while(aktualny != null) {
				rodzic = aktualny;
				aktualny = (aktualny.etykieta.compareTo(etykieta) > 0) ? aktualny.lewy : aktualny.prawy;
			}
			if(rodzic.etykieta.compareTo(etykieta) > 0) {
				rodzic.lewy = new Node<T>(etykieta);
				rodzic.lewy.rodzic = rodzic;
			}
			else {
				rodzic.prawy = new Node<T>(etykieta);
				rodzic.prawy.rodzic = rodzic;
			}
		}
	}
	
	/**
	 * metoda znajdująca maksymalny element w drzewie
	 * @param node węzeł, od którego zaczyna się szukanie
	 * @return zwracana jest referencja do maksymalnego węzła
	 */
	public Node<T> max(Node<T> node) {
		while(node.prawy != null)
			node = node.prawy;
		return node;
	}
	
	/**
	 * metoda wyszukująca następnika dla węzła o podanej etykiecie w drzewie
	 * @param etykieta węzła, którego następnik ma zostać znaleziony
	 * @return zwracana jest referencja do węzła, który jest następnikiem podanego węzła
	 * @throws ThreeException gdy nie odnaleziono następnika, zwracany jest wyjątek i komunikat
	 */
	public Node<T> nastepnik(T etykieta) throws ThreeException {
		Node<T> node = this.search(etykieta);
		//szukanie następnika gdy węzeł pa prawego potomka
		if(node.prawy != null) {
			node = node.prawy;
			while(node.lewy != null)
				node = node.lewy;
			return node;
		}
		//szukanie następnika gdy węzeł nie ma prawego potomka
		else if(node.prawy == null && node != root && node != this.max(root)) {
			Node<T> rodzic = node.rodzic;
			while(rodzic != root && rodzic.etykieta.compareTo(node.etykieta) > 0)
				rodzic = rodzic.rodzic;
			return rodzic;
		}
		else 
			throw new ThreeException("Nie odnaleziono następnika");
	}
	
	/**
	 * metoda która usuwa z drzewa węzeł o podanej etykiecie
	 * @param etykieta, której posiadacz ma zostać usunięty
	 * @return zwracany jest referencja węzła 
	 * @throws ThreeException zgłaszany jest wyjątek gdy została podana zła etykieta
	 */
	public Node<T> delete(T etykieta) throws ThreeException {
		Node<T> node = this.search(etykieta);
		Node<T> rodzic = node.rodzic;
		Node<T> tymczasowy;
		if(node.lewy != null && node.prawy != null) {
			tymczasowy = this.delete(this.nastepnik(etykieta).etykieta);
			tymczasowy.lewy = node.lewy;
			if(tymczasowy.lewy != null)
				tymczasowy.lewy.rodzic = tymczasowy;
			tymczasowy.prawy = node.prawy;
			if(tymczasowy.prawy != null)
				tymczasowy.prawy.rodzic = tymczasowy;
		}
		else
			tymczasowy = (node.lewy != null) ? node.lewy : node.prawy;
		if(tymczasowy != null)
			node.rodzic = rodzic;
		if(rodzic == null)
			root = tymczasowy;
		else if(rodzic.lewy == node)
			rodzic.lewy = tymczasowy;
		else
			rodzic.prawy = tymczasowy;
		return node;
	}
	
	/**
	 * metoda wyświetlająca węzły drzewa jako listę uporządkowanych elementów
	 * @param node węzeł, od którego ma się zacząć wyświetlanie
	 */
	public void listuj(Node<T> node) {
		if(node != null) {
			listuj(node.lewy);
			System.out.print(node.etykieta.toString() + ", ");
			listuj(node.prawy);
			
		}
	}
}
