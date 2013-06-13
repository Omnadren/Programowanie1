import java.awt.Color;


public class Ogniwo extends Thread {
  
	private Wyswietlacz m_cwWyswietlacz;
	private int m_nRozmiarM, m_nRozmiarN, m_nSzybkoscDzialaniaK;
	private double m_dPrawdopodobienstwoP;
	
	/**
	 * Konstruktor klasy Ogniwo
	 * 
	 * @param nRozmiarM parametr rozmiaru m
	 * @param nRozmiarN parametr rozmiaru n
	 * @param cwWyswietlacz parametr wyswietlacza
	 * @param dPrawdopP parametr prawdopodobienstwa zmiany koloru
	 * @param nSzybkoscK parametr szybkosci dzialania
	 */
	Ogniwo(int nRozmiarM, int nRozmiarN, Wyswietlacz cwWyswietlacz, double dPrawdopP, int nSzybkoscK ) {
		m_nRozmiarM = nRozmiarM;
		m_nRozmiarN = nRozmiarN;
		m_cwWyswietlacz = cwWyswietlacz;
		m_nSzybkoscDzialaniaK = nSzybkoscK;
		m_dPrawdopodobienstwoP = dPrawdopP;
	}
	
	/**
	 * metoda sterująca ogniwem, zmieniajaca kolor
	 */
	@SuppressWarnings("static-access")
	public void run() {
		while(true) {
			if(m_cwWyswietlacz.m_rLosowanieNumerow.nextDouble() < m_dPrawdopodobienstwoP)
				m_cwWyswietlacz.losujKolor(m_nRozmiarM, m_nRozmiarN); //z prawdopodobieństwem p zmienia kolor na losowy
			else { //z prawdopodobieństwem 1-p sprawdza kolory sąsiadów, liczy średnią i przyjmuje
				Color clrPn = m_cwWyswietlacz.getColor(m_nRozmiarM, m_nRozmiarN - 1);
				Color clrPd = m_cwWyswietlacz.getColor(m_nRozmiarM, m_nRozmiarN + 1);
				Color clrZach = m_cwWyswietlacz.getColor(m_nRozmiarM - 1, m_nRozmiarN);
				Color clrWsch = m_cwWyswietlacz.getColor(m_nRozmiarM + 1, m_nRozmiarN);
				
				int nRed = (clrPn.getRed() + clrPd.getRed() + clrWsch.getRed() + clrZach.getRed()) / 4;
				int nGreen = (clrPn.getGreen() + clrPd.getGreen() + clrWsch.getGreen() + clrZach.getGreen()) / 4;
				int nBlue = (clrPn.getBlue() + clrPd.getBlue() + clrWsch.getBlue() + clrZach.getBlue()) / 4;
				
				m_cwWyswietlacz.setColor(m_nRozmiarM, m_nRozmiarN, nRed, nGreen, nBlue);
			}
			try {
				this.sleep((int)(m_nSzybkoscDzialaniaK * (m_cwWyswietlacz.m_rLosowanieNumerow.nextDouble() + 0.5)));
			} catch (InterruptedException ex) {
			}
		}
	}
}
