#include "Liczba.h"

Liczba::Liczba(void) {
  m_nLiczbaDziesietna = 0;
	m_vsVektorZapisu.reserve(17);
}

Liczba::Liczba(int nLiczbaDziesietna) {
	m_nLiczbaDziesietna = nLiczbaDziesietna;
	m_vsVektorZapisu.reserve(17);
}

Liczba::Liczba(string sZapisRoboczy, int nPodstawaRobocza) {
	m_sZapisRoboczy = sZapisRoboczy;
	m_nPodstawaRobocza = nPodstawaRobocza;
	m_vsVektorZapisu.reserve(17);
}

void Liczba::ustawDoDziesiatej(void) {
	if(m_nLiczbaDziesietna = 10) return;
	vector<char> vcVectorCharRoboczy;
	vector<int> vnVectorIntRoboczy;
	int nLiczbaDziesietna = 0;
	vcVectorCharRoboczy.reserve(m_sZapisRoboczy.length());
	vnVectorIntRoboczy.reserve(m_sZapisRoboczy.length());
	int nPozycja = 0;
	for (int i = 0; i < (int) m_sZapisRoboczy.length(); i++)
		vcVectorCharRoboczy.push_back(m_sZapisRoboczy[i]);
	for (int i = 0; i < (int) m_sZapisRoboczy.length(); i++) {
		switch (vcVectorCharRoboczy[i]) {
		case'0': vnVectorIntRoboczy.push_back(0);break;
		case'1': vnVectorIntRoboczy.push_back(1);break;
		case'2': vnVectorIntRoboczy.push_back(2);break;
		case'3': vnVectorIntRoboczy.push_back(3);break;
		case'4': vnVectorIntRoboczy.push_back(4);break;
		case'5': vnVectorIntRoboczy.push_back(5);break;
		case'6': vnVectorIntRoboczy.push_back(6);break;
		case'7': vnVectorIntRoboczy.push_back(7);break;
		case'8': vnVectorIntRoboczy.push_back(8);break;
		case'9': vnVectorIntRoboczy.push_back(9);break;
		case'A': vnVectorIntRoboczy.push_back(10);break;
		case'B': vnVectorIntRoboczy.push_back(11);break;
		case'C': vnVectorIntRoboczy.push_back(12);break;
		case'D': vnVectorIntRoboczy.push_back(13);break;
		case'E': vnVectorIntRoboczy.push_back(14);break;
		case'F': vnVectorIntRoboczy.push_back(15);break;
		default:;
		}
	}
	for (int j = (vnVectorIntRoboczy.size() - 1); j >= 0; j--) {
		nLiczbaDziesietna = (nLiczbaDziesietna + (vnVectorIntRoboczy[nPozycja] * (int) pow(m_nPodstawaRobocza, j)));
		nPozycja ++;
	}
	m_nLiczbaDziesietna = nLiczbaDziesietna;
}

void Liczba::ustawZapisLiczby(void) {
	string sZapisRoboczy;
	ostringstream ss, ss2;
	int nPodstawa;
	m_vsVektorZapisu.push_back("brak zapisu");
	m_vsVektorZapisu.push_back("brak zapisu");
	for(int i = 2; i < 17; i++) {
		sZapisRoboczy = "";
		nPodstawa = i;
		int nLiczbaDziesietna = m_nLiczbaDziesietna;
		if (nPodstawa < 11) {
			while ((nLiczbaDziesietna / nPodstawa) > 0) {
				ss << (nLiczbaDziesietna % nPodstawa);
				sZapisRoboczy = ss.str() + sZapisRoboczy;
				nLiczbaDziesietna /= nPodstawa;
			}
			ss2 << nLiczbaDziesietna;
			if ((nLiczbaDziesietna / nPodstawa) == 0)
				sZapisRoboczy = ss2.str() + sZapisRoboczy;
			m_vsVektorZapisu.push_back(sZapisRoboczy);
		} else {
			while ((nLiczbaDziesietna / nPodstawa) > 0) {
				if ((nLiczbaDziesietna % nPodstawa) < 10) {
					ss << nLiczbaDziesietna % nPodstawa;
					sZapisRoboczy = ss.str() + sZapisRoboczy;
					nLiczbaDziesietna /= nPodstawa;
				} else {
					switch (nLiczbaDziesietna % nPodstawa) {
					case 10: sZapisRoboczy = "A" + sZapisRoboczy; nLiczbaDziesietna /= nPodstawa; break;
					case 11: sZapisRoboczy = "B" + sZapisRoboczy; nLiczbaDziesietna /= nPodstawa; break;
					case 12: sZapisRoboczy = "C" + sZapisRoboczy; nLiczbaDziesietna /= nPodstawa; break;
					case 13: sZapisRoboczy = "D" + sZapisRoboczy; nLiczbaDziesietna /= nPodstawa; break;
					case 14: sZapisRoboczy = "E" + sZapisRoboczy; nLiczbaDziesietna /= nPodstawa; break;
					case 15: sZapisRoboczy = "F" + sZapisRoboczy; nLiczbaDziesietna /= nPodstawa; break;
					}
				}
			}
			if ((nLiczbaDziesietna / nPodstawa) == 0) {
				if (nLiczbaDziesietna % nPodstawa < 10) {
					ss2 << nLiczbaDziesietna;
					sZapisRoboczy = ss2.str() + sZapisRoboczy;
				} else {
					switch (nLiczbaDziesietna % nPodstawa) {
					case 10: sZapisRoboczy = "A" + sZapisRoboczy;break;
					case 11: sZapisRoboczy = "B" + sZapisRoboczy;break;
					case 12: sZapisRoboczy = "C" + sZapisRoboczy;break;
					case 13: sZapisRoboczy = "D" + sZapisRoboczy;break;
					case 14: sZapisRoboczy = "E" + sZapisRoboczy;break;
					case 15: sZapisRoboczy = "F" + sZapisRoboczy;break;
					}
				}
			}
			m_vsVektorZapisu.push_back(sZapisRoboczy);
		}
	}
}

string Liczba::zwrocZapisLiczby(int nPodstawa) {
	return m_vsVektorZapisu[nPodstawa];
}
Liczba::~Liczba(void)
{
}
