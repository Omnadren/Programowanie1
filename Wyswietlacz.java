import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Wyswietlacz extends JApplet {

  public Random m_rLosowanieNumerow;
	public JPanel m_panelPanel;
	private JLabel[][] m_lblEtykieta;
	private Ogniwo[][] m_cOgniwo;
	int m_nRozmiarM, m_nRozmiarN;
	
	/**
	 * metoda ustawiająca kolor w danym miejscu etykiety
	 * @param nX parametr polozenia x
	 * @param nY parametr polozenia y
	 * @param nR parametr R koloru RGB 
	 * @param nG parametr G koloru RGB
	 * @param nB parametr B koloru RGB
	 */
	public synchronized void setColor(int nX, int nY, int nR, int nG, int nB) {
		
		if(nX > m_nRozmiarM || nY > m_nRozmiarN) return;
		
		if(m_lblEtykieta[nX][nY] == null) {
			System.out.println("Etykieta jest pusta!");
			return;
		}
		
		synchronized (m_lblEtykieta[nX][nY]) {
			m_lblEtykieta[nX][nY].setBackground(new Color(nR, nG, nB));
		}
	}
	
	/**
	 * metoda generująca losowe kolory
	 * @param nX parametr polozenia x
	 * @param nY parametr polozenia y
	 */
	public void losujKolor(int nX, int nY) {
		setColor(nX, nY, m_rLosowanieNumerow.nextInt(255), m_rLosowanieNumerow.nextInt(255), m_rLosowanieNumerow.nextInt(255));
	}
	
	/**
	 * metoda pobierająca kolor z elementu etykiety
	 * @param nX
	 * @param nY
	 * @return zwracana jest referencja obiektu Color
	 */
	public Color getColor(int nX, int nY) {
		Color clrKolor;
		if(nX >= m_nRozmiarM) 
			nX = 0;
		else if (nX < 0) 
			nX = m_nRozmiarM -1;
		if (nY >= m_nRozmiarN)
			nY = 0;
		else if (nY < 0)
			nY = m_nRozmiarN - 1;
		synchronized (m_lblEtykieta[nX][nY]) {
			clrKolor = m_lblEtykieta[nX][nY].getBackground();
		}
		return clrKolor;
	}
	
	public void Wyswietlacz2() {
		int nRozmiarM = 10;
		int nRozmiarN = 10;
		int nSzybkoscDzialaniaK = 200;
		double dPrawdopodobienstwoP = 0.4;
		nRozmiarM = Integer.parseInt(getParameter("m_nRozmiarM"));
		nRozmiarN = Integer.parseInt(getParameter("m_nRozmiarN"));
		 m_lblEtykieta = new JLabel[nRozmiarM][nRozmiarN];
		 m_cOgniwo = new Ogniwo[nRozmiarM][nRozmiarN];
		 dPrawdopodobienstwoP = Double.parseDouble(getParameter("m_dPrawdopodobienstowP"));
		 nSzybkoscDzialaniaK = Integer.parseInt(getParameter("m_nSzybkoscDzialaniaK"));
		 
		 for(int i = 0; i < nRozmiarM; ++i) {
			 for (int j = 0; j < nRozmiarN; ++j) {
				 m_lblEtykieta[i][j] = new JLabel(i + ", " + j);
				 m_cOgniwo[i][j] = new Ogniwo(i, j, this, dPrawdopodobienstwoP, nSzybkoscDzialaniaK);
			 }
		 }
		 
		 inicjujWyswietlacz(nRozmiarM, nRozmiarN);
		 for(int i = 0; i < nRozmiarM; ++i) {
			 for(int j = 0; j < nRozmiarN; ++j) {
				 m_cOgniwo[i][j].start();
			 }
		 }
	}
	
	/**
	 * Metoda tworząca ramkę ogniw 
	 * @param nRozmiarM szerokość ramki
	 * @param nRozmiarN wysokość ramki
	 * @param dPrawdopodobienstwoP prawdopodobieństwo zmiany
	 * @param nSzybkoscDzialaniaK szybkość działania
	 */
	public void Wyswietlacz3(int nRozmiarM, int nRozmiarN, double dPrawdopodobienstwoP, int nSzybkoscDzialaniaK) {
		m_lblEtykieta = new JLabel[nRozmiarM][nRozmiarN];
		m_cOgniwo = new Ogniwo[nRozmiarM][nRozmiarN];
		
		for (int i = 0; i < nRozmiarM; ++i) {
			for (int j = 0; j < nRozmiarN; ++j) {
				m_lblEtykieta[i][j] = new JLabel(i + ", " + j);
				m_cOgniwo[i][j] = new Ogniwo(i, j, this, dPrawdopodobienstwoP, nSzybkoscDzialaniaK);
			}
		}
		
		inicjujWyswietlacz(nRozmiarM, nRozmiarN);
		for (int i = 0; i < nRozmiarM; ++i) {
			for (int j = 0; j < nRozmiarN; ++j) {
				m_cOgniwo[i][j].start();
			}
		}
	}
	
	public void Wyswietlacz() {}
	
	/**
	 * metoda inicjująca wyświetlacz
	 * @param nX szerokość 
	 * @param nY wysokość
	 */
	public void inicjujWyswietlacz(int nX, int nY) {
		m_panelPanel = new JPanel();
		m_nRozmiarM = nX; 
		m_nRozmiarN = nY;
		m_panelPanel.setLayout(new GridLayout(m_nRozmiarM, m_nRozmiarN));
		m_rLosowanieNumerow = new Random();
		for (int i = 0; i < nX; ++i) {
			for (int j = 0; j < nY; ++j) {
				m_lblEtykieta[i][j].setOpaque(true);
				m_lblEtykieta[i][j].setBackground(new Color(m_rLosowanieNumerow.nextInt(255),
															m_rLosowanieNumerow.nextInt(255),
															m_rLosowanieNumerow.nextInt(255)));
				m_panelPanel.add(m_lblEtykieta[i][j]);
			}
		}
		add(m_panelPanel);
	}
	
	public void inicjuj() {
		if (null == getParameter("nRozmiarM")) System.out.print("HERE");
		this.Wyswietlacz2();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int nRozmiarM = 10, nRozmiarN = 10, nSzybkoscK = 150;
		double dPrawdopP = 0.1;
		
		if(args.length != 4) {
			System.out.println("Zla liczba argumentow!");
			return;
		}
		try {
			nRozmiarM = Integer.parseInt(args[0]);
			nRozmiarN = Integer.parseInt(args[1]);
			dPrawdopP = Double.parseDouble(args[2]);
			nSzybkoscK = Integer.parseInt(args[3]);
		} catch (NumberFormatException e) {
			System.out.println("Zly argument!");
			return;
		}
		
		Wyswietlacz cwWyswietlacz = new Wyswietlacz();
		cwWyswietlacz.Wyswietlacz3(nRozmiarM, nRozmiarN, dPrawdopP, nSzybkoscK);
		JFrame frameRamka = new JFrame();
		frameRamka.add(cwWyswietlacz.m_panelPanel);
		frameRamka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameRamka.setVisible(true);
	}

}
