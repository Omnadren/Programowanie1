
public class RzymArabTest {
  
	public static void main(String[] args) {
		
		int[] tablica = new int[args.length];
		
		if (args.length == 0) System.out.println("Brak podanych argumentów!");
		
		for (int i = 0; i < args.length; i++){
		
			try { tablica[i] = Integer.parseInt(args[i]);}
			catch (NumberFormatException ex) {
			
				if (RzymArab.rzym2arab(args[i]) != 0)
					System.out.println(args[i]+ " = "+RzymArab.rzym2arab(args[i]));
			}
		}
		for (int i = 0; i < tablica.length; i++){
			
			if (tablica[i] != 0) {
			
				if (tablica[i] > 4000 || tablica[i] < 1) System.out.println(tablica[i]+" nie należy do przedziału 1-3999!");
				else System.out.println(tablica[i]+" = "+ RzymArab.arab2rzym(tablica[i]));
			}
		}
	}
}
