
public class RzymArab {
  
	public static String arab2rzym (int arab) {
		
		String rzym = "";
		
		while(arab != 0) {
		
			if (arab >= 1000) {
			
				rzym = rzym + "M";
				arab -= 1000;
			}
			else if (arab >= 900) {
				
				rzym = rzym + "CM";
				arab = arab - 900;
			}
			else if (arab >= 500) {
				
				rzym = rzym + "D";
				arab = arab - 500;
			}
			else if (arab >= 400) {
				
				rzym = rzym + "CD";
				arab = arab - 400;
			}
			else if (arab >= 100) {
				
				rzym = rzym + "C";
				arab = arab - 100;
			}
			else if (arab >= 90) {
				
				rzym = rzym + "XC";
				arab = arab - 90;
			}
			else if (arab >= 50) {
				
				rzym = rzym + "L";
				arab = arab - 50;
			}
			else if (arab >= 40) {
				
				rzym = rzym + "XL";
				arab = arab - 40;
			}
			else if (arab >= 10) {
				
				rzym = rzym + "X";
				arab = arab - 10;
			}
			else if (arab >= 9) {
				
				rzym = rzym + "IX";
				arab = arab - 9;
			}
			else if (arab >= 5) {
				
				rzym = rzym + "V";
				arab = arab - 5;
			}
			else if (arab >= 4) {
				
				rzym = rzym + "IV";
				arab = arab - 4;
			}
			else if (arab >= 1) {
				
				rzym = rzym + "I";
				arab = arab - 1;
			}
		}
		return rzym;
	}
	public static int rzym2arab (String rzym) {
		
		int arab = 0;
		
		while (!(rzym.isEmpty())) {
		
			if (rzym.startsWith("M")) {
			
				arab = arab + 1000;
				rzym = rzym.substring(1);
			}
			else if (rzym.startsWith("CM")) {
				
				arab = arab + 900;
				rzym = rzym.substring(2);
			}
			else if (rzym.startsWith("D")) {
				
				arab = arab + 500;
				rzym = rzym.substring(1);
			}
			else if (rzym.startsWith("CD")) {
				
				arab = arab + 400;
				rzym = rzym.substring(2);
			}
			else if (rzym.startsWith("C")) {
				
				arab = arab + 100;
				rzym = rzym.substring(1);
			}
			else if (rzym.startsWith("XC")) {
				
				arab = arab + 90;
				rzym = rzym.substring(2);
			}
			else if (rzym.startsWith("L")) {
				
				arab = arab + 50;
				rzym = rzym.substring(1);
			}
			else if (rzym.startsWith("XL")) {
				
				arab = arab + 40;
				rzym = rzym.substring(2);
			}
			else if (rzym.startsWith("X")) {
				
				arab = arab + 10;
				rzym = rzym.substring(1);
			}
			else if (rzym.startsWith("IX")) {
				
				arab = arab + 9;
				rzym = rzym.substring(2);
			}
			else if (rzym.startsWith("V")) {
				
				arab = arab + 5;
				rzym = rzym.substring(1);
			}
			else if (rzym.startsWith("IV")) {
				
				arab = arab + 4;
				rzym = rzym.substring(2);
			}
			else if (rzym.startsWith("I")) {
				
				arab = arab + 1;
				rzym = rzym.substring(1);
			}
			else {
				
				System.out.println(rzym+" = Zła dana!");
				rzym = "";
			}
		}
		return arab;
	}
}
