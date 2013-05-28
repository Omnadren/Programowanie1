import java.lang.Math;

public class Liczba {
  
	private int naturalna, n_przechowywana;
	public String string;
	
	Liczba(String n, int podstawa) throws LiczbaException, LiczbaException2, LiczbaException3 {
		if ((podstawa < 2) || (podstawa > 16)) throw new LiczbaException();
		if (n.length() > 9) throw new LiczbaException3();
		
		char[] tablica_char = new char[n.length()];
		int[] tablica_int = new int[n.length()];
		int pozycja = 0;
		tablica_char = n.toCharArray();
		for (int i = 0; i < tablica_int.length; i++){
			switch(tablica_char[i]) {
			case '0': tablica_int[i] = 0;break;
			case '1': tablica_int[i] = 1;break;
			case '2': tablica_int[i] = 2;break;
			case '3': tablica_int[i] = 3;break;
			case '4': tablica_int[i] = 4;break;
			case '5': tablica_int[i] = 5;break;
			case '6': tablica_int[i] = 6;break;
			case '7': tablica_int[i] = 7;break;
			case '8': tablica_int[i] = 8;break;
			case '9': tablica_int[i] = 9;break;
			case 'A': tablica_int[i] = 10;break;
			case 'B': tablica_int[i] = 11;break;
			case 'C': tablica_int[i] = 12;break;
			case 'D': tablica_int[i] = 13;break;
			case 'E': tablica_int[i] = 14;break;
			case 'F': tablica_int[i] = 15;break;
			default : throw new LiczbaException2();
			}
		}
		for (int j = (tablica_int.length - 1); j >= 0; j--) {
			naturalna = (naturalna + (tablica_int[pozycja] * (int)Math.pow(podstawa, j)));
			pozycja ++;
		}
		n_przechowywana = naturalna;
	}
	public String zapis(int podstawa) throws LiczbaException {
		if ((podstawa < 2) || (podstawa > 16)) throw new LiczbaException();
		string = "";
		naturalna = n_przechowywana;
		if (podstawa < 11) {
			while ((naturalna / podstawa) > 0){
				string = Integer.toString(naturalna % podstawa) + string;
				naturalna = naturalna / podstawa;
			}
			if ((naturalna / podstawa) == 0) string = Integer.toString(naturalna) + string;
			return string;
		}
		else {
			while ((naturalna / podstawa) > 0){
				if ((naturalna % podstawa) <10) {
					string = Integer.toString(naturalna % podstawa) + string;
					naturalna = naturalna / podstawa;
				}
				else {
					switch (naturalna % podstawa) {
					case 10: string = "A" + string;	naturalna = naturalna / podstawa;break;
					case 11: string = "B" + string;	naturalna = naturalna / podstawa;break;
					case 12: string = "C" + string;	naturalna = naturalna / podstawa;break;
					case 13: string = "D" + string;	naturalna = naturalna / podstawa;break;
					case 14: string = "E" + string;	naturalna = naturalna / podstawa;break;
					case 15: string = "F" + string; naturalna = naturalna / podstawa;break;
					}
				}
			}
			if ((naturalna / podstawa) == 0) {
				if (naturalna % podstawa < 10) string = Integer.toString(naturalna) + string;
				else {
					switch (naturalna % podstawa) {
					case 10: string = "A" + string;break;
					case 11: string = "B" + string;break;
					case 12: string = "C" + string;break;
					case 13: string = "D" + string;break;
					case 14: string = "E" + string;break;
					case 15: string = "F" + string;break;
					}
				}
			}
			return string;
		}
	}
}
