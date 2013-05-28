
public class LiczbaTest {

  public static void main(String[] args) {
		if(args.length != 2){
			System.out.println("Zła ilość podanych argumentów! Podaj w kolejności dwa argumenty: Liczba Podstawa");
			return;
		}
		Liczba liczba;
		try {
			int n = Integer.parseInt(args[1]); 
			liczba = new Liczba(args[0], n);
		}
		catch (LiczbaException e) {
			System.out.print("Zła podstawa!");
			return;
		}
		catch (LiczbaException2 ex) {
			System.out.print("Zła liczba!");
			return;
		}
		catch (LiczbaException3 ex){
			System.out.print("Liczba jest zbyt wielka!");
			return;
		}
		catch (NumberFormatException e) {
			System.out.print("Zła podstawa!");
			return;
		}
		for (int i = 2; i < 17; i++) {
			try {
				System.out.println(args[0] + " = " + liczba.zapis(i) + " w systemie " + i + "-owym");
			} catch (LiczbaException e) {
				System.out.print("Zła podstawa!");
				return;
			}
		}
		}
}
