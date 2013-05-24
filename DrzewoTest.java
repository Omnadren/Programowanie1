/**
 * 
 */

/**
 * @author Adam Szerszeń
 * klasa testująca drzewo binarne
 */
public class DrzewoTest {

  /**
	 * @param args
	 */
	public static void main(String[] args) {
		Drzewo<String> drzewo = new Drzewo<String>();
		System.out.println("Stworzono nowe drzewo");
		
		//dodawanie elementów
		drzewo.insert("Adam");
		drzewo.insert("Alicja");
		drzewo.insert("Anatol");
		drzewo.insert("Anna");
		
		//wyświetlanie elementów drzewa
		drzewo.listuj(drzewo.returnRoot());
		System.out.println(" ");
		
		//usuwanie elementów drzewa
		try {
			drzewo.delete("Adam");
			drzewo.delete("Karol");
		} catch (ThreeException e) {
			System.out.println(e.getMessage());
		}
		drzewo.listuj(drzewo.returnRoot());
	}

}
